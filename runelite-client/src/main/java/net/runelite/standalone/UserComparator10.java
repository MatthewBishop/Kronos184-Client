package net.runelite.standalone;

public class UserComparator10 extends AbstractUserComparator {
   static boolean field1809;
   static int field1808;
   final boolean reversed;

   public UserComparator10(boolean var1) {
      this.reversed = var1;
   }

   int method3084(Buddy var1, Buddy var2) {
      return Client.worldId == var1.world && var2.world == Client.worldId?(this.reversed?var1.int2 - var2.int2:var2.int2 - var1.int2):this.method5015(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3084((Buddy)var1, (Buddy)var2);
   }

   public static EnumDefinition getEnum(int var0) {
      EnumDefinition var1 = (EnumDefinition)EnumDefinition.EnumDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = EnumDefinition.EnumDefinition_archive.method4020(8, var0, (short)16793);
         var1 = new EnumDefinition();
         if(var2 != null) {
            var1.method4220(new Buffer(var2));
         }

         EnumDefinition.EnumDefinition_cached.method3034(var1, (long)var0);
         return var1;
      }
   }
}
