package net.runelite.standalone;

public class class163 implements class167 {
   public static String field1987;
   static Bounds field1985;
   static boolean ItemDefinition_inMembersWorld;

   static void resetContainerContents(int containerId) {
      ItemContainer container = (ItemContainer)ItemContainer.itemContainers.method6346(containerId);
      if(container != null) {
         for(int slot = 0; slot < container.ids.length; ++slot) {
            container.ids[slot] = -1;
            container.quantities[slot] = 0;
            container.itemAttributes[slot] = new String[] { "null", "null", "null" };
         }
      }
   }
}
