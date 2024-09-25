package net.runelite.standalone;

public final class BZip2State {
   static int port2;
   final int field3705;
   int field3678;
   final int field3695;
   byte[] inputArray;
   final int field3682;
   int su_ch2;
   int bsLive;
   final int field3694;
   final int field3714;
   int bsBuff;
   int originalPointer;
   int nextBit_unused;
   final int field3688;
   byte out_char;
   byte[] ll8;
   byte[] selectorMtf;
   boolean[] inUse;
   int[] minLens;
   int[][] perm;
   int field3715;
   int[][] base;
   int[] getAndMoveToFrontDecode_yy;
   byte[] selector;
   int[][] limit;
   byte[] seqToUnseq;
   byte[][] temp_charArray2d;
   boolean[] inUse16;
   int outputLength;
   int next_out;
   int[] cftab;
   int su_rNToGo;
   int[] unzftab;
   int blockSize100k;
   int field3697;
   byte[] outputArray;
   int nblocks_used;
   int nInUse;
   int nextByte;

   BZip2State() {
      this.field3688 = 4096;
      this.field3705 = 16;
      this.field3714 = 258;
      this.field3694 = 6;
      this.field3682 = 50;
      this.field3695 = 18002;
      this.nextByte = 0;
      this.next_out = 0;
      this.unzftab = new int[256];
      this.cftab = new int[257];
      this.inUse = new boolean[256];
      this.inUse16 = new boolean[16];
      this.seqToUnseq = new byte[256];
      this.ll8 = new byte[4096];
      this.getAndMoveToFrontDecode_yy = new int[16];
      this.selector = new byte[18002];
      this.selectorMtf = new byte[18002];
      this.temp_charArray2d = new byte[6][258];
      this.limit = new int[6][258];
      this.base = new int[6][258];
      this.perm = new int[6][258];
      this.minLens = new int[6];
   }

   static PrivateChatMode[] method5454() {
      return new PrivateChatMode[]{PrivateChatMode.field3633, PrivateChatMode.field3631, PrivateChatMode.field3632};
   }

   static boolean method5455(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
