package net.runelite.standalone;

public class Script extends DualNode implements net.runelite.api.Script {
   static EvictingDualNodeHashTable Script_cached;
   static Archive archive15;
   int[] opcodes;
   int localStringCount;
   int intArgumentCount;
   int localIntCount;
   String[] stringOperands;
   int[] intOperands;
   IterableNodeHashTable[] switches;
   int stringArgumentCount;

   static {
      Script_cached = new EvictingDualNodeHashTable(128);
   }

   IterableNodeHashTable[] method2200(int var1) {
      return new IterableNodeHashTable[var1];
   }

   @Override
   public int[] getInstructions() {
      return this.opcodes;
   }

   @Override
   public int[] getIntOperands() {
      return this.intOperands;
   }
}
