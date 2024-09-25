package net.runelite.standalone;

public class GraphicsDefaults {
   static Font fontPlain12;
   public int field3784;
   public int field3783;
   public int field3789;
   public int field3787;
   public int headIconsPk;
   public int mapScenes;
   public int field3791;
   public int compass;
   public int field3793;
   public int field3794;
   public int field3790;

   public GraphicsDefaults() {
      this.compass = -1;
      this.field3784 = -1;
      this.mapScenes = -1;
      this.headIconsPk = -1;
      this.field3787 = -1;
      this.field3783 = -1;
      this.field3789 = -1;
      this.field3790 = -1;
      this.field3791 = -1;
      this.field3794 = -1;
      this.field3793 = -1;
   }

   public void method5792(AbstractArchive var1) {
      byte[] var2 = var1.method4027(DefaultsGroup.field3746.group);
      Buffer var3 = new Buffer(var2);

      while(true) {
         int var4 = var3.readUnsignedByte();
         if(var4 == 0) {
            return;
         }

         switch(var4) {
         case 1:
            var3.method5500();
            break;
         case 2:
            this.compass = var3.method5507();
            this.field3784 = var3.method5507();
            this.mapScenes = var3.method5507();
            this.headIconsPk = var3.method5507();
            this.field3787 = var3.method5507();
            this.field3783 = var3.method5507();
            this.field3789 = var3.method5507();
            this.field3790 = var3.method5507();
            this.field3791 = var3.method5507();
            this.field3794 = var3.method5507();
            this.field3793 = var3.method5507();
         }
      }
   }
}
