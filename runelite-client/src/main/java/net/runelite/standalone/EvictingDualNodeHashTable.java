package net.runelite.standalone;

import net.runelite.api.NodeCache;

public final class EvictingDualNodeHashTable implements NodeCache {
   int capacity;
   IterableDualNodeQueue deque;
   IterableNodeHashTable hashTable;
   int remainingCapacity;
   DualNode dualNode;

   public EvictingDualNodeHashTable(int var1) {
      this.dualNode = new DualNode();
      this.deque = new IterableDualNodeQueue();
      this.capacity = var1;
      this.remainingCapacity = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.hashTable = new IterableNodeHashTable(var2);
   }

   public void remove(long var1) {
      DualNode var3 = (DualNode)this.hashTable.get(var1);
      if(var3 != null) {
         var3.unlink();
         var3.unlinkDual();
         ++this.remainingCapacity;
      }

   }

   public void clear() {
      this.deque.method4897();
      this.hashTable.method6063();
      this.dualNode = new DualNode();
      this.remainingCapacity = this.capacity;
   }

   public void method3034(DualNode var1, long var2) {
      if(this.remainingCapacity == 0) {
         DualNode var4 = this.deque.method4920();
         var4.unlink();
         var4.unlinkDual();
         if(var4 == this.dualNode) {
            var4 = this.deque.method4920();
            var4.unlink();
            var4.unlinkDual();
         }
      } else {
         --this.remainingCapacity;
      }

      this.hashTable.put(var1, var2);
      this.deque.add(var1);
   }

   public DualNode get(long var1) {
      DualNode var3 = (DualNode)this.hashTable.get(var1);
      if(var3 != null) {
         this.deque.add(var3);
      }

      return var3;
   }

   @Override
   public void setCapacity(int var1) {
      this.capacity = var1;
   }

   @Override
   public void setRemainingCapacity(int var1) {
      this.remainingCapacity = var1;
   }

   @Override
   public void reset() {
      this.clear();
   }
}
