package net.runelite.standalone;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionCheck extends Node {
   static int foundItemIndex;
   static Sprite[] headIconHintSprites;
   int size;
   int[] intReplaceValues;
   Method[] methods;
   Field[] fields;
   int[] creationErrors;
   int[] operations;
   int id;
   byte[][][] arguments;

   static int method2145(int var0, Script var1, boolean var2) {
      if(var0 == 3200) {
         Interpreter.Interpreter_intStackSize -= 3;
         Message.method888(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2]);
         return 1;
      } else if(var0 == 3201) {
         MusicPatchNode2.method3725(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         return 1;
      } else if(var0 == 3202) {
         Interpreter.Interpreter_intStackSize -= 2;
         ClientPacket.method3878(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
         return 1;
      } else {
         return 2;
      }
   }
}
