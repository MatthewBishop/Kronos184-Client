package net.runelite.standalone;

public enum StudioGame implements Enumerated {
   runescape("runescape", "RuneScape", 0),
   stellardawn("stellardawn", "Stellar Dawn", 1),
   game3("game3", "Game 3", 2),
   game4("game4", "Game 4", 3),
   game5("game5", "Game 5", 4),
   oldscape("oldscape", "RuneScape 2007", 5);

   public static class235 field2468;
   public final String name;
   final int id;

   StudioGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   public int getId() {
      return this.id;
   }

   public static InvDefinition method3908(int var0) {
      InvDefinition var1 = (InvDefinition)InvDefinition.InvDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvDefinition.InvDefinition_archive.method4020(5, var0, (short)-817);
         var1 = new InvDefinition();
         if(var2 != null) {
            var1.method4328(new Buffer(var2));
         }

         InvDefinition.InvDefinition_cached.method3034(var1, (long)var0);
         return var1;
      }
   }
}
