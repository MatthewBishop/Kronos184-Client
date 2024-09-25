package net.runelite.standalone;

public class KitDefinition extends DualNode {
   static Widget field3452;
   public static EvictingDualNodeHashTable KitDefinition_cached;
   public static AbstractArchive KitDefinition_archive;
   int[] models2;
   short[] recolorFrom;
   public int bodypartID;
   short[] retextureFrom;
   public boolean nonSelectable;
   int[] models;
   short[] retextureTo;
   short[] recolorTo;

   static {
      KitDefinition_cached = new EvictingDualNodeHashTable(64);
   }

   KitDefinition() {
      this.bodypartID = -1;
      this.models = new int[]{-1, -1, -1, -1, -1};
      this.nonSelectable = false;
   }

   void method4707(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4693(var1, var2);
      }
   }

   public boolean method4706() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.models[var2] != -1 && !GrandExchangeOfferOwnWorldComparator.KitDefinition_modelsArchive.method4024(this.models[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   public ModelData method4708() {
      ModelData[] var1 = new ModelData[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.models[var3] != -1) {
            var1[var2++] = ModelData.method2823(GrandExchangeOfferOwnWorldComparator.KitDefinition_modelsArchive, this.models[var3], 0);
         }
      }

      ModelData var5 = new ModelData(var1, var2);
      int var4;
      if(this.recolorFrom != null) {
         for(var4 = 0; var4 < this.recolorFrom.length; ++var4) {
            var5.method2770(this.recolorFrom[var4], this.recolorTo[var4]);
         }
      }

      if(this.retextureFrom != null) {
         for(var4 = 0; var4 < this.retextureFrom.length; ++var4) {
            var5.method2831(this.retextureFrom[var4], this.retextureTo[var4]);
         }
      }

      return var5;
   }

   public ModelData method4695() {
      if(this.models2 == null) {
         return null;
      } else {
         ModelData[] var1 = new ModelData[this.models2.length];

         for(int var2 = 0; var2 < this.models2.length; ++var2) {
            var1[var2] = ModelData.method2823(GrandExchangeOfferOwnWorldComparator.KitDefinition_modelsArchive, this.models2[var2], 0);
         }

         ModelData var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new ModelData(var1, var1.length);
         }

         int var3;
         if(this.recolorFrom != null) {
            for(var3 = 0; var3 < this.recolorFrom.length; ++var3) {
               var4.method2770(this.recolorFrom[var3], this.recolorTo[var3]);
            }
         }

         if(this.retextureFrom != null) {
            for(var3 = 0; var3 < this.retextureFrom.length; ++var3) {
               var4.method2831(this.retextureFrom[var3], this.retextureTo[var3]);
            }
         }

         return var4;
      }
   }

   public boolean method4710() {
      if(this.models2 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.models2.length; ++var2) {
            if(!GrandExchangeOfferOwnWorldComparator.KitDefinition_modelsArchive.method4024(this.models2[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   void method4693(Buffer var1, int var2) {
      if(var2 == 1) {
         this.bodypartID = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.readUnsignedByte();
            this.models2 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.models2[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 3) {
            this.nonSelectable = true;
         } else if(var2 == 40) {
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
         } else if(var2 >= 60 && var2 < 70) {
            this.models[var2 - 60] = var1.readUnsignedShort();
         }
      }

   }
}
