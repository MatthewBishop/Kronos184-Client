package net.runelite.standalone;

import java.util.zip.CRC32;

public class NetCache {
   static int NetCache_loadTime;
   static NodeHashTable NetCache_pendingPriorityResponses;
   static int NetCache_pendingPriorityResponsesCount;
   static int NetCache_pendingPriorityWritesCount;
   static Archive[] NetCache_archives;
   static int field3271;
   static NodeHashTable NetCache_pendingPriorityWrites;
   static long field3273;
   static CRC32 NetCache_crc;
   static NodeHashTable NetCache_pendingWrites;
   static AbstractSocket NetCache_socket;
   static int NetCache_pendingResponsesCount;
   static NodeHashTable NetCache_pendingResponses;
   public static int NetCache_ioExceptions;
   static Buffer NetCache_responseHeaderBuffer;
   static byte field3287;
   static int NetCache_pendingWritesCount;
   public static int NetCache_crcMismatches;
   static DualNodeDeque NetCache_pendingWritesQueue;

   static {
      NetCache_loadTime = 0;
      NetCache_pendingPriorityWrites = new NodeHashTable(4096);
      NetCache_pendingPriorityWritesCount = 0;
      NetCache_pendingPriorityResponses = new NodeHashTable(32);
      NetCache_pendingPriorityResponsesCount = 0;
      NetCache_pendingWritesQueue = new DualNodeDeque();
      NetCache_pendingWrites = new NodeHashTable(4096);
      NetCache_pendingWritesCount = 0;
      NetCache_pendingResponses = new NodeHashTable(4096);
      NetCache_pendingResponsesCount = 0;
      NetCache_responseHeaderBuffer = new Buffer(8);
      field3271 = 0;
      NetCache_crc = new CRC32();
      NetCache_archives = new Archive[256];
      field3287 = 0;
      NetCache_crcMismatches = 0;
      NetCache_ioExceptions = 0;
   }

   static boolean method4466(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   static final void method4465(String var0) {
      if(Varps.clanChat != null) {
         PacketBufferNode var1 = InterfaceParent.method1140(ClientPacket.field2371, Client.packetWriter.isaacCipher);
         var1.packetBuffer.writeByte(class267.method4877(var0));
         var1.packetBuffer.writeString(var0);
         Client.packetWriter.method1622(var1);
      }
   }

   static void method4449(int var0) {
      Client.oculusOrbState = var0;
   }
}
