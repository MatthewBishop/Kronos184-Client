package net.runelite.standalone;

import java.util.Comparator;

public class UserComparator4 implements Comparator {
   public static String[] field1892;
   final boolean reversed;

   public UserComparator4(boolean var1) {
      this.reversed = var1;
   }

   int method3284(Buddy var1, Buddy var2) {
      return this.reversed?var1.int2 - var2.int2:var2.int2 - var1.int2;
   }

   public int compare(Object var1, Object var2) {
      return this.method3284((Buddy)var1, (Buddy)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public static void method3289(AbstractArchive var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method4059(var1);
      int var6 = var0.method4039(var5, var2);
      class78.method1576(var0, var5, var6, var3, var4);
   }

   static void method3290() {
      if(Client.oculusOrbState == 1) {
         Client.field1087 = true;
      }

   }
}
