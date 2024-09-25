package net.runelite.standalone;

public class RawSound extends AbstractSound {
   public byte[] samples;
   public boolean field809;
   int end;
   public int start;
   public int sampleRate;

   RawSound(int var1, byte[] var2, int var3, int var4) {
      this.sampleRate = var1;
      this.samples = var2;
      this.start = var3;
      this.end = var4;
   }

   RawSound(int var1, byte[] var2, int var3, int var4, boolean var5) {
      this.sampleRate = var1;
      this.samples = var2;
      this.start = var3;
      this.end = var4;
      this.field809 = var5;
   }

   public RawSound applyResampler(Decimator var1) {
      this.samples = var1.method2497(this.samples);
      this.sampleRate = var1.method2487(this.sampleRate);
      if(this.start == this.end) {
         this.start = this.end = var1.method2496(this.start);
      } else {
         this.start = var1.method2496(this.start);
         this.end = var1.method2496(this.end);
         if(this.start == this.end) {
            --this.start;
         }
      }

      return this;
   }

}
