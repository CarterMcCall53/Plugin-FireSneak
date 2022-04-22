package dev.cmccall.firesneakplugin;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class Events implements Listener {
    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent e) {
        if (e.getPlayer().isSneaking()) {
            for (Entity en : e.getPlayer().getNearbyEntities(20, 20, 20)) {
                if (en instanceof LivingEntity) {
                    if (en == e.getPlayer()) {
                        return;
                    } else {
                        en.setFireTicks(200);
                        en.getWorld().spawnParticle(Particle.FLAME, en.getLocation(), 20);
                        en.getWorld().playSound(en.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10f, 1);
                    }
                }
            }
        }
    }
}

