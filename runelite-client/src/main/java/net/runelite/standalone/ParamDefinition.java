package net.runelite.standalone;

public class ParamDefinition extends DualNode {
   static EvictingDualNodeHashTable ParamDefinition_cached;
   static int field3155;
   public static AbstractArchive ParamDefinition_archive;
   static MenuAction tempMenuAction;
   boolean autoDisable;
   public String defaultStr;
   public int defaultInt;
   char type;

   static {
      ParamDefinition_cached = new EvictingDualNodeHashTable(64);
   }

   ParamDefinition() {
      this.autoDisable = true;
   }

   void method4310() {
   }

   public boolean isString() {
      return this.type == 's';
   }

   void method4312(Buffer var1, int var2) {
      if(var2 == 1) {
         this.type = WorldMapEvent.method683(var1.readByte());
      } else if(var2 == 2) {
         this.defaultInt = var1.readInt();
      } else if(var2 == 4) {
         this.autoDisable = false;
      } else if(var2 == 5) {
         this.defaultStr = var1.readString();
      }

   }

   void method4311(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4312(var1, var2);
      }
   }

   public static void method4313(ScriptEvent var0) {
      KeyHandler.runScript(var0, 500000, (byte)0);
   }

   static final boolean method4325(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuOpcodes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
