package net.runelite.standalone;

public class WorldMapIcon_0 extends AbstractWorldMapIcon {
   static short[] foundItemIds;
   static IndexedSprite worldSelectLeftSprite;
   final WorldMapLabel label;
   final int subHeight;
   final int subWidth;
   final int element;

   WorldMapIcon_0(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
      super(var1, var2);
      this.element = var3;
      this.label = var4;
      WorldMapElement var5 = Decimator.method2498(this.vmethod2277());
      Sprite var6 = var5.method4369(false);
      if(var6 != null) {
         this.subWidth = var6.subWidth;
         this.subHeight = var6.subHeight;
      } else {
         this.subWidth = 0;
         this.subHeight = 0;
      }

   }

   WorldMapLabel vmethod2273() {
      return this.label;
   }

   int vmethod2257() {
      return this.subHeight;
   }

   int vmethod2269() {
      return this.subWidth;
   }

   public int vmethod2277() {
      return this.element;
   }

   public static IndexedSprite[] method193(AbstractArchive var0, String var1, String var2) {
      int var3 = var0.method4059(var1);
      int var4 = var0.method4039(var3, var2);
      return class313.method5840(var0, var3, var4);
   }

   static final void method192(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 324) {
         if(Client.field1108 == -1) {
            Client.field1108 = var0.spriteId2;
            Client.field1109 = var0.spriteId;
         }

         if(Client.playerAppearance.isFemale) {
            var0.spriteId2 = Client.field1108;
         } else {
            var0.spriteId2 = Client.field1109;
         }

      } else if(var1 == 325) {
         if(Client.field1108 == -1) {
            Client.field1108 = var0.spriteId2;
            Client.field1109 = var0.spriteId;
         }

         if(Client.playerAppearance.isFemale) {
            var0.spriteId2 = Client.field1109;
         } else {
            var0.spriteId2 = Client.field1108;
         }

      } else if(var1 == 327) {
         var0.modelAngleX = 150;
         var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if(var1 == 328) {
         var0.modelAngleX = 150;
         var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
