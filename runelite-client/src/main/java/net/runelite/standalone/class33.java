package net.runelite.standalone;

public class class33 {
   static final class33 field250;
   static final class33 field253;
   static AbstractSocket field251;
   final int value;

   static {
      field253 = new class33(0);
      field250 = new class33(1);
   }

   class33(int var1) {
      this.value = var1;
   }

   public static synchronized byte[] method679(int var0) {
      return ByteArrayPool.method5765(var0, false);
   }

   static final void method675(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               Tiles.field525[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
               }

               if(var0 + var2 == var5 && var5 < 103) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   public static final synchronized long method680() {
      long var0 = System.currentTimeMillis();
      if(var0 < class289.field3628) {
         class289.field3629 += class289.field3628 - var0;
      }

      class289.field3628 = var0;
      return var0 + class289.field3629;
   }

   public static int method677(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 = var0 * var2;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var0 * var2;
      } else {
         return var2;
      }
   }

   static void method676(SequenceDefinition var0, int var1, int var2, int var3) {
      if(Client.soundEffectCount < 50 && Client.field1076 != 0) {
         if(var0.soundEffects != null && var1 < var0.soundEffects.length) {
            int var4 = var0.soundEffects[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.soundEffectIds[Client.soundEffectCount] = var5;
               Client.queuedSoundEffectLoops[Client.soundEffectCount] = var6;
               Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
               Client.soundEffects[Client.soundEffectCount] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.soundLocations[Client.soundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.soundEffectCount;
               Client.queuedSoundEffectCountChanged(-1);
            }
         }
      }
   }

   static void method678(Widget var0, int var1, int var2) {
      if(var0.xAlignment == 0) {
         var0.x = var0.rawX;
      } else if(var0.xAlignment == 1) {
         var0.x = var0.rawX + (var1 - var0.width) / 2;
      } else if(var0.xAlignment == 2) {
         var0.x = var1 - var0.width - var0.rawX;
      } else if(var0.xAlignment == 3) {
         var0.x = var0.rawX * var1 >> 14;
      } else if(var0.xAlignment == 4) {
         var0.x = (var1 - var0.width) / 2 + (var0.rawX * var1 >> 14);
      } else {
         var0.x = var1 - var0.width - (var0.rawX * var1 >> 14);
      }

      if(var0.yAlignment == 0) {
         var0.y = var0.rawY;
         var0.onPositionChanged(-1);
      } else if(var0.yAlignment == 1) {
         var0.y = (var2 - var0.height) / 2 + var0.rawY;
         var0.onPositionChanged(-1);
      } else if(var0.yAlignment == 2) {
         var0.y = var2 - var0.height - var0.rawY;
         var0.onPositionChanged(-1);
      } else if(var0.yAlignment == 3) {
         var0.y = var2 * var0.rawY >> 14;
         var0.onPositionChanged(-1);
      } else if(var0.yAlignment == 4) {
         var0.y = (var2 * var0.rawY >> 14) + (var2 - var0.height) / 2;
         var0.onPositionChanged(-1);
      } else {
         var0.y = var2 - var0.height - (var2 * var0.rawY >> 14);
         var0.onPositionChanged(-1);
      }

   }
}
