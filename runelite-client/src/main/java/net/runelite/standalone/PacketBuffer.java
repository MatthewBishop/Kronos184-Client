package net.runelite.standalone;

public class PacketBuffer extends Buffer {
   static final int[] field3647;
   int bitIndex;
   IsaacCipher isaacCipher;

   static {
      field3647 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }

   public PacketBuffer(int var1) {
      super(var1);
   }

   public void method5303(IsaacCipher var1) {
      this.isaacCipher = var1;
   }

   public int method5302() {
      int var1 = super.array[++super.offset - 1] - this.isaacCipher.method6234() & 255;
      return var1 < 128?var1:(var1 - 128 << 8) + (super.array[++super.offset - 1] - this.isaacCipher.method6234() & 255);
   }

   public void method5282(byte[] var1, int var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         var1[var4 + var2] = (byte)(super.array[++super.offset - 1] - this.isaacCipher.method6234());
      }

   }

   public boolean method5277() {
      int var1 = super.array[super.offset] - this.isaacCipher.method6223() & 255;
      return var1 >= 128;
   }

   public int method5276() {
      return super.array[++super.offset - 1] - this.isaacCipher.method6234() & 255;
   }

   public void method5275(int var1) {
      super.array[++super.offset - 1] = (byte)(var1 + this.isaacCipher.method6234());
   }

   public int method5281(int var1) {
      int var2 = this.bitIndex >> 3;
      int var3 = 8 - (this.bitIndex & 7);
      int var4 = 0;

      for(this.bitIndex += var1; var1 > var3; var3 = 8) {
         var4 += (super.array[var2++] & field3647[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.array[var2] & field3647[var3];
      } else {
         var4 += super.array[var2] >> var3 - var1 & field3647[var1];
      }

      return var4;
   }

   public void method5273(int[] var1) {
      this.isaacCipher = new IsaacCipher(var1);
   }

   public int method5283(int var1) {
      return var1 * 8 - this.bitIndex;
   }

   public void method5279() {
      super.offset = (this.bitIndex + 7) / 8;
   }

   public void method5293() {
      this.bitIndex = super.offset * 8;
   }

   static int method5305(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         Interpreter.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         EnumDefinition var5 = UserComparator10.getEnum(var3);
         if(var5.outputType != 's') {
            ;
         }

         for(var6 = 0; var6 < var5.outputCount; ++var6) {
            if(var4 == var5.keys[var6]) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.strVals[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.defaultStr;
         }

         return 1;
      } else if(var0 != 3408) {
         if(var0 == 3411) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            EnumDefinition var10 = UserComparator10.getEnum(var3);
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var10.method4219();
            return 1;
         } else {
            return 2;
         }
      } else {
         Interpreter.Interpreter_intStackSize -= 4;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         int var9 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         EnumDefinition var7 = UserComparator10.getEnum(var9);
         if(var3 == var7.inputType && var4 == var7.outputType) {
            for(int var8 = 0; var8 < var7.outputCount; ++var8) {
               if(var6 == var7.keys[var8]) {
                  if(var4 == 115) {
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7.strVals[var8];
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var7.defaultStr;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "null";
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
