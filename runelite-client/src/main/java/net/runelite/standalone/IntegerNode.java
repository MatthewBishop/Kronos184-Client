package net.runelite.standalone;

public class IntegerNode extends Node implements net.runelite.api.IntegerNode {
   public int integer;

   public IntegerNode(int var1) {
      this.integer = var1;
   }

   @Override
   public void setValue(int var1) {
      this.integer = var1;
   }

   @Override
   public int getValue() {
      return this.integer;
   }
}
