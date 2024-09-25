package net.runelite.standalone;

import java.util.ArrayList;
import java.util.Collection;

import net.runelite.api.HashTable;

public final class NodeHashTable implements HashTable {
   Node[] buckets;
   int index;
   Node current;
   Node currentGet;
   int size;

   public NodeHashTable(int var1) {
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

   public Node method6345() {
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

   public Node method6348() {
      this.index = 0;
      return this.method6345();
   }

   public Node method6346(long var1) {
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

   public Collection getNodes() {
      ArrayList var1 = new ArrayList();
      Node[] var2 = this.buckets;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Node var4 = var2[var3];

         for(net.runelite.api.Node var5 = var4.getNext(); var5 != var4; var5 = var5.getNext()) {
            var1.add(var5);
         }
      }

      return var1;
   }

   @Override
   public Node get(long var1) {
      return this.method6346(var1);
   }
}
