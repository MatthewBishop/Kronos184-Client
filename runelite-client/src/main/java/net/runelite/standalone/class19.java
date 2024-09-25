package net.runelite.standalone;

public class class19 {
   static IndexedSprite titleboxSprite;

   public static int method345(long var0) {
      return (int)(var0 >>> 7 & 127L);
   }

   static char method344(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   public static void method342(String var0, Throwable var1) {
      if(var1 != null) {
         var1.printStackTrace();
      } else {
         if(var1 != null) {
            Throwable var2 = var1;
            if(var1 instanceof RunException) {
                var2 = ((RunException) var1).throwable;
            }

            ViewportMouse.client.getLogger().error("Game crash: {}", var0, var2);
         }

      }
   }

   static final void method338() {
      int var0 = Players.Players_count;
      int[] var1 = Players.Players_indices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.players[var1[var2]];
         if(var3 != null) {
            class329.method6315(var3, 1);
         }
      }

   }

   static void method340(int var0, int var1, int var2, int var3) {
      Widget var4 = GrandExchangeOfferWorldComparator.method93(var0, var1);
      if(var4 != null && var4.onTargetEnter != null) {
         ScriptEvent var5 = new ScriptEvent();
         var5.widget = var4;
         var5.args = var4.onTargetEnter;
         ParamDefinition.method4313(var5);
      }

      Client.field1001 = var3;
      Client.isSpellSelected = true;
      AttackOption.selectedSpellWidget = var0;
      Client.selectedSpellChildIndex = var1;
      ItemContainer.selectedSpellFlags = var2;
      WorldMapSectionType.method116(var4);
   }

   static final void method343(int var0, int var1, int var2, int var3) {
      if(Client.isItemSelected == 0 && !Client.isSpellSelected) {
         WorldMapData_1.method519("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      long var4 = -1L;
      long var6 = -1L;
      int var8 = 0;

      while(true) {
         int var10 = ViewportMouse.ViewportMouse_entityCount;
         if(var8 >= var10) {
            if(-1L != var4) {
               var8 = class12.method153(var4);
               int var9 = method345(var4);
               Player var27 = Client.players[Client.combatTargetPlayerIndex];
               GrandExchangeEvent.method6487(var27, Client.combatTargetPlayerIndex, var8, var9);
            }

            return;
         }

         long var11 = ViewportMouse.ViewportMouse_entityTags[var8];
         if(var11 != var6) {
            label336: {
               var6 = var11;
               int var15 = class12.method153(ViewportMouse.ViewportMouse_entityTags[var8]);
               int var16 = var15;
               int var17 = ArchiveLoader.method1301(var8);
               int var18 = class86.method2113(var8);
               int var19 = class86.method2114(ViewportMouse.ViewportMouse_entityTags[var8]);
               int var20 = var19;
               if(var18 == 2 && PacketWriter.scene.method3144(WorldMapRectangle.plane, var15, var17, var11) >= 0) {
                  ObjectDefinition var21 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var19);
                  if(var21.transforms != null) {
                     var21 = var21.method4733();
                  }

                  if(var21 == null) {
                     break label336;
                  }

                  if(Client.isItemSelected == 1) {
                     WorldMapData_1.method519("Use", Client.selectedItemName + " " + "->" + " " + World.method1251(65535) + var21.name, 1, var19, var15, var17);
                  } else if(Client.isSpellSelected) {
                     if((ItemContainer.selectedSpellFlags & 4) == 4) {
                        WorldMapData_1.method519(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + World.method1251(65535) + var21.name, 2, var19, var15, var17);
                     }
                  } else {
                     String[] var28 = var21.actions;
                     if(var28 != null) {
                        for(int var29 = 4; var29 >= 0; --var29) {
                           if(var28[var29] != null) {
                              short var24 = 0;
                              if(var29 == 0) {
                                 var24 = 3;
                              }

                              if(var29 == 1) {
                                 var24 = 4;
                              }

                              if(var29 == 2) {
                                 var24 = 5;
                              }

                              if(var29 == 3) {
                                 var24 = 6;
                              }

                              if(var29 == 4) {
                                 var24 = 1001;
                              }

                              WorldMapData_1.method519(var28[var29], World.method1251(65535) + var21.name, var24, var20, var16, var17);
                           }
                        }
                     }

                     WorldMapData_1.method519("Examine", World.method1251(65535) + var21.name, 1002, var21.id, var16, var17);
                  }
               }

               int var22;
               NPC var23;
               Player var25;
               int[] var35;
               int var37;
               if(var18 == 1) {
                  NPC var32 = Client.npcs[var20];
                  if(var32 == null) {
                     break label336;
                  }

                  if(var32.definition.size == 1 && (var32.x & 127) == 64 && (var32.y * 682054857 & 127) == 64) {
                     for(var22 = 0; var22 < Client.npcCount; ++var22) {
                        var23 = Client.npcs[Client.npcIndices[var22]];
                        if(var23 != null && var23 != var32 && var23.definition.size == 1 && var23.x == var32.x && var32.y * 682054857 == var23.y * 682054857) {
                           class186.method3727(var23.definition, Client.npcIndices[var22], var16, var17);
                        }
                     }

                     var22 = Players.Players_count;
                     var35 = Players.Players_indices;

                     for(var37 = 0; var37 < var22; ++var37) {
                        var25 = Client.players[var35[var37]];
                        if(var25 != null && var32.x == var25.x && var32.y * 682054857 == var25.y * 682054857) {
                           GrandExchangeEvent.method6487(var25, var35[var37], var16, var17);
                        }
                     }
                  }

                  class186.method3727(var32.definition, var20, var16, var17);
               }

               if(var18 == 0) {
                  Player var33 = Client.players[var20];
                  if(var33 == null) {
                     break label336;
                  }

                  if((var33.x & 127) == 64 && (var33.y * 682054857 & 127) == 64) {
                     for(var22 = 0; var22 < Client.npcCount; ++var22) {
                        var23 = Client.npcs[Client.npcIndices[var22]];
                        if(var23 != null && var23.definition.size == 1 && var23.x == var33.x && var23.y * 682054857 == var33.y * 682054857) {
                           class186.method3727(var23.definition, Client.npcIndices[var22], var16, var17);
                        }
                     }

                     var22 = Players.Players_count;
                     var35 = Players.Players_indices;

                     for(var37 = 0; var37 < var22; ++var37) {
                        var25 = Client.players[var35[var37]];
                        if(var25 != null && var33 != var25 && var33.x == var25.x && var33.y * 682054857 == var25.y * 682054857) {
                           GrandExchangeEvent.method6487(var25, var35[var37], var16, var17);
                        }
                     }
                  }

                  if(var20 != Client.combatTargetPlayerIndex) {
                     GrandExchangeEvent.method6487(var33, var20, var16, var17);
                  } else {
                     var4 = var11;
                  }
               }

               if(var18 == 3) {
                  NodeDeque var34 = Client.groundItems[WorldMapRectangle.plane][var16][var17];
                  if(var34 != null) {
                     for(TileItem var38 = (TileItem)var34.getTail(); var38 != null; var38 = (TileItem)var34.getPrevious()) {
                        ItemDefinition var36 = Occluder.getItemDefinition(var38.id);
                        if(Client.isItemSelected == 1) {
                           WorldMapData_1.method519("Use", Client.selectedItemName + " " + "->" + " " + World.method1251(16748608) + var36.name, 16, var38.id, var16, var17);
                        } else if(Client.isSpellSelected) {
                           if((ItemContainer.selectedSpellFlags & 1) == 1) {
                              WorldMapData_1.method519(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + World.method1251(16748608) + var36.name, 17, var38.id, var16, var17);
                           }
                        } else {
                           String[] var30 = var36.groundActions;

                           for(int var31 = 4; var31 >= 0; --var31) {
                              if(var30 != null && var30[var31] != null) {
                                 byte var26 = 0;
                                 if(var31 == 0) {
                                    var26 = 18;
                                 }

                                 if(var31 == 1) {
                                    var26 = 19;
                                 }

                                 if(var31 == 2) {
                                    var26 = 20;
                                 }

                                 if(var31 == 3) {
                                    var26 = 21;
                                 }

                                 if(var31 == 4) {
                                    var26 = 22;
                                 }

                                 WorldMapData_1.method519(var30[var31], World.method1251(16748608) + var36.name, var26, var38.id, var16, var17);
                              } else if(var31 == 2) {
                                 WorldMapData_1.method519("Take", World.method1251(16748608) + var36.name, 20, var38.id, var16, var17);
                              }
                           }

                           WorldMapData_1.method519("Examine", World.method1251(16748608) + var36.name, 1004, var38.id, var16, var17);
                        }
                     }
                  }
               }
            }
         }

         ++var8;
      }
   }
}
