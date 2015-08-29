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
import static org.bukkit.Material.PISTON_BASE;
import static org.bukkit.Material.PISTON_EXTENSION;
import static org.bukkit.Material.PISTON_STICKY_BASE;
import static org.bukkit.Material.REDSTONE_BLOCK;
import static org.bukkit.Material.REDSTONE_LAMP_OFF;
import static org.bukkit.Material.SEA_LANTERN;
import static org.bukkit.Material.SLIME_BLOCK;
import static org.bukkit.Material.WATCH;
import static org.bukkit.Material.WEB;
import static org.bukkit.enchantments.Enchantment.WATER_WORKER;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author psygate (http://github.com/psygate)
 */
public class MechanicalFactory extends Factory {

    static final ItemStack output = new ItemStack(WATCH, 1);

    static {
        setDisplayName(output, AQUA + "Bastion Mechanical Core");
        output.addUnsafeEnchantment(WATER_WORKER, 1);
    }

    private static void setDisplayName(ItemStack mechanical, String string) {
        ItemMeta meta = mechanical.getItemMeta();
        meta.setDisplayName(string);
        mechanical.setItemMeta(meta);
    }

    public MechanicalFactory() {
        super("Mechanical Factory", output, asList(new ItemStack(SLIME_BLOCK, 16),
                new ItemStack(REDSTONE_BLOCK, 12),
                new ItemStack(REDSTONE_LAMP_OFF, 16),
                new ItemStack(PISTON_STICKY_BASE, 16),
                new ItemStack(WEB, 64)
        ),
                //16 slime blocks, 12 redstone blocks, 16 sticky pistons, 64 cobwebs, and 16 redstone lamps.
                new Pair(new Vec3(0, 0, 0), PISTON_BASE),
                new Pair(new Vec3(0, 0, -1), SEA_LANTERN),
                new Pair(new Vec3(1, 0, 0), SEA_LANTERN),
                new Pair(new Vec3(0, 0, 1), SEA_LANTERN),
                new Pair(new Vec3(0, 1, 0), BEACON),
                new Pair(new Vec3(0, -1, 0), SLIME_BLOCK),
                new Pair(new Vec3(1, 0, -1), EMERALD_BLOCK),
                new Pair(new Vec3(-1, 0, -1), EMERALD_BLOCK),
                new Pair(new Vec3(1, 0, 1), EMERALD_BLOCK),
                new Pair(new Vec3(-1, 0, 1), EMERALD_BLOCK),
                new Pair(new Vec3(-1, 1, 1), REDSTONE_BLOCK),
                new Pair(new Vec3(-1, -1, 1), SLIME_BLOCK),
                new Pair(new Vec3(-1, -1, 0), SLIME_BLOCK),
                new Pair(new Vec3(0, -1, 1), SLIME_BLOCK),
                new Pair(new Vec3(0, -1, -1), SLIME_BLOCK),
                new Pair(new Vec3(1, -1, 0), SLIME_BLOCK),
                new Pair(new Vec3(1, -1, -1), SLIME_BLOCK),
                new Pair(new Vec3(1, -1, 1), SLIME_BLOCK),
                new Pair(new Vec3(-1, -1, -1), SLIME_BLOCK),
                new Pair(new Vec3(-1, 1, 0), PISTON_STICKY_BASE),
                new Pair(new Vec3(0, 1, 1), PISTON_STICKY_BASE),
                new Pair(new Vec3(0, 1, -1), PISTON_STICKY_BASE),
                new Pair(new Vec3(1, 1, 0), PISTON_STICKY_BASE),
                new Pair(new Vec3(1, 1, -1), REDSTONE_BLOCK),
                new Pair(new Vec3(1, 1, 1), REDSTONE_BLOCK),
                new Pair(new Vec3(1, 2, 0), PISTON_EXTENSION),
                new Pair(new Vec3(-1, 1, -1), REDSTONE_BLOCK),
                new Pair(new Vec3(0, 2, -1), PISTON_EXTENSION),
                new Pair(new Vec3(0, 2, 1), PISTON_EXTENSION),
                new Pair(new Vec3(-1, 2, 0), PISTON_EXTENSION)
        );
    }
}
