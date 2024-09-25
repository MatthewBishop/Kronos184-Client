package net.runelite.standalone;

public class Timer {
   long field3531;
   long field3535;
   int field3536;
   long field3534;
   long field3533;
   public boolean field3532;
   int field3538;
   long field3530;
   int field3539;
   int field3537;

   public Timer() {
      this.field3530 = -1L;
      this.field3531 = -1L;
      this.field3532 = false;
      this.field3533 = 0L;
      this.field3534 = 0L;
      this.field3535 = 0L;
      this.field3536 = 0;
      this.field3537 = 0;
      this.field3538 = 0;
      this.field3539 = 0;
   }

   public void method4849() {
      if(-1L != this.field3530) {
         this.field3534 = class33.method680() - this.field3530;
         this.field3530 = -1L;
      }

   }

   public void method4853() {
      this.method4851();
   }

   public void method4854(Buffer var1) {
      long var2 = this.field3534;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.method5481((int)var2);
      long var4 = this.field3533;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.method5481((int)var4);
      long var6 = this.field3535;
      var6 /= 10L;
      if(var6 < 0L) {
         var6 = 0L;
      } else if(var6 > 65535L) {
         var6 = 65535L;
      }

      var1.method5481((int)var6);
      var1.method5481(this.field3536);
      var1.method5481(this.field3537);
      var1.method5481(this.field3538);
      var1.method5481(this.field3539);
   }

   public void method4852() {
      this.field3532 = false;
      this.field3537 = 0;
   }

   public void method4851() {
      if(-1L != this.field3531) {
         this.field3533 = class33.method680() - this.field3531;
         this.field3531 = -1L;
      }

      ++this.field3538;
      this.field3532 = true;
   }

   public void method4850(int var1) {
      this.field3531 = class33.method680();
      this.field3536 = var1;
   }

   public void method4848() {
      this.field3530 = class33.method680();
   }

   public static int method4847(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
