package net.runelite.standalone;

import java.security.SecureRandom;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.GraphicsObjectCreated;

public final class GraphicsObject extends Entity implements net.runelite.api.GraphicsObject {
   static SecureRandom secureRandom;
   int id;
   int y;
   SequenceDefinition sequenceDefinition;
   int x;
   int plane;
   int cycleStart;
   int frameCycle;
   int height;
   boolean isFinished;
   int frame;

   GraphicsObject(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.frame = 0;
      this.frameCycle = 0;
      this.isFinished = false;
      this.id = var1;
      this.plane = var2;
      this.x = var3;
      this.y = var4;
      this.height = var5;
      this.cycleStart = var7 + var6;
      int var8 = InterfaceParent.method1139(this.id).sequence;
      if(var8 != -1) {
         this.isFinished = false;
         this.sequenceDefinition = GrandExchangeOfferUnitPriceComparator.method1468(var8);
      } else {
         this.isFinished = true;
      }

      this.rl$$init();
   }

   protected final Model vmethod3072(int var1) {
      SpotAnimationDefinition var2 = InterfaceParent.method1139(this.id);
      Model var3;
      if(!this.isFinished) {
         var3 = var2.method4392(this.frame);
      } else {
         var3 = var2.method4392(-1);
      }

      return var3 == null?null:var3;
   }

   final void method1255(int var1) {
      if(!this.isFinished) {
         this.frameCycle += var1;

         while(this.frameCycle > this.sequenceDefinition.frameLengths[this.frame]) {
            this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
            ++this.frame;
            if(this.frame >= this.sequenceDefinition.frameIds.length) {
               this.isFinished = true;
               break;
            }
         }

      }
   }

   private void rl$$init() {
      GraphicsObjectCreated var1 = new GraphicsObjectCreated(this);
      ViewportMouse.client.getCallbacks().post(GraphicsObjectCreated.class, var1);
   }

   public LocalPoint getLocation() {
      return new LocalPoint(this.x, this.y);
   }

   @Override
   public int getHeight() {
      return this.height;
   }

   @Override
   public int getId() {
      return this.id;
   }

   @Override
   public int getStartCycle() {
      return this.cycleStart;
   }

   @Override
   public int getLevel() {
      return this.plane;
   }
}
