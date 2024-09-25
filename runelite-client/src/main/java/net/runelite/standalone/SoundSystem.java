package net.runelite.standalone;

public class SoundSystem implements Runnable {
   volatile PcmPlayer[] players;

   SoundSystem() {
      this.players = new PcmPlayer[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            PcmPlayer var2 = this.players[var1];
            if(var2 != null) {
               var2.method2755();
            }
         }
      } catch (Exception var4) {
         class19.method342((String)null, var4);
      }

   }

   public static void method2464(Buffer var0, int var1) {
      if(JagexCache.JagexCache_randomDat != null) {
         try {
            JagexCache.JagexCache_randomDat.method22(0L);
            JagexCache.JagexCache_randomDat.method29(var0.array, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   static final void method2463(Widget var0, int var1, int var2, int var3) {
      SpriteMask var4 = var0.method3975(false);
      if(var4 != null) {
         if(Client.minimapState < 3) {
            AttackOption.compass.method6205(var1, var2, var4.width, var4.height, 25, 25, Client.camAngleY, 256, var4.xStarts, var4.xWidths);
         } else {
            Rasterizer2D.method6430(var1, var2, 0, var4.xStarts, var4.xWidths);
         }

      }
   }
}
