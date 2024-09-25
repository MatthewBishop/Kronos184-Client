package net.runelite.standalone;

public final class class229 {
   static int field2782;

   static final void method4187(Widget var0, int var1, int var2) {
      if(Client.clickedWidget == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var4 = GrandExchangeEvents.method99(var0);
            if(var4 == null) {
               var4 = var0.parent;
            }

            if(var4 != null) {
               Client.clickedWidget = var0;
               var4 = GrandExchangeEvents.method99(var0);
               if(var4 == null) {
                  var4 = var0.parent;
               }

               Client.clickedWidgetParent = var4;
               Client.widgetClickX = var1;
               Client.widgetClickY = var2;
               ViewportMouse.widgetDragDuration = 0;
               Client.isDraggingWidget = false;
               Client.draggingWidgetChanged(-1);
               int var5 = BuddyRankComparator.method3386();
               if(var5 != -1) {
                  ChatChannel.method1524(var5);
               }

               return;
            }
         }

      }
   }
}
