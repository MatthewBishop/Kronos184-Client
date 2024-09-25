package net.runelite.standalone;

public class PcmStreamMixer extends PcmStream {
   NodeDeque field743;
   int field742;
   int field744;
   NodeDeque subStreams;

   public PcmStreamMixer() {
      this.subStreams = new NodeDeque();
      this.field743 = new NodeDeque();
      this.field744 = 0;
      this.field742 = -1;
   }

   public final synchronized void method1476(PcmStream var1) {
      var1.unlink();
   }

   protected PcmStream vmethod3775() {
      return (PcmStream)this.subStreams.last();
   }

   protected PcmStream vmethod3794() {
      return (PcmStream)this.subStreams.previous();
   }

   void method1478(PcmStreamMixerListener var1) {
      var1.unlink();
      var1.method2334();
      Node var2 = this.field743.sentinel.previous;
      if(var2 == this.field743.sentinel) {
         this.field742 = -1;
      } else {
         this.field742 = ((PcmStreamMixerListener)var2).field1350;
      }

   }

   void method1500(Node var1, PcmStreamMixerListener var2) {
      while(this.field743.sentinel != var1 && ((PcmStreamMixerListener)var1).field1350 <= var2.field1350) {
         var1 = var1.previous;
      }

      NodeDeque.method5130(var2, var1);
      this.field742 = ((PcmStreamMixerListener)this.field743.sentinel.previous).field1350;
   }

   void method1477() {
      if(this.field744 > 0) {
         for(PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field743.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field743.previous()) {
            var1.field1350 -= this.field744;
         }

         this.field742 -= this.field744;
         this.field744 = 0;
      }

   }

   public final synchronized void vmethod3777(int[] var1, int var2, int var3) {
      do {
         if(this.field742 < 0) {
            this.method1484(var1, var2, var3);
            return;
         }

         if(var3 + this.field744 < this.field742) {
            this.field744 += var3;
            this.method1484(var1, var2, var3);
            return;
         }

         int var4 = this.field742 - this.field744;
         this.method1484(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field744 += var4;
         this.method1477();
         PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field743.last();
         synchronized(var5) {
            int var7 = var5.method2337();
            if(var7 < 0) {
               var5.field1350 = 0;
               this.method1478(var5);
            } else {
               var5.field1350 = var7;
               this.method1500(var5.previous, var5);
            }
         }
      } while(var3 != 0);

   }

   public final synchronized void addSubStream(PcmStream var1) {
      this.subStreams.method5106(var1);
   }

   void method1486(int var1) {
      for(PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
         var2.vmethod3778(var1);
      }

   }

   public final synchronized void vmethod3778(int var1) {
      do {
         if(this.field742 < 0) {
            this.method1486(var1);
            return;
         }

         if(this.field744 + var1 < this.field742) {
            this.field744 += var1;
            this.method1486(var1);
            return;
         }

         int var2 = this.field742 - this.field744;
         this.method1486(var2);
         var1 -= var2;
         this.field744 += var2;
         this.method1477();
         PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field743.last();
         synchronized(var3) {
            int var5 = var3.method2337();
            if(var5 < 0) {
               var3.field1350 = 0;
               this.method1478(var3);
            } else {
               var3.field1350 = var5;
               this.method1500(var3.previous, var3);
            }
         }
      } while(var1 != 0);

   }

   void method1484(int[] var1, int var2, int var3) {
      for(PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
         var4.method2327(var1, var2, var3);
      }

   }

   protected int vmethod3787() {
      return 0;
   }
}
