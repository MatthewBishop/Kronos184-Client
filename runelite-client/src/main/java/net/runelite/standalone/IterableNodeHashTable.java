package net.runelite.standalone;

import java.util.Iterator;

import net.runelite.api.IterableHashTable;

public final class IterableNodeHashTable implements IterableHashTable {
   Node[] buckets;
   int index;
   Node current;
   Node currentGet;
   int size;

   public IterableNodeHashTable(int var1) {
      this.index = 0;
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.previous = var3;
         var3.next = var3;
      }

   }

   public void put(Node var1, long var2) {
      if(var1.next != null) {
         var1.unlink();
      }

      Node var4 = this.buckets[(int)(var2 & (long)(this.size - 1))];
      var1.next = var4.next;
      var1.previous = var4;
      var1.next.previous = var1;
      var1.previous.next = var1;
      var1.key = var2;
   }

   public Node method6064() {
      Node var1;
      if(this.index > 0 && this.buckets[this.index - 1] != this.current) {
         var1 = this.current;
         this.current = var1.previous;
         return var1;
      } else {
         do {
            if(this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].previous;
         } while(var1 == this.buckets[this.index - 1]);

         this.current = var1.previous;
         return var1;
      }
   }

   public Node method6068() {
      this.index = 0;
      return this.method6064();
   }

   public void method6063() {
      for(int var1 = 0; var1 < this.size; ++var1) {
         Node var2 = this.buckets[var1];

         while(true) {
            Node var3 = var2.previous;
            if(var3 == var2) {
               break;
            }

            var3.unlink();
         }
      }

      this.currentGet = null;
      this.current = null;
   }

   @Override
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.currentGet = var3.previous; var3 != this.currentGet; this.currentGet = this.currentGet.previous) {
         if(this.currentGet.key == var1) {
            Node var4 = this.currentGet;
            this.currentGet = this.currentGet.previous;
            return var4;
         }
      }

      this.currentGet = null;
      return null;
   }

   public Iterator iterator() {
      return new IterableNodeHashTableIterator(this);
   }
}
