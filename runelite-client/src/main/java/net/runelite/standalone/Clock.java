package net.runelite.standalone;

public abstract class Clock {
   static int field2041;

   public abstract int vmethod3511(int var1, int var2);

   public abstract void vmethod3510();

   static final int method3513() {
      return ViewportMouse.ViewportMouse_x;
   }

   static void method3518(int var0, int var1) {
      PacketBufferNode var2 = InterfaceParent.method1140(ClientPacket.field2341, Client.packetWriter.isaacCipher);
      var2.packetBuffer.method5595(var0);
      var2.packetBuffer.method5481(var1);
      Client.packetWriter.method1622(var2);
   }

   static int method3519(int var0) {
      Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
      return var1 == null?-1:(var1.nextDual == Messages.Messages_queue.sentinel?-1:((Message)var1.nextDual).count);
   }
}
