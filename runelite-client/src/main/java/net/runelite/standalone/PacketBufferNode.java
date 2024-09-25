package net.runelite.standalone;

public class PacketBufferNode extends Node {
   static int PacketBufferNode_packetBufferNodeCount;
   static PacketBufferNode[] PacketBufferNode_packetBufferNodes;
   public static byte[][] SpriteBuffer_pixels;
   int clientPacketLength;
   public int index;
   public PacketBuffer packetBuffer;
   ClientPacket clientPacket;

   static {
      PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];
      PacketBufferNode_packetBufferNodeCount = 0;
   }

   public void method3764() {
      if(PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
         PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
      }
   }

   public static NPCDefinition getNpcDefinition(int var0) {
      NPCDefinition var1 = (NPCDefinition)NPCDefinition.NpcDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCDefinition.NpcDefinition_archive.method4020(9, var0, (short)-14113);
         var1 = new NPCDefinition();
         var1.id = var0;
         if(var2 != null) {
            var1.method4429(new Buffer(var2));
            var1.postDecode(); //TODO: Modified
         }

         var1.method4402();
         NPCDefinition.NpcDefinition_cached.method3034(var1, (long)var0);
         return var1;
      }
   }
}
