package com.gmail.sharpcastle33.main;

import com.gmail.sharpcastle33.listeners.MultiblockListener;
import com.psygate.minecraft.civex.bastions.multiblocks.BastionFactory;
import com.psygate.minecraft.civex.bastions.multiblocks.ChassisFactory;
import com.psygate.minecraft.civex.bastions.multiblocks.CoolantFactory;
import com.psygate.minecraft.civex.bastions.multiblocks.EssenceOrbFactory;
import com.psygate.minecraft.civex.bastions.multiblocks.Factory;
import com.psygate.minecraft.civex.bastions.multiblocks.FuelFactory;
import com.psygate.minecraft.civex.bastions.multiblocks.MechanicalFactory;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import java.util.List;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CivExBastionsFactory extends JavaPlugin {

    public static Plugin plugin;
    public static final List<Factory> factories = unmodifiableList(asList(new MechanicalFactory(),
                    new FuelFactory(),
                    new EssenceOrbFactory(),
                    new CoolantFactory(),
                    new ChassisFactory(),
                    new BastionFactory()
            )
    );

    public void onEnable() {
        plugin = this;
//        initRecipes();
        this.getServer().getPluginManager().registerEvents(new MultiblockListener(), this);
//        this.getServer().getPluginManager().registerEvents(new HelpListener(), this);
//        this.getServer().getPluginManager().registerEvents(new Listener() {
//            @EventHandler
//            public void chat(final AsyncPlayerChatEvent ev) {
//                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
//
//                    @Override
//                    public void run() {
//                        ArrayList<ItemStack> coolant2 = new ArrayList<>();
//                        ArrayList<ItemStack> fuel2 = new ArrayList<>();
//                        ArrayList<ItemStack> chassis2 = new ArrayList<>();
//                        ArrayList<ItemStack> mechanical2 = new ArrayList<>();
//                        ArrayList<ItemStack> essence2 = new ArrayList<>();
//
//                        coolant2.addAll(new CoolantFactory().getItems());
//                        coolant2.addAll(new CoolantFactory().getItems());
//
//                        fuel2.addAll(new FuelFactory().getItems());
//                        fuel2.addAll(new FuelFactory().getItems());
//
//                        chassis2.addAll(new ChassisFactory().getItems());
//                        chassis2.addAll(new ChassisFactory().getItems());
//
//                        mechanical2.addAll(new MechanicalFactory().getItems());
//                        mechanical2.addAll(new MechanicalFactory().getItems());
//
//                        essence2.addAll(new EssenceOrbFactory().getItems());
//                        essence2.addAll(new EssenceOrbFactory().getItems());
//
//                        if (ev.getMessage().equals("coolant")) {
//                            ev.getPlayer().getInventory().addItem(new CoolantFactory().getItems().toArray(new ItemStack[0]));
//                        }
//                        if (ev.getMessage().equals("fuel")) {
//                            ev.getPlayer().getInventory().addItem(new FuelFactory().getItems().toArray(new ItemStack[0]));
//                        }
//
//                        if (ev.getMessage().equals("chassis")) {
//                            ev.getPlayer().getInventory().addItem(new ChassisFactory().getItems().toArray(new ItemStack[0]));
//                        }
//
//                        if (ev.getMessage().equals("mechanical")) {
//                            ev.getPlayer().getInventory().addItem(new MechanicalFactory().getItems().toArray(new ItemStack[0]));
//                        }
//
//                        if (ev.getMessage().equals("essence")) {
//                            ev.getPlayer().getInventory().addItem(new EssenceOrbFactory().getItems().toArray(new ItemStack[0]));
//                        }
//
//                        if (ev.getMessage().equals("coolant2")) {
//                            ev.getPlayer().getInventory().addItem(coolant2.toArray(new ItemStack[0]));
//                        }
//                        if (ev.getMessage().equals("fuel2")) {
//                            ev.getPlayer().getInventory().addItem(fuel2.toArray(new ItemStack[0]));
//                        }
//
//                        if (ev.getMessage().equals("chassis2")) {
//                            ev.getPlayer().getInventory().addItem(chassis2.toArray(new ItemStack[0]));
//                        }
//
//                        if (ev.getMessage().equals("mechanical2")) {
//                            ev.getPlayer().getInventory().addItem(mechanical2.toArray(new ItemStack[0]));
//                        }
//
//                        if (ev.getMessage().equals("essence2")) {
//                            ev.getPlayer().getInventory().addItem(essence2.toArray(new ItemStack[0]));
//                        }
//
//                        if (ev.getMessage().equals("bastion")) {
//                            ev.getPlayer().getInventory().addItem(new BastionFactory().getItems().toArray(new ItemStack[0]));
//                        }
//
//                        if (ev.getMessage().equals("bastion2")) {
//                            ev.getPlayer().getInventory().addItem(new BastionFactory().getItems().toArray(new ItemStack[0]));
//                            ev.getPlayer().getInventory().addItem(new BastionFactory().getItems().toArray(new ItemStack[0]));
//                        }
//                    }
//                });
//            }
//        }, plugin);
    }

    public void onDisable() {

    }

}
