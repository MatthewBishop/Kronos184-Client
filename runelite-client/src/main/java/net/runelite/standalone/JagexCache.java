package net.runelite.standalone;

import java.io.File;

public class JagexCache {
   public static BufferedFile JagexCache_dat2File;
   public static int idxCount;
   static File JagexCache_locationFile;
   public static int ItemDefinition_fileCount;
   public static BufferedFile JagexCache_idx255File;
   public static BufferedFile JagexCache_randomDat;
   public static String userHomeDirectory;

   static {
      JagexCache_randomDat = null;
      JagexCache_dat2File = null;
      JagexCache_idx255File = null;
   }

   public static StructDefinition method3408(int var0) {
      StructDefinition var1 = (StructDefinition)StructDefinition.StructDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = StructDefinition.StructDefinition_archive.method4020(34, var0, (short)12139);
         var1 = new StructDefinition();
         if(var2 != null) {
            var1.method4500(new Buffer(var2));
         }

         var1.method4502();
         StructDefinition.StructDefinition_cached.method3034(var1, (long)var0);
         return var1;
      }
   }
}
