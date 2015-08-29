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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class Factory {

    private final List<Map<Vec3, Material>> parts = new ArrayList<>(4);
    private final List<ItemStack> items;
    private final ItemStack output;
    private final String name;

    public Factory(String name, ItemStack output, List<ItemStack> items, Entry<Vec3, Material>... part) {
        // Normal rotation
//        HashMap<Vec3, Material> norm = new HashMap<>();
//        HashMap<Vec3, Material> clock90 = new HashMap<>();
//        HashMap<Vec3, Material> clock180 = new HashMap<>();
//        HashMap<Vec3, Material> clock270 = new HashMap<>();

        for (Entry<Vec3, Material> en : part) {
            Vec3 rot = en.getKey();
            for (int i = 0; i < 4; i++) {
                if (parts.size() < i + 1) {
                    parts.add(new HashMap<Vec3, Material>());
                }
                parts.get(i).put(rot, en.getValue());
                rot = rot.rotClock90Z();
            }
        }

//        parts.add(norm);
//        parts.add(clock90);
//        parts.add(clock180);
//        parts.add(clock270);
        this.items = items;
        this.output = output;
        this.name = name;

    }

    public List<ItemStack> getItems() {
        return items;
    }

    public List<Map<Vec3, Material>> getParts() {
        return parts;
    }

    public boolean fits(final Block core) {
        for (Map<Vec3, Material> localparts : parts) {
            if (subFits(core, localparts)) {
                return true;
            }
        }

        return false;
    }

    private boolean subFits(final Block core, Map<Vec3, Material> localparts) {
        for (Map.Entry<Vec3, Material> part : localparts.entrySet()) {
            Block check = core.getRelative(part.getKey().getX(), part.getKey().getY(), part.getKey().getZ());
            if (check == null || !part.getValue().equals(check.getType())) {
                return false;
            }
        }

        return true;
    }

    public ItemStack getOutput() {
        return output.clone();
    }

    public String getName() {
        return name;
    }

    protected final static class Pair implements Entry<Vec3, Material> {

        private final Vec3 key;
        private final Material value;

        public Pair(Vec3 key, Material value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Vec3 getKey() {
            return key;
        }

        @Override
        public Material getValue() {
            return value;
        }

        @Override
        public Material setValue(Material value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
