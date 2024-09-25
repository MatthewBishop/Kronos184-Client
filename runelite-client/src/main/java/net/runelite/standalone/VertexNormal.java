package net.runelite.standalone;

public class VertexNormal {
   static ServerBuild field1530;
   int x;
   int z;
   int y;
   int magnitude;

   VertexNormal() {
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   public static String method2467(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 'A' && var7 <= 'Z') {
            var3 += (long)(var7 + 1 - 65);
         } else if(var7 >= 'a' && var7 <= 'z') {
            var3 += (long)(var7 + 1 - 97);
         } else if(var7 >= '0' && var7 <= '9') {
            var3 += (long)(var7 + 27 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(var3 % 37L == 0L && 0L != var3) {
         var3 /= 37L;
      }

      String var8 = World.method1215(var3);
      if(var8 == null) {
         var8 = "";
      }

      return var8;
   }

   public static void method2465() {
      MouseHandler var0 = MouseHandler.MouseHandler_instance;
      synchronized(MouseHandler.MouseHandler_instance) {
         MouseHandler.MouseHandler_currentButton = MouseHandler.MouseHandler_currentButtonVolatile;
         MouseHandler.MouseHandler_x = MouseHandler.MouseHandler_xVolatile;
         MouseHandler.MouseHandler_y = MouseHandler.MouseHandler_yVolatile;
         MouseHandler.MouseHandler_millis = MouseHandler.MouseHandler_lastMovedVolatile;
         MouseHandler.MouseHandler_lastButton = MouseHandler.MouseHandler_lastButtonVolatile;
         MouseHandler.MouseHandler_lastPressedX = MouseHandler.MouseHandler_lastPressedXVolatile;
         MouseHandler.MouseHandler_lastPressedY = MouseHandler.MouseHandler_lastPressedYVolatile;
         MouseHandler.MouseHandler_lastPressedTimeMillis = MouseHandler.MouseHandler_lastPressedTimeMillisVolatile;
         MouseHandler.MouseHandler_lastButtonVolatile = 0;
      }

   }

   public static void method2466() {
      class38.midiPcmStream.method3628();
      class197.field2173 = 1;
      class197.musicTrackArchive = null;
   }

   static boolean method2468(AbstractArchive var0, int var1, int var2) {
      byte[] var3 = var0.method4020(var1, var2, (short)-2259);
      if(var3 == null) {
         return false;
      } else {
         Tiles.decodeSprite(var3);
         return true;
      }
   }
}
