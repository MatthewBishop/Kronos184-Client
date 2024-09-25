package net.runelite.standalone;

import java.io.IOException;

public class PacketWriter {
   static Scene scene;
   IterableNodeDeque packetBufferNodes;
   ServerPacket field828;
   PacketBuffer packetBuffer;
   ServerPacket serverPacket;
   public IsaacCipher isaacCipher;
   Buffer buffer;
   int bufferSize;
   boolean field827;
   AbstractSocket socket;
   ServerPacket field838;
   ServerPacket field837;
   int pendingWrites;
   int field834;
   int serverPacketLength;

   PacketWriter() {
      this.packetBufferNodes = new IterableNodeDeque();
      this.bufferSize = 0;
      this.buffer = new Buffer(5000);
      this.packetBuffer = new PacketBuffer(40000);
      this.serverPacket = null;
      this.serverPacketLength = 0;
      this.field827 = true;
      this.field834 = 0;
      this.pendingWrites = 0;
   }

   final void method1619() throws IOException {
      if(this.socket != null && this.bufferSize > 0) {
         this.buffer.offset = 0;

         while(true) {
            PacketBufferNode var1 = (PacketBufferNode)this.packetBufferNodes.method5044();
            if(var1 == null || var1.index > this.buffer.array.length - this.buffer.offset) {
               this.socket.vmethod5817(this.buffer.array, 0, this.buffer.offset);
               this.pendingWrites = 0;
               break;
            }

            this.buffer.writeBytes(var1.packetBuffer.array, 0, var1.index);
            this.bufferSize -= var1.index;
            var1.unlink();
            var1.packetBuffer.method5479();
            var1.method3764();
         }
      }

   }

   void method1637() {
      this.socket = null;
   }

   AbstractSocket method1624() {
      return this.socket;
   }

   void method1623() {
      if(this.socket != null) {
         this.socket.vmethod5821();
         this.socket = null;
      }

   }

   void method1621(AbstractSocket var1) {
      this.socket = var1;
   }

   public final void method1622(PacketBufferNode var1) {
      this.packetBufferNodes.method5019(var1);
      var1.index = var1.packetBuffer.offset;
      var1.packetBuffer.offset = 0;
      this.bufferSize += var1.index;
   }

   final void method1618() {
      this.packetBufferNodes.method5032();
      this.bufferSize = 0;
   }
}
