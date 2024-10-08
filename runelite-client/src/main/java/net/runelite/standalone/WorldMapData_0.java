package net.runelite.standalone;

import java.util.Date;

public class WorldMapData_0 extends AbstractWorldMapData {
   static ArchiveDisk masterDisk;
   static GraphicsDefaults spriteIds;
   static IndexedSprite[] modIconSprites;

   void vmethod3304(Buffer var1) {
      super.planes = Math.min(super.planes, 4);
      super.floorUnderlayIds = new short[1][64][64];
      super.floorOverlayIds = new short[super.planes][64][64];
      super.field1907 = new byte[super.planes][64][64];
      super.field1895 = new byte[super.planes][64][64];
      super.decorations = new WorldMapDecoration[super.planes][64][64][];
      int var2 = var1.readUnsignedByte();
      if(var2 != class33.field253.value) {
         throw new IllegalStateException("");
      } else {
         int var3 = var1.readUnsignedByte();
         int var4 = var1.readUnsignedByte();
         if(var3 == super.regionX && var4 == super.regionY) {
            for(int var5 = 0; var5 < 64; ++var5) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  this.method3310(var5, var6, var1);
               }
            }

         } else {
            throw new IllegalStateException("");
         }
      }
   }

   void method157(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 != WorldMapID.field263.value) {
         throw new IllegalStateException("");
      } else {
         super.minPlane = var1.readUnsignedByte();
         super.planes = var1.readUnsignedByte();
         super.regionXLow = var1.readUnsignedShort();
         super.regionYLow = var1.readUnsignedShort();
         super.regionX = var1.readUnsignedShort();
         super.regionY = var1.readUnsignedShort();
         super.groupId = var1.method5507();
         super.fileId = var1.method5507();
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof WorldMapData_0)) {
         return false;
      } else {
         WorldMapData_0 var2 = (WorldMapData_0)var1;
         return var2.regionX == super.regionX && var2.regionY == super.regionY;
      }
   }

   public int hashCode() {
      return super.regionX | super.regionY << 8;
   }

   public static boolean method171(int var0) {
      if(ViewportMouse.Widget_loadedInterfaces[var0]) {
         return true;
      } else if(!Widget.Widget_archive.method4046(var0)) {
         return false;
      } else {
         int var1 = Widget.Widget_archive.fileCount(var0);
         if(var1 == 0) {
            ViewportMouse.Widget_loadedInterfaces[var0] = true;
            return true;
         } else {
            if(UserComparator5.Widget_interfaceComponents[var0] == null) {
               UserComparator5.Widget_interfaceComponents[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(UserComparator5.Widget_interfaceComponents[var0][var2] == null) {
                  byte[] var3 = Widget.Widget_archive.method4020(var0, var2, (short)-3696);
                  if(var3 != null) {
                     UserComparator5.Widget_interfaceComponents[var0][var2] = new Widget();
                     UserComparator5.Widget_interfaceComponents[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        UserComparator5.Widget_interfaceComponents[var0][var2].method4001(new Buffer(var3));
                     } else {
                        UserComparator5.Widget_interfaceComponents[var0][var2].method3966(new Buffer(var3));
                     }

                     //TODO: Custom Interface Edits
                     CustomInterfaceEdits.childLoaded(UserComparator5.Widget_interfaceComponents[var0][var2]);
                  }
               }
            }

            ViewportMouse.Widget_loadedInterfaces[var0] = true;
            return true;
         }
      }
   }

   public static void method173(int var0, AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method4059(var2);
      int var7 = var1.method4039(var6, var3);
      class197.field2173 = 1;
      class197.musicTrackArchive = var1;
      class183.musicTrackGroupId = var6;
      class38.musicTrackFileId = var7;
      TileItem.field816 = var4;
      WorldMapSectionType.musicTrackBoolean = var5;
      MusicPatchNode2.field2119 = var0;
   }

   static void method170(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].population;
                     var12 = var8.population;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1212()?1:0;
                     var12 = var8.method1212()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].population;
                     var12 = var8.population;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1212()?1:0;
                     var12 = var8.method1212()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method170(var0, var1, var6, var3, var4);
         method170(var0, var6 + 1, var2, var3, var4);
      }

   }

   static int method156(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var9;
         if(var0 == 4101) {
            Interpreter.Interpreter_stringStackSize -= 2;
            var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
            var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + var9;
            return 1;
         } else if(var0 == 4102) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + HealthBar.method2255(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var6;
            int var10;
            if(var0 == 4104) {
               var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               long var11 = 86400000L * (11745L + (long)var10);
               Interpreter.Interpreter_calendar.setTime(new Date(var11));
               var6 = Interpreter.Interpreter_calendar.get(5);
               int var16 = Interpreter.Interpreter_calendar.get(2);
               int var8 = Interpreter.Interpreter_calendar.get(1);
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var16] + "-" + var8;
               return 1;
            } else if(var0 != 4105) {
               if(var0 == 4106) {
                  var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Integer.toString(var10);
                  return 1;
               } else if(var0 == 4107) {
                  Interpreter.Interpreter_stringStackSize -= 2;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class188.method3739(Interpreter.method1409(Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1], WorldMapLabelSize.clientLanguage));
                  return 1;
               } else {
                  int var5;
                  byte[] var13;
                  Font var14;
                  if(var0 == 4108) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var13 = Tile.archive13.method4020(var5, 0, (short)-11782);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.method5327(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var13 = Tile.archive13.method4020(var5, 0, (short)-9990);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.method5389(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     Interpreter.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                     if(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
                     } else {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = AbstractFont.method5328(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if(var0 == 4113) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = TileItem.method1602((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4114) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractArchive.method4111((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4115) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator7.method2886((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4116) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = AbstractWorldMapIcon.method710((char)var10)?1:0;
                     return 1;
                  } else if(var0 == 4117) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     if(var3 != null) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.length();
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 4118) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
                     return 1;
                  } else if(var0 == 4119) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     StringBuilder var17 = new StringBuilder(var3.length());
                     boolean var15 = false;

                     for(var6 = 0; var6 < var3.length(); ++var6) {
                        char var7 = var3.charAt(var6);
                        if(var7 == '<') {
                           var15 = true;
                        } else if(var7 == '>') {
                           var15 = false;
                        } else if(!var15) {
                           var17.append(var7);
                        }
                     }

                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var17.toString();
                     return 1;
                  } else if(var0 == 4120) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.indexOf(var4);
                     return 1;
                  } else if(var0 == 4121) {
                     Interpreter.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                     var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
                     return 1;
                  } else if(var0 == 4122) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3.toUpperCase();
                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               Interpreter.Interpreter_stringStackSize -= 2;
               var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
               var9 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
               if(class215.localPlayer.appearance != null && class215.localPlayer.appearance.isFemale) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9;
               } else {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
               }

               return 1;
            }
         }
      }
   }

   public static int method172(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + Entity.method3074(var0.charAt(var3));
      }

      return var2;
   }
}
