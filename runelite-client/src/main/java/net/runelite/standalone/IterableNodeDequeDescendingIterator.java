package net.runelite.standalone;

import java.util.Iterator;

public class IterableNodeDequeDescendingIterator implements Iterator {
   Node field3612;
   Node last;
   IterableNodeDeque deque;

   IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
      this.last = null;
      this.method5159(var1);
   }

   void method5150() {
      this.field3612 = this.deque != null?this.deque.sentinel.previous:null;
      this.last = null;
   }

   public void remove() {
      if(this.last == null) {
         throw new IllegalStateException();
      } else {
         this.last.unlink();
         this.last = null;
      }
   }

   public Object next() {
      Node var1 = this.field3612;
      if(var1 == this.deque.sentinel) {
         var1 = null;
         this.field3612 = null;
      } else {
         this.field3612 = var1.previous;
      }

      this.last = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.deque.sentinel != this.field3612;
   }

   void method5159(IterableNodeDeque var1) {
      this.deque = var1;
      this.method5150();
   }
}
