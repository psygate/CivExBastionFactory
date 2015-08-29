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

import java.util.ArrayList;
import java.util.List;
import static org.bukkit.Material.BEACON;
import static org.bukkit.Material.DIAMOND_BLOCK;
import static org.bukkit.Material.GLASS;
import static org.bukkit.Material.IRON_BLOCK;
import static org.bukkit.Material.OBSIDIAN;
import static org.bukkit.Material.PISTON_BASE;
import static org.bukkit.Material.SPONGE;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author psygate (http://github.com/psygate)
 */
public class BastionFactory extends Factory {

    private final static List<ItemStack> recipe = new ArrayList<>();
    private final static ItemStack output = new ItemStack(SPONGE, 16);

    static {
        recipe.add(new ChassisFactory().getOutput());
        recipe.add(new CoolantFactory().getOutput());
        recipe.add(new EssenceOrbFactory().getOutput());
        recipe.add(new MechanicalFactory().getOutput());
        recipe.add(new FuelFactory().getOutput());
    }

    private static void setDisplayName(ItemStack mechanical, String string) {
        ItemMeta meta = mechanical.getItemMeta();
        meta.setDisplayName(string);
        mechanical.setItemMeta(meta);
    }

    public BastionFactory() {
        super("Bastion Factory", output, recipe,
                new Pair(new Vec3(0, 0, 0), PISTON_BASE),
                new Pair(new Vec3(0, 0, -1), DIAMOND_BLOCK),
                new Pair(new Vec3(1, 0, 0), DIAMOND_BLOCK),
                new Pair(new Vec3(0, 0, 1), DIAMOND_BLOCK),
                new Pair(new Vec3(0, 1, 0), BEACON),
                new Pair(new Vec3(0, -1, 0), OBSIDIAN),
                new Pair(new Vec3(1, 0, -1), IRON_BLOCK),
                new Pair(new Vec3(-1, 0, -1), IRON_BLOCK),
                new Pair(new Vec3(1, 0, 1), IRON_BLOCK),
                new Pair(new Vec3(-1, 0, 1), IRON_BLOCK),
                new Pair(new Vec3(-1, 1, 1), IRON_BLOCK),
                new Pair(new Vec3(-1, -1, 1), OBSIDIAN),
                new Pair(new Vec3(-1, -1, 0), OBSIDIAN),
                new Pair(new Vec3(0, -1, 1), OBSIDIAN),
                new Pair(new Vec3(0, -1, -1), OBSIDIAN),
                new Pair(new Vec3(1, -1, 0), OBSIDIAN),
                new Pair(new Vec3(1, -1, -1), OBSIDIAN),
                new Pair(new Vec3(1, -1, 1), OBSIDIAN),
                new Pair(new Vec3(-1, -1, -1), OBSIDIAN),
                new Pair(new Vec3(-1, 1, 0), GLASS),
                new Pair(new Vec3(0, 1, 1), GLASS),
                new Pair(new Vec3(0, 1, -1), GLASS),
                new Pair(new Vec3(1, 1, 0), GLASS),
                new Pair(new Vec3(1, 1, -1), IRON_BLOCK),
                new Pair(new Vec3(1, 1, 1), IRON_BLOCK),
                new Pair(new Vec3(-1, 1, -1), IRON_BLOCK)
        );
    }
}
