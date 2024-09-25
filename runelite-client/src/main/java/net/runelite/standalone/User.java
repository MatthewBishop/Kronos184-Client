package net.runelite.standalone;

import net.runelite.api.Nameable;

public class User implements Nameable {
   Username previousUsername;
   Username username;

   public Username method4879() {
      return this.username;
   }

   public int compareTo(Object var1) {
      return this.vmethod5168((User)var1);
   }

   void method4882(Username var1, Username var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.username = var1;
         this.previousUsername = var2;
      }
   }

   public String method4880() {
      return this.username == null?"":this.username.getName();
   }

   public String method4878() {
      return this.previousUsername == null?"":this.previousUsername.getName();
   }

   public int vmethod5168(User var1) {
      return this.username.method4992(var1.username);
   }
}
