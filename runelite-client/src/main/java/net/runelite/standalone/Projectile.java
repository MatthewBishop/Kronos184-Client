package net.runelite.standalone;

import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.api.events.ProjectileSpawned;

public final class Projectile extends Entity implements net.runelite.api.Projectile {
   int plane;
   double x;
   int endHeight;
   int cycleStart;
   int sourceZ;
   int yaw;
   double speedY;
   int sourceY;
   int sourceX;
   double speedX;
   double speedZ;
   int slope;
   int id;
   double y;
   boolean isMoving;
   int targetIndex;
   int frame;
   double z;
   int pitch;
   double speed;
   double accelerationZ;
   int startHeight;
   SequenceDefinition sequenceDefinition;
   int frameCycle;
   int cycleEnd;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.isMoving = false;
      this.frame = 0;
      this.frameCycle = 0;
      this.id = var1;
      this.plane = var2;
      this.sourceX = var3;
      this.sourceY = var4;
      this.sourceZ = var5;
      this.cycleStart = var6;
      this.cycleEnd = var7;
      this.slope = var8;
      this.startHeight = var9;
      this.targetIndex = var10;
      this.endHeight = var11;
      this.isMoving = false;
      int var12 = InterfaceParent.method1139(this.id).sequence;
      if(var12 != -1) {
         this.sequenceDefinition = GrandExchangeOfferUnitPriceComparator.method1468(var12);
      } else {
         this.sequenceDefinition = null;
      }

      this.rl$$init();
   }

   final void method2236(int var1) {
      this.isMoving = true;
      this.x += this.speedX * (double)var1;
      this.y += this.speedY * (double)var1;
      this.z += (double)var1 * (double)var1 * 0.5D * this.accelerationZ + (double)var1 * this.speedZ;
      this.speedZ += this.accelerationZ * (double)var1;
      this.yaw = (int)(Math.atan2(this.speedX, this.speedY) * 325.949D) + 1024 & 2047;
      this.pitch = (int)(Math.atan2(this.speedZ, this.speed) * 325.949D) & 2047;
      if(this.sequenceDefinition != null) {
         this.frameCycle += var1;

         while(true) {
            do {
               do {
                  if(this.frameCycle <= this.sequenceDefinition.frameLengths[this.frame]) {
                     return;
                  }

                  this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
                  ++this.frame;
               } while(this.frame < this.sequenceDefinition.frameIds.length);

               this.frame -= this.sequenceDefinition.frameCount;
            } while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

            this.frame = 0;
         }
      }
   }

   protected final Model vmethod3072(int var1) {
      SpotAnimationDefinition var2 = InterfaceParent.method1139(this.id);
      Model var3 = var2.method4392(this.frame);
      if(var3 == null) {
         return null;
      } else {
         var3.method2369(this.pitch);
         return var3;
      }
   }

   final void method2237(int var1, int var2, int var3, int var4) {
      this.projectileMoved(var1, var2, var3, var4);
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.sourceX);
         double var7 = (double)(var2 - this.sourceY);
         double var9 = Math.sqrt(var7 * var7 + var5 * var5);
         this.x = (double)this.startHeight * var5 / var9 + (double)this.sourceX;
         this.y = (double)this.startHeight * var7 / var9 + (double)this.sourceY;
         this.z = (double)this.sourceZ;
      }

      var5 = (double)(this.cycleEnd + 1 - var4);
      this.speedX = ((double)var1 - this.x) / var5;
      this.speedY = ((double)var2 - this.y) / var5;
      this.speed = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
      if(!this.isMoving) {
         this.speedZ = -this.speed * Math.tan(0.02454369D * (double)this.slope);
      }

      this.accelerationZ = 2.0D * ((double)var3 - this.z - var5 * this.speedZ) / (var5 * var5);
   }

   public void projectileMoved(int var1, int var2, int var3, int var4) {
      LocalPoint var5 = new LocalPoint(var1, var2);
      ProjectileMoved var6 = new ProjectileMoved();
      var6.setProjectile(this);
      var6.setPosition(var5);
      var6.setZ(var3);
      ViewportMouse.client.getCallbacks().post(ProjectileMoved.class, var6);
   }

   @Override
   public int getEndCycle() {
      return this.cycleEnd;
   }

   private void rl$$init() {
      ProjectileSpawned var1 = new ProjectileSpawned();
      var1.setProjectile(this);
      ViewportMouse.client.getCallbacks().post(ProjectileSpawned.class, var1);
   }

   public int getRemainingCycles() {
      int var1 = ViewportMouse.client.getGameCycle();
      return this.getEndCycle() - var1;
   }

   public net.runelite.api.Actor getInteracting() {
      int var1 = this.targetIndex;
      if(var1 == 0) {
         return null;
      } else {
         int var2;
         if(var1 > 0) {
            var2 = var1 - 1;
            NPC[] var4 = ViewportMouse.client.getCachedNPCs();
            return var4[var2];
         } else {
            var2 = -var1 - 1;
             if(var2 == Client.combatTargetPlayerIndex) {
               return ViewportMouse.client.getLocalPlayer();
            } else {
               Player[] var3 = ViewportMouse.client.getCachedPlayers();
               return var3[var2];
            }
         }
      }
   }

   @Override
   public int getId() {
      return this.id;
   }

   @Override
   public int getFloor() {
      return this.plane;
   }

   @Override
   public int getX1() {
      return this.sourceX;
   }

   @Override
   public int getY1() {
      return this.sourceY;
   }

   @Override
   public int getHeight() {
      return this.sourceZ;
   }

   @Override
   public int getEndHeight() {
      return this.endHeight;
   }

   @Override
   public int getStartMovementCycle() {
      return this.cycleStart;
   }

   @Override
   public int getSlope() {
      return this.slope;
   }

   @Override
   public int getStartHeight() {
      return this.startHeight;
   }

   @Override
   public double getX() {
      return this.x;
   }

   @Override
   public double getY() {
      return this.y;
   }

   @Override
   public double getZ() {
      return this.z;
   }

   @Override
   public double getVelocityX() {
      return this.speedX;
   }

   @Override
   public double getVelocityY() {
      return this.speedY;
   }

   @Override
   public double getScalar() {
      return this.speed;
   }

   @Override
   public double getVelocityZ() {
      return this.speedZ;
   }

   static int method2238(int var0) {
      ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1525();
   }

   static final boolean method2244(Widget var0) {
      if(var0.cs1Comparisons == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
            int var2 = class223.method4124(var0, var1);
            int var3 = var0.cs1ComparisonValues[var1];
            if(var0.cs1Comparisons[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.cs1Comparisons[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.cs1Comparisons[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
