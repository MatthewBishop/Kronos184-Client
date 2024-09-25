package net.runelite.standalone;

import java.util.HashMap;
import java.util.Iterator;

public class class194 {
   static IndexedSprite options_buttons_0Sprite;

   static {
      new HashMap();
   }

   static final void method3773() {
      Iterator var0 = Messages.Messages_hashTable.iterator();

      while(var0.hasNext()) {
         Message var1 = (Message)var0.next();
         var1.method880();
      }

      if(Varps.clanChat != null) {
         Varps.clanChat.method4931();
      }

   }
}
