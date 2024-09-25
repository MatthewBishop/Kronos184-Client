package net.runelite.standalone;

public class Bounds {
   public int lowY;
   public int highY;
   public int highX;
   public int lowX;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.method6251(var1, var2);
      this.method6252(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   public void method6252(int var1, int var2) {
      this.highX = var1;
      this.highY = var2;
   }

   int method6257() {
      return this.lowX + this.highX;
   }

   int method6253() {
      return this.highY + this.lowY;
   }

   void method6255(Bounds var1, Bounds var2) {
      var2.lowY = this.lowY;
      var2.highY = this.highY;
      if(this.lowY < var1.lowY) {
         var2.highY -= var1.lowY - this.lowY;
         var2.lowY = var1.lowY;
      }

      if(var2.method6253() > var1.method6253()) {
         var2.highY -= var2.method6253() - var1.method6253();
      }

      if(var2.highY < 0) {
         var2.highY = 0;
      }

   }

   void method6266(Bounds var1, Bounds var2) {
      var2.lowX = this.lowX;
      var2.highX = this.highX;
      if(this.lowX < var1.lowX) {
         var2.highX -= var1.lowX - this.lowX;
         var2.lowX = var1.lowX;
      }

      if(var2.method6257() > var1.method6257()) {
         var2.highX -= var2.method6257() - var1.method6257();
      }

      if(var2.highX < 0) {
         var2.highX = 0;
      }

   }

   public void method6254(Bounds var1, Bounds var2) {
      this.method6266(var1, var2);
      this.method6255(var1, var2);
   }

   public void method6251(int var1, int var2) {
      this.lowX = var1;
      this.lowY = var2;
   }

   public String toString() {
      return null;
   }

   public String aak() {
      return null;
   }

   public String aae() {
      return null;
   }

   public String aah() {
      return null;
   }
}
