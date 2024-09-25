package net.runelite.standalone;

public enum VerticalAlignment implements Enumerated {
   field3261(0, 0),
   VerticalAlignment_centered(2, 1),
   field3259(1, 2);

   static long field3264;
   final int id;
   public final int value;

   VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.id = var4;
   }

   public int getId() {
      return this.id;
   }

   static String method4441(Widget var0) {
      return class12.method155(class12.method148(var0)) == 0?null:(var0.spellActionName != null && var0.spellActionName.trim().length() != 0?var0.spellActionName:null);
   }
}
