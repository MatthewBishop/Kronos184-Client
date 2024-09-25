package net.runelite.standalone;

public class WorldMapLabelSize {
   static PcmStreamMixer pcmStreamMixer;
   public static final WorldMapLabelSize WorldMapLabelSize_medium;
   public static final WorldMapLabelSize WorldMapLabelSize_large;
   public static final WorldMapLabelSize WorldMapLabelSize_small;
   static Language clientLanguage;
   static Archive archive1;
   final int field2047;
   final int field2046;
   final int field2045;

   static {
      WorldMapLabelSize_small = new WorldMapLabelSize(1, 0, 4);
      WorldMapLabelSize_medium = new WorldMapLabelSize(0, 1, 2);
      WorldMapLabelSize_large = new WorldMapLabelSize(2, 2, 0);
   }

   WorldMapLabelSize(int var1, int var2, int var3) {
      this.field2045 = var1;
      this.field2046 = var2;
      this.field2047 = var3;
   }

   boolean method3523(float var1) {
      return var1 >= (float)this.field2047;
   }

   public static int method3522() {
      return ++MouseHandler.MouseHandler_idleCycles - 1;
   }

   static WorldMapLabelSize[] method3521() {
      return new WorldMapLabelSize[]{WorldMapLabelSize_large, WorldMapLabelSize_small, WorldMapLabelSize_medium};
   }

   static final int method3527(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = Login.method1552(var3, var5);
      int var8 = Login.method1552(var3 + 1, var5);
      int var9 = Login.method1552(var3, var5 + 1);
      int var10 = Login.method1552(var3 + 1, var5 + 1);
      int var12 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var12 * var8 >> 16);
      int var14 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var4 * 1024 / var2] >> 1;
      int var13 = ((65536 - var14) * var9 >> 16) + (var10 * var14 >> 16);
      int var16 = 65536 - Rasterizer3D.Rasterizer3D_cosine[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
      return var15;
   }

   static void method3526(int var0, String var1) {
      int var2 = Players.Players_count;
      int[] var3 = Players.Players_indices;
      boolean var4 = false;
      Username var5 = new Username(var1, WorldMapSection1.loginType);

      for(int var6 = 0; var6 < var2; ++var6) {
         Player var7 = Client.players[var3[var6]];
         if(var7 != null && var7 != class215.localPlayer && var7.username != null && var7.username.equals(var5)) {
            PacketBufferNode var8;
            if(var0 == 1) {
               var8 = InterfaceParent.method1140(ClientPacket.field2387, Client.packetWriter.isaacCipher);
               var8.packetBuffer.method5659(var3[var6]);
               var8.packetBuffer.method5521(0);
               Client.packetWriter.method1622(var8);
            } else if(var0 == 4) {
               var8 = InterfaceParent.method1140(ClientPacket.field2427, Client.packetWriter.isaacCipher);
               var8.packetBuffer.method5532(var3[var6]);
               var8.packetBuffer.method5522(0);
               Client.packetWriter.method1622(var8);
            } else if(var0 == 6) {
               var8 = InterfaceParent.method1140(ClientPacket.field2370, Client.packetWriter.isaacCipher);
               var8.packetBuffer.method5481(var3[var6]);
               var8.packetBuffer.method5521(0);
               Client.packetWriter.method1622(var8);
            } else if(var0 == 7) {
               var8 = InterfaceParent.method1140(ClientPacket.field2430, Client.packetWriter.isaacCipher);
               var8.packetBuffer.method5530(var3[var6]);
               var8.packetBuffer.method5521(0);
               Client.packetWriter.method1622(var8);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class217.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
