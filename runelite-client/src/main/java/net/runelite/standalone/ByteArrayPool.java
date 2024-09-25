package net.runelite.standalone;

public class ByteArrayPool {
   static int ByteArrayPool_mediumCount;
   static byte[][] ByteArrayPool_large;
   public static int[] ByteArrayPool_alternativeSizes;
   static byte[][] ByteArrayPool_medium;
   static byte[][] ByteArrayPool_small;
   static int ByteArrayPool_largeCount;
   static int ByteArrayPool_smallCount;
   public static int[] ByteArrayPool_altSizeArrayCounts;

   static {
      ByteArrayPool_smallCount = 0;
      ByteArrayPool_mediumCount = 0;
      ByteArrayPool_largeCount = 0;
      ByteArrayPool_small = new byte[1000][];
      ByteArrayPool_medium = new byte[250][];
      ByteArrayPool_large = new byte[50][];
   }

   static synchronized byte[] method5765(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(ByteArrayPool_smallCount > 0) {
         var2 = ByteArrayPool_small[--ByteArrayPool_smallCount];
         ByteArrayPool_small[ByteArrayPool_smallCount] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(ByteArrayPool_mediumCount > 0) {
         var2 = ByteArrayPool_medium[--ByteArrayPool_mediumCount];
         ByteArrayPool_medium[ByteArrayPool_mediumCount] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(ByteArrayPool_largeCount > 0) {
         var2 = ByteArrayPool_large[--ByteArrayPool_largeCount];
         ByteArrayPool_large[ByteArrayPool_largeCount] = null;
         return var2;
      }

      if(class86.ByteArrayPool_arrays != null) {
         for(int var4 = 0; var4 < ByteArrayPool_alternativeSizes.length; ++var4) {
            if(ByteArrayPool_alternativeSizes[var4] != var0) {
               if(var0 < ByteArrayPool_alternativeSizes[var4]) {
                  ;
               }
            } else if(ByteArrayPool_altSizeArrayCounts[var4] > 0) {
               byte[] var3 = class86.ByteArrayPool_arrays[var4][--ByteArrayPool_altSizeArrayCounts[var4]];
               class86.ByteArrayPool_arrays[var4][ByteArrayPool_altSizeArrayCounts[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }
}
