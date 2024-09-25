package net.runelite.standalone;

public class Username implements Comparable {
   String cleanName;
   String name;

   public Username(String var1, LoginType var2) {
      this.name = var1;
      this.cleanName = ScriptEvent.method801(var1, var2);
   }

   public boolean method4991() {
      return this.cleanName != null;
   }

   public int method4992(Username var1) {
      return this.cleanName == null?(var1.cleanName == null?0:1):(var1.cleanName == null?-1:this.cleanName.compareTo(var1.cleanName));
   }

   public String getName() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(var1 instanceof Username) {
         Username var2 = (Username)var1;
         return this.cleanName == null?var2.cleanName == null:(var2.cleanName == null?false:(this.hashCode() != var2.hashCode()?false:this.cleanName.equals(var2.cleanName)));
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.cleanName == null?0:this.cleanName.hashCode();
   }

   public String toString() {
      return this.getName();
   }

   public int compareTo(Object var1) {
      return this.method4992((Username)var1);
   }

   public String aah() {
      return this.getName();
   }

   public String aae() {
      return this.getName();
   }

   public String aak() {
      return this.getName();
   }

   public static int method5005(byte[] var0, int var1) {
      return LoginScreenAnimation.method1293(var0, 0, var1);
   }
}
