package net.runelite.standalone;

public class class47 {
    static int[] regionLandArchiveIds;

   static final void method824() {
      if(Client.field851 != WorldMapRectangle.plane) {
         Client.field851 = WorldMapRectangle.plane;
         int var0 = WorldMapRectangle.plane;
         int[] var1 = ObjectSound.sceneMinimapSprite.pixels;
         int var2 = var1.length;

         int var3;
         for(var3 = 0; var3 < var2; ++var3) {
            var1[var3] = 0;
         }

         int var4;
         int var5;
         for(var3 = 1; var3 < 103; ++var3) {
            var4 = (103 - var3) * 2048 + 24628;

            for(var5 = 1; var5 < 103; ++var5) {
               if((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
                  PacketWriter.scene.drawTile(var1, var4, 512, var0, var5, var3);
               }

               if(var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
                  PacketWriter.scene.drawTile(var1, var4, 512, var0 + 1, var5, var3);
               }

               var4 += 4;
            }
         }

         var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
         var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
         ObjectSound.sceneMinimapSprite.setRaster();

         int var6;
         for(var5 = 1; var5 < 103; ++var5) {
            for(var6 = 1; var6 < 103; ++var6) {
               if((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
                  class30.drawObject(var0, var6, var5, var3, var4);
               }

               if(var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
                  class30.drawObject(var0 + 1, var6, var5, var3, var4);
               }
            }
         }

         Client.mapIconCount = 0;

         for(var5 = 0; var5 < 104; ++var5) {
            for(var6 = 0; var6 < 104; ++var6) {
               long var7 = PacketWriter.scene.method3143(WorldMapRectangle.plane, var5, var6);
               if(0L != var7) {
                  int var9 = class86.method2114(var7);
                  int var10 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var9).mapIconId;
                  if(var10 >= 0) {
                     Client.mapIcons[Client.mapIconCount] = Decimator.method2498(var10).method4369(false);
                     Client.mapIconXs[Client.mapIconCount] = var5;
                     Client.mapIconYs[Client.mapIconCount] = var6;
                     ++Client.mapIconCount;
                  }
               }
            }
         }

         class30.rasterProvider.setRaster();
      }

   }
}
