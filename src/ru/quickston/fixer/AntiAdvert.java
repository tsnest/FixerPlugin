package ru.quickston.fixer;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class AntiAdvert implements Listener {

   String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Fixer" + ChatColor.DARK_GRAY + "] ";
   Plugin plugin = Bukkit.getPluginManager().getPlugin("Fixer");

   @EventHandler(priority = EventPriority.HIGHEST)
   public void onChat(AsyncPlayerChatEvent e) {
      if (this.plugin.getConfig().getBoolean("Advert.active")) {
         Player p = e.getPlayer();
         String[] args = e.getMessage().split("");
         int count = 0;

         for(String format : args) {
            if (format.length() == 1 && Character.isDigit(format.charAt(0))) {
               ++count;
            }
         }

         if (count > this.plugin.getConfig().getInt("Advert.numLimit")) {
            e.setCancelled(true);
            p.sendMessage(this.prefix + this.plugin.getConfig().getString("Advert.msg"));
            if (this.plugin.getConfig().getBoolean("Advert.log")) {
               Date var9 = new Date();
               SimpleDateFormat var10 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
               LogFile.log("[" + var10.format(var9) + "] " + p.getName() + " : " + e.getMessage());
            }
         }
      }
   }

   @EventHandler(priority = EventPriority.HIGHEST)
   public void onCmd(PlayerCommandPreprocessEvent e) {
      if (this.plugin.getConfig().getBoolean("Advert.active")) {
         String low = e.getMessage().toLowerCase();
         if (low.contains("/msg")
                 || low.contains("/w ")
                 || low.contains("/m ")
                 || low.contains("/t ")
                 || low.contains("/emsg ")
                 || low.contains("/tell ")
                 || low.contains("/etell ")
                 || low.contains("/whisper ")
                 || low.contains("/ewhisper ")) {
            String[] args = e.getMessage().split("");
            int count = 0;

            for(String format : args) {
               if (format.length() == 1 && Character.isDigit(format.charAt(0))) {
                  ++count;
               }
            }

            if (count > this.plugin.getConfig().getInt("Advert.numLimit")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")
                    || low.contains("???")) {
               e.setCancelled(true);
               e.getPlayer().sendMessage(this.prefix + this.plugin.getConfig().getString("Advert.msg"));
               if (this.plugin.getConfig().getBoolean("Advert.log")) {
                  Date var9 = new Date();
                  SimpleDateFormat var10 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                  LogFile.log("[" + var10.format(var9) + "] " + e.getPlayer().getName() + " : " + e.getMessage());
               }
            }
         }
      }
   }

   @EventHandler
   public void onChat1(AsyncPlayerChatEvent e) {
      if (this.plugin.getConfig().getBoolean("Advert.blockSymbols")) {
         String msg = e.getMessage();
         if (msg.contains("???")
                 || msg.contains( "???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")
                 || msg.contains("???")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(this.prefix + this.plugin.getConfig().getString("Advert.msg"));
            if (this.plugin.getConfig().getBoolean("Advert.log")) {
               Date now = new Date();
               SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
               LogFile.log("[" + format.format(now) + "] " + e.getPlayer().getName() + " : " + e.getMessage());
            }
         }
      }
   }

}
