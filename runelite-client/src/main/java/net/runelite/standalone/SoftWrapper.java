package net.runelite.standalone;

import java.lang.ref.SoftReference;

public class SoftWrapper extends Wrapper {
   SoftReference ref;

   SoftWrapper(Object var1, int var2) {
      super(var2);
      this.ref = new SoftReference(var1);
   }

   boolean vmethod3295() {
      return true;
   }

   Object vmethod3292() {
      return this.ref.get();
   }
}
