package net.runelite.standalone;

public class ViewportMouse {
   static int widgetDragDuration;
   static int ViewportMouse_x;
   static int field1310;
   static int field1316;
   static int field1309;
   static boolean ViewportMouse_false0;
   static int ViewportMouse_y;
   static int field1320;
   static boolean ViewportMouse_isInViewport;
   public static int ViewportMouse_entityCount;
   static Client client;
   public static long[] ViewportMouse_entityTags;
   static int field1313;
   static boolean[] Widget_loadedInterfaces;

   static {
      ViewportMouse_isInViewport = false;
      ViewportMouse_x = 0;
      ViewportMouse_y = 0;
      ViewportMouse_false0 = false;
      ViewportMouse_entityCount = 0;
      ViewportMouse_entityTags = new long[1000];
   }

   static final void method2303(int var0, int var1, int var2, int var3) {
      Client.overheadTextCount = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = -1;
      int var7 = Players.Players_count;
      int[] var8 = Players.Players_indices;

      int var9;
      for(var9 = 0; var9 < var7 + Client.npcCount; ++var9) {
         Object var10;
         if(var9 < var7) {
            var10 = Client.players[var8[var9]];
            if(var8[var9] == Client.combatTargetPlayerIndex) {
               var4 = true;
               var5 = var9;
               continue;
            }

            if(var10 == class215.localPlayer) {
               var6 = var9;
               continue;
            }
         } else {
            var10 = Client.npcs[Client.npcIndices[var9 - var7]];
         }

         class319.method6089((Actor)var10, var9, var0, var1, var2, var3, 1693287542);
      }

      if(Client.renderSelf && var6 != -1) {
         class319.method6089(class215.localPlayer, var6, var0, var1, var2, var3, 1286490452);
      }

      if(var4) {
         class319.method6089(Client.players[Client.combatTargetPlayerIndex], var5, var0, var1, var2, var3, 2106384053);
      }

      for(var9 = 0; var9 < Client.overheadTextCount; ++var9) {
         int var19 = Client.overheadTextXs[var9];
         int var11 = Client.overheadTextYs[var9];
         int var12 = Client.overheadTextXOffsets[var9];
         int var13 = Client.overheadTextAscents[var9];
         boolean var14 = true;

         while(var14) {
            var14 = false;

            for(int var15 = 0; var15 < var9; ++var15) {
               if(var11 + 2 > Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] && var11 - var13 < Client.overheadTextYs[var15] + 2 && var19 - var12 < Client.overheadTextXOffsets[var15] + Client.overheadTextXs[var15] && var19 + var12 > Client.overheadTextXs[var15] - Client.overheadTextXOffsets[var15] && Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] < var11) {
                  var11 = Client.overheadTextYs[var15] - Client.overheadTextAscents[var15];
                  var14 = true;
               }
            }
         }

         Client.viewportTempX = Client.overheadTextXs[var9];
         Client.viewportTempY = Client.overheadTextYs[var9] = var11;
         String var20 = Client.overheadText[var9];
         if(Client.chatEffects == 0) {
            int var16 = 16776960;
            if(Client.overheadTextColors[var9] < 6) {
               var16 = Client.field1059[Client.overheadTextColors[var9]];
            }

            if(Client.overheadTextColors[var9] == 6) {
               var16 = Client.viewportDrawCount % 20 < 10?16711680:16776960;
            }

            if(Client.overheadTextColors[var9] == 7) {
               var16 = Client.viewportDrawCount % 20 < 10?255:'\uffff';
            }

            if(Client.overheadTextColors[var9] == 8) {
               var16 = Client.viewportDrawCount % 20 < 10?'뀀':8454016;
            }

            int var17;
            if(Client.overheadTextColors[var9] == 9) {
               var17 = 150 - Client.overheadTextCyclesRemaining[var9];
               if(var17 < 50) {
                  var16 = var17 * 1280 + 16711680;
               } else if(var17 < 100) {
                  var16 = 16776960 - (var17 - 50) * 327680;
               } else if(var17 < 150) {
                  var16 = (var17 - 100) * 5 + 65280;
               }
            }

            if(Client.overheadTextColors[var9] == 10) {
               var17 = 150 - Client.overheadTextCyclesRemaining[var9];
               if(var17 < 50) {
                  var16 = var17 * 5 + 16711680;
               } else if(var17 < 100) {
                  var16 = 16711935 - (var17 - 50) * 327680;
               } else if(var17 < 150) {
                  var16 = (var17 - 100) * 327680 + 255 - (var17 - 100) * 5;
               }
            }

            if(Client.overheadTextColors[var9] == 11) {
               var17 = 150 - Client.overheadTextCyclesRemaining[var9];
               if(var17 < 50) {
                  var16 = 16777215 - var17 * 327685;
               } else if(var17 < 100) {
                  var16 = (var17 - 50) * 327685 + 65280;
               } else if(var17 < 150) {
                  var16 = 16777215 - (var17 - 100) * 327680;
               }
            }

            if(Client.overheadTextEffects[var9] == 0) {
               class170.fontBold12.method5332(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0);
            }

            if(Client.overheadTextEffects[var9] == 1) {
               class170.fontBold12.method5372(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
            }

            if(Client.overheadTextEffects[var9] == 2) {
               class170.fontBold12.method5366(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
            }

            if(Client.overheadTextEffects[var9] == 3) {
               class170.fontBold12.method5336(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var9]);
            }

            if(Client.overheadTextEffects[var9] == 4) {
               var17 = (150 - Client.overheadTextCyclesRemaining[var9]) * (class170.fontBold12.method5324(var20) + 100) / 150;
               Rasterizer2D.method6478(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
               class170.fontBold12.drawTextLeftAligned(var20, var0 + Client.viewportTempX + 50 - var17, Client.viewportTempY + var1, var16, 0);
               Rasterizer2D.method6474(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.overheadTextEffects[var9] == 5) {
               var17 = 150 - Client.overheadTextCyclesRemaining[var9];
               int var18 = 0;
               if(var17 < 25) {
                  var18 = var17 - 25;
               } else if(var17 > 125) {
                  var18 = var17 - 125;
               }

               Rasterizer2D.method6478(var0, Client.viewportTempY + var1 - class170.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
               class170.fontBold12.method5332(var20, var0 + Client.viewportTempX, var18 + Client.viewportTempY + var1, var16, 0);
               Rasterizer2D.method6474(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class170.fontBold12.method5332(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
         }
      }

   }
}
