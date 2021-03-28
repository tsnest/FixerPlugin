package ru.quickston.fixer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class Potions implements Listener {

   Plugin plugin = Bukkit.getPluginManager().getPlugin("Fixer");

   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
      Player p = e.getPlayer();
      if (this.plugin.getConfig().getBoolean("Potion.active") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand() != null && p.getItemInHand().getType() != null && p.getItemInHand().getTypeId() == 373) {
         e.getItem().setAmount(1);
      }
   }

}
