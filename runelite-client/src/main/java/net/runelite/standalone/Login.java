package net.runelite.standalone;

import java.text.DecimalFormat;

public class Login {
   static boolean field755;
   static IndexedSprite[] runesSprite;
   static int xPadding;
   static IndexedSprite field758;
   static int field769;
   static int field766;
   static String Login_response0;
   static boolean field787;
   static String Login_response2;
   static String Login_response3;
   static int loginIndex;
   static String Login_password;
   static String Login_response1;
   static String Login_username;
   static boolean field771;
   static int worldSelectPage;
   static int currentLoginField;
   static boolean field778;
   static int hoveredWorldIndex;
   static long field772;
   static boolean worldSelectOpen;
   static int worldSelectPagesCount;
   static long field776;
   static Task js5SocketTask;
   static int Login_loadingPercent;
   static int loginBoxX;
   static String Login_loadingText;

   static {
      xPadding = 0;
      loginBoxX = xPadding + 202;
      Login_loadingPercent = 10;
      Login_loadingText = "";
      field769 = -1;
      field766 = 1;
      loginIndex = 0;
      Login_response0 = "";
      Login_response1 = "";
      Login_response2 = "";
      Login_response3 = "";
      Login_username = "";
      Login_password = "";
      field771 = false;
      field787 = false;
      field778 = true;
      currentLoginField = 0;
      worldSelectOpen = false;
      hoveredWorldIndex = -1;
      worldSelectPage = 0;
      worldSelectPagesCount = 0;
      new DecimalFormat("##0.00");
      new class163();
      field776 = -1L;
      field772 = -1L;
   }

   static int method1567(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         var4 = Canvas.getWidget(var3);
      } else {
         var4 = var2?GrandExchangeOfferAgeComparator.field26:KitDefinition.field3452;
      }

      if(var0 == 1000) {
         Interpreter.Interpreter_intStackSize -= 4;
         var4.rawX = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4.rawY = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var4.xAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var4.yAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         WorldMapSectionType.method116(var4);
         ViewportMouse.client.revalidateWidget(var4);
         if(var3 != -1 && var4.type == 0) {
            GameShell.revalidateWidgetScroll(UserComparator5.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         Interpreter.Interpreter_intStackSize -= 4;
         var4.rawWidth = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4.rawHeight = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         var4.widthAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var4.heightAlignment = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         WorldMapSectionType.method116(var4);
         ViewportMouse.client.revalidateWidget(var4);
         if(var3 != -1 && var4.type == 0) {
            GameShell.revalidateWidgetScroll(UserComparator5.Widget_interfaceComponents[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            var4.onHiddenChanged(-1);
            WorldMapSectionType.method116(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.noScrollThrough = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   static final int method1552(int var0, int var1) {
      int var2 = class158.method3398(var0 - 1, var1 - 1) + class158.method3398(var0 + 1, var1 - 1) + class158.method3398(var0 - 1, 1 + var1) + class158.method3398(1 + var0, var1 + 1);
      int var3 = class158.method3398(var0 - 1, var1) + class158.method3398(var0 + 1, var1) + class158.method3398(var0, var1 - 1) + class158.method3398(var0, var1 + 1);
      int var4 = class158.method3398(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   static void method1566() {
      int var0 = Players.Players_count;
      int[] var1 = Players.Players_indices;

      for(int var2 = 0; var2 < var0; ++var2) {
         if(var1[var2] != Client.combatTargetPlayerIndex && var1[var2] != Client.localPlayerIndex) {
            Players.method2146(Client.players[var1[var2]], true);
         }
      }

   }
}
