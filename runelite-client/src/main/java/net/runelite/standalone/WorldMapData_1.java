package net.runelite.standalone;

public class WorldMapData_1 extends AbstractWorldMapData {
   static Archive archive14;
   int chunkYLow;
   int chunkXLow;
   int chunkY;
   int chunkX;

   void vmethod3304(Buffer var1) {
      super.planes = Math.min(super.planes, 4);
      super.floorUnderlayIds = new short[1][64][64];
      super.floorOverlayIds = new short[super.planes][64][64];
      super.field1907 = new byte[super.planes][64][64];
      super.field1895 = new byte[super.planes][64][64];
      super.decorations = new WorldMapDecoration[super.planes][64][64][];
      int var2 = var1.readUnsignedByte();
      if(var2 != class33.field250.value) {
         throw new IllegalStateException("");
      } else {
         int var3 = var1.readUnsignedByte();
         int var4 = var1.readUnsignedByte();
         int var5 = var1.readUnsignedByte();
         int var6 = var1.readUnsignedByte();
         if(var3 == super.regionX && var4 == super.regionY && var5 == this.chunkX && var6 == this.chunkY) {
            for(int var7 = 0; var7 < 8; ++var7) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  this.method3310(var7 + this.chunkX * 8, var8 + this.chunkY * 8, var1);
               }
            }

         } else {
            throw new IllegalStateException("");
         }
      }
   }

   int method526() {
      return this.chunkYLow;
   }

   int method511() {
      return this.chunkXLow;
   }

   void method508(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 != WorldMapID.field264.value) {
         throw new IllegalStateException("");
      } else {
         super.minPlane = var1.readUnsignedByte();
         super.planes = var1.readUnsignedByte();
         super.regionXLow = var1.readUnsignedShort();
         super.regionYLow = var1.readUnsignedShort();
         this.chunkXLow = var1.readUnsignedByte();
         this.chunkYLow = var1.readUnsignedByte();
         super.regionX = var1.readUnsignedShort();
         super.regionY = var1.readUnsignedShort();
         this.chunkX = var1.readUnsignedByte();
         this.chunkY = var1.readUnsignedByte();
         super.groupId = var1.method5507();
         super.fileId = var1.method5507();
      }
   }

   int method518() {
      return this.chunkY;
   }

   int method512() {
      return this.chunkX;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof WorldMapData_1)) {
         return false;
      } else {
         WorldMapData_1 var2 = (WorldMapData_1)var1;
         return var2.regionX == super.regionX && super.regionY == var2.regionY?var2.chunkX == this.chunkX && this.chunkY == var2.chunkY:false;
      }
   }

   public int hashCode() {
      return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
   }

   static void addChatMessage(int channelId, String text, String var2, String var3) {
      ChatChannel channel = (ChatChannel) Messages.Messages_channels.get(Integer.valueOf(channelId));
      if(channel == null) {
         channel = new ChatChannel();
         Messages.Messages_channels.put(Integer.valueOf(channelId), channel);
      }

      Message message = channel.method1523(channelId, text, var2, var3);
      Messages.Messages_hashTable.put(message, (long) message.count);
      Messages.Messages_queue.add(message);
      Client.chatCycle = Client.cycleCntr;
      Client.onAddChatMessage(channelId, text, var2, var3);
   }

   static int method536(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         Interpreter.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         int var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         if(!Client.isCameraLocked) {
            Client.camAngleX = var3;
            Client.onCameraPitchTargetChanged(-1);
            Client.camAngleY = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camAngleX;
         return 1;
      } else if(var0 == 5506) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camAngleY;
         return 1;
      } else if(var0 == 5530) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.camFollowHeight = var3 * -767303221;
         return 1;
      } else if(var0 == 5531) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.camFollowHeight * -844153885;
         return 1;
      } else {
         return 2;
      }
   }

   public static final void method519(String var0, String var1, int var2, int var3, int var4, int var5) {
      AttackOption.method2104(var0, var1, var2, var3, var4, var5, false);
   }
}
