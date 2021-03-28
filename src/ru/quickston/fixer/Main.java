package ru.quickston.fixer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

   PluginDescriptionFile pdf = this.getDescription();
   private static Main instance;
   String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Fixer" + ChatColor.DARK_GRAY + "] ";

   public static Main getInstance() {
      return instance;
   }

   @Override
   public void onLoad() {
      instance = this;
      Config.generateConfig();
   }

   @Override
   public void onEnable() {
      Bukkit.getPluginManager().registerEvents(this, this);
      Bukkit.getPluginManager().registerEvents(new Drop(), this);
      Bukkit.getPluginManager().registerEvents(new Potions(), this);
      Bukkit.getPluginManager().registerEvents(new ColorCodes(), this);
      Bukkit.getPluginManager().registerEvents(new Enchants(), this);
      Bukkit.getPluginManager().registerEvents(new Dupe(), this);
      Bukkit.getPluginManager().registerEvents(new AntiAdvert(), this);
      Bukkit.getPluginManager().registerEvents(new WorldEdit(), this);
      if (getServer().getPluginManager().getPlugin("WorldEdit") != null && getServer().getPluginManager().getPlugin("WorldGuard") != null) {
         Bukkit.getPluginManager().registerEvents(new WorldGuard(), this);
      } else {
         getLogger().info(ChatColor.RED + " WorldEdit & WorldGuard not installed. Option <WGBlocks> disabled.");
      }
   }

   @Override
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
      Player p = (Player)sender;
      command.getName().equalsIgnoreCase("fixer");
      if (args.length == 0) {
         p.sendMessage(ChatColor.DARK_GRAY + "=============" + ChatColor.AQUA + "Fixer " + pdf.getVersion() + ChatColor.DARK_GRAY + "=============");
         p.sendMessage(ChatColor.GREEN + "/fixer reload" + ChatColor.GRAY + " - перезагрузить конфиг.");
         p.sendMessage(ChatColor.DARK_GRAY + "=====" + ChatColor.AQUA + ChatColor.BOLD + "Minecraft-Hosting.ru" + ChatColor.DARK_GRAY + "======");
         return true;
      } else if (args[0].equalsIgnoreCase("reload")) {
         if (p.hasPermission("fixer.reload")) {
            this.reloadConfig();
            sender.sendMessage(prefix + ChatColor.GREEN + "Конфиг перезагружен.");
         } else {
            sender.sendMessage(prefix + ChatColor.RED + "У вас нет прав.");
         }

         return true;
      } else {
         return true;
      }
   }

   @EventHandler(priority = EventPriority.HIGHEST)
   public void onCmd(PlayerCommandPreprocessEvent e) {
      String msg = e.getMessage().toLowerCase();
      if (msg.contains("/fixer") || msg.contains("/fx")) {
         e.getPlayer().sendMessage(prefix + ChatColor.GRAY + pdf.getWebsite());
      }
   }

}
