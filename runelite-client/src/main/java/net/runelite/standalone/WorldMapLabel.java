package net.runelite.standalone;

public class WorldMapLabel {
   static MouseRecorder mouseRecorder;
   static Archive archive19;
   int width;
   WorldMapLabelSize size;
   int height;
   String text;

   WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
      this.text = var1;
      this.width = var2;
      this.height = var3;
      this.size = var4;
   }

   static void method743(int var0, Coord var1, boolean var2) {
      WorldMapArea var3 = Decimator.getRenderOverview().method5899(var0);
      int var4 = class215.localPlayer.plane;
      int var5 = (class215.localPlayer.x >> 7) + class215.baseX;
      int var6 = (class215.localPlayer.y * 682054857 >> 7) + class304.baseY;
      Coord var7 = new Coord(var4, var5, var6);
      Decimator.getRenderOverview().method6058(var3, var7, var1, var2);
   }

   static final void method742() {
      PacketBufferNode var0 = InterfaceParent.method1140(ClientPacket.field2393, Client.packetWriter.isaacCipher);
      var0.packetBuffer.writeByte(0);
      Client.packetWriter.method1622(var0);
   }
}
