package net.runelite.standalone;

public class StructDefinition extends DualNode {
   public static EvictingDualNodeHashTable StructDefinition_cached;
   public static AbstractArchive StructDefinition_archive;
   static Sprite[] headIconPkSprites;
   IterableNodeHashTable params;

   static {
      StructDefinition_cached = new EvictingDualNodeHashTable(64);
   }

   void method4502() {
   }

   public String method4503(int var1, String var2) {
      return class94.method2216(this.params, var1, var2);
   }

   public int method4505(int var1, int var2) {
      return HealthBar.getParam(this.params, var1, var2);
   }

   void method4501(Buffer var1, int var2) {
      if(var2 == 249) {
         this.params = UserComparator5.method3374(var1, this.params);
      }

   }

   void method4500(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4501(var1, var2);
      }
   }
}
