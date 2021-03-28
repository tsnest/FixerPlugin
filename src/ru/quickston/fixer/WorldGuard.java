package ru.quickston.fixer;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class WorldGuard implements Listener {

   Plugin plugin = Bukkit.getPluginManager().getPlugin("Fixer");
   String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Fixer" + ChatColor.DARK_GRAY + "] ";

   private WorldGuardPlugin getWorldGuard() {
      Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
      return plugin != null && plugin instanceof WorldGuardPlugin ? (WorldGuardPlugin)plugin : null;
   }

   @EventHandler
   public void onBlockPlace(BlockPlaceEvent e) {
      if (this.plugin.getConfig().getBoolean("WGBlocks.active")) {
         Player p = e.getPlayer();
         if (!p.hasPermission("fixer.wgblocksbypass") && this.plugin.getConfig().getIntegerList("WGBlocks.blocks").contains(e.getBlockPlaced().getTypeId())) {
            WorldGuardPlugin guard = this.getWorldGuard();
            RegionManager m = guard.getRegionManager(p.getLocation().getWorld());
            ApplicableRegionSet set = m.getApplicableRegions(Vector.toBlockPoint((double)e.getBlock().getX(), (double)e.getBlock().getY(), (double)e.getBlock().getZ()));
            if (set.size() == 0) {
               e.setCancelled(true);
               p.sendMessage(this.plugin.getConfig().getString("WGBlocks.msg"));
            } else {
               for(ProtectedRegion rg : set) {
                  if (!rg.getOwners().contains(p.getName()) && !rg.getMembers().contains(p.getName())) {
                     e.setCancelled(true);
                     p.sendMessage(this.plugin.getConfig().getString("WGBlocks.msg"));
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
      if (e.getAction() == Action.RIGHT_CLICK_BLOCK && this.plugin.getConfig().getBoolean("WGBlocks.active")) {
         Player p = e.getPlayer();
         if (!p.hasPermission("fixer.wgblocksbypass") && this.plugin.getConfig().getIntegerList("WGBlocks.blocks").contains(p.getItemInHand().getTypeId())) {
            WorldGuardPlugin guard = this.getWorldGuard();
            RegionManager m = guard.getRegionManager(p.getLocation().getWorld());
            ApplicableRegionSet set = m.getApplicableRegions(Vector.toBlockPoint((double)e.getClickedBlock().getX(), (double)e.getClickedBlock().getY(), (double)e.getClickedBlock().getZ()));
            if (set.size() == 0) {
               e.setCancelled(true);
               p.sendMessage(this.prefix + this.plugin.getConfig().getString("WGBlocks.msg"));
            } else {
               for(ProtectedRegion rg : set) {
                  if (!rg.getOwners().contains(p.getName()) && !rg.getMembers().contains(p.getName())) {
                     e.setCancelled(true);
                     p.sendMessage(this.prefix + this.plugin.getConfig().getString("WGBlocks.msg"));
                  }
               }
            }
         }
      }
   }

}
