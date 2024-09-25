package net.runelite.standalone;

import net.runelite.api.events.DynamicObjectAnimationChanged;

public class DynamicObject extends Entity implements net.runelite.api.DynamicObject {
   int type;
   int y;
   SequenceDefinition sequenceDefinition;
   int x;
   int plane;
   int orientation;
   int cycleStart;
   int id;
   public int animationID;
   int frame;

   DynamicObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Entity var9) {
      this.id = var1;
      this.type = var2;
      this.orientation = var3;
      this.plane = var4;
      this.x = var5;
      this.y = var6;
      if(var7 != -1) {
         this.sequenceDefinition = GrandExchangeOfferUnitPriceComparator.method1468(var7);
         this.frame = 0;
         this.cycleStart = Client.cycle - 1;
         this.onAnimCycleCountChanged(-1);
         if(this.sequenceDefinition.field3438 == 0 && var9 != null && var9 instanceof DynamicObject) {
            DynamicObject var10 = (DynamicObject)var9;
            if(var10.sequenceDefinition == this.sequenceDefinition) {
               this.frame = var10.frame;
               this.cycleStart = var10.cycleStart;
               this.onAnimCycleCountChanged(-1);
               this.rl$init(var1, var2, var3, var4, var5, var6, var7, var8, var9);
               return;
            }
         }

         if(var8 && this.sequenceDefinition.frameCount != -1) {
            this.frame = (int)(Math.random() * (double)this.sequenceDefinition.frameIds.length);
            this.cycleStart -= (int)(Math.random() * (double)this.sequenceDefinition.frameLengths[this.frame]);
            this.onAnimCycleCountChanged(-1);
         }
      }

      this.rl$init(var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   protected final Model vmethod3072(int var1) {
      boolean var8 = false;

      Model var3;
      try {
         var8 = true;
         int var2 = this.frame;
         if(var2 < 0) {
            this.frame = (var2 ^ Integer.MIN_VALUE) & 65535;
         }

         var3 = this.copy$getModel(var1);
         var8 = false;
      } finally {
         if(var8) {
            int var6 = this.frame;
            if(var6 < 0) {
               this.frame = (var6 ^ Integer.MIN_VALUE) & 65535;
            }

         }
      }

      int var4 = this.frame;
      if(var4 < 0) {
         this.frame = (var4 ^ Integer.MIN_VALUE) & 65535;
      }

      return (Model)var3;
   }

   public final Model copy$getModel(int var1) {
      if(this.sequenceDefinition != null) {
         int var2 = Client.cycle - this.cycleStart;
         if(var2 > 100 && this.sequenceDefinition.frameCount > 0) {
            var2 = 100;
         }

         label56: {
            do {
               do {
                  if(var2 <= this.sequenceDefinition.frameLengths[this.frame]) {
                     break label56;
                  }

                  var2 -= this.sequenceDefinition.frameLengths[this.frame];
                  ++this.frame;
               } while(this.frame < this.sequenceDefinition.frameIds.length);

               this.frame -= this.sequenceDefinition.frameCount;
            } while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

            this.sequenceDefinition = null;
         }

         this.cycleStart = Client.cycle - var2;
         this.onAnimCycleCountChanged(-1);
      }

      ObjectDefinition var13 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(this.id);
      if(var13.transforms != null) {
         var13 = var13.method4733();
      }

      if(var13 == null) {
         return null;
      } else {
         int var3;
         int var4;
         if(this.orientation != 1 && this.orientation != 3) {
            var3 = var13.sizeX;
            var4 = var13.sizeY;
         } else {
            var3 = var13.sizeY;
            var4 = var13.sizeX;
         }

         int var5 = (var3 >> 1) + this.x;
         int var6 = (var3 + 1 >> 1) + this.x;
         int var7 = (var4 >> 1) + this.y;
         int var8 = (var4 + 1 >> 1) + this.y;
         int[][] var9 = Tiles.Tiles_heights[this.plane];
         int var10 = var9[var6][var7] + var9[var5][var7] + var9[var5][var8] + var9[var6][var8] >> 2;
         int var11 = (this.x << 7) + (var3 << 6);
         int var12 = (this.y << 7) + (var4 << 6);
         return var13.method4723(this.type, this.orientation, var9, var11, var10, var12, this.sequenceDefinition, this.frame);
      }
   }

   public void rl$init(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Entity var9) {
      this.animationID = var7;
      if(var7 != -1) {
         DynamicObjectAnimationChanged var10 = new DynamicObjectAnimationChanged();
         var10.setObject(var1);
         var10.setAnimation(var7);
         ViewportMouse.client.getCallbacks().post(DynamicObjectAnimationChanged.class, var10);
      }

   }

   public void onAnimCycleCountChanged(int var1) {
      if(ViewportMouse.client.isInterpolateObjectAnimations()) {
         int var2 = ViewportMouse.client.getGameCycle() - this.cycleStart;
         this.frame = Integer.MIN_VALUE | var2 << 16 | this.frame;
      }

   }

   public int getAnimationID() {
      return this.animationID;
   }

   public static final boolean method1568() {
      KeyHandler var0 = KeyHandler.KeyHandler_instance;
      boolean var10000;
      synchronized(KeyHandler.KeyHandler_instance) {
         if(KeyHandler.field181 == KeyHandler.field179) {
            var10000 = false;
            return var10000;
         }

         SecureRandomFuture.field748 = KeyHandler.field176[KeyHandler.field179];
         KeyHandler.field182 = KeyHandler.field175[KeyHandler.field179];
         KeyHandler.field179 = KeyHandler.field179 + 1 & 127;
         var10000 = true;
      }

      return var10000;
   }

   static final void method1573(PcmStream var0) {
      var0.active = false;
      if(var0.sound != null) {
         var0.sound.position = 0;
      }

      for(PcmStream var1 = var0.vmethod3775(); var1 != null; var1 = var0.vmethod3794()) {
         method1573(var1);
      }

   }

   static final void method1570() {
      Client.packetWriter.method1623();
      WorldMapIcon_1.method2278();
      PacketWriter.scene.method3141();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method3352();
      }

      System.gc();
      class197.field2173 = 1;
      class197.musicTrackArchive = null;
      class183.musicTrackGroupId = -1;
      class38.musicTrackFileId = -1;
      TileItem.field816 = 0;
      WorldMapSectionType.musicTrackBoolean = false;
      MusicPatchNode2.field2119 = 2;
      Client.field874 = -1;
      Client.field967 = false;
      ClientPacket.method3879();
      MouseRecorder.setGameState(10);
   }

   static final void method1572() {
      for(Projectile var0 = (Projectile)Client.projectiles.last(); var0 != null; var0 = (Projectile)Client.projectiles.previous()) {
         if(var0.plane == WorldMapRectangle.plane && Client.cycle <= var0.cycleEnd) {
            if(Client.cycle >= var0.cycleStart) {
               if(var0.targetIndex > 0) {
                  NPC var1 = Client.npcs[var0.targetIndex - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y * 682054857 >= 0 && var1.y * 682054857 < 13312) {
                     var0.method2237(var1.x, var1.y * 682054857, MusicPatchPcmStream.method3798(var1.x, var1.y * 682054857, var0.plane) - var0.endHeight, Client.cycle);
                  }
               }

               if(var0.targetIndex < 0) {
                  int var2 = -var0.targetIndex - 1;
                  Player var3;
                  if(var2 == Client.localPlayerIndex) {
                     var3 = class215.localPlayer;
                  } else {
                     var3 = Client.players[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y * 682054857 >= 0 && var3.y * 682054857 < 13312) {
                     var0.method2237(var3.x, var3.y * 682054857, MusicPatchPcmStream.method3798(var3.x, var3.y * 682054857, var0.plane) - var0.endHeight, Client.cycle);
                  }
               }

               var0.method2236(Client.field906);
               PacketWriter.scene.method3125(WorldMapRectangle.plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.yaw, -1L, false);
            }
         } else {
            var0.unlink();
         }
      }

   }
}
