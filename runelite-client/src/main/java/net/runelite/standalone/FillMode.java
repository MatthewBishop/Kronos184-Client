package net.runelite.standalone;

public enum FillMode implements Enumerated {
   SOLID(0, 0),
   field4020(1, 1),
   field4021(2, 2);

   final int id;
   public final int value;

   FillMode(int var3, int var4) {
      this.value = var3;
      this.id = var4;
   }

   public int getId() {
      return this.id;
   }

   static Sprite method6384() {
      Sprite var0 = new Sprite();
      var0.width = class329.SpriteBuffer_spriteWidth;
      var0.height = Frames.SpriteBuffer_spriteHeight;
      var0.xOffset = class329.SpriteBuffer_xOffsets[0];
      var0.yOffset = MusicPatchPcmStream.SpriteBuffer_yOffsets[0];
      var0.subWidth = class329.SpriteBuffer_spriteWidths[0];
      var0.subHeight = RunException.SpriteBuffer_spriteHeights[0];
      int var1 = var0.subHeight * var0.subWidth;
      byte[] var2 = PacketBufferNode.SpriteBuffer_pixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class329.SpriteBuffer_spritePalette[var2[var3] & 255];
      }

      class329.SpriteBuffer_xOffsets = null;
      MusicPatchPcmStream.SpriteBuffer_yOffsets = null;
      class329.SpriteBuffer_spriteWidths = null;
      RunException.SpriteBuffer_spriteHeights = null;
      class329.SpriteBuffer_spritePalette = null;
      PacketBufferNode.SpriteBuffer_pixels = null;
      return var0;
   }
}
