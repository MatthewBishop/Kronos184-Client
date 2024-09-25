package net.runelite.standalone;

public class class217 {
   public static Huffman huffman;

   static void sendGameMessage(int var0, String var1, String var2) {
      WorldMapData_1.addChatMessage(var0, var1, var2, (String)null);
   }

   static void method3954() {
      PacketBufferNode var0 = InterfaceParent.method1140(ClientPacket.field2412, Client.packetWriter.isaacCipher);
      var0.packetBuffer.writeByte(class256.method4656());
      var0.packetBuffer.method5481(FloorDecoration.canvasWidth);
      var0.packetBuffer.method5481(WallDecoration.canvasHeight);
      Client.packetWriter.method1622(var0);
   }
}
