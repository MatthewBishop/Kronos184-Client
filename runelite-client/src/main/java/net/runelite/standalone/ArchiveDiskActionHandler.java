package net.runelite.standalone;

public class ArchiveDiskActionHandler implements Runnable {
   public static NodeDeque ArchiveDiskActionHandler_responseQueue;
   static Object ArchiveDiskActionHandler_lock;
   static int field3167;
   public static NodeDeque ArchiveDiskActionHandler_requestQueue;

   static {
      ArchiveDiskActionHandler_requestQueue = new NodeDeque();
      ArchiveDiskActionHandler_responseQueue = new NodeDeque();
      field3167 = 0;
      ArchiveDiskActionHandler_lock = new Object();
   }

   public void run() {
      try {
         while(true) {
            while(true) {
               NodeDeque var2 = ArchiveDiskActionHandler_requestQueue;
               ArchiveDiskAction var1;
               synchronized(ArchiveDiskActionHandler_requestQueue) {
                  var1 = (ArchiveDiskAction)ArchiveDiskActionHandler_requestQueue.last();
               }

               Object var18;
               if(var1 != null) {
                  if(var1.type == 0) {
                     var1.archiveDisk.method5312((int)var1.key, var1.data, var1.data.length);
                     var2 = ArchiveDiskActionHandler_requestQueue;
                     synchronized(ArchiveDiskActionHandler_requestQueue) {
                        var1.unlink();
                     }
                  } else if(var1.type == 1) {
                     var1.data = var1.archiveDisk.method5306((int)var1.key);
                     var2 = ArchiveDiskActionHandler_requestQueue;
                     synchronized(ArchiveDiskActionHandler_requestQueue) {
                        ArchiveDiskActionHandler_responseQueue.addFirst(var1);
                     }
                  }

                  var18 = ArchiveDiskActionHandler_lock;
                  synchronized(ArchiveDiskActionHandler_lock) {
                     if(field3167 <= 1) {
                        field3167 = 0;
                        ArchiveDiskActionHandler_lock.notifyAll();
                        return;
                     }

                     field3167 = 600;
                  }
               } else {
                  long var8 = 99L;

                  try {
                     Thread.sleep(var8);
                  } catch (InterruptedException var13) {
                     ;
                  }

                  try {
                     Thread.sleep(1L);
                  } catch (InterruptedException var12) {
                     ;
                  }

                  var18 = ArchiveDiskActionHandler_lock;
                  synchronized(ArchiveDiskActionHandler_lock) {
                     if(field3167 <= 1) {
                        field3167 = 0;
                        ArchiveDiskActionHandler_lock.notifyAll();
                        return;
                     }

                     --field3167;
                  }
               }
            }
         }
      } catch (Exception var17) {
         class19.method342((String)null, var17);
      }
   }

   public static void method4341(String url, boolean var1, boolean var2) {
      WorldMapID.method685(url, var1, "openjs", var2);
   }
}
