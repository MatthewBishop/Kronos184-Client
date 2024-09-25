package net.runelite.standalone;

public abstract class PcmStream extends Node {
   PcmStream after;
   volatile boolean active;
   AbstractSound sound;
   int field1325;

   protected PcmStream() {
      this.active = true;
   }

   protected abstract PcmStream vmethod3775();

   protected abstract PcmStream vmethod3794();

   protected abstract void vmethod3777(int[] var1, int var2, int var3);

   int vmethod2542() {
      return 255;
   }

   protected abstract void vmethod3778(int var1);

   final void method2327(int[] var1, int var2, int var3) {
      if(this.active) {
         this.vmethod3777(var1, var2, var3);
      } else {
         this.vmethod3778(var3);
      }

   }

   protected abstract int vmethod3787();
}
