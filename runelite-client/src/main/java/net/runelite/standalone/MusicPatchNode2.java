package net.runelite.standalone;

public class MusicPatchNode2 {
   public static int field2119;
   byte[] field2111;
   int field2115;
   int field2116;
   int field2114;
   int field2110;
   int field2112;
   int field2118;
   byte[] field2113;
   int field2117;

   static void method3725(int var0) {
      if(var0 == -1 && !Client.field967) {
         VertexNormal.method2466();
      } else if(var0 != -1 && var0 != Client.field874 && Client.field969 != 0 && !Client.field967) {
         Archive var1 = class212.archive6;
         int var2 = Client.field969;
         class197.field2173 = 1;
         class197.musicTrackArchive = var1;
         class183.musicTrackGroupId = var0;
         class38.musicTrackFileId = 0;
         TileItem.field816 = var2;
         WorldMapSectionType.musicTrackBoolean = false;
         field2119 = 2;
      }

      Client.field874 = var0;
   }

   static boolean method3726(int var0) {
      for(int var1 = 0; var1 < Client.field1065; ++var1) {
         if(Client.field1067[var1] == var0) {
            return true;
         }
      }

      return false;
   }
}
