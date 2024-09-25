package net.runelite.standalone;

public class Coord {
   public int plane;
   public int y;
   public int x;

   public Coord(Coord var1) {
      this.plane = var1.plane;
      this.x = var1.x;
      this.y = var1.y;
   }

   public Coord(int var1, int var2, int var3) {
      this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   public Coord(int var1) {
      if(var1 == -1) {
         this.plane = -1;
      } else {
         this.plane = var1 >> 28 & 3;
         this.x = var1 >> 14 & 16383;
         this.y = var1 & 16383;
      }

   }

   boolean method3915(Coord var1) {
      return this.plane != var1.plane?false:(this.x != var1.x?false:this.y == var1.y);
   }

   String method3916(String var1) {
      return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
   }

   public int method3913() {
      return this.plane << 28 | this.x << 14 | this.y;
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coord)?false:this.method3915((Coord)var1));
   }

   public int hashCode() {
      return this.method3913();
   }

   public String toString() {
      return this.method3916(",");
   }

   public String aah() {
      return this.method3916(",");
   }

   public String aae() {
      return this.method3916(",");
   }

   public String aak() {
      return this.method3916(",");
   }

   static void method3929() {
      Login.worldSelectOpen = false;
      WorldMapID.leftTitleSprite.method6102(Login.xPadding, 0);
      class37.rightTitleSprite.method6102(Login.xPadding + 382, 0);
      //FontName.logoSprite.method6320(Login.xPadding + 382 - FontName.logoSprite.subWidth / 2, 18);
   }

   static final void method3928() {
      for(int var0 = 0; var0 < Players.Players_count; ++var0) {
         Player var1 = Client.players[Players.Players_indices[var0]];
         var1.method1091();
      }

      KeyHandler.method504();
      if(Varps.clanChat != null) {
         Varps.clanChat.method4930();
      }

   }
}
