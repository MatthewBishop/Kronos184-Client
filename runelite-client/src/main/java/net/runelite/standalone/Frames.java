package net.runelite.standalone;

public class Frames extends DualNode {
   public static int SpriteBuffer_spriteHeight;
   static IndexedSprite[] worldSelectStars;
   static Widget dragInventoryWidget;
   Animation[] frames;

   public Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
      NodeDeque var5 = new NodeDeque();
      int var6 = var1.fileCount(var3);
      this.frames = new Animation[var6];
      int[] var7 = var1.method4042(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.method4020(var3, var7[var8], (short)10411);
         Skeleton var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(Skeleton var12 = (Skeleton)var5.last(); var12 != null; var12 = (Skeleton)var5.previous()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method4028(var11, 0);
            var10 = new Skeleton(var11, var13);
            var5.addFirst(var10);
         }

         this.frames[var7[var8]] = new Animation(var9, var10);
      }

   }

   public boolean method3064(int var1) {
      return this.frames[var1].hasAlphaTransform;
   }

}
