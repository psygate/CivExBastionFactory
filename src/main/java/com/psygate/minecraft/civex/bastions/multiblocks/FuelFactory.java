/*


 The MIT License (MIT)

 Copyright (c) 2015 psygate (http://github.com/psygate)

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.

 */
package com.psygate.minecraft.civex.bastions.multiblocks;

import static java.util.Arrays.asList;
import static org.bukkit.ChatColor.AQUA;
import static org.bukkit.Material.BEACON;
import static org.bukkit.Material.EMERALD_BLOCK;
import static org.bukkit.Material.GOLD_BLOCK;
import static org.bukkit.Material.GOLD_INGOT;
import static org.bukkit.Material.LAVA_BUCKET;
import static org.bukkit.Material.NETHER_BRICK;
import static org.bukkit.Material.PISTON_BASE;
import static org.bukkit.Material.REDSTONE;
import static org.bukkit.Material.REDSTONE_BLOCK;
import static org.bukkit.Material.REDSTONE_LAMP_ON;
import static org.bukkit.Material.TNT;
import static org.bukkit.enchantments.Enchantment.WATER_WORKER;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author psygate (http://github.com/psygate)
 */
public class FuelFactory extends Factory {

    static final ItemStack output = new ItemStack(LAVA_BUCKET, 1);

    static {
        setDisplayName(output, AQUA + "Bastion Fuel");
        output.addUnsafeEnchantment(WATER_WORKER, 1);
    }

    private static void setDisplayName(ItemStack mechanical, String string) {
        ItemMeta meta = mechanical.getItemMeta();
        meta.setDisplayName(string);
        mechanical.setItemMeta(meta);
    }

    public FuelFactory() {
        super("Fuel Factory", output, asList(new ItemStack(LAVA_BUCKET, 9),
                new ItemStack(GOLD_INGOT, 64),
                new ItemStack(TNT, 4),
                new ItemStack(REDSTONE, 16),
                new ItemStack(NETHER_BRICK, 64)
        ),
                //9 lava buckets, 64 gold ingots, 4 tnt, 16 redstone, 64 netherbrick blocks.

                new Pair(new Vec3(0, 0, 0), PISTON_BASE),
                new Pair(new Vec3(0, 0, -1), REDSTONE_LAMP_ON),
                new Pair(new Vec3(1, 0, 0), REDSTONE_LAMP_ON),
                new Pair(new Vec3(0, 0, 1), REDSTONE_LAMP_ON),
                new Pair(new Vec3(0, 1, 0), BEACON),
                new Pair(new Vec3(0, -1, 0), EMERALD_BLOCK),
                new Pair(new Vec3(1, 0, -1), GOLD_BLOCK),
                new Pair(new Vec3(-1, 0, -1), GOLD_BLOCK),
                new Pair(new Vec3(1, 0, 1), GOLD_BLOCK),
                new Pair(new Vec3(-1, 0, 1), GOLD_BLOCK),
                new Pair(new Vec3(-1, 1, 1), GOLD_BLOCK),
                new Pair(new Vec3(-1, -1, 1), REDSTONE_BLOCK),
                new Pair(new Vec3(-1, -1, 0), REDSTONE_BLOCK),
                new Pair(new Vec3(0, -1, 1), REDSTONE_BLOCK),
                new Pair(new Vec3(0, -1, -1), REDSTONE_BLOCK),
                new Pair(new Vec3(1, -1, 0), REDSTONE_BLOCK),
                new Pair(new Vec3(1, -1, -1), REDSTONE_BLOCK),
                new Pair(new Vec3(1, -1, 1), REDSTONE_BLOCK),
                new Pair(new Vec3(-1, -1, -1), REDSTONE_BLOCK),
                new Pair(new Vec3(-1, 1, 0), GOLD_BLOCK),
                new Pair(new Vec3(0, 1, 1), NETHER_BRICK),
                new Pair(new Vec3(0, 1, -1), NETHER_BRICK),
                new Pair(new Vec3(1, 1, 0), GOLD_BLOCK),
                new Pair(new Vec3(1, 1, -1), GOLD_BLOCK),
                new Pair(new Vec3(1, 1, 1), GOLD_BLOCK),
                new Pair(new Vec3(-1, 1, -1), GOLD_BLOCK)
        );
    }
}
