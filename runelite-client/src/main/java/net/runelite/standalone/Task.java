package net.runelite.standalone;

public class Task {
   int type;
   public int intArgument;
   public volatile int status;
   public volatile Object result;
   Task next;
   Object objectArgument;

   Task() {
      this.status = 0;
   }
}
