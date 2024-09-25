package net.runelite.standalone;

public class MidiPcmStream extends PcmStream {
   int field2056;
   int[] field2070;
   int[] field2061;
   int[] field2068;
   int[] field2055;
   int[] field2072;
   int field2057;
   int[] field2063;
   NodeHashTable musicPatches;
   int track;
   long field2080;
   MusicPatchNode[][] field2074;
   int trackLength;
   long field2079;
   boolean field2076;
   MusicPatchPcmStream patchStream;
   MidiFileReader midiFile;
   int[] field2066;
   int[] field2065;
   int[] field2069;
   int[] field2081;
   int[] field2067;
   int[] field2062;
   int[] field2071;
   MusicPatchNode[][] field2073;
   int[] field2064;
   int[] field2058;

   public MidiPcmStream() {
      this.field2056 = 256;
      this.field2057 = 1000000;
      this.field2072 = new int[16];
      this.field2068 = new int[16];
      this.field2070 = new int[16];
      this.field2061 = new int[16];
      this.field2058 = new int[16];
      this.field2063 = new int[16];
      this.field2062 = new int[16];
      this.field2065 = new int[16];
      this.field2066 = new int[16];
      this.field2067 = new int[16];
      this.field2055 = new int[16];
      this.field2081 = new int[16];
      this.field2071 = new int[16];
      this.field2069 = new int[16];
      this.field2064 = new int[16];
      this.field2073 = new MusicPatchNode[16][128];
      this.field2074 = new MusicPatchNode[16][128];
      this.midiFile = new MidiFileReader();
      this.patchStream = new MusicPatchPcmStream(this);
      this.musicPatches = new NodeHashTable(128);
      this.method3552();
   }

   public int method3607() {
      return this.field2056;
   }

   public synchronized boolean method3551() {
      return this.midiFile.method3658();
   }

   protected synchronized PcmStream vmethod3775() {
      return this.patchStream;
   }

   protected synchronized PcmStream vmethod3794() {
      return null;
   }

   public synchronized void method3537() {
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.method6348(); var1 != null; var1 = (MusicPatch)this.musicPatches.method6345()) {
         var1.unlink();
      }

   }

   void method3544(MusicPatchNode var1, boolean var2) {
      int var3 = var1.rawSound.samples.length;
      int var4;
      if(var2 && var1.rawSound.field809) {
         int var5 = var3 + var3 - var1.rawSound.start;
         var4 = (int)((long)this.field2071[var1.field2214] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.stream.method2554();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2071[var1.field2214] >> 6);
      }

      var1.stream.method2610(var4);
   }

   public synchronized void method3643() {
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.method6348(); var1 != null; var1 = (MusicPatch)this.musicPatches.method6345()) {
         var1.method3760();
      }

   }

   public synchronized boolean method3533(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
      var1.method3730();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.table.method6348(); var7 != null; var7 = (ByteArrayNode)var1.table.method6345()) {
         int var8 = (int)var7.key;
         MusicPatch var9 = (MusicPatch)this.musicPatches.method6346((long)var8);
         if(var9 == null) {
            var9 = WorldMapRegion.method296(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.musicPatches.put(var9, (long)var8);
         }

         if(!var9.method3749(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3729();
      }

      return var5;
   }

   void method3542(int var1, int var2) {
      if(var2 != this.field2058[var1]) {
         this.field2058[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2074[var1][var3] = null;
         }
      }

   }

   protected synchronized void vmethod3777(int[] var1, int var2, int var3) {
      if(this.midiFile.method3658()) {
         int var4 = this.midiFile.division * this.field2057 / UrlRequest.PcmPlayer_sampleRate;

         do {
            long var5 = this.field2079 + (long)var4 * (long)var3;
            if(this.field2080 - var5 >= 0L) {
               this.field2079 = var5;
               break;
            }

            int var7 = (int)((this.field2080 - this.field2079 + (long)var4 - 1L) / (long)var4);
            this.field2079 += (long)var7 * (long)var4;
            this.patchStream.vmethod3777(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3602();
         } while(this.midiFile.method3658());
      }

      this.patchStream.vmethod3777(var1, var2, var3);
   }

   public synchronized void method3622(int var1) {
      this.field2056 = var1;
   }

   public synchronized void method3608(int var1, int var2) {
      this.method3609(var1, var2);
   }

   void method3552() {
      this.method3549(-1);
      this.method3550(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2058[var1] = this.field2061[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2063[var1] = this.field2061[var1] & -128;
      }

   }

   int method3558(MusicPatchNode var1) {
      MusicPatchNode2 var2 = var1.field2229;
      int var3 = this.field2072[var1.field2214] * this.field2070[var1.field2214] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2219 + 16384 >> 15;
      var3 = var3 * this.field2056 + 128 >> 8;
      if(var2.field2112 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2222 * 1.953125E-5D * (double)var2.field2112) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2113 != null) {
         var4 = var1.field2225;
         var5 = var2.field2113[var1.field2226 + 1];
         if(var1.field2226 < var2.field2113.length - 2) {
            var6 = (var2.field2113[var1.field2226] & 255) << 8;
            var7 = (var2.field2113[var1.field2226 + 2] & 255) << 8;
            var5 += (var2.field2113[var1.field2226 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2227 > 0 && var2.field2111 != null) {
         var4 = var1.field2227;
         var5 = var2.field2111[var1.field2228 + 1];
         if(var1.field2228 < var2.field2111.length - 2) {
            var6 = (var2.field2111[var1.field2228] & 255) << 8;
            var7 = (var2.field2111[var1.field2228 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2111[var1.field2228 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   void method3554(int var1) {
      if((this.field2067[var1] & 4) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if(var2.field2214 == var1) {
               var2.field2213 = 0;
            }
         }
      }

   }

   void method3550(int var1) {
      if(var1 >= 0) {
         this.field2072[var1] = 12800;
         this.field2068[var1] = 8192;
         this.field2070[var1] = 16383;
         this.field2062[var1] = 8192;
         this.field2065[var1] = 0;
         this.field2066[var1] = 8192;
         this.method3553(var1);
         this.method3554(var1);
         this.field2067[var1] = 0;
         this.field2055[var1] = 32767;
         this.field2081[var1] = 256;
         this.field2071[var1] = 0;
         this.method3606(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3550(var1);
         }

      }
   }

   void method3630(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3545(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3600(var3, var4, var5);
         } else {
            this.method3545(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3546(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2063[var3] = (var5 << 14) + (this.field2063[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2063[var3] = (var5 << 7) + (this.field2063[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2065[var3] = (var5 << 7) + (this.field2065[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2065[var3] = var5 + (this.field2065[var3] & -128);
         }

         if(var4 == 5) {
            this.field2066[var3] = (var5 << 7) + (this.field2066[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2066[var3] = var5 + (this.field2066[var3] & -128);
         }

         if(var4 == 7) {
            this.field2072[var3] = (var5 << 7) + (this.field2072[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2072[var3] = var5 + (this.field2072[var3] & -128);
         }

         if(var4 == 10) {
            this.field2068[var3] = (var5 << 7) + (this.field2068[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2068[var3] = var5 + (this.field2068[var3] & -128);
         }

         if(var4 == 11) {
            this.field2070[var3] = (var5 << 7) + (this.field2070[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2070[var3] = var5 + (this.field2070[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2067[var3] |= 1;
            } else {
               this.field2067[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2067[var3] |= 2;
            } else {
               this.method3553(var3);
               this.field2067[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2055[var3] = (var5 << 7) + (this.field2055[var3] & 127);
         }

         if(var4 == 98) {
            this.field2055[var3] = (this.field2055[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2055[var3] = (var5 << 7) + (this.field2055[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2055[var3] = (this.field2055[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3549(var3);
         }

         if(var4 == 121) {
            this.method3550(var3);
         }

         if(var4 == 123) {
            this.method3647(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2055[var3];
            if(var6 == 16384) {
               this.field2081[var3] = (var5 << 7) + (this.field2081[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2055[var3];
            if(var6 == 16384) {
               this.field2081[var3] = var5 + (this.field2081[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2071[var3] = (var5 << 7) + (this.field2071[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2071[var3] = var5 + (this.field2071[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2067[var3] |= 4;
            } else {
               this.method3554(var3);
               this.field2067[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3606(var3, (var5 << 7) + (this.field2069[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3606(var3, var5 + (this.field2069[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3542(var3, var4 + this.field2063[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3650(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3548(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3552();
         }
      }
   }

   void method3647(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if((var1 < 0 || var2.field2214 == var1) && var2.field2227 < 0) {
            this.field2073[var2.field2214][var2.field2218] = null;
            var2.field2227 = 0;
         }
      }

   }

   int method3613(MusicPatchNode var1) {
      int var2 = this.field2068[var1.field2214];
      return var2 < 8192?var2 * var1.field2220 + 32 >> 6:16384 - ((128 - var1.field2220) * (16384 - var2) + 32 >> 6);
   }

   int method3557(MusicPatchNode var1) {
      int var2 = (var1.field2235 * var1.field2223 >> 12) + var1.field2221;
      var2 += (this.field2062[var1.field2214] - 8192) * this.field2081[var1.field2214] >> 12;
      MusicPatchNode2 var3 = var1.field2229;
      int var4;
      if(var3.field2117 > 0 && (var3.field2116 > 0 || this.field2065[var1.field2214] > 0)) {
         var4 = var3.field2116 << 2;
         int var5 = var3.field2118 << 1;
         if(var1.field2233 < var5) {
            var4 = var4 * var1.field2233 / var5;
         }

         var4 += this.field2065[var1.field2214] >> 7;
         double var6 = Math.sin((double)(var1.field2230 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)UrlRequest.PcmPlayer_sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   void method3553(int var1) {
      if((this.field2067[var1] & 2) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if(var2.field2214 == var1 && this.field2073[var1][var2.field2218] == null && var2.field2227 < 0) {
               var2.field2227 = 0;
            }
         }
      }

   }

   void method3606(int var1, int var2) {
      this.field2069[var1] = var2;
      this.field2064[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   public synchronized void method3628() {
      this.midiFile.method3692();
      this.method3552();
   }

   boolean method3567(MusicPatchNode var1, int[] var2, int var3, int var4) {
      var1.field2232 = UrlRequest.PcmPlayer_sampleRate / 100;
      if(var1.field2227 < 0 || var1.stream != null && !var1.stream.method2561()) {
         int var5 = var1.field2223;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2066[var1.field2214]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2223 = var5;
         }

         var1.stream.method2559(this.method3557(var1));
         MusicPatchNode2 var6 = var1.field2229;
         boolean var7 = false;
         ++var1.field2233;
         var1.field2230 += var6.field2117;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2218 - 60 << 8) + (var1.field2235 * var1.field2223 >> 12));
         if(var6.field2112 > 0) {
            if(var6.field2115 > 0) {
               var1.field2222 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2115 * var8) + 0.5D);
            } else {
               var1.field2222 += 128;
            }
         }

         if(var6.field2113 != null) {
            if(var6.field2110 > 0) {
               var1.field2225 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2110 * var8) + 0.5D);
            } else {
               var1.field2225 += 128;
            }

            while(var1.field2226 < var6.field2113.length - 2 && var1.field2225 > (var6.field2113[var1.field2226 + 2] & 255) << 8) {
               var1.field2226 += 2;
            }

            if(var6.field2113.length - 2 == var1.field2226 && var6.field2113[var1.field2226 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2227 >= 0 && var6.field2111 != null && (this.field2067[var1.field2214] & 1) == 0 && (var1.field2217 < 0 || var1 != this.field2074[var1.field2214][var1.field2217])) {
            if(var6.field2114 > 0) {
               var1.field2227 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2114 * var8) + 0.5D);
            } else {
               var1.field2227 += 128;
            }

            while(var1.field2228 < var6.field2111.length - 2 && var1.field2227 > (var6.field2111[var1.field2228 + 2] & 255) << 8) {
               var1.field2228 += 2;
            }

            if(var6.field2111.length - 2 == var1.field2228) {
               var7 = true;
            }
         }

         if(var7) {
            var1.stream.method2558(var1.field2232);
            if(var2 != null) {
               var1.stream.vmethod3777(var2, var3, var4);
            } else {
               var1.stream.vmethod3778(var4);
            }

            if(var1.stream.method2562()) {
               this.patchStream.mixer.addSubStream(var1.stream);
            }

            var1.method3838();
            if(var1.field2227 >= 0) {
               var1.unlink();
               if(var1.field2217 > 0 && var1 == this.field2074[var1.field2214][var1.field2217]) {
                  this.field2074[var1.field2214][var1.field2217] = null;
               }
            }

            return true;
         } else {
            var1.stream.method2557(var1.field2232, this.method3558(var1), this.method3613(var1));
            return false;
         }
      } else {
         var1.method3838();
         var1.unlink();
         if(var1.field2217 > 0 && var1 == this.field2074[var1.field2214][var1.field2217]) {
            this.field2074[var1.field2214][var1.field2217] = null;
         }

         return true;
      }
   }

   boolean method3566(MusicPatchNode var1) {
      if(var1.stream == null) {
         if(var1.field2227 >= 0) {
            var1.unlink();
            if(var1.field2217 > 0 && var1 == this.field2074[var1.field2214][var1.field2217]) {
               this.field2074[var1.field2214][var1.field2217] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   void method3602() {
      int var1 = this.track;
      int var2 = this.trackLength;

      long var3;
      for(var3 = this.field2080; var2 == this.trackLength; var3 = this.midiFile.method3668(var2)) {
         while(var2 == this.midiFile.trackLengths[var1]) {
            this.midiFile.method3671(var1);
            int var5 = this.midiFile.method3665(var1);
            if(var5 == 1) {
               this.midiFile.method3660();
               this.midiFile.method3662(var1);
               if(this.midiFile.method3670()) {
                  if(!this.field2076 || var2 == 0) {
                     this.method3552();
                     this.midiFile.method3692();
                     return;
                  }

                  this.midiFile.method3684(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3630(var5);
            }

            this.midiFile.method3664(var1);
            this.midiFile.method3662(var1);
         }

         var1 = this.midiFile.method3669();
         var2 = this.midiFile.trackLengths[var1];
      }

      this.track = var1;
      this.trackLength = var2;
      this.field2080 = var3;
   }

   protected synchronized void vmethod3778(int var1) {
      if(this.midiFile.method3658()) {
         int var2 = this.midiFile.division * this.field2057 / UrlRequest.PcmPlayer_sampleRate;

         do {
            long var3 = this.field2079 + (long)var2 * (long)var1;
            if(this.field2080 - var3 >= 0L) {
               this.field2079 = var3;
               break;
            }

            int var5 = (int)((this.field2080 - this.field2079 + (long)var2 - 1L) / (long)var2);
            this.field2079 += (long)var5 * (long)var2;
            this.patchStream.vmethod3778(var5);
            var1 -= var5;
            this.method3602();
         } while(this.midiFile.method3658());
      }

      this.patchStream.vmethod3778(var1);
   }

   void method3650(int var1, int var2) {
   }

   void method3609(int var1, int var2) {
      this.field2061[var1] = var2;
      this.field2063[var1] = var2 & -128;
      this.method3542(var1, var2);
   }

   void method3545(int var1, int var2, int var3) {
      MusicPatchNode var4 = this.field2073[var1][var2];
      if(var4 != null) {
         this.field2073[var1][var2] = null;
         if((this.field2067[var1] & 2) != 0) {
            for(MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
               if(var4.field2214 == var5.field2214 && var5.field2227 < 0 && var4 != var5) {
                  var4.field2227 = 0;
                  break;
               }
            }
         } else {
            var4.field2227 = 0;
         }

      }
   }

   void method3600(int var1, int var2, int var3) {
      this.method3545(var1, var2, 64);
      if((this.field2067[var1] & 2) != 0) {
         for(MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.getTail(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.getPrevious()) {
            if(var4.field2214 == var1 && var4.field2227 < 0) {
               this.field2073[var1][var4.field2218] = null;
               this.field2073[var1][var2] = var4;
               int var5 = (var4.field2223 * var4.field2235 >> 12) + var4.field2221;
               var4.field2221 += var2 - var4.field2218 << 8;
               var4.field2235 = var5 - var4.field2221;
               var4.field2223 = 4096;
               var4.field2218 = var2;
               return;
            }
         }
      }

      MusicPatch var9 = (MusicPatch)this.musicPatches.method6346((long)this.field2058[var1]);
      if(var9 != null) {
         RawSound var8 = var9.rawSounds[var2];
         if(var8 != null) {
            MusicPatchNode var6 = new MusicPatchNode();
            var6.field2214 = var1;
            var6.patch = var9;
            var6.rawSound = var8;
            var6.field2229 = var9.field2140[var2];
            var6.field2217 = var9.field2138[var2];
            var6.field2218 = var2;
            var6.field2219 = var3 * var3 * var9.field2137[var2] * var9.field2136 + 1024 >> 11;
            var6.field2220 = var9.field2134[var2] & 255;
            var6.field2221 = (var2 << 8) - (var9.field2135[var2] & 32767);
            var6.field2222 = 0;
            var6.field2225 = 0;
            var6.field2226 = 0;
            var6.field2227 = -1;
            var6.field2228 = 0;
            if(this.field2071[var1] == 0) {
               var6.stream = RawPcmStream.method2577(var8, this.method3557(var6), this.method3558(var6), this.method3613(var6));
            } else {
               var6.stream = RawPcmStream.method2577(var8, this.method3557(var6), 0, this.method3613(var6));
               this.method3544(var6, var9.field2135[var2] < 0);
            }

            if(var9.field2135[var2] < 0) {
               var6.stream.setNumLoops(-1);
            }

            if(var6.field2217 >= 0) {
               MusicPatchNode var7 = this.field2074[var1][var6.field2217];
               if(var7 != null && var7.field2227 < 0) {
                  this.field2073[var1][var7.field2218] = null;
                  var7.field2227 = 0;
               }

               this.field2074[var1][var6.field2217] = var6;
            }

            this.patchStream.queue.addFirst(var6);
            this.field2073[var1][var2] = var6;
         }
      }
   }

   public synchronized void method3615(MusicTrack var1, boolean var2) {
      this.method3628();
      this.midiFile.method3693(var1.midi);
      this.field2076 = var2;
      this.field2079 = 0L;
      int var3 = this.midiFile.method3676();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.midiFile.method3671(var4);
         this.midiFile.method3664(var4);
         this.midiFile.method3662(var4);
      }

      this.track = this.midiFile.method3669();
      this.trackLength = this.midiFile.trackLengths[this.track];
      this.field2080 = this.midiFile.method3668(this.trackLength);
   }

   void method3546(int var1, int var2, int var3) {
   }

   void method3549(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if(var1 < 0 || var2.field2214 == var1) {
            if(var2.stream != null) {
               var2.stream.method2558(UrlRequest.PcmPlayer_sampleRate / 100);
               if(var2.stream.method2562()) {
                  this.patchStream.mixer.addSubStream(var2.stream);
               }

               var2.method3838();
            }

            if(var2.field2227 < 0) {
               this.field2073[var2.field2214][var2.field2218] = null;
            }

            var2.unlink();
         }
      }

   }

   void method3548(int var1, int var2) {
      this.field2062[var1] = var2;
   }

   protected synchronized int vmethod3787() {
      return 0;
   }
}
