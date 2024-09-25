package net.runelite.standalone;

public class ModelData0 {
   static int field1785;

   public static boolean method3069(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   static final void method3068(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuArguments1[var0];
         int var2 = Client.menuArguments2[var0];
         int var3 = Client.menuOpcodes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuActions[var0];
         String var6 = Client.menuTargets[var0];
         InvDefinition.sendMenuAction(var1, var2, var3, var4, var5, var6, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY, 2035743327);
      }
   }

   static World method3067() {
      World.World_listCount = 0;
      return AbstractByteArrayCopier.method3875();
   }
}
