package ru.quickston.fixer;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class WorldEdit implements Listener {

   String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Fixer" + ChatColor.DARK_GRAY + "] ";
   Plugin plugin = Bukkit.getPluginManager().getPlugin("Fixer");

   @EventHandler(priority = EventPriority.HIGHEST)
   public void onCmd(PlayerCommandPreprocessEvent e) {
      if (this.plugin.getConfig().getBoolean("WorldEdit.active")) {
         String msg = e.getMessage().toLowerCase();
         if (msg.contains("rg claim") || msg.contains("region claim")) {
            Player p = e.getPlayer();
            WorldEditPlugin worldEdit = (WorldEditPlugin)Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
            Selection sel = worldEdit.getSelection(p);
            if (sel != null) {
               int seled = sel.getLength() * sel.getWidth() * sel.getHeight();
               if (seled > this.plugin.getConfig().getInt("WorldEdit.maxClaimVolume")) {
                  e.setCancelled(true);
                  p.sendMessage(this.prefix + this.plugin.getConfig().getString("WorldEdit.msg"));
               }
            }
         }
      }
   }

}
