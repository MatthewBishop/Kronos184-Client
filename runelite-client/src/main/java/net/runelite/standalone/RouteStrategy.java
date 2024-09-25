package net.runelite.standalone;

public abstract class RouteStrategy {
   public int approxDestinationY;
   public int approxDestinationSizeY;
   public int approxDestinationSizeX;
   public int approxDestinationX;

   protected abstract boolean vmethod3410(int var1, int var2, int var3, CollisionMap var4);

   static final boolean method3413(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class170.directions[var6][var7] = 99;
      class170.distances[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class170.bufferX[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class170.bufferY[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var11 != var18) {
         var4 = class170.bufferX[var11];
         var5 = class170.bufferY[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.xInset;
         int var14 = var5 - var3.yInset;
         if(var2.vmethod3410(2, var4, var5, var3)) {
            UserComparator10.field1808 = var4;
            class170.field2003 = var5;
            return true;
         }

         int var15 = class170.distances[var16][var17] + 1;
         if(var16 > 0 && class170.directions[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class170.bufferX[var18] = var4 - 1;
            class170.bufferY[var18] = var5;
            var18 = var18 + 1 & 4095;
            class170.directions[var16 - 1][var17] = 2;
            class170.distances[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class170.directions[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class170.bufferX[var18] = var4 + 1;
            class170.bufferY[var18] = var5;
            var18 = var18 + 1 & 4095;
            class170.directions[var16 + 1][var17] = 8;
            class170.distances[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class170.directions[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class170.bufferX[var18] = var4;
            class170.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class170.directions[var16][var17 - 1] = 1;
            class170.distances[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class170.directions[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class170.bufferX[var18] = var4;
            class170.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class170.directions[var16][var17 + 1] = 4;
            class170.distances[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class170.directions[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class170.bufferX[var18] = var4 - 1;
            class170.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class170.directions[var16 - 1][var17 - 1] = 3;
            class170.distances[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class170.directions[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class170.bufferX[var18] = var4 + 1;
            class170.bufferY[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class170.directions[var16 + 1][var17 - 1] = 9;
            class170.distances[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class170.directions[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class170.bufferX[var18] = var4 - 1;
            class170.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class170.directions[var16 - 1][var17 + 1] = 6;
            class170.distances[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class170.directions[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class170.bufferX[var18] = var4 + 1;
            class170.bufferY[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class170.directions[var16 + 1][var17 + 1] = 12;
            class170.distances[var16 + 1][var17 + 1] = var15;
         }
      }

      UserComparator10.field1808 = var4;
      class170.field2003 = var5;
      return false;
   }
}
