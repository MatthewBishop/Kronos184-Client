package net.runelite.standalone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GrandExchangeEvents {
   public static Comparator GrandExchangeEvents_ageComparator;
   public static Comparator GrandExchangeEvents_quantityComparator;
   public static Comparator GrandExchangeEvents_nameComparator;
   public static Comparator GrandExchangeEvents_priceComparator;
   public final List events;

   static {
      GrandExchangeEvents_ageComparator = new GrandExchangeOfferAgeComparator();
      new GrandExchangeOfferWorldComparator();
      GrandExchangeEvents_priceComparator = new GrandExchangeOfferUnitPriceComparator();
      GrandExchangeEvents_nameComparator = new GrandExchangeOfferNameComparator();
      GrandExchangeEvents_quantityComparator = new GrandExchangeOfferTotalQuantityComparator();
   }

   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.events = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

   public void method100(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   public static Object method94(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0.length > 136) {
         DirectByteArrayCopier var2 = new DirectByteArrayCopier();
         var2.vmethod3858(var0);
         return var2;
      } else {
         return var0;
      }
   }

   static Widget method99(Widget var0) {
      int var1 = UserComparator9.method3030(class12.method148(var0));
      if(var1 == 0) {
         return null;
      } else {
         for(int var2 = 0; var2 < var1; ++var2) {
            var0 = Canvas.getWidget(var0.parentId);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }
}
