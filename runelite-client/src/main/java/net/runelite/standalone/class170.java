package net.runelite.standalone;

public class class170 {
   static int field2003;
   static int[][] distances;
   static int[][] directions;
   static int[] bufferY;
   static Font fontBold12;
   static int[] bufferX;

   static {
      directions = new int[128][128];
      distances = new int[128][128];
      bufferX = new int[4096];
      bufferY = new int[4096];
   }

   public static int method3448(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }
}
