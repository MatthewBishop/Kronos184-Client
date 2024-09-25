package net.runelite.standalone;

public enum class319 implements Enumerated {
   field3904(4, 0),
   field3895(1, 1),
   field3902(8, 2),
   field3897(2, 3),
   field3894(6, 4),
   field3899(5, 5),
   field3901(0, 6),
   field3898(7, 7),
   field3900(3, 8);

   final int id;
   final int field3903;

   class319(int var3, int var4) {
      this.field3903 = var3;
      this.id = var4;
   }

   public int getId() {
      return this.id;
   }

   static final void method6089(Actor var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Scene.shouldDraw(var0, true)) {
         Scene.copy$drawActor2d(var0, var1, var2, var3, var4, var5, var6);
      }

   }
}
