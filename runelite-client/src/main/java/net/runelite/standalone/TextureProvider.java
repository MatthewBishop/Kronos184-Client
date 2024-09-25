package net.runelite.standalone;

import net.runelite.api.IndexDataBase;

public class TextureProvider implements TextureLoader, net.runelite.api.TextureProvider {
   NodeDeque deque;
   int textureSize;
   AbstractArchive archive;
   double brightness;
   int remaining;
   int capacity;
   Texture[] textures;

   public TextureProvider(AbstractArchive var1, AbstractArchive var2, int var3, double var4, int var6) {
      this.deque = new NodeDeque();
      this.remaining = 0;
      this.brightness = 1.0D;
      this.textureSize = 128;
      this.archive = var2;
      this.capacity = var3;
      this.remaining = this.capacity;
      this.brightness = var4;
      this.textureSize = var6;
      int[] var7 = var1.method4042(0);
      int var8 = var7.length;
      this.textures = new Texture[var1.fileCount(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method4020(0, var7[var9], (short)13505));
         this.textures[var7[var9]] = new Texture(var10);
      }

      this.rl$init(var1, var2, var3, var4, var6);
   }

   public void method2840(double var1) {
      this.brightness = var1;
      this.method2845();
   }

   public boolean vmethod2927(int var1) {
      return this.textureSize == 64;
   }

   public void method2845() {
      for(int var1 = 0; var1 < this.textures.length; ++var1) {
         if(this.textures[var1] != null) {
            this.textures[var1].method2347();
         }
      }

      this.deque = new NodeDeque();
      this.remaining = this.capacity;
   }

   public boolean vmethod2928(int var1) {
      return this.textures[var1].field1363;
   }

   public int vmethod2926(int var1) {
      return this.textures[var1] != null?this.textures[var1].averageRGB:0;
   }

   public int[] vmethod2935(int var1) {
      Texture var2 = this.textures[var1];
      if(var2 != null) {
         if(var2.pixels != null) {
            this.deque.method5106(var2);
            var2.isLoaded = true;
            return var2.pixels;
         }

         boolean var3 = var2.method2346(this.brightness, this.textureSize, this.archive);
         if(var3) {
            if(this.remaining == 0) {
               Texture var4 = (Texture)this.deque.method5109();
               var4.method2347();
            } else {
               --this.remaining;
            }

            this.deque.method5106(var2);
            var2.isLoaded = true;
            return var2.pixels;
         }
      }

      return null;
   }

   public int method2839() {
      int var1 = 0;
      int var2 = 0;
      Texture[] var3 = this.textures;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         Texture var5 = var3[var4];
         if(var5 != null && var5.fileIds != null) {
            var1 += var5.fileIds.length;
            int[] var6 = var5.fileIds;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               int var8 = var6[var7];
               if(this.archive.method4031(var8)) {
                  ++var2;
               }
            }
         }
      }

      if(var1 == 0) {
         return 0;
      } else {
         return var2 * 100 / var1;
      }
   }

   public void checkTextures(int var1) {
      ViewportMouse.client.getCallbacks().drawAboveOverheads();
   }

   public void rl$init(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.capacity = 64;
      this.remaining = 64;
   }

   @Override
   public Texture[] getTextures() {
      return this.textures;
   }

   @Override
   public double getBrightness() {
      return this.brightness;
   }

   @Override
   public void setBrightness(double var1) {
      this.method2840(var1);
   }

   @Override
   public int[] load(int var1) {
      return this.vmethod2935(var1);
   }

   public void method2846(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.animationDirection != 0 && var3.isLoaded) {
            var3.method2345(var1);
            var3.isLoaded = false;
         }
      }

      this.checkTextures(var1);
   }

   public static void method2859() {
      ParamDefinition.ParamDefinition_cached.clear();
   }

   static Class method2867(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   static void method2870() {
      Tiles.Tiles_minPlane = 99;
      Tiles.field540 = new byte[4][104][104];
      Tiles.field522 = new byte[4][104][104];
      DevicePcmPlayerProvider.field156 = new byte[4][104][104];
      class298.field3719 = new byte[4][104][104];
      Tiles.field527 = new int[4][105][105];
      Tiles.field525 = new byte[4][105][105];
      DevicePcmPlayerProvider.field149 = new int[105][105];
      Tiles.Tiles_hue = new int[104];
      ArchiveLoader.Tiles_saturation = new int[104];
      Tiles.Tiles_lightness = new int[104];
      FontName.Tiles_hueMultiplier = new int[104];
      Tiles.field526 = new int[104];
   }
}
