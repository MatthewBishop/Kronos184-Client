package net.runelite.standalone;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;

public final class AccessFile {
   final long maxSize;
   long offset;
   RandomAccessFile file;

   public AccessFile(File var1, String var2, long var3) throws IOException {
      if(-1L == var3) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() > var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.maxSize = var3;
      this.offset = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   public final void method14(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.offset > this.maxSize) {
         this.file.seek(this.maxSize);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.offset += (long)var3;
      }
   }

   public final int method6(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.offset += (long)var4;
      }

      return var4;
   }

   public final long method5() throws IOException {
      return this.file.length();
   }

   public final void method0(boolean var1) throws IOException {
      if(this.file != null) {
         if(var1) {
            try {
               this.file.getFD().sync();
            } catch (SyncFailedException var3) {
               ;
            }
         }

         this.file.close();
         this.file = null;
      }

   }

   public final void method18() throws IOException {
      this.method0(false);
   }

   final void method2(long var1) throws IOException {
      this.file.seek(var1);
      this.offset = var1;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method18();
      }

   }

   protected void aav() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method18();
      }

   }

   protected void aao() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.method18();
      }

   }
}
