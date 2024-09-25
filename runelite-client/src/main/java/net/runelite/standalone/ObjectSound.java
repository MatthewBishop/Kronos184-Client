package net.runelite.standalone;

public final class ObjectSound extends Node {
   static Sprite sceneMinimapSprite;
   static NodeDeque objectSounds;
   static int oculusOrbFocalPointX;
   int[] soundEffectIds;
   int y;
   int field414;
   ObjectDefinition obj;
   int x;
   int plane;
   int soundEffectId;
   int field413;
   int field421;
   int field424;
   int field418;
   RawPcmStream stream2;
   RawPcmStream stream1;
   int field415;

   static {
      objectSounds = new NodeDeque();
   }

   void method949() {
      int var1 = this.soundEffectId;
      ObjectDefinition var2 = this.obj.method4733();
      if(var2 != null) {
         this.soundEffectId = var2.ambientSoundId;
         this.field415 = var2.int4 * 128;
         this.field418 = var2.int5;
         this.field424 = var2.int6;
         this.soundEffectIds = var2.soundEffectIds;
      } else {
         this.soundEffectId = -1;
         this.field415 = 0;
         this.field418 = 0;
         this.field424 = 0;
         this.soundEffectIds = null;
      }

      if(var1 != this.soundEffectId && this.stream1 != null) {
         WorldMapLabelSize.pcmStreamMixer.method1476(this.stream1);
         this.stream1 = null;
      }

   }
}
