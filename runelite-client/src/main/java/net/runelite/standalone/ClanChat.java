package net.runelite.standalone;

import net.runelite.api.events.ClanMemberJoined;
import net.runelite.api.events.ClanMemberLeft;

public class ClanChat extends UserList<ClanMate> {
   final LoginType loginType;
   public int rank;
   final Usernamed localUser;
   int field3568;
   public byte minKick;
   public String owner;
   public String name;

   public ClanChat(LoginType var1, Usernamed var2) {
      super(200);
      this.name = null;
      this.owner = null;
      this.field3568 = 1;
      this.loginType = var1;
      this.localUser = var2;
   }

   User[] vmethod5186(int var1) {
      return new ClanMate[var1];
   }

   final void method4926(String var1) {
      this.name = VertexNormal.method2467(var1);
   }

   public final void method4928(Buffer var1) {
      this.method4951(var1.readString());
      /*long var2 = var1.method5502();
      long var5 = var2;
      String var4;
      int var7;
      if(var2 > 0L && var2 < 6582952005840035281L) {
         if(var2 % 37L == 0L) {
            var4 = null;
         } else {
            var7 = 0;

            for(long var13 = var2; 0L != var13; var13 /= 37L) {
               ++var7;
            }

            StringBuilder var15 = new StringBuilder(var7);

            while(0L != var5) {
               long var11 = var5;
               var5 /= 37L;
               var15.append(class292.base37Table[(int)(var11 - 37L * var5)]);
            }

            var4 = var15.reverse().toString();
         }
      } else {
         var4 = null;
      }*/

      //TODO:: Modified cc packet
      String string_0 = var1.readString();
      int var7;

      this.method4926(string_0);
      this.minKick = var1.readByte();
      var7 = var1.readUnsignedByte();
      if(var7 != 255) {
         this.method4767();

         for(int var8 = 0; var8 < var7; ++var8) {
            ClanMate var9 = (ClanMate)this.method4833(new Username(var1.readString(), this.loginType));
            int var10 = var1.readUnsignedShort();
            var9.method4957(var10, ++this.field3568 - 1);
            var9.rank = var1.readByte();
            var1.readString();
            this.method4932(var9);
         }

      }
   }

   User vmethod5179() {
      return new ClanMate();
   }

   final void method4932(ClanMate var1) {
      if(var1.method4879().equals(this.localUser.vmethod5099())) {
         this.rank = var1.rank;
      }

   }

   public void rl$add(Username var1, Username var2) {
      ClanMate var3 = (ClanMate)this.findByName(var1);
      if(var3 != null) {
         ClanMemberJoined var4 = new ClanMemberJoined(var3);
         ViewportMouse.client.getCallbacks().postDeferred(ClanMemberJoined.class, var4);
      }
   }

   public void rl$remove(User var1) {
       ClanMate var2 = (ClanMate)this.findByName(var1.username);
      if(var2 != null) {
         ClanMemberLeft var3 = new ClanMemberLeft(var2);
         ViewportMouse.client.getCallbacks().postDeferred(ClanMemberLeft.class, var3);
      }
   }

   public final void method4930() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMate)this.method4778(var1)).method4973();
      }

   }

   public final void method4931() {
      for(int var1 = 0; var1 < this.getCount(); ++var1) {
         ((ClanMate)this.method4778(var1)).method4975();
      }

   }

   public final void method4929(Buffer var1) {
      Username var2 = new Username(var1.readString(), this.loginType);
      int var3 = var1.readUnsignedShort();
      byte var4 = var1.readByte();
      boolean var5 = false;
      if(var4 == -128) {
         var5 = true;
      }

      ClanMate var6;
      if(var5) {
         if(this.getCount() == 0) {
            return;
         }

         var6 = (ClanMate)this.method4815(var2);
         if(var6 != null && var6.method4958() == var3) {
            this.method4842(var6);
         }
      } else {
         var1.readString();
         var6 = (ClanMate)this.method4815(var2);

         if(var6 == null) {
            if(this.getCount() > super.capacity) {
               return;
            }

            var6 = (ClanMate)this.method4833(var2);
         }

         var6.method4957(var3, ++this.field3568 - 1);
         var6.rank = var4;
         this.method4932(var6);
      }

   }

   final void method4951(String var1) {
      this.owner = VertexNormal.method2467(var1);
   }
}
