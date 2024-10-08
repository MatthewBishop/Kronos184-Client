package net.runelite.standalone;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class NetSocket extends AbstractSocket implements Runnable {
   static Widget mousedOverWidgetIf1;
   OutputStream outputStream;
   Task task;
   byte[] outBuffer;
   TaskHandler taskHandler;
   boolean isClosed;
   Socket socket;
   int outOffset;
   InputStream inputStream;
   final int maxPacketLength;
   final int bufferLength;
   boolean exceptionWriting;
   int outLength;

   public NetSocket(Socket var1, TaskHandler var2, int var3) throws IOException {
      this.isClosed = false;
      this.outLength = 0;
      this.outOffset = 0;
      this.exceptionWriting = false;
      this.taskHandler = var2;
      this.socket = var1;
      this.bufferLength = var3;
      this.maxPacketLength = var3 - 100;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(65536);
      this.socket.setSendBufferSize(65536);
      this.inputStream = this.socket.getInputStream();
      this.outputStream = this.socket.getOutputStream();
   }

   public int vmethod5815() throws IOException {
      return this.isClosed?0:this.inputStream.read();
   }

   void method3462(byte[] var1, int var2, int var3) throws IOException {
      if(!this.isClosed) {
         if(this.exceptionWriting) {
            this.exceptionWriting = false;
            throw new IOException();
         } else {
            if(this.outBuffer == null) {
               this.outBuffer = new byte[this.bufferLength];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.outBuffer[this.outOffset] = var1[var5 + var2];
                  this.outOffset = (this.outOffset + 1) % this.bufferLength;
                  if((this.maxPacketLength + this.outLength) % this.bufferLength == this.outOffset) {
                     throw new IOException();
                  }
               }

               if(this.task == null) {
                  this.task = this.taskHandler.method3427(this, 3);
               }

               this.notifyAll();
            }

         }
      }
   }

   public void vmethod5817(byte[] var1, int var2, int var3) throws IOException {
      this.method3462(var1, var2, var3);
   }

   public int vmethod5832(byte[] var1, int var2, int var3) throws IOException {
      if(this.isClosed) {
         return 0;
      } else {
         int var4;
         int var5;
         for(var4 = var3; var3 > 0; var3 -= var5) {
            var5 = this.inputStream.read(var1, var2, var3);
            if(var5 <= 0) {
               throw new EOFException();
            }

            var2 += var5;
         }

         return var4;
      }
   }

   public boolean vmethod5816(int var1) throws IOException {
      return this.isClosed?false:this.inputStream.available() >= var1;
   }

   public int vmethod5838() throws IOException {
      return this.isClosed?0:this.inputStream.available();
   }

   public void vmethod5821() {
      if(!this.isClosed) {
         synchronized(this) {
            this.isClosed = true;
            this.notifyAll();
         }

         if(this.task != null) {
            while(this.task.status == 0) {
               try {
                  Thread.sleep(1L);
               } catch (InterruptedException var4) {
                  ;
               }
            }

            if(this.task.status == 1) {
               try {
                  ((Thread)this.task.result).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.task = null;
      }
   }

   protected void finalize() {
      this.vmethod5821();
   }

   protected void aav() {
      this.vmethod5821();
   }

   protected void aao() {
      this.vmethod5821();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.outLength == this.outOffset) {
                     if(this.isClosed) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.outLength;
                  if(this.outOffset >= this.outLength) {
                     var1 = this.outOffset - this.outLength;
                  } else {
                     var1 = this.bufferLength - this.outLength;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.outputStream.write(this.outBuffer, var2, var1);
               } catch (IOException var9) {
                  this.exceptionWriting = true;
               }

               this.outLength = (var1 + this.outLength) % this.bufferLength;

               try {
                  if(this.outOffset == this.outLength) {
                     this.outputStream.flush();
                  }
               } catch (IOException var8) {
                  this.exceptionWriting = true;
               }
               continue;
            }

            try {
               if(this.inputStream != null) {
                  this.inputStream.close();
               }

               if(this.outputStream != null) {
                  this.outputStream.close();
               }

               if(this.socket != null) {
                  this.socket.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.outBuffer = null;
            break;
         }
      } catch (Exception var12) {
         class19.method342((String)null, var12);
      }

   }

   public static boolean method3488(CharSequence var0) {
      return MouseRecorder.method1204(var0, 10, true);
   }

   public static String method3456(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = UrlRequester.method3053(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   public static Enumerated getEnumeratedTypeIndex(Enumerated[] enumeratedToSearch, int id) {
      Enumerated[] holder = enumeratedToSearch;
      for(int index = 0; index < holder.length; ++index) {
         Enumerated enumerated = holder[index];
         if(id == enumerated.getId()) {
            return enumerated;
         }
      }
      return null;
   }

   static final void method3457(int var0) {
      class329.method6295();

      for(ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.last(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if(var1.obj != null) {
            var1.method949();
         }
      }

      int var4 = AbstractWorldMapData.method3328(var0).type;
      if(var4 != 0) {
         int var2 = Varps.Varps_main[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               Rasterizer3D.method2949(0.9D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2840(0.9D);
            }

            if(var2 == 2) {
               Rasterizer3D.method2949(0.8D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2840(0.8D);
            }

            if(var2 == 3) {
               Rasterizer3D.method2949(0.7D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2840(0.7D);
            }

            if(var2 == 4) {
               Rasterizer3D.method2949(0.6D);
               ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2840(0.6D);
            }

            ItemDefinition.ItemDefinition_cachedSprites.clear();
         }

         if(var4 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field969) {
               if(Client.field969 == 0 && Client.field874 != -1) {
                  class78.method1576(class212.archive6, Client.field874, 0, var3, false);
                  Client.field967 = false;
               } else if(var3 == 0) {
                  VertexNormal.method2466();
                  Client.field967 = false;
               } else if(class197.field2173 != 0) {
                  TileItem.field816 = var3;
               } else {
                  class38.midiPcmStream.method3622(var3);
               }

               Client.field969 = var3;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.soundEffectVolume = 127;
            }

            if(var2 == 1) {
               Client.soundEffectVolume = 96;
            }

            if(var2 == 2) {
               Client.soundEffectVolume = 64;
            }

            if(var2 == 3) {
               Client.soundEffectVolume = 32;
            }

            if(var2 == 4) {
               Client.soundEffectVolume = 0;
            }
         }

         if(var4 == 5) {
            Client.leftClickOpensMenu = var2;
         }

         if(var4 == 6) {
            Client.chatEffects = var2;
         }

         if(var4 == 9) {
            Client.field1081 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field1076 = 127;
            }

            if(var2 == 1) {
               Client.field1076 = 96;
            }

            if(var2 == 2) {
               Client.field1076 = 64;
            }

            if(var2 == 3) {
               Client.field1076 = 32;
            }

            if(var2 == 4) {
               Client.field1076 = 0;
            }
         }

         if(var4 == 17) {
            Client.followerIndex = var2 & 65535;
         }

         if(var4 == 18) {
            Client.playerAttackOption = (AttackOption) getEnumeratedTypeIndex(FloorUnderlayDefinition.method4604(), var2);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.combatTargetPlayerIndex = -1;
            } else {
               Client.combatTargetPlayerIndex = var2 & 2047;
            }
         }

         if(var4 == 22) {
            Client.npcAttackOption = (AttackOption) getEnumeratedTypeIndex(FloorUnderlayDefinition.method4604(), var2);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
