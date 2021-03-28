package ru.quickston.fixer;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class Drop implements Listener {

   Plugin cfg = Bukkit.getPluginManager().getPlugin("Fixer");
   HashMap<String, Integer> dpm = new HashMap<String, Integer>();
   String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Fixer" + ChatColor.DARK_GRAY + "] ";

   @EventHandler
   public void onJoin(PlayerJoinEvent e) {
      if (this.cfg.getConfig().getBoolean("Drop.active")) {
         Player p = e.getPlayer();
         this.dpm.put(p.getName(), 0);
      }
   }

   @EventHandler
   public void DropPerMinute(PlayerDropItemEvent e) {
      if (this.cfg.getConfig().getBoolean("Drop.active")) {
         int seconds = this.cfg.getConfig().getInt("Drop.items");
         final Player p = e.getPlayer();
         if (!p.hasPermission("fixer.dropbypass")) {
            if (this.dpm.get(p.getName()) == 0) {
               Bukkit.getScheduler().scheduleSyncDelayedTask(Bukkit.getPluginManager().getPlugin("Fixer"), new Runnable() {
                  @Override
                  public void run() {
                     Drop.this.dpm.put(p.getName(), 0);
                  }
               }, (long)(seconds * 20));
            }

            if (this.dpm.get(p.getName()) == seconds) {
               p.sendMessage(this.prefix + this.cfg.getConfig().getString("Drop.msg"));
               e.setCancelled(true);
            } else {
               this.dpm.put(p.getName(), this.dpm.get(p.getName()) + 1);
            }
         }
      }
   }

}
