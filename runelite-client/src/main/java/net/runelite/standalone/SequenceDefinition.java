package net.runelite.standalone;

public class SequenceDefinition extends DualNode {
   static AbstractArchive SequenceDefinition_animationsArchive;
   public static EvictingDualNodeHashTable SequenceDefinition_cachedFrames;
   public static EvictingDualNodeHashTable SequenceDefinition_cached;
   static AbstractArchive SequenceDefinition_archive;
   static java.awt.Font fontHelvetica13;
   public int field3432;
   public int[] frameIds;
   int[] chatFrameIds;
   public int field3436;
   public int field3424;
   public int field3438;
   public int[] soundEffects;
   public int shield;
   public boolean field3425;
   int[] field3430;
   public int weapon;
   public int field3431;
   public int frameCount;
   public int[] frameLengths;

   static {
      SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
      SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);
   }

   SequenceDefinition() {
      this.frameCount = -1;
      this.field3425 = false;
      this.field3432 = 5;
      this.shield = -1;
      this.weapon = -1;
      this.field3424 = 99;
      this.field3436 = -1;
      this.field3431 = -1;
      this.field3438 = 2;
   }

   public Model method4661(Model var1, int var2, int var3) {
      if(var2 >= 0) {
         return (Model)this.copy$transformActorModel(var1, var2, var3);
      } else {
         int var4 = var2 ^ Integer.MIN_VALUE;
         int var5 = var4 >> 16;
         var2 = var4 & 65535;
         int var6 = var2 + 1;
         if(var6 >= this.frameIds.length) {
            var6 = -1;
         }

         int[] var7 = this.frameIds;
         int var8 = var7[var2];
         Frames var9 = class210.getFrames(var8 >> 16);
         int var10 = var8 & 65535;
         int var11 = -1;
         Frames var12 = null;
         if(var6 != -1) {
            int var13 = var7[var6];
            var12 = class210.getFrames(var13 >> 16);
            var11 = var13 & 65535;
         }

         if(var9 == null) {
            return (Model)var1.toSharedModel(true);
         } else {
            Animation animation = var9.frames[var10];
             Model var14 = var1.toSharedModel(!animation.hasAlphaTransform);
            var14.interpolateFrames(var9, var10, var12, var11, var5, this.frameLengths[var2]);
            return (Model)var14;
         }
      }
   }

   Model method4662(Model var1, int var2, int var3, byte var4) {
      if(var2 >= 0) {
         return (Model)this.copy$transformObjectModel(var1, var2, var3, var4);
      } else {
         int var5 = var2 ^ Integer.MIN_VALUE;
         int var6 = var5 >> 16;
         var2 = var5 & 65535;
         int var7 = var2 + 1;
         if(var7 >= this.frameIds.length) {
            var7 = -1;
         }

         int[] var8 = this.frameIds;
         int var9 = var8[var2];
         Frames var10 = class210.getFrames(var9 >> 16);
         int var11 = var9 & 65535;
         int var12 = -1;
         Frames var13 = null;
         if(var7 != -1) {
            int var14 = var8[var7];
            var13 = class210.getFrames(var14 >> 16);
            var12 = var14 & 65535;
         }

         if(var10 == null) {
            return (Model)var1.toSharedModel(true);
         } else {
            Animation animation = var10.frames[var11];
             Model var15 = var1.toSharedModel(!animation.hasAlphaTransform);
            var3 &= 3;
            if(var3 == 1) {
               var15.rotateY270Ccw();
            } else if(var3 == 2) {
               var15.rotateY180Ccw();
            } else if(var3 == 3) {
               var15.rotateY90Ccw();
            }

            var15.interpolateFrames(var10, var11, var13, var12, var6, this.frameLengths[var2]);
            if(var3 == 1) {
               var15.rotateY90Ccw();
            } else if(var3 == 2) {
               var15.rotateY180Ccw();
            } else if(var3 == 3) {
               var15.rotateY270Ccw();
            }

            return (Model)var15;
         }
      }
   }

   void method4687() {
      if(this.field3436 == -1) {
         if(this.field3430 != null) {
            this.field3436 = 2;
         } else {
            this.field3436 = 0;
         }
      }

      if(this.field3431 == -1) {
         if(this.field3430 != null) {
            this.field3431 = 2;
         } else {
            this.field3431 = 0;
         }
      }

   }

   void method4674(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLengths = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLengths[var4] = var1.readUnsignedShort();
         }

         this.frameIds = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIds[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIds[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 2) {
         this.frameCount = var1.readUnsignedShort();
      } else if(var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.field3430 = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3430[var4] = var1.readUnsignedByte();
         }

         this.field3430[var3] = 9999999;
      } else if(var2 == 4) {
         this.field3425 = true;
      } else if(var2 == 5) {
         this.field3432 = var1.readUnsignedByte();
      } else if(var2 == 6) {
         this.shield = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.weapon = var1.readUnsignedShort();
      } else if(var2 == 8) {
         this.field3424 = var1.readUnsignedByte();
      } else if(var2 == 9) {
         this.field3436 = var1.readUnsignedByte();
      } else if(var2 == 10) {
         this.field3431 = var1.readUnsignedByte();
      } else if(var2 == 11) {
         this.field3438 = var1.readUnsignedByte();
      } else if(var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.chatFrameIds = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.chatFrameIds[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.chatFrameIds[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.soundEffects = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.soundEffects[var4] = var1.method5500();
         }
      }

   }

   void method4658(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4674(var1, var2);
      }
   }

   public Model method4660(Model var1, int var2, SequenceDefinition var3, int var4, byte var5) {
      int var6;
      if(var2 < 0) {
         var6 = var2 ^ Integer.MIN_VALUE;
         var2 = var6 & 65535;
      }

      if(var4 < 0) {
         var6 = var4 ^ Integer.MIN_VALUE;
         var4 = var6 & 65535;
      }

      return (Model)this.copy$applyTransformations(var1, var2, var3, var4, var5);
   }

   public Model copy$transformObjectModel(Model var1, int var2, int var3, byte var4) {
      var2 = this.frameIds[var2];
      Frames var5 = class210.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var1.toSharedModel(true);
      } else {
         Model var6 = var1.toSharedModel(!var5.method3064(var2));
         var3 &= 3;
         if(var3 == 1) {
            var6.rotateY270Ccw();
         } else if(var3 == 2) {
            var6.rotateY180Ccw();
         } else if(var3 == 3) {
            var6.rotateY90Ccw();
         }

         var6.method2363(var5, var2);
         if(var3 == 1) {
            var6.rotateY90Ccw();
         } else if(var3 == 2) {
            var6.rotateY180Ccw();
         } else if(var3 == 3) {
            var6.rotateY270Ccw();
         }

         return var6;
      }
   }

   public Model copy$transformSpotAnimationModel(Model var1, int var2, int var3) {
      var2 = this.frameIds[var2];
      Frames var4 = class210.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.toSharedSpotAnimModel(true);
      } else {
         Model var5 = var1.toSharedSpotAnimModel(!var4.method3064(var2));
         var5.method2363(var4, var2);
         return var5;
      }
   }

   public Model copy$transformWidgetModel(Model var1, int var2, byte var3) {
      int var4 = this.frameIds[var2];
      Frames var5 = class210.getFrames(var4 >> 16);
      var4 &= 65535;
      if(var5 == null) {
         return var1.toSharedModel(true);
      } else {
         Frames var6 = null;
         int var7 = 0;
         if(this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
            var7 = this.chatFrameIds[var2];
            var6 = class210.getFrames(var7 >> 16);
            var7 &= 65535;
         }

         Model var8;
         if(var6 != null && var7 != 65535) {
            var8 = var1.toSharedModel(!var5.method3064(var4) & !var6.method3064(var7));
            var8.method2363(var5, var4);
            var8.method2363(var6, var7);
            return var8;
         } else {
            var8 = var1.toSharedModel(!var5.method3064(var4));
            var8.method2363(var5, var4);
            return var8;
         }
      }
   }

   public Model copy$transformActorModel(Model var1, int var2, int var3) {
      var2 = this.frameIds[var2];
      Frames var4 = class210.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.toSharedModel(true);
      } else {
         Model var5 = var1.toSharedModel(!var4.method3064(var2));
         var5.method2363(var4, var2);
         return var5;
      }
   }

   public Model copy$applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4, byte var5) {
      var2 = this.frameIds[var2];
      Frames var6 = class210.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var6 == null) {
         return var3.method4661(var1, var4, 1973323654);
      } else {
         var4 = var3.frameIds[var4];
         Frames var7 = class210.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var8;
         if(var7 == null) {
            var8 = var1.toSharedModel(!var6.method3064(var2));
            var8.method2363(var6, var2);
            return var8;
         } else {
            var8 = var1.toSharedModel(!var6.method3064(var2) & !var7.method3064(var4));
            var8.method2419(var6, var2, var7, var4, this.field3430);
            return var8;
         }
      }
   }

   public Model method4669(Model var1, int var2, byte var3) {
      if(var2 >= 0) {
         return (Model)this.copy$transformWidgetModel(var1, var2, var3);
      } else {
         int var4 = var2 ^ Integer.MIN_VALUE;
         int var5 = var4 >> 16;
         var2 = var4 & 65535;
         int var6 = var2 + 1;
         if(var6 >= this.frameIds.length) {
            var6 = -1;
         }

         int[] var7 = this.frameIds;
         int var8 = var7[var2];
         Frames var9 = class210.getFrames(var8 >> 16);
         int var10 = var8 & 65535;
         int var11 = -1;
         Frames var12 = null;
         if(var6 != -1) {
            int var13 = var7[var6];
            var12 = class210.getFrames(var13 >> 16);
            var11 = var13 & 65535;
         }

         if(var9 == null) {
            return (Model)var1.toSharedModel(true);
         } else {
            Frames var18 = null;
            int var14 = 0;
            if(this.chatFrameIds != null) {
               if (var2 < this.chatFrameIds.length) {
                  int var15 = this.chatFrameIds[var2];
                  var18 = class210.getFrames(var15 >> 16);
                  var14 = var15 & 65535;
               }
            }

            if(var18 != null && var14 != 65535) {
               Frames var21 = null;
               int var16 = -1;
               if(var6 != -1) {
                  if (var6 < this.chatFrameIds.length) {
                     int var17 = this.chatFrameIds[var6];
                     var21 = class210.getFrames(var17 >> 16);
                     var16 = var17 & 65535;
                  }
               }

               if(var16 == 65535) {
                  var21 = null;
               }

               Animation animation = var18.frames[var14];
               Animation animation1 = var9.frames[var10];
                Model var20 = var1.toSharedModel(!animation1.hasAlphaTransform & !animation.hasAlphaTransform);
               var20.interpolateFrames(var9, var10, var12, var11, var5, this.frameLengths[var2]);
               var20.interpolateFrames(var18, var14, var21, var16, var5, this.frameLengths[var2]);
               return (Model)var20;
            } else {
               Animation animation = var9.frames[var10];
                Model var19 = var1.toSharedModel(!animation.hasAlphaTransform);
               var19.interpolateFrames(var9, var10, var12, var11, var5, this.frameLengths[var2]);
               return (Model)var19;
            }
         }
      }
   }

   Model method4663(Model var1, int var2, int var3) {
      if(var2 >= 0) {
         return (Model)this.copy$transformSpotAnimationModel(var1, var2, var3);
      } else {
         int var4 = var2 ^ Integer.MIN_VALUE;
         int var5 = var4 >> 16;
         var2 = var4 & 65535;
         int var6 = var2 + 1;
         if(var6 >= this.frameIds.length) {
            var6 = -1;
         }

         int[] var7 = this.frameIds;
         int var8 = var7[var2];
         Frames var9 = class210.getFrames(var8 >> 16);
         int var10 = var8 & 65535;
         int var11 = -1;
         Frames var12 = null;
         if(var6 != -1) {
            int var13 = var7[var6];
            var12 = class210.getFrames(var13 >> 16);
            var11 = var13 & 65535;
         }

         if(var9 == null) {
            return (Model)var1.toSharedSpotAnimModel(true);
         } else {
            Animation animation = var9.frames[var10];
             Model var14 = var1.toSharedSpotAnimModel(!animation.hasAlphaTransform);
            var14.interpolateFrames(var9, var10, var12, var11, var5, this.frameLengths[var2]);
            return (Model)var14;
         }
      }
   }

   static final void method4691(int var0, int var1) {
      Client.copy$forceDisconnect(var0, var1);
      if(Client.hideDisconnect && var0 == 1) {
         TilePaint.promptCredentials(true);
      }

   }
}
