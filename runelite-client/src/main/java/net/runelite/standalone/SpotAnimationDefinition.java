package net.runelite.standalone;

public class SpotAnimationDefinition extends DualNode {
   public static AbstractArchive SpotAnimationDefinition_modelArchive;
   static EvictingDualNodeHashTable SpotAnimationDefinition_cachedModels;
   static EvictingDualNodeHashTable SpotAnimationDefinition_cached;
   int heightScale;
   int archive;
   public int sequence;
   int id;
   int contrast;
   short[] recolorTo;
   int orientation;
   int widthScale;
   short[] retextureTo;
   int ambient;
   short[] retextureFrom;
   short[] recolorFrom;

   static {
      SpotAnimationDefinition_cached = new EvictingDualNodeHashTable(64);
      SpotAnimationDefinition_cachedModels = new EvictingDualNodeHashTable(30);
   }

   SpotAnimationDefinition() {
      this.sequence = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.orientation = 0;
      this.ambient = 0;
      this.contrast = 0;
   }

   void method4390(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4396(var1, var2);
      }
   }

   public final Model method4392(int var1) {
      Model var2 = (Model)SpotAnimationDefinition_cachedModels.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2823(SpotAnimationDefinition_modelArchive, this.archive, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.recolorFrom != null) {
            for(var4 = 0; var4 < this.recolorFrom.length; ++var4) {
               var3.method2770(this.recolorFrom[var4], this.recolorTo[var4]);
            }
         }

         if(this.retextureFrom != null) {
            for(var4 = 0; var4 < this.retextureFrom.length; ++var4) {
               var3.method2831(this.retextureFrom[var4], this.retextureTo[var4]);
            }
         }

         var2 = var3.method2778(this.ambient + 64, this.contrast + 850, -30, -50, -30);
         SpotAnimationDefinition_cachedModels.method3034(var2, (long)this.id);
      }

      Model var5;
      if(this.sequence != -1 && var1 != -1) {
         var5 = GrandExchangeOfferUnitPriceComparator.method1468(this.sequence).method4663(var2, var1, -1452846924);
      } else {
         var5 = var2.toSharedSpotAnimModel(true);
      }

      if(this.widthScale != 128 || this.heightScale != 128) {
         var5.method2402(this.widthScale, this.heightScale, this.widthScale);
      }

      if(this.orientation != 0) {
         if(this.orientation == 90) {
            var5.rotateY90Ccw();
         }

         if(this.orientation == 180) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }

         if(this.orientation == 270) {
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
            var5.rotateY90Ccw();
         }
      }

      return var5;
   }

   void method4396(Buffer var1, int var2) {
      if(var2 == 1) {
         this.archive = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.sequence = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.orientation = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.ambient = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.contrast = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorFrom = new short[var3];
            this.recolorTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorFrom[var4] = (short)var1.readUnsignedShort();
               this.recolorTo[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retextureFrom = new short[var3];
            this.retextureTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureFrom[var4] = (short)var1.readUnsignedShort();
               this.retextureTo[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }
}
