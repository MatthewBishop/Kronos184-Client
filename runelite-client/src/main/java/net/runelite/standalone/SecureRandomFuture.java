package net.runelite.standalone;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SecureRandomFuture {
   static int field746;
   public static int field748;
   Future future;
   ExecutorService executor;

   SecureRandomFuture() {
      this.executor = Executors.newSingleThreadExecutor();
      this.future = this.executor.submit(new SecureRandomCallable());
   }

   boolean method1516() {
      return this.future.isDone();
   }

   SecureRandom method1518() {
      SecureRandom var10000;
      try {
         var10000 = (SecureRandom)this.future.get();
      } catch (Exception var2) {
         return AttackOption.method2107();
      }

      return var10000;
   }

   void method1515() {
      this.executor.shutdown();
      this.executor = null;
   }

   static void method1521() {
      for(int var0 = 0; var0 < Client.menuOptionsCount; ++var0) {
         if(BZip2State.method5455(Client.menuOpcodes[var0])) {
            if(var0 < Client.menuOptionsCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionsCount - 1; ++var1) {
                  Client.menuActions[var1] = Client.menuActions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
                  Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
                  Client.menuShiftClick[var1] = Client.menuShiftClick[var1 + 1];
               }
            }

            --var0;
            --Client.menuOptionsCount;
            Client.onMenuOptionsChanged(-1);
         }
      }

      UserComparator6.method3507(FriendSystem.menuWidth / 2 + UrlRequester.menuX, class37.menuY);
   }
}
