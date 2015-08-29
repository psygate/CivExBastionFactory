package com.gmail.sharpcastle33.listeners;

import static com.gmail.sharpcastle33.main.CivExBastionsFactory.factories;
import com.psygate.minecraft.civex.bastions.multiblocks.Factory;
import static java.lang.System.nanoTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.bukkit.ChatColor.AQUA;
import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;
import org.bukkit.Material;
import static org.bukkit.Material.EMERALD;
import static org.bukkit.Material.EMERALD_BLOCK;
import static org.bukkit.Material.IRON_FENCE;
import static org.bukkit.Material.LAVA_BUCKET;
import static org.bukkit.Material.PISTON_BASE;
import static org.bukkit.Material.WATCH;
import static org.bukkit.Material.WATER_BUCKET;
import static org.bukkit.Sound.ANVIL_USE;
import org.bukkit.block.Block;
import static org.bukkit.enchantments.Enchantment.DURABILITY;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import static org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class MultiblockListener implements Listener {

    private final HashMap<UUID, Long> ratelimit = new HashMap<>();

    Material clickableBlock = PISTON_BASE;

    @EventHandler
    public void craftBastionPart(PlayerInteractEvent event) {
        if (!event.getPlayer().isOp()) {
            if (!ratelimit.containsKey(event.getPlayer().getUniqueId())) {
                ratelimit.put(event.getPlayer().getUniqueId(), nanoTime());
            } else if (nanoTime() - ratelimit.get(event.getPlayer().getUniqueId()) < SECONDS.toNanos(3)) {
                return;
            }

            ratelimit.put(event.getPlayer().getUniqueId(), nanoTime());
        }

        if (event.getAction() == RIGHT_CLICK_BLOCK) {
            if (event.getClickedBlock() != null && event.getClickedBlock().getType() == clickableBlock) {
                Block b = event.getClickedBlock();
                Player p = event.getPlayer();
                for (Factory factory : factories) {
                    if (factory.fits(b)) {
                        p.sendMessage(GREEN + "You clicked a " + factory.getName());
                        if (hasRequiredMaterials(p, factory.getItems())) {
                            ItemStack bastion = factory.getOutput();
                            if (p.getInventory().firstEmpty() == -1) {
                                p.getWorld().dropItemNaturally(p.getLocation(), bastion);
                            } else {
                                p.getInventory().addItem(bastion);
                            }
                            p.getLocation().getWorld().playSound(p.getLocation(), ANVIL_USE, 0, 0);

                        }
                        event.setCancelled(true);
                        return;
                    }
                }
            }
        }

    }

    public boolean hasRequiredMaterials(Player p, List<ItemStack> recipe) {
        ArrayList<ItemStack> contains = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        for (ItemStack stack : recipe) {
            contains.add(stack);
            count.add(count(stack, p.getInventory()));
        }

        for (int i = 0; i < contains.size(); i++) {
            if (contains.get(i).getAmount() > count.get(i)) {
                p.sendMessage(RED + "Not enough materials. " + contains.get(i).getType() + " Required: " + contains.get(i).getAmount());
                return false;
            }
        }

        removeFromInventory(p.getInventory(), contains);
        return true;
    }

    private void removeFromInventory(PlayerInventory inv, List<ItemStack> mats) {
        for (ListIterator<ItemStack> it = mats.listIterator(); it.hasNext();) {
            ItemStack search = it.next().clone();
            int amount = search.getAmount();

            for (ListIterator<ItemStack> it2 = inv.iterator(); it2.hasNext();) {
                ItemStack stack = it2.next();
                if (equals(stack, search)) {
                    if (stack.getAmount() > amount) {
                        stack.setAmount(stack.getAmount() - amount);
                        break;
                    } else if (stack.getAmount() == amount) {
                        it2.set(null);
                        break;
                    } else {
                        amount -= stack.getAmount();
                        it2.set(null);
                    }
                }
            }
        }
    }

    private Integer count(ItemStack search, PlayerInventory inventory) {
        int count = 0;
        for (ItemStack stack : inventory.getContents()) {
            if (equals(search, stack)) {
                count += stack.getAmount();
            }
        }

        return count;
    }

    private boolean equals(ItemStack search, ItemStack stack) {
        if (stack == null && search == null) {
            return true;
        } else if (stack != null && search == null) {
            return false;
        } else if (stack == null && search != null) {
            return false;
        } else if (stack != null && search != null) {
//            System.out.println((stack.getType() + " " + search.getType()) + " " + (search.getDurability() + " " + stack.getDurability()));
            if (stack.getType() == search.getType() && search.getDurability() == stack.getDurability()) {
                if (!stack.hasItemMeta() && !search.hasItemMeta()) {
//                    System.out.println("No meta.");
                    return true;
                } else if (stack.hasItemMeta() && search.hasItemMeta()) {
//                    System.out.println(stack.hasItemMeta() + " " + search.hasItemMeta());
//                    System.out.println(stack.getItemMeta() + " " + search.getItemMeta());
                    return stack.getItemMeta().equals(search.getItemMeta());
                }
            }
        }

        return false;
    }

    public boolean hasBastionMaterials(Player p) {

        ItemStack parts = new ItemStack(WATCH, 1);
        setCustomName(parts, AQUA + "Mechanical Parts");
        makeGlowy(parts);

        ItemStack orb = new ItemStack(EMERALD, 1);
        setCustomName(orb, AQUA + "Essence Orb");
        makeGlowy(orb);

        ItemStack chassi = new ItemStack(IRON_FENCE, 1);
        setCustomName(chassi, AQUA + "Bastion Chassis");
        makeGlowy(chassi);

        ItemStack fuel = new ItemStack(LAVA_BUCKET, 1);
        setCustomName(fuel, AQUA + "Bastion Fuel");
        makeGlowy(fuel);

        ItemStack coolant = new ItemStack(WATER_BUCKET, 1);
        setCustomName(coolant, AQUA + "Bastion Coolant");
        makeGlowy(coolant);

        Inventory i = p.getInventory();

        if (i.contains(parts, 1)
                && i.contains(orb, 1)
                && i.contains(chassi, 1)
                && i.contains(fuel, 1)
                && i.contains(coolant, 1)) {
            p.getInventory().removeItem(orb);
            p.getInventory().removeItem(chassi);
            p.getInventory().removeItem(fuel);
            p.getInventory().removeItem(coolant);
            p.getInventory().removeItem(parts);
            return true;
        }

        return false;

    }

//    public boolean hasEssenceMaterials(Player p) {
//
//        for (ItemStack i : essence) {
//            if (!p.getInventory().contains(i.getType(), i.getAmount())) {
//                p.sendMessage("You are missing" + i.getType().toString());
//                return false;
//            }
//        }
//        int test = 0;
//        //ItemStack xpblock = new ItemStack(Material.EMERALD_BLOCK,1);
//        //	xpblock.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
//		/*if(!p.getInventory().contains(new ItemStack(Material.EMERALD_BLOCK,1))){
//         p.sendMessage("You are missing an xpblock");
//         return false;
//         }else{*/
//        for (ItemStack i : p.getInventory().getContents()) {
//            if (i != null && i.getType() == Material.EMERALD_BLOCK) {
//                if (i.containsEnchantment(Enchantment.DURABILITY)) {
//                    test = 1;
//                    p.getInventory().removeItem(i);
//                }
//            }
//        }
//        //}
//
//        if (test == 0) {
//            return false;
//        }
//
//        for (ItemStack i : essence) {
//            removeItem(p, i);
//        }
//        return true;
//    }
    public void removeItem(Player p, ItemStack i) {
        p.getInventory().removeItem(i);
    }

//    public ArrayList<Block> getMultiblock(Block b) {
//        ArrayList<Block> blocks = new ArrayList<>();
//
//        blocks.add(b);
//
//        blocks.add(b.getRelative(BlockFace.EAST));
//        blocks.add(b.getRelative(BlockFace.WEST));
//        blocks.add(b.getRelative(BlockFace.NORTH));
//        blocks.add(b.getRelative(BlockFace.SOUTH));
//
//        blocks.add(b.getRelative(BlockFace.NORTH).getRelative(BlockFace.EAST));
//        blocks.add(b.getRelative(BlockFace.NORTH).getRelative(BlockFace.WEST));
//
//        blocks.add(b.getRelative(BlockFace.SOUTH).getRelative(BlockFace.EAST));
//        blocks.add(b.getRelative(BlockFace.SOUTH).getRelative(BlockFace.WEST));
//
//        Block a = b.getRelative(BlockFace.UP);
//
//        blocks.add(a);
//
//        blocks.add(a.getRelative(BlockFace.EAST));
//        blocks.add(a.getRelative(BlockFace.WEST));
//        blocks.add(a.getRelative(BlockFace.NORTH));
//        blocks.add(a.getRelative(BlockFace.SOUTH));
//
//        blocks.add(a.getRelative(BlockFace.NORTH).getRelative(BlockFace.EAST));
//        blocks.add(a.getRelative(BlockFace.NORTH).getRelative(BlockFace.WEST));
//
//        blocks.add(a.getRelative(BlockFace.SOUTH).getRelative(BlockFace.EAST));
//        blocks.add(a.getRelative(BlockFace.SOUTH).getRelative(BlockFace.WEST));
//
//        Block c = b.getRelative(BlockFace.DOWN);
//
//        blocks.add(c);
//
//        blocks.add(c.getRelative(BlockFace.EAST));
//        blocks.add(c.getRelative(BlockFace.WEST));
//        blocks.add(c.getRelative(BlockFace.NORTH));
//        blocks.add(c.getRelative(BlockFace.SOUTH));
//
//        blocks.add(c.getRelative(BlockFace.NORTH).getRelative(BlockFace.EAST));
//        blocks.add(c.getRelative(BlockFace.NORTH).getRelative(BlockFace.WEST));
//
//        blocks.add(c.getRelative(BlockFace.SOUTH).getRelative(BlockFace.EAST));
//        blocks.add(c.getRelative(BlockFace.SOUTH).getRelative(BlockFace.WEST));
//
//        return blocks;
//    }
    public Map<Material, Integer> getMaterials(ArrayList<Block> blocks) {
        Map<Material, Integer> mats = new HashMap<>();

        for (Block b : blocks) {
            Material m = b.getType();
            if (mats.containsKey(m)) {
                mats.put(m, mats.get(m) + 1);
            } else {
                mats.put(m, 1);
            }
        }
        return mats;
    }

    public boolean isFilledEmeraldBlock(ItemStack i) {
        if (i.getType() == EMERALD_BLOCK) {
            if (i.containsEnchantment(DURABILITY)) {
                return true;
            }
        }
        return false;
    }

    public void addLore(ItemStack i, String lore) {

    }

    public void setCustomName(ItemStack i, String name) {
        ItemMeta im = i.getItemMeta();
        im.setDisplayName(name);
        i.setItemMeta(im);
    }

    public void makeGlowy(ItemStack i) {
        i.addUnsafeEnchantment(DURABILITY, 3);
    }
}
