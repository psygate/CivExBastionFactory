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
package com.gmail.sharpcastle33.listeners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import static org.bukkit.Bukkit.broadcastMessage;
import org.bukkit.Material;
import static org.bukkit.Material.AIR;
import static org.bukkit.Material.STICK;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import static org.bukkit.block.BlockFace.values;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import static org.bukkit.event.block.Action.LEFT_CLICK_BLOCK;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author psygate (http://github.com/psygate)
 */
public class HelpListener implements Listener {

    final int reclimit = 100;

    @EventHandler
    public void playerBlockBlick(PlayerInteractEvent ev) {
        if (ev.getAction() == LEFT_CLICK_BLOCK) {
            if (ev.getPlayer().getItemInHand() != null && ev.getPlayer().getItemInHand().getType() == STICK) {
                ArrayList<Block> blocks = new ArrayList<>();
                Stack<Block> checksurr = new Stack();
                Block base = ev.getClickedBlock();
                blocks.add(base);
                checksurr.push(base);

                while (!checksurr.isEmpty() && checksurr.size() != reclimit) {
                    Block check = checksurr.pop();

                    for (BlockFace face : values()) {
                        Block rel = check.getRelative(face);
                        if (rel != null && !AIR.equals(rel.getType())) {
                            if (!blocks.contains(rel)) {
                                blocks.add(rel);
                                checksurr.push(rel);
                            }
                        }
                    }
                }

                broadcastMessage("public class Factory extends MultiBlock {");
                broadcastMessage("public Factory() {");
                broadcastMessage("super(");
//                Iterator<Block> it = blocks.iterator();
                for (Iterator<Block> it = blocks.iterator(); it.hasNext();) {
                    Block block = it.next();
                    Material type = block.getType();
                    int xdiff = (block.getX() - base.getX());
                    int ydiff = (block.getY() - base.getY());
                    int zdiff = (block.getZ() - base.getZ());

                    if (it.hasNext()) {
                        String msg = "new Pair(new Vec3(" + xdiff + "," + ydiff + "," + zdiff + "), Material." + type + " ),";
                        broadcastMessage(msg);
                    } else {
                        String msg = "new Pair(new Vec3(" + xdiff + "," + ydiff + "," + zdiff + "), Material." + type + " )";
                        broadcastMessage(msg);
                    }

                }
                broadcastMessage(");");

                broadcastMessage("}");
                ev.setCancelled(true);

            }
        }
    }
}
