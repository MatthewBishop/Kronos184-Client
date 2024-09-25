package net.runelite.standalone;

import net.runelite.api.ChatMessageType;
import net.runelite.api.MessageNode;

public class Message extends DualNode implements MessageNode {
   static int field398;
   int cycle;
   TriBool isFromFriend0;
   TriBool isFromIgnored0;
   Username senderUsername;
   String sender;
   int type;
   String text;
   int count;
   public String runeLiteFormatMessage;
   public int rl$timestamp;
   String prefix;

   Message(int var1, String var2, String var3, String var4) {
      this.isFromFriend0 = TriBool.TriBool_unknown;
      this.isFromIgnored0 = TriBool.TriBool_unknown;
      this.method861(var1, var2, var3, var4);
      this.rl$$init();
   }

   void method884() {
      this.isFromFriend0 = TriBool.TriBool_unknown;
   }

   final boolean method866() {
      if(this.isFromIgnored0 == TriBool.TriBool_unknown) {
         this.method867();
      }

      return this.isFromIgnored0 == TriBool.TriBool_true;
   }

   void method867() {
      this.isFromIgnored0 = Tiles.friendSystem.ignoreList.isMember(this.senderUsername)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   void method880() {
      this.isFromIgnored0 = TriBool.TriBool_unknown;
   }

   void method862() {
      this.isFromFriend0 = Tiles.friendSystem.friendsList.isMember(this.senderUsername)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   final boolean method865() {
      if(this.isFromFriend0 == TriBool.TriBool_unknown) {
         this.method862();
      }

      return this.isFromFriend0 == TriBool.TriBool_true;
   }

   void method861(int var1, String var2, String var3, String var4) {
      int var5 = ++Messages.Messages_count - 1;
      this.count = var5;
      this.cycle = Client.cycle;
      this.type = var1;
      this.sender = var2;
      this.method868();
      this.prefix = var3;
      this.text = var4;
      this.method884();
      this.method880();
      this.setMessage(var1, var2, var3, var4);
   }

   private void rl$$init() {
      this.rl$timestamp = (int)(System.currentTimeMillis() / 1000L);
   }

   public void setMessage(int var1, String var2, String var3, String var4) {
      this.runeLiteFormatMessage = null;
      this.rl$timestamp = (int)(System.currentTimeMillis() / 1000L);
   }

   public ChatMessageType getType() {
      return ChatMessageType.of(this.type);
   }

   public String getRuneLiteFormatMessage() {
      return this.runeLiteFormatMessage;
   }

   public void setRuneLiteFormatMessage(String var1) {
      this.runeLiteFormatMessage = var1;
   }

   public int getTimestamp() {
      return this.rl$timestamp;
   }

   public void setTimestamp(int var1) {
      this.rl$timestamp = var1;
   }

   public boolean isFromClanMate() {
       ClanChat var1 = Varps.clanChat;
      return var1 != null && var1.isMember(this.senderUsername);
   }

   @Override
   public int getId() {
      return this.count;
   }

   @Override
   public void setName(String var1) {
      this.sender = var1;
   }

   @Override
   public String getName() {
      return this.sender;
   }

   @Override
   public void setSender(String var1) {
      this.prefix = var1;
   }

   @Override
   public String getSender() {
      return this.prefix;
   }

   @Override
   public void setValue(String var1) {
      this.text = var1;
   }

   @Override
   public String getValue() {
      return this.text;
   }

   @Override
   public boolean isFromFriend() {
      return this.method865();
   }

   final void method868() {
      if(this.sender != null) {
         this.senderUsername = new Username(WorldMapSectionType.method113(this.sender), WorldMapSection1.loginType);
      } else {
         this.senderUsername = null;
      }

   }

   static void method888(int var0, int var1, int var2) {
      if(Client.soundEffectVolume != 0 && var1 != 0 && Client.soundEffectCount < 50) {
         Client.soundEffectIds[Client.soundEffectCount] = var0;
         Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
         Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
         Client.soundEffects[Client.soundEffectCount] = null;
         Client.soundLocations[Client.soundEffectCount] = 0;
         ++Client.soundEffectCount;
         Client.queuedSoundEffectCountChanged(-1);
      }

   }

   static final void method876(int var0, int var1) {
      if(Client.hintArrowType == 2) {
         PlayerAppearance.method4162((Client.hintArrowX - class215.baseX << 7) + Client.hintArrowSubX * 1732957465, (Client.hintArrowY - class304.baseY << 7) + Client.hintArrowSubY * 739749845, Client.hintArrowHeight * 2);
         if(Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
            ReflectionCheck.headIconHintSprites[0].method6159(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
         }

      }
   }
}
