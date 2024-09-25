package net.runelite.standalone;

public class NodeDeque {
   Node current;
   public Node sentinel;

   public NodeDeque() {
      this.sentinel = new Node();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   public void addFirst(Node var1) {
      if(var1.next != null) {
         var1.unlink();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Node method5109() {
      Node var1 = this.sentinel.next;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   public Node last() {
      Node var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   public Node method5108() {
      Node var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.unlink();
         return var1;
      }
   }

   public void method5106(Node var1) {
      if(var1.next != null) {
         var1.unlink();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Node previous() {
      Node var1 = this.current;
      if(var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   public void method5104() {
      while(true) {
         Node var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            this.current = null;
            return;
         }

         var1.unlink();
      }
   }

   public Node getPrevious() {
      Node var1 = this.current;
      if(var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   public Node getTail() {
      Node var1 = this.sentinel.next;
      if(var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.next;
         return var1;
      }
   }

   public static void method5130(Node var0, Node var1) {
      if(var0.next != null) {
         var0.unlink();
      }

      var0.next = var1.next;
      var0.previous = var1;
      var0.next.previous = var0;
      var0.previous.next = var0;
   }
}
