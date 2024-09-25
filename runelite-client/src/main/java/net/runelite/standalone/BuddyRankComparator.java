package net.runelite.standalone;

public class BuddyRankComparator extends AbstractUserComparator {
   final boolean reversed;

   public BuddyRankComparator(boolean var1) {
      this.reversed = var1;
   }

   int method3384(Buddy var1, Buddy var2) {
      return var2.rank != var1.rank?(this.reversed?var1.rank - var2.rank:var2.rank - var1.rank):this.method5015(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3384((Buddy)var1, (Buddy)var2);
   }

   static final int method3386() {
      return Client.menuOptionsCount - 1;
   }
}
