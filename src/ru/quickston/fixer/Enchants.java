package ru.quickston.fixer;

import java.util.Iterator;
import java.util.Map.Entry;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class Enchants implements Listener {

   Plugin plugin = Bukkit.getPluginManager().getPlugin("Fixer");

   @EventHandler
   public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
      if (this.plugin.getConfig().getBoolean("Enchants.checkOnDamage") && e.getDamager() instanceof Player) {
         Player p = (Player)e.getDamager();
         if (p.getItemInHand() != null && (p.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL) > 5 || p.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD) > 5 || p.getItemInHand().getEnchantmentLevel(Enchantment.DAMAGE_ARTHROPODS) > 5 || p.getItemInHand().getEnchantmentLevel(Enchantment.KNOCKBACK) > 2 || p.getItemInHand().getEnchantmentLevel(Enchantment.FIRE_ASPECT) > 2 || p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) > 3 || p.getItemInHand().getEnchantmentLevel(Enchantment.DIG_SPEED) > 5 || p.getItemInHand().getEnchantmentLevel(Enchantment.SILK_TOUCH) > 1 || p.getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) > 3 || p.getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) > 3)) {
            e.setCancelled(true);

            Iterator i$ = p.getItemInHand().getEnchantments().keySet().iterator();
            while(i$.hasNext()) {
               Enchantment del = (Enchantment)i$.next();
               p.getItemInHand().removeEnchantment(del);
            }
         }
      }
   }

   @EventHandler
   public void onBlockBreak(BlockBreakEvent e) {
      if (this.plugin.getConfig().getBoolean("Enchants.checkOnBlockBreak")) {
         Player p = e.getPlayer();
         if (p.getItemInHand() != null) {
            Iterator iterator = p.getItemInHand().getEnchantments().keySet().iterator();
            while(iterator.hasNext()) {
               Entry entry = (Entry)iterator.next();
               if ((int)entry.getValue() >= 6) {
                  e.setCancelled(true);

                  Iterator i$ = p.getItemInHand().getEnchantments().keySet().iterator();
                  while(i$.hasNext()) {
                     Enchantment del = (Enchantment)i$.next();
                     p.getItemInHand().removeEnchantment(del);
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onInventoryClick(InventoryClickEvent e) {
      if (this.plugin.getConfig().getBoolean("Enchants.checkOnClickInventory") && e.getWhoClicked() instanceof Player) {
         Player p = (Player)e.getWhoClicked();
         if (e.getCurrentItem() != null && (e.getCurrentItem().getEnchantmentLevel(Enchantment.DAMAGE_ALL) > 5 || e.getCurrentItem().getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD) > 5 || e.getCurrentItem().getEnchantmentLevel(Enchantment.DAMAGE_ARTHROPODS) > 5 || e.getCurrentItem().getEnchantmentLevel(Enchantment.KNOCKBACK) > 2 || e.getCurrentItem().getEnchantmentLevel(Enchantment.FIRE_ASPECT) > 2 || e.getCurrentItem().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) > 3 || e.getCurrentItem().getEnchantmentLevel(Enchantment.DIG_SPEED) > 5 || e.getCurrentItem().getEnchantmentLevel(Enchantment.SILK_TOUCH) > 1 || e.getCurrentItem().getEnchantmentLevel(Enchantment.DURABILITY) > 3 || e.getCurrentItem().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) > 3 || e.getCurrentItem().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) > 4 || e.getCurrentItem().getEnchantmentLevel(Enchantment.PROTECTION_FIRE) > 4 || e.getCurrentItem().getEnchantmentLevel(Enchantment.PROTECTION_FALL) > 4 || e.getCurrentItem().getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS) > 4 || e.getCurrentItem().getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE) > 4 || e.getCurrentItem().getEnchantmentLevel(Enchantment.OXYGEN) > 3 || e.getCurrentItem().getEnchantmentLevel(Enchantment.WATER_WORKER) > 1 || e.getCurrentItem().getEnchantmentLevel(Enchantment.THORNS) > 3 || e.getCurrentItem().getEnchantmentLevel(Enchantment.ARROW_DAMAGE) > 5 || e.getCurrentItem().getEnchantmentLevel(Enchantment.ARROW_FIRE) > 1 || e.getCurrentItem().getEnchantmentLevel(Enchantment.ARROW_INFINITE) > 1 || e.getCurrentItem().getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK) > 2)) {
            e.setCancelled(true);

            Iterator i$ = e.getCurrentItem().getEnchantments().keySet().iterator();
            while(i$.hasNext()) {
               Enchantment del = (Enchantment)i$.next();
               p.getItemInHand().removeEnchantment(del);
            }
         }
      }
   }

   @EventHandler
   public void onInteract(PlayerInteractEvent e) {
      if (this.plugin.getConfig().getBoolean("Enchants.checkOnInteract")) {
         Player p = e.getPlayer();
         if (p.getItemInHand() != null && p.getItemInHand().getType() != null && (p.getItemInHand().getTypeId() == 298 || p.getItemInHand().getTypeId() == 299 || p.getItemInHand().getTypeId() == 300 || p.getItemInHand().getTypeId() == 301 || p.getItemInHand().getTypeId() == 302 || p.getItemInHand().getTypeId() == 303 || p.getItemInHand().getTypeId() == 304 || p.getItemInHand().getTypeId() == 305 || p.getItemInHand().getTypeId() == 306 || p.getItemInHand().getTypeId() == 307 || p.getItemInHand().getTypeId() == 308 || p.getItemInHand().getTypeId() == 309 || p.getItemInHand().getTypeId() == 310 || p.getItemInHand().getTypeId() == 311 || p.getItemInHand().getTypeId() == 312 || p.getItemInHand().getTypeId() == 313 || p.getItemInHand().getTypeId() == 314 || p.getItemInHand().getTypeId() == 315 || p.getItemInHand().getTypeId() == 316 || p.getItemInHand().getTypeId() == 317 || p.getItemInHand().getTypeId() == 261 && e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && (p.getItemInHand().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) > 4 || p.getItemInHand().getEnchantmentLevel(Enchantment.PROTECTION_FIRE) > 4 || p.getItemInHand().getEnchantmentLevel(Enchantment.PROTECTION_FALL) > 4 || p.getItemInHand().getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS) > 4 || p.getItemInHand().getEnchantmentLevel(Enchantment.PROTECTION_PROJECTILE) > 4 || p.getItemInHand().getEnchantmentLevel(Enchantment.OXYGEN) > 3 || p.getItemInHand().getEnchantmentLevel(Enchantment.WATER_WORKER) > 1 || p.getItemInHand().getEnchantmentLevel(Enchantment.THORNS) > 3 || p.getItemInHand().getEnchantmentLevel(Enchantment.ARROW_DAMAGE) > 5 || p.getItemInHand().getEnchantmentLevel(Enchantment.ARROW_FIRE) > 1 || p.getItemInHand().getEnchantmentLevel(Enchantment.ARROW_INFINITE) > 1 || p.getItemInHand().getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK) > 2)) {
            Iterator i$ = p.getItemInHand().getEnchantments().keySet().iterator();
            while(i$.hasNext()) {
               Enchantment del = (Enchantment)i$.next();
               p.getItemInHand().removeEnchantment(del);
            }
         }
      }
   }

}
