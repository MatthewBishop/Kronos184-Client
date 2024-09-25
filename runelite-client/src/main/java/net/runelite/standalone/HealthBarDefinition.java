package net.runelite.standalone;

import net.runelite.api.HealthBar;
import net.runelite.api.events.PostHealthBar;

public class HealthBarDefinition extends DualNode implements HealthBar {
   static AbstractArchive HitSplatDefinition_spritesArchive;
   public static EvictingDualNodeHashTable HealthBarDefinition_cachedSprites;
   public static EvictingDualNodeHashTable HealthBarDefinition_cached;
   public static AbstractArchive HealthBarDefinition_archive;
   int frontSpriteID;
   public int field3296;
   public int widthPadding;
   public int int2;
   int backSpriteID;
   public int int5;
   public int int4;
   public int width;
   public int int3;
   public int int1;

   static {
      HealthBarDefinition_cached = new EvictingDualNodeHashTable(64);
      HealthBarDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
   }

   public HealthBarDefinition() {
      this.int1 = 255;
      this.int2 = 255;
      this.int3 = -1;
      this.int4 = 1;
      this.int5 = 70;
      this.frontSpriteID = -1;
      this.backSpriteID = -1;
      this.width = 30;
      this.widthPadding = 0;
   }

   public void method4469(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            this.onRead(var1);
            return;
         }

         this.method4472(var1, var2);
      }
   }

   public Sprite getHealthBarBackSprite() {
      if(this.backSpriteID < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)HealthBarDefinition_cachedSprites.get((long)this.backSpriteID);
         if(var1 != null) {
            return var1;
         } else {
            var1 = NPCDefinition.method4417(HitSplatDefinition_spritesArchive, this.backSpriteID, 0, -1092680498);
            if(var1 != null) {
               HealthBarDefinition_cachedSprites.method3034(var1, (long)this.backSpriteID);
            }

            return var1;
         }
      }
   }

   public Sprite getHealthBarFrontSprite() {
      if(this.frontSpriteID < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)HealthBarDefinition_cachedSprites.get((long)this.frontSpriteID);
         if(var1 != null) {
            return var1;
         } else {
            var1 = NPCDefinition.method4417(HitSplatDefinition_spritesArchive, this.frontSpriteID, 0, -1092680498);
            if(var1 != null) {
               HealthBarDefinition_cachedSprites.method3034(var1, (long)this.frontSpriteID);
            }

            return var1;
         }
      }
   }

   void method4472(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.int1 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.int2 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.int3 = 0;
      } else if(var2 == 5) {
         this.int5 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.frontSpriteID = var1.method5507();
      } else if(var2 == 8) {
         this.backSpriteID = var1.method5507();
      } else if(var2 == 11) {
         this.int3 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.width = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.widthPadding = var1.readUnsignedByte();
      }

   }

   public void onRead(Buffer var1) {
      PostHealthBar var2 = new PostHealthBar();
      var2.setHealthBar(this);
      ViewportMouse.client.getCallbacks().post(PostHealthBar.class, var2);
   }

   @Override
   public int getHealthBarFrontSpriteId() {
      return this.frontSpriteID;
   }

   @Override
   public void setPadding(int var1) {
      this.widthPadding = var1;
   }

}
