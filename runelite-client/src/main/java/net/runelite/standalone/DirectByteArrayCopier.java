package net.runelite.standalone;

import java.io.IOException;
import java.nio.ByteBuffer;

public class DirectByteArrayCopier extends AbstractByteArrayCopier {
   static int[] field2133;
   static int[] BZip2Decompressor_block;
   ByteBuffer directBuffer;

   void vmethod3858(byte[] var1) {
      this.directBuffer = ByteBuffer.allocateDirect(var1.length);
      this.directBuffer.position(0);
      this.directBuffer.put(var1);
   }

   byte[] vmethod3857() {
      byte[] var1 = new byte[this.directBuffer.capacity()];
      this.directBuffer.position(0);
      this.directBuffer.get(var1);
      return var1;
   }

   public static void method3744(boolean var0) {
      if(NetCache.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.writeByte(var0?2:3);
            var1.write24BitInteger(0);
            NetCache.NetCache_socket.vmethod5817(var1.array, 0, 4);
         } catch (IOException var4) {
            try {
               NetCache.NetCache_socket.vmethod5821();
            } catch (Exception var3) {
               ;
            }

            ++NetCache.NetCache_ioExceptions;
            NetCache.NetCache_socket = null;
         }

      }
   }
}
