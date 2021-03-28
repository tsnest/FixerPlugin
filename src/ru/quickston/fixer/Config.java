package ru.quickston.fixer;

import java.util.Arrays;

public class Config {

   public static void generateConfig() {
      Main.getInstance().getConfig().addDefault("Enchants.checkOnDamage", true);
      Main.getInstance().getConfig().addDefault("Enchants.checkOnBlockBreak", true);
      Main.getInstance().getConfig().addDefault("Enchants.checkOnClickInventory", true);
      Main.getInstance().getConfig().addDefault("Enchants.checkOnInteract", true);
      Main.getInstance().getConfig().addDefault("Dupe.blockDupeCmds", true);
      Main.getInstance().getConfig().addDefault("Dupe.blockDupeInVehicle", true);
      Main.getInstance().getConfig().addDefault("Dupe.msg", "§cДюп запрещен.");
      Main.getInstance().getConfig().addDefault("Poion.active", true);
      Main.getInstance().getConfig().addDefault("ColorCodes.active", true);
      Main.getInstance().getConfig().addDefault("ColorCodes.msg", "§cИспользование &r в сообщении запрещено.");
      Main.getInstance().getConfig().addDefault("Drop.active", true);
      Main.getInstance().getConfig().addDefault("Drop.items", 128);
      Main.getInstance().getConfig().addDefault("Drop.seconds", 60);
      Main.getInstance().getConfig().addDefault("Drop.msg", "§cВы превысили лимит выкидываемых предметов.");
      Main.getInstance().getConfig().addDefault("WGBlocks.active", true);
      Integer[] list = new Integer[] { 327, 326, 259, 79, 33, 29, 23 };
      Main.getInstance().getConfig().addDefault("WGBlocks.blocks", Arrays.asList(list));
      Main.getInstance().getConfig().addDefault("WGBlocks.msg", "§cИспользовать этот предмет можно только на своем регионе.");
      Main.getInstance().getConfig().addDefault("Advert.active", true);
      Main.getInstance().getConfig().addDefault("Advert.numLimit", 6);
      Main.getInstance().getConfig().addDefault("Advert.msg", "§cРеклама сторонних серверов запрещена.");
      Main.getInstance().getConfig().addDefault("Advert.blockSymbols", true);
      Main.getInstance().getConfig().addDefault("Advert.log", true);
      Main.getInstance().getConfig().addDefault("WorldEdit.active", true);
      Main.getInstance().getConfig().addDefault("WorldEdit.maxClaimVolume", 40000);
      Main.getInstance().getConfig().addDefault("WorldEdit.msg", "§cВы превысили размер привата.");
      Main.getInstance().getConfig().options().copyDefaults(true);
      Main.getInstance().saveConfig();
   }

}
