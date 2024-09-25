package net.runelite.standalone;

import java.util.Collection;
import java.util.Iterator;

public class IterableNodeDeque implements Collection {
   Node field3598;
   Node sentinel;

   public IterableNodeDeque() {
      this.sentinel = new Node();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   public void method5019(Node var1) {
      if(var1.next != null) {
         var1.unlink();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   Node method5047(Node var1) {
      Node var2;
      if(var1 == null) {
         var2 = this.sentinel.previous;
      } else {
         var2 = var1;
      }

      if(var2 == this.sentinel) {
         this.field3598 = null;
         return null;
      } else {
         this.field3598 = var2.previous;
         return var2;
      }
   }

   public Node method5024() {
      Node var1 = this.field3598;
      if(var1 == this.sentinel) {
         this.field3598 = null;
         return null;
      } else {
         this.field3598 = var1.previous;
         return var1;
      }
   }

   public Node method5044() {
      return this.method5047((Node)null);
   }

   public void method5027(Node var1) {
      if(var1.next != null) {
         var1.unlink();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public boolean method5026() {
      return this.sentinel.previous == this.sentinel;
   }

   public void method5032() {
      while(this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.unlink();
      }

   }

   boolean method5029(Node var1) {
      this.method5019(var1);
      return true;
   }

   public Iterator iterator() {
      return new IterableNodeDequeDescendingIterator(this);
   }

   public int size() {
      return this.method5025();
   }

   public boolean isEmpty() {
      return this.method5026();
   }

   public boolean contains(Object var1) {
      throw new RuntimeException();
   }

   public Object[] toArray(Object[] var1) {
      int var2 = 0;

      for(Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
         var1[var2++] = var3;
      }

      return var1;
   }

   public void clear() {
      this.method5032();
   }

   public boolean add(Object var1) {
      return this.method5029((Node)var1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public boolean retainAll(Collection var1) {
      throw new RuntimeException();
   }

   public int hashCode() {
      return super.hashCode();
   }

   public boolean containsAll(Collection var1) {
      throw new RuntimeException();
   }

   public boolean addAll(Collection var1) {
      throw new RuntimeException();
   }

   public boolean remove(Object var1) {
      throw new RuntimeException();
   }

   public Object[] toArray() {
      return this.method5070();
   }

   public boolean removeAll(Collection var1) {
      throw new RuntimeException();
   }

   Node[] method5070() {
      Node[] var1 = new Node[this.method5025()];
      int var2 = 0;

      for(Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
         var1[var2++] = var3;
      }

      return var1;
   }

   int method5025() {
      int var1 = 0;

      for(Node var2 = this.sentinel.previous; var2 != this.sentinel; var2 = var2.previous) {
         ++var1;
      }

      return var1;
   }

   public static void method5021(Node var0, Node var1) {
      if(var0.next != null) {
         var0.unlink();
      }

      var0.next = var1;
      var0.previous = var1.previous;
      var0.next.previous = var0;
      var0.previous.next = var0;
   }
}
