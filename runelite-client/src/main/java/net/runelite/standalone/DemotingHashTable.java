package net.runelite.standalone;

public final class DemotingHashTable {
   int remaining;
   class147 field1816;
   IterableDualNodeQueue queue;
   IterableNodeHashTable hashTable;
   int capacity;

   public DemotingHashTable(int var1, int var2) {
      this.queue = new IterableDualNodeQueue();
      this.capacity = var1;
      this.remaining = var1;

      int var3;
      for(var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
         ;
      }

      this.hashTable = new IterableNodeHashTable(var3);
   }

   void method3089(long var1) {
      Wrapper var3 = (Wrapper)this.hashTable.get(var1);
      this.method3091(var3);
   }

   public void method3094() {
      this.queue.method4897();
      this.hashTable.method6063();
      this.remaining = this.capacity;
   }

   public void method3093(int var1) {
      for(Wrapper var2 = (Wrapper)this.queue.method4898(); var2 != null; var2 = (Wrapper)this.queue.method4902()) {
         if(var2.vmethod3295()) {
            if(var2.vmethod3292() == null) {
               var2.unlink();
               var2.unlinkDual();
               this.remaining += var2.size;
            }
         } else if(++var2.keyDual > (long)var1) {
            SoftWrapper var3 = new SoftWrapper(var2.vmethod3292(), var2.size);
            this.hashTable.put(var3, var2.key);
            IterableDualNodeQueue.method4899(var3, var2);
            var2.unlink();
            var2.unlinkDual();
         }
      }

   }

   public void method3104(Object var1, long var2, int var4) {
      if(var4 > this.capacity) {
         throw new IllegalStateException();
      } else {
         this.method3089(var2);
         this.remaining -= var4;

         while(this.remaining < 0) {
            Wrapper var5 = (Wrapper)this.queue.method4920();
            if(var5 == null) {
               throw new RuntimeException("");
            }

            if(!var5.vmethod3295()) {
               ;
            }

            this.method3091(var5);
            if(this.field1816 != null) {
               this.field1816.method3112(var5.vmethod3292());
            }
         }

         DirectWrapper var6 = new DirectWrapper(var1, var4);
         this.hashTable.put(var6, var2);
         this.queue.add(var6);
         var6.keyDual = 0L;
      }
   }

   void method3091(Wrapper var1) {
      if(var1 != null) {
         var1.unlink();
         var1.unlinkDual();
         this.remaining += var1.size;
      }

   }

   public Object method3092(long var1) {
      Wrapper var3 = (Wrapper)this.hashTable.get(var1);
      if(var3 == null) {
         return null;
      } else {
         Object var4 = var3.vmethod3292();
         if(var4 == null) {
            var3.unlink();
            var3.unlinkDual();
            this.remaining += var3.size;
            return null;
         } else {
            if(var3.vmethod3295()) {
               DirectWrapper var5 = new DirectWrapper(var4, var3.size);
               this.hashTable.put(var5, var3.key);
               this.queue.add(var5);
               var5.keyDual = 0L;
               var3.unlink();
               var3.unlinkDual();
            } else {
               this.queue.add(var3);
               var3.keyDual = 0L;
            }

            return var4;
         }
      }
   }
}
