package net.runelite.standalone;

public class PrivateChatMode {
   public static final PrivateChatMode field3632;
   static final PrivateChatMode field3633;
   static final PrivateChatMode field3631;
   public final int field3634;

   static {
      field3631 = new PrivateChatMode(0);
      field3632 = new PrivateChatMode(1);
      field3633 = new PrivateChatMode(2);
   }

   PrivateChatMode(int var1) {
      this.field3634 = var1;
   }
}
