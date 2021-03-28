package ru.quickston.fixer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Dupe implements Listener {

   FileConfiguration cfg = Bukkit.getPluginManager().getPlugin("Fixer").getConfig();
   String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Fixer" + ChatColor.DARK_GRAY + "] ";

   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
      if (this.cfg.getBoolean("Dupe.blockDupeInVehicle") && e.getPlayer().isInsideVehicle() && e.hasBlock()) {
         e.setCancelled(true);
         e.getPlayer().sendMessage(this.prefix + this.cfg.get("Dupe.msg"));
      }
   }

   @EventHandler
   public void onInteractEntity(PlayerInteractEntityEvent e) {
      if (this.cfg.getBoolean("Dupe.blockDupeInVehicle") && e.getPlayer().isInsideVehicle() && (e.getRightClicked().getType() == EntityType.MINECART_CHEST || e.getRightClicked().getType() == EntityType.MINECART_FURNACE || e.getRightClicked().getType() == EntityType.MINECART_HOPPER)) {
         e.setCancelled(true);
         e.getPlayer().sendMessage(this.prefix + this.cfg.get("Dupe.msg"));
      }
   }

   @EventHandler(priority = EventPriority.HIGHEST)
   public void onCmd(PlayerCommandPreprocessEvent e) {
      if (this.cfg.getBoolean("Dupe.blockDupeCmds")) {
         String cmd = e.getMessage().toLowerCase();
         if (cmd.contains("/dupe") || cmd.contains("/sd") || cmd.contains("/simpledupe")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(this.prefix + this.cfg.get("Dupe.msg"));
         }

         if (cmd.contains("/more")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(this.prefix + this.cfg.get("Dupe.msg"));
         }
      }
   }

}
