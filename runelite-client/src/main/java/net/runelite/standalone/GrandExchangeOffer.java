package net.runelite.standalone;

import java.io.IOException;
import net.runelite.api.GrandExchangeOfferState;

public class GrandExchangeOffer implements net.runelite.api.GrandExchangeOffer {
   static Widget[] field3107;
   public int id;
   public int currentPrice;
   public int currentQuantity;
   public int totalQuantity;
   public int unitPrice;
   byte state;

   public GrandExchangeOffer() {
   }

   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.state = var1.readByte();
      this.id = var1.readUnsignedShort();
      this.unitPrice = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.currentQuantity = var1.readInt();
      this.currentPrice = var1.readInt();
   }

   void method4206(int var1) {
      this.state &= -9;
      if(var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   void method4199(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   public int method4198() {
      return (this.state & 8) == 8?1:0;
   }

   public int method4197() {
      return this.state & 7;
   }

   @Override
   public int getQuantitySold() {
      return this.currentQuantity;
   }

   @Override
   public int getTotalQuantity() {
      return this.totalQuantity;
   }

   public GrandExchangeOfferState getState() {
      byte var1 = this.state;
      boolean var2 = (var1 & 8) == 8;
      boolean var3 = (var1 & 4) == 4;
      return var1 == 0?GrandExchangeOfferState.EMPTY:(var3 && this.getQuantitySold() < this.getTotalQuantity()?(var2?GrandExchangeOfferState.CANCELLED_SELL:GrandExchangeOfferState.CANCELLED_BUY):(var2?(var3?GrandExchangeOfferState.SOLD:GrandExchangeOfferState.SELLING):(var3?GrandExchangeOfferState.BOUGHT:GrandExchangeOfferState.BUYING)));
   }

   @Override
   public int getItemId() {
      return this.id;
   }

   @Override
   public int getPrice() {
      return this.unitPrice;
   }

   @Override
   public int getSpent() {
      return this.currentPrice;
   }

   static final void method4218(boolean var0) {
      WorldMapID.method687();
      ++Client.packetWriter.pendingWrites;
      if(Client.packetWriter.pendingWrites >= 50 || var0) {
         Client.packetWriter.pendingWrites = 0;
         if(!Client.field938 && Client.packetWriter.method1624() != null) {
            PacketBufferNode var1 = InterfaceParent.method1140(ClientPacket.field2363, Client.packetWriter.isaacCipher);
            Client.packetWriter.method1622(var1);

            try {
               Client.packetWriter.method1619();
            } catch (IOException var3) {
               Client.field938 = true;
            }
         }

      }
   }
}
