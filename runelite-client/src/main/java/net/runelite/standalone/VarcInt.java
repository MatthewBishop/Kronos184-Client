package net.runelite.standalone;

public class VarcInt extends DualNode {
   public static EvictingDualNodeHashTable VarcInt_cached;
   public static AbstractArchive VarcInt_archive;
   static Archive archive18;
   public boolean persist;

   static {
      VarcInt_cached = new EvictingDualNodeHashTable(64);
   }

   public VarcInt() {
      this.persist = false;
   }

   void method4522(Buffer var1, int var2) {
      if(var2 == 2) {
         this.persist = true;
      }

   }

   public void method4519(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4522(var1, var2);
      }
   }
}
