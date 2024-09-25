package net.runelite.standalone;

public class UserComparator9 extends AbstractUserComparator {
   final boolean reversed;

   public UserComparator9(boolean var1) {
      this.reversed = var1;
   }

   int method3027(Buddy var1, Buddy var2) {
      return Client.worldId == var1.world && var2.world == Client.worldId?(this.reversed?var1.method4879().method4992(var2.method4879()):var2.method4879().method4992(var1.method4879())):this.method5015(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3027((Buddy)var1, (Buddy)var2);
   }

   public static int method3030(int var0) {
      return var0 >> 17 & 7;
   }

   public static FloorUnderlayDefinition method3029(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.method4020(1, var0, (short)27219);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.method4603(new Buffer(var2), var0);
         }

         var1.method4602();
         FloorUnderlayDefinition.FloorUnderlayDefinition_cached.method3034(var1, (long)var0);
         return var1;
      }
   }
}
