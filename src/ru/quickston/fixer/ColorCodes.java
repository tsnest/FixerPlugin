package ru.quickston.fixer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class ColorCodes implements Listener {

   String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Fixer" + ChatColor.DARK_GRAY + "] ";
   Plugin plugin = Bukkit.getPluginManager().getPlugin("Fixer");

   @EventHandler
   public void onChat(AsyncPlayerChatEvent e) {
      if (this.plugin.getConfig().getBoolean("ColorCodes.active")) {
         String msg = e.getMessage();
         if (msg.contains("&r") || msg.contains("&R") && !e.getPlayer().isOp()) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(this.prefix + this.plugin.getConfig().getString("ColorCodes.msg"));
         }
      }
   }

}
