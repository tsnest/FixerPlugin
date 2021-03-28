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
                    || low.contains("➀")
                    || low.contains("➁")
                    || low.contains("➂")
                    || low.contains("➃")
                    || low.contains("➄")
                    || low.contains("➅")
                    || low.contains("➆")
                    || low.contains("➇")
                    || low.contains("➈")
                    || low.contains("➊")
                    || low.contains("➋")
                    || low.contains("➌")
                    || low.contains("➍")
                    || low.contains("➎")
                    || low.contains("➏")
                    || low.contains("➐")
                    || low.contains("➑")
                    || low.contains("➒")
                    || low.contains("➓")
                    || low.contains("❶")
                    || low.contains("❷")
                    || low.contains("❸")
                    || low.contains("❹")
                    || low.contains("❺")
                    || low.contains("❻")
                    || low.contains("❼")
                    || low.contains("❽")
                    || low.contains("❾")) {
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
         if (msg.contains("➀")
                 || msg.contains( "➁")
                 || msg.contains("➂")
                 || msg.contains("➃")
                 || msg.contains("➄")
                 || msg.contains("➅")
                 || msg.contains("➆")
                 || msg.contains("➇")
                 || msg.contains("➈")
                 || msg.contains("➊")
                 || msg.contains("➋")
                 || msg.contains("➌")
                 || msg.contains("➍")
                 || msg.contains("➎")
                 || msg.contains("➏")
                 || msg.contains("➐")
                 || msg.contains("➑")
                 || msg.contains("➒")
                 || msg.contains("➓")
                 || msg.contains("❶")
                 || msg.contains("❷")
                 || msg.contains("❸")
                 || msg.contains("❹")
                 || msg.contains("❺")
                 || msg.contains("❻")
                 || msg.contains("❼")
                 || msg.contains("❽")
                 || msg.contains("❾")) {
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
