package net.runelite.standalone;

public class DirectWrapper extends Wrapper {
   Object obj;

   DirectWrapper(Object var1, int var2) {
      super(var2);
      this.obj = var1;
   }

   boolean vmethod3295() {
      return false;
   }

   Object vmethod3292() {
      return this.obj;
   }
}
