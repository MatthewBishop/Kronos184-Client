package net.runelite.standalone;

import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.runelite.api.HeadIcon;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.SkullIcon;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.model.Triangle;
import net.runelite.api.model.Vertex;

public final class Player extends Actor implements net.runelite.api.Player {
   PlayerAppearance appearance;
   int tileHeight2;
   String[] actions;
   int combatLevel;
   int team;
   int field481;
   int headIconPrayer;
   int headIconPk;
   int field492;
   int field483;
   int tileHeight;
   Username username;
   int field478;
   boolean field491;
   int tileY;
   int tileX;
   int field476;
   int animationCycleEnd;
   public boolean friended;
   int index;
   Model model0;
   boolean isHidden;
   int field482;
   boolean isUnanimated;
   int animationCycleStart;
   int plane;
   TriBool isInClanChat;
   TriBool isFriendTriBool;
   int skillLevel;

   Player() {
      this.headIconPk = -1;
      this.headIconPrayer = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.skillLevel = 0;
      this.animationCycleStart = 0;
      this.animationCycleEnd = 0;
      this.isUnanimated = false;
      this.team = 0;
      this.isHidden = false;
      this.isFriendTriBool = TriBool.TriBool_unknown;
      this.isInClanChat = TriBool.TriBool_unknown;
      this.field491 = false;
   }

   boolean method1090() {
      if(this.isFriendTriBool == TriBool.TriBool_unknown) {
         this.method1092();
      }

      return this.isFriendTriBool == TriBool.TriBool_true;
   }

   final boolean vmethod1611() {
      return this.appearance != null;
   }

   void method1122() {
      this.isInClanChat = TriBool.TriBool_unknown;
   }

   void method1094() {
      this.isInClanChat = Varps.clanChat != null && Varps.clanChat.isMember(this.username)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   boolean method1093() {
      if(this.isInClanChat == TriBool.TriBool_unknown) {
         this.method1094();
      }

      return this.isInClanChat == TriBool.TriBool_true;
   }

   void method1092() {
      this.isFriendTriBool = Tiles.friendSystem.method903(this.username)?TriBool.TriBool_true:TriBool.TriBool_false;
      this.updateFriended();
   }

   void method1091() {
      this.isFriendTriBool = TriBool.TriBool_unknown;
   }

   protected final Model vmethod3072(int var1) {
      if(!ViewportMouse.client.isInterpolatePlayerAnimations()) {
         return (Model)this.copy$getModel(var1);
      } else {
         int var2 = this.getActionFrame();
         int var3 = this.movementFrame;
         int var4 = this.spotAnimationFrame;

         Model var5;
         try {
            this.setActionFrame(Integer.MIN_VALUE | this.getActionFrameCycle() << 16 | var2);
            int var11 = Integer.MIN_VALUE | this.movementFrameCycle << 16 | var3;
            this.movementFrame = var11;
            this.setSpotAnimationFrame(Integer.MIN_VALUE | this.spotAnimationFrameCycle << 16 | var4);
            var5 = this.copy$getModel(var1);
         } finally {
            this.setActionFrame(var2);
            this.movementFrame = var3;
            this.setSpotAnimationFrame(var4);
         }

         return (Model)var5;
      }
   }

   final void method1088(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      this.headIconPk = var1.readByte();
      this.headIconPrayer = var1.readByte();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.readUnsignedByte();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.readUnsignedByte();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == 65535) {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = Occluder.getItemDefinition(var4[var5] - 512).team;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= PlayerAppearance.field2742[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.readySequence = var1.readUnsignedShort();
      if(super.readySequence == 65535) {
         super.readySequence = -1;
      }

      super.turnLeftSequence = var1.readUnsignedShort();
      if(super.turnLeftSequence == 65535) {
         super.turnLeftSequence = -1;
      }

      super.turnRightSequence = super.turnLeftSequence;
      super.walkSequence = var1.readUnsignedShort();
      if(super.walkSequence == 65535) {
         super.walkSequence = -1;
      }

      super.walkBackSequence = var1.readUnsignedShort();
      if(super.walkBackSequence == 65535) {
         super.walkBackSequence = -1;
      }

      super.walkLeftSequence = var1.readUnsignedShort();
      if(super.walkLeftSequence == 65535) {
         super.walkLeftSequence = -1;
      }

      super.walkRightSequence = var1.readUnsignedShort();
      if(super.walkRightSequence == 65535) {
         super.walkRightSequence = -1;
      }

      super.runSequence = var1.readUnsignedShort();
      if(super.runSequence == 65535) {
         super.runSequence = -1;
      }

      this.username = new Username(var1.readString(), WorldMapSection1.loginType);
      prefix = var1.readString();//TODO:: titles (custom)
      suffix = var1.readString();
      this.method1091();
      this.method1122();
      if(this == class215.localPlayer) {
         RunException.localPlayerName = this.username.getName();
      }

      this.combatLevel = var1.readUnsignedByte();
      this.skillLevel = var1.readUnsignedShort();
      this.isHidden = var1.readUnsignedByte() == 1;
      if(Client.gameBuild == 0 && Client.staffModLevel >= 2) {
         this.isHidden = false;
      }

      if(this.appearance == null) {
         this.appearance = new PlayerAppearance();
      }

      this.appearance.method4152(var4, var9, var2 == 1, var3);
   }

   final void method1100(int var1, int var2, byte var3) {
      if(super.pathLength < 9) {
         ++super.pathLength;
      }

      for(int var4 = super.pathLength; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.pathTraversed[0] = var3;
   }

   void method1099(int var1, int var2) {
      super.pathLength = 0;
      super.field726 = 0;
      super.field687 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method1089();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * -297705920 + super.pathY[0] * -595411840;
   }

   public Polygon getConvexHull() {
      Model var1 = this.getModel();
      if(var1 == null) {
         return null;
      } else {
         int var2 = Perspective.getTileHeight(ViewportMouse.client, new LocalPoint(this.x, this.y * 682054857), ViewportMouse.client.getPlane());
         return var1.getConvexHull(this.x, this.y * 682054857, this.getOrientation(), var2);
      }
   }

   @Override
   public boolean isFriend() {
      return this.method1090();
   }

   public String getPrefix() {
      return prefix;
   }

   public String getSuffix() {
      return suffix;
   }

   public final Model copy$getModel(int var1) {
      if(this.appearance == null) {
         return null;
      } else {
         SequenceDefinition var2 = super.sequence != -1 && super.sequenceDelay == 0?GrandExchangeOfferUnitPriceComparator.method1468(super.sequence):null;
         SequenceDefinition var3 = super.movementSequence != -1 && !this.isUnanimated && (super.movementSequence != super.readySequence || var2 == null)?GrandExchangeOfferUnitPriceComparator.method1468(super.movementSequence):null;
         Model var4 = this.appearance.method4156(var2, super.sequenceFrame, var3, super.movementFrame);
         if(var4 == null) {
            return null;
         } else {
            var4.method2359();
            super.defaultHeight = var4.height;
            Model var5;
            Model[] var6;
            if(!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
               var5 = InterfaceParent.method1139(super.spotAnimation).method4392(super.spotAnimationFrame);
               if(var5 != null) {
                  var5.method2423(0, -super.heightOffset, 0);
                  var6 = new Model[]{var4, var5};
                  var4 = new Model(var6, 2);
               }
            }

            if(!this.isUnanimated && this.model0 != null) {
               if(Client.cycle >= this.animationCycleEnd) {
                  this.model0 = null;
               }

               if(Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
                  var5 = this.model0;
                  var5.method2423(this.field476 - super.x, this.tileHeight2 - this.tileHeight, this.field478 - super.y * 682054857);
                  if(super.orientation == 512) {
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                  } else if(super.orientation == 1024) {
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                  } else if(super.orientation == 1536) {
                     var5.rotateY90Ccw();
                  }

                  var6 = new Model[]{var4, var5};
                  var4 = new Model(var6, 2);
                  if(super.orientation == 512) {
                     var5.rotateY90Ccw();
                  } else if(super.orientation == 1024) {
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                  } else if(super.orientation == 1536) {
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                  }

                  var5.method2423(super.x - this.field476, this.tileHeight - this.tileHeight2, super.y * 682054857 - this.field478);
               }
            }

            var4.isSingleTile = true;
            return var4;
         }
      }
   }

   public void updateFriended() {
      this.friended = Tiles.friendSystem.isFriended(this.username, false);
   }

   public List rotate(List var1, int var2) {
      ArrayList var3 = new ArrayList();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         Triangle var5 = (Triangle)var4.next();
         Vertex var6 = var5.getA();
         Vertex var7 = var5.getB();
         Vertex var8 = var5.getC();
         Triangle var9 = new Triangle(var6.rotate(var2), var7.rotate(var2), var8.rotate(var2));
         var3.add(var9);
      }

      return var3;
   }

   public String getName() {
      Username var1 = this.username;
      if(var1 == null) {
         return null;
      } else {
         String var2 = var1.getName();
         return var2 == null?null:var2.replace(' ', ' ');
      }
   }

   //TODO: Modified [Custom Titles]
   private String prefix, suffix;

   //TODO: Modified [Custom Titles]
   public String getName(boolean useTitle) {
      if (useTitle && !CustomMisc.HIDE_TITLES) {
         if (prefix != null)
            return prefix + username.getName();
         if (suffix != null)
            return username.getName() + suffix;
         return username.getName();
      } else {
         return username.getName();
      }
   }

   public HeadIcon getOverheadIcon() {
      switch(this.headIconPrayer) {
      case 0:
         return HeadIcon.MELEE;
      case 1:
         return HeadIcon.RANGED;
      case 2:
         return HeadIcon.MAGIC;
      case 3:
         return HeadIcon.RETRIBUTION;
      case 4:
         return HeadIcon.SMITE;
      case 5:
         return HeadIcon.REDEMPTION;
      default:
         return null;
      }
   }

   public SkullIcon getSkullIcon() {
      switch(this.headIconPk) {
      case 0:
         return SkullIcon.SKULL;
      case 1:
         return SkullIcon.SKULL_FIGHT_PIT;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      default:
         return null;
      case 8:
         return SkullIcon.DEAD_MAN_FIVE;
      case 9:
         return SkullIcon.DEAD_MAN_FOUR;
      case 10:
         return SkullIcon.DEAD_MAN_THREE;
      case 11:
         return SkullIcon.DEAD_MAN_TWO;
      case 12:
         return SkullIcon.DEAD_MAN_ONE;
      }
   }

   public Polygon[] getPolygons() {
      Model var1 = this.getModel();
      if(var1 == null) {
         return null;
      } else {
         int var2 = this.x;
         int var3 = this.y * 682054857;
         int var4 = this.getOrientation();
         int var5 = Perspective.getTileHeight(ViewportMouse.client, new LocalPoint(var2, var3), ViewportMouse.client.getPlane());
         List var6 = var1.getTriangles();
         var6 = this.rotate(var6, var4);
         ArrayList var7 = new ArrayList();
         Iterator var8 = var6.iterator();

         while(var8.hasNext()) {
            Triangle var9 = (Triangle)var8.next();
            Vertex var10 = var9.getA();
            Vertex var11 = var9.getB();
            Vertex var12 = var9.getC();
            Point var13 = Perspective.localToCanvas(ViewportMouse.client, var2 - var10.getX(), var3 - var10.getZ(), var5 + var10.getY());
            Point var14 = Perspective.localToCanvas(ViewportMouse.client, var2 - var11.getX(), var3 - var11.getZ(), var5 + var11.getY());
            Point var15 = Perspective.localToCanvas(ViewportMouse.client, var2 - var12.getX(), var3 - var12.getZ(), var5 + var12.getY());
            int[] var16 = new int[]{var13.getX(), var14.getX(), var15.getX()};
            int[] var17 = new int[]{var13.getY(), var14.getY(), var15.getY()};
            var7.add(new Polygon(var16, var17, 3));
         }

         return (Polygon[])var7.toArray(new Polygon[var7.size()]);
      }
   }

   public boolean isFriended() {
      return this.isFriend() || this.friended;
   }

   @Override
   public PlayerAppearance getPlayerAppearance() {
      return this.appearance;
   }

   @Override
   public int getCombatLevel() {
      return this.combatLevel;
   }

   @Override
   public int getTeam() {
      return this.team;
   }

   @Override
   public int getPlayerId() {
      return this.index;
   }

   @Override
   public boolean isClanMember() {
      return this.method1093();
   }

   final void method1111(int var1, int var2, byte var3) {
      if(super.sequence != -1 && GrandExchangeOfferUnitPriceComparator.method1468(super.sequence).field3431 == 1) {
         super.sequence = -1;
         this.animationChanged(-1);
      }

      super.field695 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class4.method65(this, var1, var2, (byte)2);
            }

            this.method1100(var1, var2, var3);
         } else {
            this.method1099(var1, var2);
         }
      } else {
         this.method1099(var1, var2);
      }

   }

   int method1089() {
      return this.appearance != null && this.appearance.npcTransformId != -1?PacketBufferNode.getNpcDefinition(this.appearance.npcTransformId).size:1;
   }
}
