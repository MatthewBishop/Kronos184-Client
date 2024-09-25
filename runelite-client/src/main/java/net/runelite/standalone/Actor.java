package net.runelite.standalone;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import net.runelite.api.Hitsplat;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Hitsplat.HitsplatType;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AnimationChanged;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.events.InteractingChanged;
import net.runelite.api.events.LocalPlayerDeath;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.events.PlayerDeath;
import net.runelite.api.events.SpotAnimationChanged;

public abstract class Actor extends Entity implements net.runelite.api.Actor {
   int x;
   boolean isWalking;
   int turnRightSequence;
   String overheadText;
   byte hitSplatCount;
   int overheadTextCyclesRemaining;
   boolean field682;
   int walkBackSequence;
   int overheadTextColor;
   int walkLeftSequence;
   int turnLeftSequence;
   int runSequence;
   int walkSequence;
   int readySequence;
   int y;
   int walkRightSequence;
   int rotation;
   int playerCycle;
   int[] hitSplatTypes;
   boolean isAutoChatting;
   int size;
   int overheadTextEffect;
   int movementFrameCycle;
   int field703;
   int movementSequence;
   int[] hitSplatTypes2;
   int sequenceFrame;
   int field710;
   int field711;
   int[] hitSplatCycles;
   int sequenceDelay;
   int targetIndex;
   int movementFrame;
   int field709;
   int[] hitSplatValues2;
   int sequence;
   int field707;
   int field686;
   int spotAnimationFrameCycle;
   int heightOffset;
   boolean false0;
   int spotAnimation;
   int sequenceFrameCycle;
   IterableNodeDeque healthBars;
   int field712;
   int[] hitSplatValues;
   int spotAnimationFrame;
   int field695;
   byte[] pathTraversed;
   int pathLength;
   int field719;
   int[] pathY;
   int field715;
   int field720;
   int defaultHeight;
   int field687;
   int orientation;
   int field726;
   int npcCycle;
   int[] pathX;
   int field714;

   Actor() {
      this.isWalking = false;
      this.size = 1;
      this.readySequence = -1;
      this.turnLeftSequence = -1;
      this.turnRightSequence = -1;
      this.walkSequence = -1;
      this.walkBackSequence = -1;
      this.walkLeftSequence = -1;
      this.walkRightSequence = -1;
      this.runSequence = -1;
      this.overheadText = null;
      this.overheadTextChanged(-1);
      this.field682 = false;
      this.overheadTextCyclesRemaining = 100;
      this.overheadTextColor = 0;
      this.overheadTextEffect = 0;
      this.hitSplatCount = 0;
      this.hitSplatTypes = new int[4];
      this.hitSplatValues = new int[4];
      this.hitSplatCycles = new int[4];
      this.hitSplatTypes2 = new int[4];
      this.hitSplatValues2 = new int[4];
      this.healthBars = new IterableNodeDeque();
      this.targetIndex = -1;
      this.interactingChanged(-1);
      this.false0 = false;
      this.field695 = -1;
      this.movementSequence = -1;
      this.movementFrame = 0;
      this.movementFrameCycle = 0;
      this.sequence = -1;
      this.animationChanged(-1);
      this.sequenceFrame = 0;
      this.sequenceFrameCycle = 0;
      this.sequenceDelay = 0;
      this.field703 = 0;
      this.spotAnimation = -1;
      this.spotAnimationChanged(-1);
      this.spotAnimationFrame = 0;
      this.spotAnimationFrameCycle = 0;
      this.npcCycle = 0;
      this.defaultHeight = 200;
      this.field719 = 0;
      this.field720 = 32;
      this.pathLength = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.pathTraversed = new byte[10];
      this.field687 = 0;
      this.field726 = 0;
   }

   boolean vmethod1611() {
      return false;
   }

   final void method1442() {
      this.pathLength = 0;
      this.field726 = 0;
   }

   final void method1434(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.hitSplatCycles[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         HitSplatDefinition var13 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var1);
         HitSplatDefinition var12;
         if(var13 != null) {
            var12 = var13;
         } else {
            byte[] var14 = HitSplatDefinition.HitSplatDefinition_archive.method4020(32, var1, (short)-18673);
            var13 = new HitSplatDefinition();
            if(var14 != null) {
               var13.method4619(new Buffer(var14));
            }

            HitSplatDefinition.HitSplatDefinition_cached.method3034(var13, (long)var1);
            var12 = var13;
         }

         var10 = var12.field3409;
         var11 = var12.field3400;
      }

      int var15;
      if(var8) {
         if(var10 == -1) {
            this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
            return;
         }

         var9 = 0;
         var15 = 0;
         if(var10 == 0) {
            var15 = this.hitSplatCycles[0];
         } else if(var10 == 1) {
            var15 = this.hitSplatValues[0];
         }

         for(int var16 = 1; var16 < 4; ++var16) {
            if(var10 == 0) {
               if(this.hitSplatCycles[var16] < var15) {
                  var9 = var16;
                  var15 = this.hitSplatCycles[var16];
               }
            } else if(var10 == 1 && this.hitSplatValues[var16] < var15) {
               var9 = var16;
               var15 = this.hitSplatValues[var16];
            }
         }

         if(var10 == 1 && var15 >= var2) {
            this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
            return;
         }
      } else {
         if(var7) {
            this.hitSplatCount = 0;
         }

         for(var15 = 0; var15 < 4; ++var15) {
            byte var17 = this.hitSplatCount;
            this.hitSplatCount = (byte)((this.hitSplatCount + 1) % 4);
            if(this.hitSplatCycles[var17] <= var5) {
               var9 = var17;
               break;
            }
         }
      }

      if(var9 < 0) {
         this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
      } else {
         this.hitSplatTypes[var9] = var1;
         this.hitSplatValues[var9] = var2;
         this.hitSplatTypes2[var9] = var3;
         this.hitSplatValues2[var9] = var4;
         this.hitSplatCycles[var9] = var5 + var11 + var6;
         this.applyActorHitsplat(var1, var2, var3, var4, var5, var6);
      }
   }

   final void method1430(int var1) {
      HealthBarDefinition var3 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var1);
      HealthBarDefinition var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = HealthBarDefinition.HealthBarDefinition_archive.method4020(33, var1, (short)17224);
         var3 = new HealthBarDefinition();
         if(var4 != null) {
            var3.method4469(new Buffer(var4));
         }

         HealthBarDefinition.HealthBarDefinition_cached.method3034(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(HealthBar var5 = (HealthBar)this.healthBars.method5044(); var5 != null; var5 = (HealthBar)this.healthBars.method5024()) {
         if(var3 == var5.definition) {
            var5.unlink();
            return;
         }
      }

   }

   final void method1429(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.setCombatInfo(var1, var2, var3, var4, var5, var6);
      HealthBarDefinition var8 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var1);
      HealthBarDefinition var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = HealthBarDefinition.HealthBarDefinition_archive.method4020(33, var1, (short)1780);
         var8 = new HealthBarDefinition();
         if(var9 != null) {
            var8.method4469(new Buffer(var9));
         }

         HealthBarDefinition.HealthBarDefinition_cached.method3034(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      HealthBar var14 = null;
      HealthBar var10 = null;
      int var11 = var7.int2;
      int var12 = 0;

      HealthBar var13;
      for(var13 = (HealthBar)this.healthBars.method5044(); var13 != null; var13 = (HealthBar)this.healthBars.method5024()) {
         ++var12;
         if(var13.definition.field3296 == var8.field3296) {
            var13.method2246(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.definition.int1 <= var8.int1) {
            var14 = var13;
         }

         if(var13.definition.int2 > var11) {
            var10 = var13;
            var11 = var13.definition.int2;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new HealthBar(var8);
         if(var14 == null) {
            this.healthBars.method5027(var13);
         } else {
            IterableNodeDeque.method5021(var13, var14);
         }

         var13.method2246(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   public void setCombatInfo(int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var5 == 0) {
         if(this == ViewportMouse.client.getLocalPlayer()) {
            ViewportMouse.client.getLogger().debug("You died!");
            LocalPlayerDeath var7 = LocalPlayerDeath.INSTANCE;
            ViewportMouse.client.getCallbacks().post(LocalPlayerDeath.class, var7);
         } else if(this != ViewportMouse.client.getLocalPlayer() && this instanceof net.runelite.api.Player) {
            PlayerDeath var8 = new PlayerDeath((net.runelite.api.Player)this);
            ViewportMouse.client.getCallbacks().post(PlayerDeath.class, var8);
         } else if(this instanceof NPC) {
            ((NPC)this).setDead(true);
         }
      }

   }

   @Override
   public int getRSInteracting() {
      return this.targetIndex;
   }

   public net.runelite.api.Actor getInteracting() {
      int var1 = this.getRSInteracting();
      if(var1 != -1 && var1 != 65535) {
         if(var1 < 32768) {
            NPC[] var3 = ViewportMouse.client.getCachedNPCs();
            return var3[var1];
         } else {
            var1 -= 32768;
            Player[] var2 = ViewportMouse.client.getCachedPlayers();
            return var2[var1];
         }
      } else {
         return null;
      }
   }

   @Override
   public String getOverheadText() {
      return this.overheadText;
   }

   public WorldPoint getWorldLocation() {
      return WorldPoint.fromLocal(ViewportMouse.client, this.pathX[0] * 128 + 64, this.pathY[0] * 128 + 64, ViewportMouse.client.getPlane());
   }

   public LocalPoint getLocalLocation() {
      return new LocalPoint(this.x, this.y * 682054857);
   }

   @Override
   public int getAnimation() {
      return this.sequence;
   }

   @Override
   public int getActionFrame() {
      return this.sequenceFrame;
   }

   @Override
   public int getOrientation() {
      return this.orientation;
   }

   @Override
   public int getActionFrameCycle() {
      return this.sequenceFrameCycle;
   }

   @Override
   public void setActionFrame(int var1) {
      this.sequenceFrame = var1;
   }

   public void animationChanged(int var1) {
      AnimationChanged var2 = new AnimationChanged();
      var2.setActor(this);
      ViewportMouse.client.getCallbacks().post(AnimationChanged.class, var2);
   }

   public void applyActorHitsplat(int var1, int var2, int var3, int var4, int var5, int var6) {
      Hitsplat var7 = new Hitsplat(HitsplatType.fromInteger(var1), var2, var5 + var6);
      HitsplatApplied var8 = new HitsplatApplied();
      var8.setActor(this);
      var8.setHitsplat(var7);
      ViewportMouse.client.getCallbacks().post(HitsplatApplied.class, var8);
   }

   @Override
   public void setSpotAnimationFrame(int var1) {
      this.spotAnimationFrame = var1;
   }

   public void overheadTextChanged(int var1) {
      String var2 = this.getOverheadText();
      if(var2 != null) {
         OverheadTextChanged var3 = new OverheadTextChanged(this, var2);
         ViewportMouse.client.getCallbacks().post(OverheadTextChanged.class, var3);
      }

   }

   public void interactingChanged(int var1) {
      InteractingChanged var2 = new InteractingChanged(this, this.getInteracting());
      ViewportMouse.client.getCallbacks().post(InteractingChanged.class, var2);
   }

   public void spotAnimationChanged(int var1) {
      SpotAnimationChanged var2 = new SpotAnimationChanged();
      var2.setActor(this);
      ViewportMouse.client.getCallbacks().post(SpotAnimationChanged.class, var2);
   }

   public int getHealthRatio() {
      IterableNodeDeque var1 = this.healthBars;
      if(var1 != null) {
         Node var2 = var1.sentinel;
         Node var3 = var2.getNext();
         if(var3 instanceof HealthBar) {
            HealthBar var4 = (HealthBar)var3;
            IterableNodeDeque var5 = var4.updates;
            Node var6 = var5.sentinel;
            Node var7 = var6.getNext();
            if(var7 instanceof HealthBarUpdate) {
               HealthBarUpdate var8 = (HealthBarUpdate)var7;
                return var8.health;
            }
         }
      }

      return -1;
   }

   public int getHealth() {
      IterableNodeDeque var1 = this.healthBars;
      if(var1 != null) {
         Node var2 = var1.sentinel;
         Node var3 = var2.getNext();
         if(var3 instanceof HealthBar) {
            HealthBar var4 = (HealthBar)var3;
             HealthBarDefinition var5 = var4.definition;
            return var5.width;
         }
      }

      return -1;
   }

   public Polygon getCanvasTilePoly() {
      return Perspective.getCanvasTilePoly(ViewportMouse.client, this.getLocalLocation());
   }

   public Point getCanvasTextLocation(Graphics2D var1, String var2, int var3) {
      return Perspective.getCanvasTextLocation(ViewportMouse.client, var1, this.getLocalLocation(), var2, var3);
   }

   public Point getCanvasImageLocation(BufferedImage var1, int var2) {
      return Perspective.getCanvasImageLocation(ViewportMouse.client, this.getLocalLocation(), var1, var2);
   }

   public Point getCanvasSpriteLocation(net.runelite.api.Sprite var1, int var2) {
      return Perspective.getCanvasSpriteLocation(ViewportMouse.client, this.getLocalLocation(), var1, var2);
   }

   public Point getMinimapLocation() {
      return Perspective.localToMinimap(ViewportMouse.client, this.getLocalLocation());
   }

   public WorldArea getWorldArea() {
      int var1 = 1;
      if(this instanceof net.runelite.api.NPC) {
         net.runelite.api.NPCDefinition var2 = ((net.runelite.api.NPC)this).getDefinition();
         if(var2 != null && var2.getConfigs() != null) {
            var2 = var2.transform();
         }

         if(var2 != null) {
            var1 = var2.getSize();
         }
      }

      return new WorldArea(this.getWorldLocation(), var1, var1);
   }

   @Override
   public int getCurrentOrientation() {
      return this.rotation;
   }

   @Override
   public void setIdlePoseAnimation(int var1) {
      this.readySequence = var1;
   }

   @Override
   public void setOverheadText(String var1) {
      this.overheadText = var1;
   }

   @Override
   public void setPoseAnimation(int var1) {
      this.movementSequence = var1;
   }

   @Override
   public void setAnimation(int var1) {
      this.sequence = var1;
   }

   @Override
   public void setSpotAnimation(int var1) {
      this.spotAnimation = var1;
   }

   @Override
   public int getSpotAnimation() {
      return this.spotAnimation;
   }

   @Override
   public int getLogicalHeight() {
      return this.defaultHeight;
   }
}
