package net.runelite.standalone;

import net.runelite.api.Item;

import java.util.Arrays;

public class ItemContainer extends Node implements net.runelite.api.ItemContainer {
   static int selectedSpellFlags;
   static NodeHashTable itemContainers;
   public static int rl$lastCycle;
   public static int rl$lastContainer;
   int[] ids;
   int[] quantities;
   String[][] itemAttributes;

   static {
      itemContainers = new NodeHashTable(32);
   }

   ItemContainer() {
      this.ids = new int[]{-1};
      this.quantities = new int[]{0};
      this.itemAttributes = new String[ids.length][3];
   }

   public Item[] getItems() {
      int[] var1 = this.ids;
      int[] var2 = this.quantities;
      String[][] var6 = this.itemAttributes;
      Item[] var3 = new Item[var1.length];

      for(int var4 = 0; var4 < var1.length; ++var4) {
         Item var5 = new Item(var1[var4], var2[var4], var6[var4]);
         var3[var4] = var5;
      }

      return var3;
   }

   public static Clock method1451() {
      NanoClock var10000;
      try {
         var10000 = new NanoClock();
      } catch (Throwable var1) {
         return new MilliClock();
      }

      return var10000;
   }

   public static void method1461(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
      SequenceDefinition.SequenceDefinition_archive = var0;
      SequenceDefinition.SequenceDefinition_animationsArchive = var1;
      class183.SequenceDefinition_skeletonsArchive = var2;
   }

   public static void copy$itemContainerSetItem(int containerId, int slot, int itemId, int quantity, String[] attributes, int attributeCount) {
      ItemContainer container = (ItemContainer) itemContainers.method6346(containerId);
      if (container == null) {
         container = new ItemContainer();
         itemContainers.put(container, containerId);
      }
      if(container.ids.length <= slot) {
         int[] ids = new int[slot + 1];
         int[] amounts = new int[slot + 1];
         String[][] attribs = new String[slot + 1][attributes == null ? attributeCount : attributes.length];
         for (int i = 0; i < container.ids.length; ++i) {
            ids[i] = container.ids[i];
            amounts[i] = container.quantities[i];
            attribs[i] = container.itemAttributes[i];
         }
         for (int i = container.ids.length; i < slot; ++i) {
            ids[i] = -1;
            amounts[i] = 0;
            attribs[i] = null;
         }
         container.ids = ids;
         container.quantities = amounts;
         container.itemAttributes = attribs;
      }
      container.ids[slot] = itemId;
      container.quantities[slot] = quantity;
      container.itemAttributes[slot] = attributes;
   }

   static final void method1459(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(WorldMapData_0.method171(var0)) {
         GrandExchangeOffer.field3107 = null;
         ScriptEvent.method806(UserComparator5.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(GrandExchangeOffer.field3107 != null) {
            ScriptEvent.method806(GrandExchangeOffer.field3107, -1412584499, var1, var2, var3, var4, class229.field2782, Occluder.field1806, var7);
            GrandExchangeOffer.field3107 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1049[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1049[var8] = true;
            }
         }

      }
   }

   @Override
   public String toString() {
      return "ItemContainer{" +
              "ids=" + Arrays.toString(ids) +
              ", quantities=" + Arrays.toString(quantities) +
              ", itemAttributes=" + Arrays.deepToString(itemAttributes) +
              '}';
   }
}
