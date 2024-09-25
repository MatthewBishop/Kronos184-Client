package net.runelite.standalone;

import net.runelite.api.Ignore;

public class Ignored extends User implements Ignore {
   int id;

   int method4962(Ignored var1) {
      return this.id - var1.id;
   }

   public int compareTo(Object var1) {
      return this.method4962((Ignored)var1);
   }

   public String getName() {
      return this.username.getName();
   }

   public String getPrevName() {
       Username var1 = this.previousUsername;
      return var1 == null?null:var1.getName();
   }

   public int vmethod5168(User var1) {
      return this.method4962((Ignored)var1);
   }
}
