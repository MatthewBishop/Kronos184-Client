package net.runelite.standalone;

public class VarpDefinition extends DualNode {
   public static int VarpDefinition_fileCount;
   static EvictingDualNodeHashTable VarpDefinition_cached;
   public static AbstractArchive VarpDefinition_archive;
   public int type;

   static {
      VarpDefinition_cached = new EvictingDualNodeHashTable(64);
   }

   VarpDefinition() {
      this.type = 0;
   }

   void method4487(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4488(var1, var2);
      }
   }

   void method4488(Buffer var1, int var2) {
      if(var2 == 5) {
         this.type = var1.readUnsignedShort();
      }

   }

   static int method4497(int var0, Script var1, boolean var2) {
      Widget var3 = var2?GrandExchangeOfferAgeComparator.field26:KitDefinition.field3452;
      if(var0 == 1700) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 1701) {
         if(var3.itemId != -1) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemQuantity;
         } else {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.childIndex;
         return 1;
      } else {
         return 2;
      }
   }
}
