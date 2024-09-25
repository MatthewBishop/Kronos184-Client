package net.runelite.standalone;

public class MilliClock extends Clock {
   int field1935;
   int field1938;
   int field1939;
   long field1940;
   int field1937;
   long[] field1936;

   MilliClock() {
      this.field1936 = new long[10];
      this.field1935 = 256;
      this.field1937 = 1;
      this.field1939 = 0;
      this.field1940 = class33.method680();

      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1936[var1] = this.field1940;
      }

   }

   public int vmethod3511(int var1, int var2) {
      int var3 = this.field1935;
      int var4 = this.field1937;
      this.field1935 = 300;
      this.field1937 = 1;
      this.field1940 = class33.method680();
      if(0L == this.field1936[this.field1938]) {
         this.field1935 = var3;
         this.field1937 = var4;
      } else if(this.field1940 > this.field1936[this.field1938]) {
         this.field1935 = (int)((long)(var1 * 2560) / (this.field1940 - this.field1936[this.field1938]));
      }

      if(this.field1935 < 25) {
         this.field1935 = 25;
      }

      if(this.field1935 > 256) {
         this.field1935 = 256;
         this.field1937 = (int)((long)var1 - (this.field1940 - this.field1936[this.field1938]) / 10L);
      }

      if(this.field1937 > var1) {
         this.field1937 = var1;
      }

      this.field1936[this.field1938] = this.field1940;
      this.field1938 = (this.field1938 + 1) % 10;
      if(this.field1937 > 1) {
         for(int var5 = 0; var5 < 10; ++var5) {
            if(0L != this.field1936[var5]) {
               this.field1936[var5] += (long)this.field1937;
            }
         }
      }

      if(this.field1937 < var2) {
         this.field1937 = var2;
      }

      long var10 = (long)this.field1937;
      if(var10 > 0L) {
         if(var10 % 10L == 0L) {
            long var7 = var10 - 1L;

            try {
               Thread.sleep(var7);
            } catch (InterruptedException var16) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var15) {
               ;
            }
         } else {
            try {
               Thread.sleep(var10);
            } catch (InterruptedException var14) {
               ;
            }
         }
      }

      int var13;
      for(var13 = 0; this.field1939 < 256; this.field1939 += this.field1935) {
         ++var13;
      }

      this.field1939 &= 255;
      return var13;
   }

   public void vmethod3510() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field1936[var1] = 0L;
      }

   }
}
