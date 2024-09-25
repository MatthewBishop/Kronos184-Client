package net.runelite.standalone;

import java.util.Comparator;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

final class GrandExchangeOfferNameComparator implements Comparator {
   static AbstractArchive field321;

   int method790(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method6490().compareTo(var2.method6490());
   }

   public int compare(Object var1, Object var2) {
      return this.method790((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public static void method799(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method799(var0, var1, var2, var5 - 1);
         method799(var0, var1, var5 + 1, var3);
      }

   }

   public static void method800(AbstractArchive var0) {
      VarbitDefinition.VarbitDefinition_archive = var0;
   }

   public static final PcmPlayer method798(TaskHandler var0, int var1, int var2) {
      if(UrlRequest.PcmPlayer_sampleRate == 0) {
         throw new IllegalStateException();
      } else if(var1 >= 0 && var1 < 2) {
         if(var2 < 256) {
            var2 = 256;
         }

         PcmPlayer var10000;
         try {
            PcmPlayer var3 = PcmPlayer.pcmPlayerProvider.vmethod1574();
            var3.samples = new int[256 * (PcmPlayer.PcmPlayer_stereo?2:1)];
            var3.field1591 = var2;
            var3.vmethod2711();
            var3.capacity = (var2 & -1024) + 1024;
            if(var3.capacity > 16384) {
               var3.capacity = 16384;
            }

            var3.vmethod2712(var3.capacity);
            if(MenuAction.PcmPlayer_count > 0 && RunException.soundSystem == null) {
               RunException.soundSystem = new SoundSystem();
               PcmPlayer.soundSystemExecutor = Executors.newScheduledThreadPool(1);
               PcmPlayer.soundSystemExecutor.scheduleAtFixedRate(RunException.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
            }

            if(RunException.soundSystem != null) {
               if(RunException.soundSystem.players[var1] != null) {
                  throw new IllegalArgumentException();
               }

               RunException.soundSystem.players[var1] = var3;
            }

            var10000 = var3;
         } catch (Throwable var4) {
            return new PcmPlayer();
         }

         return var10000;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
