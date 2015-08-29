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
import static org.bukkit.Material.DIAMOND;
import static org.bukkit.Material.DIAMOND_BLOCK;
import static org.bukkit.Material.GLASS;
import static org.bukkit.Material.ICE;
import static org.bukkit.Material.LAPIS_BLOCK;
import static org.bukkit.Material.PACKED_ICE;
import static org.bukkit.Material.PISTON_BASE;
import static org.bukkit.Material.QUARTZ_BLOCK;
import static org.bukkit.Material.SNOW_BLOCK;
import static org.bukkit.Material.WATER_BUCKET;
import static org.bukkit.enchantments.Enchantment.WATER_WORKER;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author psygate (http://github.com/psygate)
 */
public class CoolantFactory extends Factory {

    static final ItemStack output = new ItemStack(WATER_BUCKET, 1);

    static {
        setDisplayName(output, AQUA + "Bastion Coolant");
        output.addUnsafeEnchantment(WATER_WORKER, 1);
    }

    private static void setDisplayName(ItemStack mechanical, String string) {
        ItemMeta meta = mechanical.getItemMeta();
        meta.setDisplayName(string);
        mechanical.setItemMeta(meta);
    }

    public CoolantFactory() {
        super("Coolant Factory", output,
                asList(new ItemStack(WATER_BUCKET, 9),
                        new ItemStack(ICE, 64),
                        new ItemStack(SNOW_BLOCK, 64),
                        new ItemStack(DIAMOND, 10),
                        new ItemStack(LAPIS_BLOCK, 10),
                        new ItemStack(GLASS, 32)),
                //9 Water buckets, a stack of ice, a stack of snow block, 10 diamonds, 10 lapis blocks, and 32 glass.
                new Pair(new Vec3(0, 0, 0), PISTON_BASE),
                new Pair(new Vec3(0, 0, -1), QUARTZ_BLOCK),
                new Pair(new Vec3(1, 0, 0), QUARTZ_BLOCK),
                new Pair(new Vec3(0, 0, 1), QUARTZ_BLOCK),
                new Pair(new Vec3(0, 1, 0), BEACON),
                new Pair(new Vec3(0, -1, 0), PACKED_ICE),
                new Pair(new Vec3(1, 0, -1), DIAMOND_BLOCK),
                new Pair(new Vec3(-1, 0, -1), DIAMOND_BLOCK),
                new Pair(new Vec3(1, 0, 1), DIAMOND_BLOCK),
                new Pair(new Vec3(-1, 0, 1), DIAMOND_BLOCK),
                new Pair(new Vec3(-1, 1, 1), DIAMOND_BLOCK),
                new Pair(new Vec3(-1, -1, 1), LAPIS_BLOCK),
                new Pair(new Vec3(-1, -1, 0), LAPIS_BLOCK),
                new Pair(new Vec3(0, -1, 1), LAPIS_BLOCK),
                new Pair(new Vec3(0, -1, -1), LAPIS_BLOCK),
                new Pair(new Vec3(1, -1, 0), LAPIS_BLOCK),
                new Pair(new Vec3(1, -1, -1), LAPIS_BLOCK),
                new Pair(new Vec3(1, -1, 1), LAPIS_BLOCK),
                new Pair(new Vec3(-1, -1, -1), LAPIS_BLOCK),
                new Pair(new Vec3(-1, 1, 0), GLASS),
                new Pair(new Vec3(0, 1, 1), GLASS),
                new Pair(new Vec3(0, 1, -1), GLASS),
                new Pair(new Vec3(1, 1, 0), GLASS),
                new Pair(new Vec3(1, 1, -1), DIAMOND_BLOCK),
                new Pair(new Vec3(1, 1, 1), DIAMOND_BLOCK),
                new Pair(new Vec3(-1, 1, -1), DIAMOND_BLOCK)
        );
    }
}
