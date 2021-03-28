package ru.quickston.fixer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogFile {

   public static void log(String message) {
      try {
         File e = Main.getInstance().getDataFolder();
         if (!e.exists()) {
            e.mkdir();
         }

         File advert = new File(Main.getInstance().getDataFolder(), "adverts.txt");
         if (!advert.exists()) {
            advert.createNewFile();
         }

         FileWriter fw = new FileWriter(advert, true);
         PrintWriter pw = new PrintWriter(fw);
         pw.println(message);
         pw.flush();
         pw.close();
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

}
