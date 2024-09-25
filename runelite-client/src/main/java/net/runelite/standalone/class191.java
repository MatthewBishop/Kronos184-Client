package net.runelite.standalone;

public class class191 {
   static final class191 field2144;
   static final class191 field2145;
   static final class191 field2143;

   static {
      field2143 = new class191();
      field2144 = new class191();
      field2145 = new class191();
   }

   public static void method3763() {
      if(KeyHandler.KeyHandler_instance != null) {
         KeyHandler var0 = KeyHandler.KeyHandler_instance;
         synchronized(KeyHandler.KeyHandler_instance) {
            KeyHandler.KeyHandler_instance = null;
         }
      }

   }

   static final void method3762(Actor var0) {
      int var1 = var0.field686 - Client.cycle;
      int var2 = var0.field709 * 128 + var0.size * 64;
      int var3 = var0.field711 * 128 + var0.size * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y * 682054857) / var1 * -944175751;
      var0.field687 = 0;
      var0.orientation = var0.field715;
   }
}
