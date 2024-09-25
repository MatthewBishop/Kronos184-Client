package net.runelite.standalone;

public class WorldMapSection2 implements WorldMapSection {
   static int field3815;
   static int cameraYaw;
   int planes;
   int regionEndY;
   int field3811;
   int regionEndX;
   int regionStartY;
   int regionStartX;
   int field3813;
   int minPlane;
   int field3816;
   int field3812;

   public boolean vmethod5843(int var1, int var2, int var3) {
      return var1 >= this.minPlane && var1 < this.planes + this.minPlane?var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY:false;
   }

   public void decode(Buffer var1) {
      this.minPlane = var1.readUnsignedByte();
      this.planes = var1.readUnsignedByte();
      this.regionStartX = var1.readUnsignedShort();
      this.regionStartY = var1.readUnsignedShort();
      this.regionEndX = var1.readUnsignedShort();
      this.regionEndY = var1.readUnsignedShort();
      this.field3811 = var1.readUnsignedShort();
      this.field3812 = var1.readUnsignedShort();
      this.field3813 = var1.readUnsignedShort();
      this.field3816 = var1.readUnsignedShort();
      this.method5865();
   }

   void method5865() {
   }

   public Coord vmethod5846(int var1, int var2) {
      if(!this.vmethod5844(var1, var2)) {
         return null;
      } else {
         int var3 = this.regionStartX * 64 - this.field3811 * 64 + var1;
         int var4 = this.regionStartY * 64 - this.field3812 * 64 + var2;
         return new Coord(this.minPlane, var3, var4);
      }
   }

   public int[] vmethod5845(int var1, int var2, int var3) {
      if(!this.vmethod5843(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field3811 * 64 - this.regionStartX * 64 + var2, var3 + (this.field3812 * 64 - this.regionStartY * 64)};
         return var4;
      }
   }

   public boolean vmethod5844(int var1, int var2) {
      return var1 >> 6 >= this.field3811 && var1 >> 6 <= this.field3813 && var2 >> 6 >= this.field3812 && var2 >> 6 <= this.field3816;
   }

   public void vmethod5850(WorldMapArea var1) {
      if(var1.regionLowX > this.field3811) {
         var1.regionLowX = this.field3811;
      }

      if(var1.regionHighX < this.field3813) {
         var1.regionHighX = this.field3813;
      }

      if(var1.regionLowY > this.field3812) {
         var1.regionLowY = this.field3812;
      }

      if(var1.regionHighY < this.field3816) {
         var1.regionHighY = this.field3816;
      }

   }

   static int method5868(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         Interpreter.Interpreter_intStackSize -= 3;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = Canvas.getWidget(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.childIndex = var5;
               var12.isIf3 = true;
               var6.children[var5] = var12;
               if(var2) {
                  GrandExchangeOfferAgeComparator.field26 = var12;
               } else {
                  KitDefinition.field3452 = var12;
               }

               WorldMapSectionType.method116(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?GrandExchangeOfferAgeComparator.field26:KitDefinition.field3452;
            Widget var10 = Canvas.getWidget(var9.id);
            var10.children[var9.childIndex] = null;
            WorldMapSectionType.method116(var10);
            return 1;
         } else if(var0 == 102) {
            var9 = Canvas.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
            var9.children = null;
            WorldMapSectionType.method116(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = Canvas.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               if(var9 != null) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                  if(var2) {
                     GrandExchangeOfferAgeComparator.field26 = var9;
                  } else {
                     KitDefinition.field3452 = var9;
                  }
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Widget var11 = GrandExchangeOfferWorldComparator.method93(var3, var4);
            if(var11 != null && var4 != -1) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
               if(var2) {
                  GrandExchangeOfferAgeComparator.field26 = var11;
               } else {
                  KitDefinition.field3452 = var11;
               }
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
