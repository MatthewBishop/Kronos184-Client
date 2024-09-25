package net.runelite.standalone;

public class IgnoreList extends UserList<Ignored> {
   static int cameraPitch;
   final LoginType loginType;

   public IgnoreList(LoginType var1) {
      super(400);
      this.loginType = var1;
   }

   User[] vmethod5186(int var1) {
      return new Ignored[var1];
   }

   public void method5142(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Username var5 = new Username(var1.readString(), this.loginType);
            Username var6 = new Username(var1.readString(), this.loginType);
            var1.readString();
            if(var5 != null && var5.method4991()) {
               Ignored var7 = (Ignored)this.method4815(var5);
               if(var4) {
                  Ignored var8 = (Ignored)this.method4815(var6);
                  if(var8 != null && var7 != var8) {
                     if(var7 != null) {
                        this.method4842(var8);
                     } else {
                        var7 = var8;
                     }
                  }
               }

               if(var7 != null) {
                  this.method4780(var7, var5, var6);
                  continue;
               }

               if(this.getCount() < 400) {
                  int var9 = this.getCount();
                  var7 = (Ignored)this.method4777(var5, var6);
                  var7.id = var9;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }

   User vmethod5179() {
      return new Ignored();
   }
}
