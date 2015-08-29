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
import static org.bukkit.Material.BOOKSHELF;
import static org.bukkit.Material.CARROT_ITEM;
import static org.bukkit.Material.EMERALD;
import static org.bukkit.Material.EMERALD_BLOCK;
import static org.bukkit.Material.ENCHANTMENT_TABLE;
import static org.bukkit.Material.LAPIS_BLOCK;
import static org.bukkit.Material.OBSIDIAN;
import static org.bukkit.Material.PISTON_BASE;
import static org.bukkit.Material.POISONOUS_POTATO;
import static org.bukkit.Material.POTATO_ITEM;
import static org.bukkit.Material.ROTTEN_FLESH;
import static org.bukkit.Material.SEA_LANTERN;
import static org.bukkit.Material.SPIDER_EYE;
import static org.bukkit.Material.VINE;
import static org.bukkit.Material.WHEAT;
import static org.bukkit.enchantments.Enchantment.WATER_WORKER;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author psygate (http://github.com/psygate)
 */
public class EssenceOrbFactory extends Factory {

    static final ItemStack output = new ItemStack(EMERALD, 1);

    static {
        setDisplayName(output, AQUA + "Bastion Essence Orb");
        output.addUnsafeEnchantment(WATER_WORKER, 1);
    }

    private static void setDisplayName(ItemStack mechanical, String string) {
        ItemMeta meta = mechanical.getItemMeta();
        meta.setDisplayName(string);
        mechanical.setItemMeta(meta);
    }

    public EssenceOrbFactory() {
        super("EssenceOrbFactory", output, asList(new ItemStack(ROTTEN_FLESH, 192),
                new ItemStack(SPIDER_EYE, 32),
                new ItemStack(POISONOUS_POTATO, 4),
                new ItemStack(WHEAT, 192),
                new ItemStack(CARROT_ITEM, 192),
                new ItemStack(POTATO_ITEM, 192),
                new ItemStack(EMERALD, 64),
                new ItemStack(LAPIS_BLOCK, 4),
                new ItemStack(ENCHANTMENT_TABLE, 1),
                new ItemStack(SEA_LANTERN, 4),
                new ItemStack(VINE, 64)
        ),
                //a filled xp block, 3 stacks of rotten flesh, 3 stacks wheat, 3 stacks carrots, 3 stacks potato, 32 spider eyes, 4 poisonous potatos
                //64 emeralds, 4 lapis blocks, and an enchantment table, and four sea lanterns.

                new Pair(new Vec3(0, 0, 0), PISTON_BASE),
                new Pair(new Vec3(0, 0, -1), OBSIDIAN),
                new Pair(new Vec3(1, 0, 0), OBSIDIAN),
                new Pair(new Vec3(0, 0, 1), OBSIDIAN),
                new Pair(new Vec3(0, 1, 0), BEACON),
                new Pair(new Vec3(0, -1, 0), EMERALD_BLOCK),
                new Pair(new Vec3(1, 0, -1), BOOKSHELF),
                new Pair(new Vec3(-1, 0, -1), BOOKSHELF),
                new Pair(new Vec3(1, 0, 1), BOOKSHELF),
                new Pair(new Vec3(-1, 0, 1), BOOKSHELF),
                new Pair(new Vec3(-1, 1, 1), BOOKSHELF),
                new Pair(new Vec3(-1, -1, 1), EMERALD_BLOCK),
                new Pair(new Vec3(-1, -1, 0), EMERALD_BLOCK),
                new Pair(new Vec3(0, -1, 1), EMERALD_BLOCK),
                new Pair(new Vec3(0, -1, -1), EMERALD_BLOCK),
                new Pair(new Vec3(1, -1, 0), EMERALD_BLOCK),
                new Pair(new Vec3(1, -1, -1), EMERALD_BLOCK),
                new Pair(new Vec3(1, -1, 1), EMERALD_BLOCK),
                new Pair(new Vec3(-1, -1, -1), EMERALD_BLOCK),
                new Pair(new Vec3(-1, 1, 0), ENCHANTMENT_TABLE),
                new Pair(new Vec3(0, 1, 1), ENCHANTMENT_TABLE),
                new Pair(new Vec3(0, 1, -1), ENCHANTMENT_TABLE),
                new Pair(new Vec3(1, 1, 0), ENCHANTMENT_TABLE),
                new Pair(new Vec3(1, 1, -1), BOOKSHELF),
                new Pair(new Vec3(1, 1, 1), BOOKSHELF),
                new Pair(new Vec3(-1, 1, -1), BOOKSHELF)
        );
    }
}
