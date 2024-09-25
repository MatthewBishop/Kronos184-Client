package net.runelite.standalone;

public class Link {
   public Link next;
   public Link previous;

   public void method3451() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
