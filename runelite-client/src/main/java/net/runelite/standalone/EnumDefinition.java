package net.runelite.standalone;

public class EnumDefinition extends DualNode implements net.runelite.api.EnumDefinition {
   static EvictingDualNodeHashTable EnumDefinition_cached;
   static WorldMapEvent worldMapEvent;
   public static AbstractArchive EnumDefinition_archive;
   public int defaultInt;
   public int outputCount;
   public String defaultStr;
   public char outputType;
   public char inputType;
   public int[] intVals;
   public String[] strVals;
   public int[] keys;

   static {
      EnumDefinition_cached = new EvictingDualNodeHashTable(64);
   }

   EnumDefinition() {
      this.defaultStr = "null";
      this.outputCount = 0;
   }

   void method4220(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4221(var1, var2);
      }
   }

   public int method4219() {
      return this.outputCount;
   }

   void method4221(Buffer var1, int var2) {
      if(var2 == 1) {
         this.inputType = (char)var1.readUnsignedByte();
      } else if(var2 == 2) {
         this.outputType = (char)var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.defaultStr = var1.readString();
      } else if(var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if(var2 == 5) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.strVals = new String[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.strVals[var3] = var1.readString();
            }
         } else if(var2 == 6) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.intVals = new int[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.intVals[var3] = var1.readInt();
            }
         }
      }

   }

   @Override
   public int[] getKeys() {
      return this.keys;
   }

   @Override
   public int[] getIntVals() {
      return this.intVals;
   }

   @Override
   public String[] getStringVals() {
      return this.strVals;
   }

   public int getIntValue(int var1) {
      int[] var2 = this.getKeys();
      if(var2 == null) {
         return this.defaultInt;
      } else {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            if(var2[var3] == var1) {
               int[] var4 = this.getIntVals();
               return var4[var3];
            }
         }

         return this.defaultInt;
      }
   }

   public String getStringValue(int var1) {
      int[] var2 = this.getKeys();
      if(var2 == null) {
         return this.defaultStr;
      } else {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            if(var2[var3] == var1) {
               String[] var4 = this.getStringVals();
               return var4[var3];
            }
         }

         return this.defaultStr;
      }
   }

   static final void method4225(String var0) {
      class217.sendGameMessage(30, "", var0);
   }
}
