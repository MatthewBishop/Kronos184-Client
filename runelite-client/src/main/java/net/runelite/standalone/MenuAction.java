package net.runelite.standalone;

import java.io.IOException;

public class MenuAction {
   public static int PcmPlayer_count;
   int argument1;
   String action;
   int argument0;
   int argument2;
   int opcode;

   public static void method2160(AbstractSocket var0, boolean var1) {
      if(NetCache.NetCache_socket != null) {
         try {
            NetCache.NetCache_socket.vmethod5821();
         } catch (Exception var6) {
            ;
         }

         NetCache.NetCache_socket = null;
      }

      NetCache.NetCache_socket = var0;
      DirectByteArrayCopier.method3744(var1);
      NetCache.NetCache_responseHeaderBuffer.offset = 0;
      WorldMapEvent.NetCache_currentResponse = null;
      FaceNormal.NetCache_responseArchiveBuffer = null;
      NetCache.field3271 = 0;

      while(true) {
         NetFileRequest var2 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.method6348();
         if(var2 == null) {
            while(true) {
               var2 = (NetFileRequest)NetCache.NetCache_pendingResponses.method6348();
               if(var2 == null) {
                  if(NetCache.field3287 != 0) {
                     try {
                        Buffer var7 = new Buffer(4);
                        var7.writeByte(4);
                        var7.writeByte(NetCache.field3287);
                        var7.method5481(0);
                        NetCache.NetCache_socket.vmethod5817(var7.array, 0, 4);
                     } catch (IOException var5) {
                        try {
                           NetCache.NetCache_socket.vmethod5821();
                        } catch (Exception var4) {
                           ;
                        }

                        ++NetCache.NetCache_ioExceptions;
                        NetCache.NetCache_socket = null;
                     }
                  }

                  NetCache.NetCache_loadTime = 0;
                  NetCache.field3273 = class33.method680();
                  return;
               }

               NetCache.NetCache_pendingWritesQueue.method4253(var2);
               NetCache.NetCache_pendingWrites.put(var2, var2.key);
               ++NetCache.NetCache_pendingWritesCount;
               --NetCache.NetCache_pendingResponsesCount;
            }
         }

         NetCache.NetCache_pendingPriorityWrites.put(var2, var2.key);
         ++NetCache.NetCache_pendingPriorityWritesCount;
         --NetCache.NetCache_pendingPriorityResponsesCount;
      }
   }

   public static final void method2159() {
      ViewportMouse.ViewportMouse_isInViewport = false;
      ViewportMouse.ViewportMouse_entityCount = 0;
   }
}
