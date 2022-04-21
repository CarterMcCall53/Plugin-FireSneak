package org.tartarsauce.firetrailplugin;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Events implements Listener {
    @EventHandler
    public void onPlayerMovement(PlayerMoveEvent e) {
        if (e.getFrom().getBlockX() == e.getTo().getBlockX()) {
            if (e.getFrom().getBlockY() == e.getTo().getBlockY()) {
                if (e.getFrom().getBlockZ() == e.getTo().getBlockZ()) {
                    return;
                }
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                // code here
                var loc = e.getFrom();
                e.getPlayer().getWorld().setType(loc, Material.FIRE);
            }
        }.runTaskLater(FireTrailPlugin.plugin, 5);

    }
}
