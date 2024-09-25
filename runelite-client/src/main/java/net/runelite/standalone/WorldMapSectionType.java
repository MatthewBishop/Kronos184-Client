package net.runelite.standalone;

public enum WorldMapSectionType implements Enumerated {
   WORLDMAPSECTIONTYPE0(0, (byte)0),
   WORLDMAPSECTIONTYPE1(3, (byte)1),
   WORLDMAPSECTIONTYPE2(2, (byte)2),
   WORLDMAPSECTIONTYPE3(1, (byte)3);

   static String field59;
   public static boolean musicTrackBoolean;
   final byte id;
   final int type;

   WorldMapSectionType(int var3, byte var4) {
      this.type = var3;
      this.id = var4;
   }

   public int getId() {
      return this.id;
   }

   static void method116(Widget var0) {
      if(var0.cycle == Client.field846) {
         Client.field1049[var0.rootIndex] = true;
      }

   }

   static String method113(String var0) {
      PlayerType[] var1 = class210.getPlayerTypes();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         PlayerType var3 = var1[var2];
         if(var3.modIcon != -1 && var0.startsWith(class256.method4655(var3.modIcon))) {
            var0 = var0.substring(6 + Integer.toString(var3.modIcon).length());
            break;
         }
      }

      return var0;
   }

   static boolean method118(Widget var0) {
      return var0.isHidden;
   }
}
