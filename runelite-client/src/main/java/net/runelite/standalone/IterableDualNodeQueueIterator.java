package net.runelite.standalone;

import java.util.Iterator;

public class IterableDualNodeQueueIterator implements Iterator {
   DualNode head;
   DualNode last;
   IterableDualNodeQueue queue;

   IterableDualNodeQueueIterator(IterableDualNodeQueue var1) {
      this.last = null;
      this.queue = var1;
      this.head = this.queue.sentinel.previousDual;
      this.last = null;
   }

   public void remove() {
      if(this.last == null) {
         throw new IllegalStateException();
      } else {
         this.last.unlinkDual();
         this.last = null;
      }
   }

   public boolean hasNext() {
      return this.queue.sentinel != this.head;
   }

   public Object next() {
      DualNode var1 = this.head;
      if(var1 == this.queue.sentinel) {
         var1 = null;
         this.head = null;
      } else {
         this.head = var1.previousDual;
      }

      this.last = var1;
      return var1;
   }
}
