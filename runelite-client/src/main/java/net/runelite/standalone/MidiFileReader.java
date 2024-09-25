package net.runelite.standalone;

public class MidiFileReader {
   static final byte[] field2087;
   int division;
   int[] field2093;
   int field2082;
   int[] trackLengths;
   int[] trackPositions;
   int[] trackStarts;
   long field2090;
   Buffer buffer;

   static {
      field2087 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   MidiFileReader(byte[] var1) {
      this.buffer = new Buffer((byte[])null);
      this.method3693(var1);
   }

   MidiFileReader() {
      this.buffer = new Buffer((byte[])null);
   }

   void method3692() {
      this.buffer.array = null;
      this.trackStarts = null;
      this.trackPositions = null;
      this.trackLengths = null;
      this.field2093 = null;
   }

   int method3669() {
      int var1 = this.trackPositions.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.trackPositions[var4] >= 0 && this.trackLengths[var4] < var3) {
            var2 = var4;
            var3 = this.trackLengths[var4];
         }
      }

      return var2;
   }

   void method3662(int var1) {
      this.trackPositions[var1] = this.buffer.offset;
   }

   void method3660() {
      this.buffer.offset = -1;
   }

   void method3671(int var1) {
      this.buffer.offset = this.trackPositions[var1];
   }

   int method3676() {
      return this.trackPositions.length;
   }

   boolean method3658() {
      return this.buffer.array != null;
   }

   int method3665(int var1) {
      int var2 = this.method3666(var1);
      return var2;
   }

   void method3693(byte[] var1) {
      this.buffer.array = var1;
      this.buffer.offset = 10;
      int var2 = this.buffer.readUnsignedShort();
      this.division = this.buffer.readUnsignedShort();
      this.field2082 = 500000;
      this.trackStarts = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.buffer.offset += var5) {
         int var4 = this.buffer.readInt();
         var5 = this.buffer.readInt();
         if(var4 == 1297379947) {
            this.trackStarts[var3] = this.buffer.offset;
            ++var3;
         }
      }

      this.field2090 = 0L;
      this.trackPositions = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.trackPositions[var3] = this.trackStarts[var3];
      }

      this.trackLengths = new int[var2];
      this.field2093 = new int[var2];
   }

   boolean method3670() {
      int var1 = this.trackPositions.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.trackPositions[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   long method3668(int var1) {
      return this.field2090 + (long)var1 * (long)this.field2082;
   }

   int method3667(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.buffer.readUnsignedByte();
         var4 = this.buffer.method5514();
         if(var7 == 47) {
            this.buffer.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.buffer.method5500();
            var4 -= 3;
            int var6 = this.trackLengths[var1];
            this.field2090 += (long)var6 * (long)(this.field2082 - var5);
            this.field2082 = var5;
            this.buffer.offset += var4;
            return 2;
         } else {
            this.buffer.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2087[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.buffer.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.buffer.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   void method3684(long var1) {
      this.field2090 = var1;
      int var3 = this.trackPositions.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.trackLengths[var4] = 0;
         this.field2093[var4] = 0;
         this.buffer.offset = this.trackStarts[var4];
         this.method3664(var4);
         this.trackPositions[var4] = this.buffer.offset;
      }

   }

   int method3666(int var1) {
      byte var2 = this.buffer.array[this.buffer.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2093[var1] = var5;
         ++this.buffer.offset;
      } else {
         var5 = this.field2093[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3667(var1, var5);
      } else {
         int var3 = this.buffer.method5514();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.buffer.array[this.buffer.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.buffer.offset;
               this.field2093[var1] = var4;
               return this.method3667(var1, var4);
            }
         }

         this.buffer.offset += var3;
         return 0;
      }
   }

   void method3664(int var1) {
      int var2 = this.buffer.method5514();
      this.trackLengths[var1] += var2;
   }
}
