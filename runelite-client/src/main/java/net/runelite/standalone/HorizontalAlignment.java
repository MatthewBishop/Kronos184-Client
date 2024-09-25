package net.runelite.standalone;

public enum HorizontalAlignment implements Enumerated {
   field3267(1, 0),
   HorizontalAlignment_centered(2, 1),
   field3265(0, 2);

   public static short[] field3270;
   final int id;
   public final int value;

   HorizontalAlignment(int var3, int var4) {
      this.value = var3;
      this.id = var4;
   }

   public int getId() {
      return this.id;
   }
}
