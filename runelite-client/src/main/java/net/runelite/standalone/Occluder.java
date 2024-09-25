package net.runelite.standalone;

import java.util.Date;

public final class Occluder {
   static int field1806;
   int maxTileX;
   int field1801;
   int minX;
   int maxX;
   int type;
   int field1796;
   int maxTileY;
   int minTileY;
   int field1803;
   int maxZ;
   int minTileX;
   int field1788;
   int field1799;
   int maxY;
   int field1802;
   int field1804;
   int minY;
   int minZ;

   public static ItemDefinition getItemDefinition(int var0) {
      ItemDefinition var1 = (ItemDefinition)ItemDefinition.ItemDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemDefinition.ItemDefinition_archive.method4020(10, var0, (short)9424);
         var1 = new ItemDefinition();
         var1.id = var0;
         if(var2 != null) {
            var1.method4527(new Buffer(var2));
            //TODO: Custom Item Definitions
            var1.postDecode();
         }

         var1.method4528();
         if(var1.noteTemplate != -1) {
            var1.method4552(getItemDefinition(var1.noteTemplate), getItemDefinition(var1.note));
         }

         if(var1.notedId != -1) {
            var1.method4532(getItemDefinition(var1.notedId), getItemDefinition(var1.unnotedId));
         }

         if(var1.placeholderTemplate != -1) {
            var1.method4533(getItemDefinition(var1.placeholderTemplate), getItemDefinition(var1.placeholder));
         }

         if(!class163.ItemDefinition_inMembersWorld && var1.isMembersOnly) {
            var1.name = "Members object";
            var1.isTradable = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.shiftClickIndex = -1;
            var1.team = 0;
            if(var1.params != null) {
               boolean var3 = false;

               for(Node var4 = var1.params.method6068(); var4 != null; var4 = var1.params.method6064()) {
                  ParamDefinition var5 = WallDecoration.method2913((int)var4.key);
                  if(var5.autoDisable) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.params = null;
               }
            }
         }

         ItemDefinition.ItemDefinition_cached.method3034(var1, (long)var0);
         return var1;
      }
   }

   public static void method3081() {
      try {
         JagexCache.JagexCache_dat2File.method23();

         for(int var0 = 0; var0 < JagexCache.idxCount; ++var0) {
            class188.JagexCache_idxFiles[var0].method23();
         }

         JagexCache.JagexCache_idx255File.method23();
         JagexCache.JagexCache_randomDat.method23();
      } catch (Exception var2) {
         ;
      }

   }

   static void method3080(String var0) {
      class197.field2177 = var0;

      try {
         String var1 = ViewportMouse.client.getParameter(Integer.toString(18));
         String var2 = ViewportMouse.client.getParameter(Integer.toString(13));
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = class33.method680() + 94608000000L;
            Calendar.Calendar_calendar.setTime(new Date(var6));
            int var8 = Calendar.Calendar_calendar.get(7);
            int var9 = Calendar.Calendar_calendar.get(5);
            int var10 = Calendar.Calendar_calendar.get(2);
            int var11 = Calendar.Calendar_calendar.get(1);
            int var12 = Calendar.Calendar_calendar.get(11);
            int var13 = Calendar.Calendar_calendar.get(12);
            int var14 = Calendar.Calendar_calendar.get(13);
            String var5 = Calendar.DAYS_OF_THE_WEEK[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         class27.method538(ViewportMouse.client, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var15) {
         ;
      }

   }
}
