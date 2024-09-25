package net.runelite.standalone;

public class DualNode extends Node {
   public DualNode nextDual;
   public DualNode previousDual;
   public long keyDual;

   public void unlinkDual() {
      if(this.nextDual != null) {
         this.nextDual.previousDual = this.previousDual;
         this.previousDual.nextDual = this.nextDual;
         this.previousDual = null;
         this.nextDual = null;
      }
   }

}
