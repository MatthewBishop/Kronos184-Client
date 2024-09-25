package net.runelite.standalone;

public class Node implements net.runelite.api.Node {
   public long key;
   public Node next;
   public Node previous;

   /**
    * Called when this node is unlinked
    */
   public void onUnlink() {
   }

   public void rl$unlink() {
      this.onUnlink();
   }

   @Override
   public long getHash() {
      return this.key;
   }

   @Override
   public Node getNext() {
      return this.previous;
   }

   @Override
   public Node getPrevious() {
      return this.next;
   }

   public boolean method3494() {
      return this.next != null;
   }

   public void unlink() {
      this.rl$unlink();
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
