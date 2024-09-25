package net.runelite.standalone;

public class ServerPacket {
   public static final ServerPacket UPDATE_CONATINER_ITEMS;
   public static final ServerPacket field2248;
   public static final ServerPacket field2240;
   public static final ServerPacket field2242;
   public static final ServerPacket field2254;
   public static final ServerPacket field2256;
   public static final ServerPacket field2252;
   public static final ServerPacket field2239;
   public static final ServerPacket field2246;
   public static final ServerPacket field2251;
   public static final ServerPacket field2286;
   public static final ServerPacket field2244;
   public static final ServerPacket field2267;
   public static final ServerPacket field2243;
   public static final ServerPacket field2265;
   public static final ServerPacket field2268;
   public static final ServerPacket field2236;
   public static final ServerPacket field2282;
   public static final ServerPacket field2279;
   public static final ServerPacket field2283;
   public static final ServerPacket field2315;
   public static final ServerPacket field2270;
   public static final ServerPacket field2247;
   public static final ServerPacket field2323;
   public static final ServerPacket field2276;
   public static final ServerPacket field2300;
   public static final ServerPacket field2278;
   public static final ServerPacket field2262;
   public static final ServerPacket field2271;
   public static final ServerPacket field2245;
   public static final ServerPacket field2277;
   public static final ServerPacket field2274;
   public static final ServerPacket field2258;
   public static final ServerPacket field2287;
   public static final ServerPacket SEND_CONTAINER_ITEMS;
   public static final ServerPacket field2241;
   public static final ServerPacket field2264;
   public static final ServerPacket field2269;
   public static final ServerPacket field2309;
   public static final ServerPacket field2263;
   public static final ServerPacket field2308;
   public static final ServerPacket field2238;
   public static final ServerPacket field2303;
   public static final ServerPacket field2296;
   public static final ServerPacket field2290;
   public static final ServerPacket field2298;
   public static final ServerPacket field2310;
   public static final ServerPacket field2311;
   public static final ServerPacket field2289;
   public static final ServerPacket field2302;
   public static final ServerPacket field2293;
   public static final ServerPacket field2297;
   public static final ServerPacket field2307;
   public static final ServerPacket field2291;
   public static final ServerPacket field2299;
   public static final ServerPacket field2257;
   public static final ServerPacket field2313;
   public static final ServerPacket field2306;
   public static final ServerPacket field2284;
   public static final ServerPacket field2294;
   public static final ServerPacket field2304;
   public static final ServerPacket field2301;
   public static final ServerPacket field2292;
   public static final ServerPacket field2312;
   public static final ServerPacket field2288;
   public static final ServerPacket field2305;
   public static final ServerPacket field2295;
   public static final ServerPacket field2273;
   public static final ServerPacket field2321;
   public static final ServerPacket field2319;
   public static final ServerPacket field2324;
   public static final ServerPacket field2266;
   public static final ServerPacket field2317;
   public static final ServerPacket field2320;
   public static final ServerPacket field2316;
   public static final ServerPacket field2314;
   public static final ServerPacket field2259;
   public static final ServerPacket field2250;
   public static final ServerPacket field2237;

    static int field2272;
   public static final ServerPacket field2253;
   public static final ServerPacket field2255;
   public static final ServerPacket field2281;
   public static final ServerPacket field2280;
   public static final ServerPacket field2261;
   public static final ServerPacket field2260;
   public static final ServerPacket field2318;
   public final int length;
   public final int id;

   public static final ServerPacket CLAN_CHAT_SETTINGS = new ServerPacket(86, -1);
   public static final ServerPacket OPEN_URL = new ServerPacket(87, -1);
   public static final ServerPacket SHOP_INTERFACE = new ServerPacket(88, -2);
   public static final ServerPacket TELEPORT_INTERFACE = new ServerPacket(89, -2);
   public static final ServerPacket DROP_TABLE_INTERFACE = new ServerPacket(90, -2);
   public static final ServerPacket WIDGET_TIMER = new ServerPacket(91, -2);

   static {
      field2267 = new ServerPacket(0, 6);
      UPDATE_CONATINER_ITEMS = new ServerPacket(1, -2);
      field2246 = new ServerPacket(2, 7);
      field2239 = new ServerPacket(3, -2);
      field2254 = new ServerPacket(4, -2);
      field2240 = new ServerPacket(5, 0);
      field2242 = new ServerPacket(6, 2);
      field2318 = new ServerPacket(7, -1);
      field2244 = new ServerPacket(8, 4);
      field2281 = new ServerPacket(9, 6);
      field2273 = new ServerPacket(10, 5);
      field2308 = new ServerPacket(11, 1);
      field2248 = new ServerPacket(12, 8);
      field2243 = new ServerPacket(13, 10);
      field2250 = new ServerPacket(14, -2);
      field2251 = new ServerPacket(15, -2);
      field2252 = new ServerPacket(16, 0);
      field2253 = new ServerPacket(17, 1);
      field2286 = new ServerPacket(18, 20);
      field2255 = new ServerPacket(19, 6);
      field2256 = new ServerPacket(20, -1);
      field2237 = new ServerPacket(21, 14);
      field2280 = new ServerPacket(22, -1);
      field2259 = new ServerPacket(23, -1);
      field2260 = new ServerPacket(24, 6);
      field2261 = new ServerPacket(25, 2);
      field2236 = new ServerPacket(26, 8);
      field2263 = new ServerPacket(27, 12);
      field2264 = new ServerPacket(28, -2);
      field2265 = new ServerPacket(29, 2);
      field2245 = new ServerPacket(30, 3);
      field2274 = new ServerPacket(31, -2);
      field2268 = new ServerPacket(32, -2);
      field2269 = new ServerPacket(33, 5);
      field2258 = new ServerPacket(34, 3);
      field2271 = new ServerPacket(35, 1);
      field2300 = new ServerPacket(36, -2);
      field2282 = new ServerPacket(37, 6);
      field2262 = new ServerPacket(38, 15);
      field2247 = new ServerPacket(39, 6);
      field2276 = new ServerPacket(40, 6);
      field2277 = new ServerPacket(41, 5);
      field2278 = new ServerPacket(42, 6);
      field2279 = new ServerPacket(43, 1);
      field2241 = new ServerPacket(44, 2);
      field2270 = new ServerPacket(45, -2);
      field2315 = new ServerPacket(46, 6);
      field2323 = new ServerPacket(47, 1);
      field2309 = new ServerPacket(48, -2);
      SEND_CONTAINER_ITEMS = new ServerPacket(49, -2);
      field2283 = new ServerPacket(50, 8);
      field2287 = new ServerPacket(51, 4);
      field2288 = new ServerPacket(52, 0);
      field2289 = new ServerPacket(53, -2);
      field2290 = new ServerPacket(54, 4);
      field2291 = new ServerPacket(55, 1);
      field2292 = new ServerPacket(56, -2);
      field2293 = new ServerPacket(57, 2);
      field2294 = new ServerPacket(58, 0);
      field2295 = new ServerPacket(59, -2);
      field2296 = new ServerPacket(60, 2);
      field2297 = new ServerPacket(61, -2);
      field2238 = new ServerPacket(62, -1);
      field2299 = new ServerPacket(63, 8);
      field2298 = new ServerPacket(64, 4);
      field2301 = new ServerPacket(65, 2);
      field2302 = new ServerPacket(66, -2);
      field2303 = new ServerPacket(67, 0);
      field2304 = new ServerPacket(68, 6);
      field2305 = new ServerPacket(69, 2);
      field2306 = new ServerPacket(70, 28);
      field2257 = new ServerPacket(71, -2);
      field2284 = new ServerPacket(72, 2);
      field2307 = new ServerPacket(73, 8);
      field2310 = new ServerPacket(74, 0);
      field2311 = new ServerPacket(75, 12);
      field2312 = new ServerPacket(76, 0);
      field2313 = new ServerPacket(77, 4);
      field2314 = new ServerPacket(78, 5);
      field2324 = new ServerPacket(79, 2);
      field2316 = new ServerPacket(80, -1);
      field2317 = new ServerPacket(81, 4);
      field2320 = new ServerPacket(82, -2);
      field2319 = new ServerPacket(83, 5);
      field2266 = new ServerPacket(84, 7);
      field2321 = new ServerPacket(85, 4);
   }

   ServerPacket(int var1, int var2) {
      this.id = var1;
      this.length = var2;
   }

   static int method3848(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.cycle;
         return 1;
      } else {
         int var3;
         int var4;
         if(var0 == 3301) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapDecoration.method5192(var3, var4);
            return 1;
         } else if(var0 == 3302) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = FloorUnderlayDefinition.method4617(var3, var4);
            return 1;
         } else if(var0 == 3303) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapEvent.method682(var3, var4);
            return 1;
         } else if(var0 == 3304) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = StudioGame.method3908(var3).size;
            return 1;
         } else if(var0 == 3305) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
            return 1;
         } else if(var0 == 3306) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.levels[var3];
            return 1;
         } else if(var0 == 3307) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.experience[var3];
            return 1;
         } else {
            int var5;
            if(var0 == 3308) {
               var3 = WorldMapRectangle.plane;
               var4 = (class215.localPlayer.x >> 7) + class215.baseX;
               var5 = (class215.localPlayer.y * 682054857 >> 7) + class304.baseY;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
               return 1;
            } else if(var0 == 3309) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.isMembersWorld?1:0;
               return 1;
            } else if(var0 == 3313) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + 32768;
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapDecoration.method5192(var3, var4);
               return 1;
            } else if(var0 == 3314) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + 32768;
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = FloorUnderlayDefinition.method4617(var3, var4);
               return 1;
            } else if(var0 == 3315) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + 32768;
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapEvent.method682(var3, var4);
               return 1;
            } else if(var0 == 3316) {
               if(Client.staffModLevel >= 2) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.staffModLevel;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3317) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.rebootTimer;
               return 1;
            } else if(var0 == 3318) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.worldId;
               return 1;
            } else if(var0 == 3321) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.runEnergy;
               return 1;
            } else if(var0 == 3322) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.weight;
               return 1;
            } else if(var0 == 3323) {
               if(Client.playerMod) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3324) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.worldProperties;
               return 1;
            } else if(var0 == 3325) {
               Interpreter.Interpreter_intStackSize -= 4;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
               int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
               var3 += var4 << 14;
               var3 += var5 << 28;
               var3 += var6;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
               return 1;
            } else {
               return 2;
            }
         }
      }
   }
}
