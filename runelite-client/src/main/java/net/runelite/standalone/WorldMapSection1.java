package net.runelite.standalone;

public class WorldMapSection1 implements WorldMapSection {
   static LoginType loginType;
   int planes;
   int regionEndY;
   int regionEndX;
   int regionStartY;
   int regionStartX;
   int minPlane;

   public boolean vmethod5843(int var1, int var2, int var3) {
      return var1 >= this.minPlane && var1 < this.planes + this.minPlane?var2 >> 6 == this.regionStartX && var3 >> 6 == this.regionStartY:false;
   }

   public void decode(Buffer var1) {
      this.minPlane = var1.readUnsignedByte();
      this.planes = var1.readUnsignedByte();
      this.regionStartX = var1.readUnsignedShort();
      this.regionStartY = var1.readUnsignedShort();
      this.regionEndX = var1.readUnsignedShort();
      this.regionEndY = var1.readUnsignedShort();
      this.method751();
   }

   void method751() {
   }

   public Coord vmethod5846(int var1, int var2) {
      if(!this.vmethod5844(var1, var2)) {
         return null;
      } else {
         int var3 = this.regionStartX * 64 - this.regionEndX * 64 + var1;
         int var4 = this.regionStartY * 64 - this.regionEndY * 64 + var2;
         return new Coord(this.minPlane, var3, var4);
      }
   }

   public int[] vmethod5845(int var1, int var2, int var3) {
      if(!this.vmethod5843(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.regionEndX * 64 - this.regionStartX * 64 + var2, var3 + (this.regionEndY * 64 - this.regionStartY * 64)};
         return var4;
      }
   }

   public boolean vmethod5844(int var1, int var2) {
      return var1 >> 6 == this.regionEndX && var2 >> 6 == this.regionEndY;
   }

   public void vmethod5850(WorldMapArea var1) {
      if(var1.regionLowX > this.regionEndX) {
         var1.regionLowX = this.regionEndX;
      }

      if(var1.regionHighX < this.regionEndX) {
         var1.regionHighX = this.regionEndX;
      }

      if(var1.regionLowY > this.regionEndY) {
         var1.regionLowY = this.regionEndY;
      }

      if(var1.regionHighY < this.regionEndY) {
         var1.regionHighY = this.regionEndY;
      }

   }

   static Script method756(int var0, int var1) {
      Script var2 = (Script) Script.Script_cached.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = GrandExchangeOfferOwnWorldComparator.archive12.method4059(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = GrandExchangeOfferOwnWorldComparator.archive12.method4027(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = class11.method139(var5);
               if(var2 != null) {
                  Script.Script_cached.method3034(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   public static void method773(AbstractArchive var0, AbstractArchive var1, boolean var2, Font var3) {
      ItemDefinition.ItemDefinition_archive = var0;
      ItemDefinition.ItemDefinition_modelArchive = var1;
      class163.ItemDefinition_inMembersWorld = var2;
      JagexCache.ItemDefinition_fileCount = ItemDefinition.ItemDefinition_archive.fileCount(10);
      FaceNormal.ItemDefinition_fontPlain11 = var3;
   }

   static final void method772(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.last(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.previous()) {
         if(var0 == var10.plane && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.plane = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         GrandExchangeEvent.method6488(var9);
         Client.pendingSpawns.addFirst(var9);
      }

      var9.id = var4;
      var9.field626 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }

   static void method770(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = GrandExchangeOfferWorldComparator.method93(var1, var2);
      if(var5 != null) {
         if(var5.onOp != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.opIndex = var0;
            var6.targetName = var4;
            var6.args = var5.onOp;
            ParamDefinition.method4313(var6);
         }
         //TODO:: Modified
         CustomClanSettingsInterface.update(var5, var0);

         boolean var11 = true;
         if(var5.contentType > 0) {
            var11 = class22.method457(var5);
         }

         if(var11) {
            int var8 = class12.method148(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               PacketBufferNode var10;
               if(var0 == 1) {
                  var10 = InterfaceParent.method1140(ClientPacket.field2400, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.method5481(var2);
                  var10.packetBuffer.method5481(var3);
                  Client.packetWriter.method1622(var10);
               }

               if(var0 == 2) {
                  var10 = InterfaceParent.method1140(ClientPacket.field2405, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.method5481(var2);
                  var10.packetBuffer.method5481(var3);
                  Client.packetWriter.method1622(var10);
               }

               if(var0 == 3) {
                  var10 = InterfaceParent.method1140(ClientPacket.field2413, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.method5481(var2);
                  var10.packetBuffer.method5481(var3);
                  Client.packetWriter.method1622(var10);
               }

               if(var0 == 4) {
                  var10 = InterfaceParent.method1140(ClientPacket.field2350, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.method5481(var2);
                  var10.packetBuffer.method5481(var3);
                  Client.packetWriter.method1622(var10);
               }

               if(var0 == 5) {
                  var10 = InterfaceParent.method1140(ClientPacket.field2360, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.method5481(var2);
                  var10.packetBuffer.method5481(var3);
                  Client.packetWriter.method1622(var10);
               }

               if(var0 == 6) {
                  var10 = InterfaceParent.method1140(ClientPacket.field2356, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.method5481(var2);
                  var10.packetBuffer.method5481(var3);
                  Client.packetWriter.method1622(var10);
               }

               if(var0 == 7) {
                  var10 = InterfaceParent.method1140(ClientPacket.field2407, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.method5481(var2);
                  var10.packetBuffer.method5481(var3);
                  Client.packetWriter.method1622(var10);
               }

               if(var0 == 8) {
                  var10 = InterfaceParent.method1140(ClientPacket.field2359, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.method5481(var2);
                  var10.packetBuffer.method5481(var3);
                  Client.packetWriter.method1622(var10);
               }

               if(var0 == 9) {
                  var10 = InterfaceParent.method1140(ClientPacket.field2369, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.method5481(var2);
                  var10.packetBuffer.method5481(var3);
                  Client.packetWriter.method1622(var10);
               }

               if(var0 == 10) {
                  var10 = InterfaceParent.method1140(ClientPacket.field2441, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeInt(var1);
                  var10.packetBuffer.method5481(var2);
                  var10.packetBuffer.method5481(var3);
                  Client.packetWriter.method1622(var10);
               }

            }
         }
      }
   }

   public static final void method747(int var0, int var1) {
      ViewportMouse.ViewportMouse_x = var0;
      ViewportMouse.ViewportMouse_y = var1;
      ViewportMouse.ViewportMouse_isInViewport = true;
      ViewportMouse.ViewportMouse_entityCount = 0;
      ViewportMouse.ViewportMouse_false0 = false;
   }
}
