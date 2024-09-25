package net.runelite.standalone;

public class Skills {
   public static final boolean[] Skills_enabled;
   public static int[] Skills_experienceTable;

   static {
      Skills_enabled = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      Skills_experienceTable = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         Skills_experienceTable[var1] = var0 / 4;
      }

   }

   static void method3958() {
      if(TaskHandler.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyHandler.KeyHandler_keyCodes[186] = 57;
         KeyHandler.KeyHandler_keyCodes[187] = 27;
         KeyHandler.KeyHandler_keyCodes[188] = 71;
         KeyHandler.KeyHandler_keyCodes[189] = 26;
         KeyHandler.KeyHandler_keyCodes[190] = 72;
         KeyHandler.KeyHandler_keyCodes[191] = 73;
         KeyHandler.KeyHandler_keyCodes[192] = 58;
         KeyHandler.KeyHandler_keyCodes[219] = 42;
         KeyHandler.KeyHandler_keyCodes[220] = 74;
         KeyHandler.KeyHandler_keyCodes[221] = 43;
         KeyHandler.KeyHandler_keyCodes[222] = 59;
         KeyHandler.KeyHandler_keyCodes[223] = 28;
      } else {
         KeyHandler.KeyHandler_keyCodes[44] = 71;
         KeyHandler.KeyHandler_keyCodes[45] = 26;
         KeyHandler.KeyHandler_keyCodes[46] = 72;
         KeyHandler.KeyHandler_keyCodes[47] = 73;
         KeyHandler.KeyHandler_keyCodes[59] = 57;
         KeyHandler.KeyHandler_keyCodes[61] = 27;
         KeyHandler.KeyHandler_keyCodes[91] = 42;
         KeyHandler.KeyHandler_keyCodes[92] = 74;
         KeyHandler.KeyHandler_keyCodes[93] = 43;
         KeyHandler.KeyHandler_keyCodes[192] = 28;
         KeyHandler.KeyHandler_keyCodes[222] = 58;
         KeyHandler.KeyHandler_keyCodes[520] = 59;
      }

   }
}
