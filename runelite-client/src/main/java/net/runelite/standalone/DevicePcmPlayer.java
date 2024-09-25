package net.runelite.standalone;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

public class DevicePcmPlayer extends PcmPlayer {
   SourceDataLine line;
   byte[] byteSamples;
   int capacity2;
   AudioFormat format;

   protected void vmethod2712(int var1) throws LineUnavailableException {
      try {
         Info var2 = new Info(SourceDataLine.class, this.format, var1 << (PcmPlayer.PcmPlayer_stereo?2:1));
         this.line = (SourceDataLine)AudioSystem.getLine(var2);
         this.line.open();
         this.line.start();
         this.capacity2 = var1;
      } catch (LineUnavailableException var5) {
         int var4 = (var1 >>> 1 & 1431655765) + (var1 & 1431655765);
         var4 = (var4 >>> 2 & 858993459) + (var4 & 858993459);
         var4 = (var4 >>> 4) + var4 & 252645135;
         var4 += var4 >>> 8;
         var4 += var4 >>> 16;
         int var3 = var4 & 255;
         if(var3 != 1) {
            this.vmethod2712(Timer.method4847(var1));
            return;
         }

         this.line = null;
         throw var5;
      }

   }

   protected void vmethod2715() {
      this.line.flush();
   }

   protected void vmethod2725() {
      if(this.line != null) {
         this.line.close();
         this.line = null;
      }

   }

   protected void vmethod2704() {
      int var1 = 256;
      if(PcmPlayer.PcmPlayer_stereo) {
         var1 <<= 1;
      }

      for(int var2 = 0; var2 < var1; ++var2) {
         int var3 = super.samples[var2];
         if((var3 + 8388608 & -16777216) != 0) {
            var3 = 8388607 ^ var3 >> 31;
         }

         this.byteSamples[var2 * 2] = (byte)(var3 >> 8);
         this.byteSamples[var2 * 2 + 1] = (byte)(var3 >> 16);
      }

      this.line.write(this.byteSamples, 0, var1 << 1);
   }

   protected int vmethod2735() {
      return this.capacity2 - (this.line.available() >> (PcmPlayer.PcmPlayer_stereo?2:1));
   }

   protected void vmethod2711() {
      this.format = new AudioFormat((float)UrlRequest.PcmPlayer_sampleRate, 16, PcmPlayer.PcmPlayer_stereo?2:1, true, false);
      this.byteSamples = new byte[256 << (PcmPlayer.PcmPlayer_stereo?2:1)];
   }
}
