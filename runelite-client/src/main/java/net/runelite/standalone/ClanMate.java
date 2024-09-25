package net.runelite.standalone;

import net.runelite.api.ChatPlayer;
import net.runelite.api.ClanMember;
import net.runelite.api.ClanMemberRank;

public class ClanMate extends Buddy implements ClanMember {
   static Archive archive11;
   TriBool ignored;
   TriBool friend;

   ClanMate() {
      this.friend = TriBool.TriBool_unknown;
      this.ignored = TriBool.TriBool_unknown;
   }

   public final boolean method4982() {
      if(this.friend == TriBool.TriBool_unknown) {
         this.method4972();
      }

      return this.friend == TriBool.TriBool_true;
   }

   void method4984() {
      this.ignored = Tiles.friendSystem.ignoreList.isMember(super.username)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   public final boolean method4976() {
      if(this.ignored == TriBool.TriBool_unknown) {
         this.method4984();
      }

      return this.ignored == TriBool.TriBool_true;
   }

   void method4975() {
      this.ignored = TriBool.TriBool_unknown;
   }

   void method4972() {
      this.friend = Tiles.friendSystem.friendsList.isMember(super.username)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   void method4973() {
      this.friend = TriBool.TriBool_unknown;
   }

   public String getUsername() {
       return this.username.getName();
   }

   public ClanMemberRank getRank() {
       return ClanMemberRank.valueOf(this.rank);
   }

   public static Font method4989(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
      return !VertexNormal.method2468(var0, var2, var3)?null:class38.method731(var1.method4020(var2, var3, (short)-3362));
   }
}
