package net.runelite.standalone;

import net.runelite.api.BufferProvider;

public abstract class AbstractRasterProvider implements BufferProvider {
   static IndexedSprite titlebuttonSprite;
   public int height;
   public int width;
   public int[] pixels;

   public abstract void vmethod6275(int var1, int var2);

   public abstract void vmethod6276(int var1, int var2, int var3, int var4);

   @Override
   public int[] getPixels() {
      return this.pixels;
   }

   @Override
   public int getWidth() {
      return this.width;
   }

   @Override
   public int getHeight() {
      return this.height;
   }

   public final void setRaster() {
      Rasterizer2D.method6409(this.pixels, this.width, this.height);
   }
}
