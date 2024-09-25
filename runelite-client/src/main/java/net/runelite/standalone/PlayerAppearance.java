package net.runelite.standalone;

import java.io.IOException;
import net.runelite.api.kit.KitType;

public class PlayerAppearance implements net.runelite.api.PlayerAppearance {
   public static short[] field2748;
   static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
   static final int[] equipmentIndices;
   public static short[][] field2742;
   int[] bodyColors;
   long field2745;
   long equipmentHash;
   public int npcTransformId;
   public boolean isFemale;
   int[] equipment;

   static {
      equipmentIndices = new int[]{8, 11, 4, 6, 9, 7, 10};
      PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
   }

   public void method4160(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipment[equipmentIndices[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = DevicePcmPlayerProvider.KitDefinition_fileCount - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= DevicePcmPlayerProvider.KitDefinition_fileCount) {
                     var3 = 0;
                  }
               }

               var4 = class223.method4125(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodypartID != var1 + (this.isFemale?7:0));

            this.equipment[equipmentIndices[var1]] = var3 + 256;
            this.method4131();
         }
      }
   }

   void method4131() {
      long hash = this.equipmentHash;
      int var3 = this.equipment[5];
      int var4 = this.equipment[9];
      this.equipment[5] = var4;
      this.equipment[9] = var3;
      this.equipmentHash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.equipmentHash <<= 4;
         if(this.equipment[var5] >= 256) {
            this.equipmentHash += this.equipment[var5] - 256;
         }
      }

      if(this.equipment[0] >= 256) {
         this.equipmentHash += this.equipment[0] - 256 >> 4;
      }

      if(this.equipment[1] >= 256) {
         this.equipmentHash += this.equipment[1] - 256 >> 8;
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.equipmentHash <<= 3;
         this.equipmentHash += this.bodyColors[var5];
      }

      this.equipmentHash <<= 1;
      this.equipmentHash += this.isFemale ? 1 : 0;
      this.equipment[5] = var3;
      this.equipment[9] = var4;
      if(hash != 0L && this.equipmentHash != hash) {
         PlayerAppearance_cachedModels.remove(hash);
      }

   }

   public Model method4156(SequenceDefinition primarySeq, int var2, SequenceDefinition var3, int var4) {
      if(this.npcTransformId != -1) {
         return PacketBufferNode.getNpcDefinition(this.npcTransformId).method4405(primarySeq, var2, var3, var4);
      } else {
         long hash = this.equipmentHash;
         int[] equipment = this.equipment;
         if(primarySeq != null && (primarySeq.shield >= 0 || primarySeq.weapon >= 0)) {
            equipment = new int[12];

            for(int slot = 0; slot < 12; ++slot) {
               equipment[slot] = this.equipment[slot];
            }

            if(primarySeq.shield >= 0) {
               hash += primarySeq.shield - this.equipment[5] << 40;
               equipment[5] = primarySeq.shield;
            }

            if(primarySeq.weapon >= 0) {
               hash += primarySeq.weapon - this.equipment[3] << 48;
               equipment[3] = primarySeq.weapon;
            }
         }

         Model var8 = (Model)PlayerAppearance_cachedModels.get(hash);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = equipment[var10];
               if(var11 >= 256 && var11 < 512 && !class223.method4125(var11 - 256).method4710()) {
                  var9 = true;
               }

               if(var11 >= 512 && !Occluder.getItemDefinition(var11 - 512).method4537(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2745) {
                  var8 = (Model)PlayerAppearance_cachedModels.get(this.field2745);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = equipment[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = class223.method4125(var13 - 256).method4695();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = Occluder.getItemDefinition(var13 - 512).method4538(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyColors[var13] < field2742[var13].length) {
                     var18.method2770(HorizontalAlignment.field3270[var13], field2742[var13][this.bodyColors[var13]]);
                  }

                  if(this.bodyColors[var13] < DevicePcmPlayerProvider.field153[var13].length) {
                     var18.method2770(field2748[var13], DevicePcmPlayerProvider.field153[var13][this.bodyColors[var13]]);
                  }
               }

               var8 = var18.method2778(64, 850, -30, -50, -30);
               PlayerAppearance_cachedModels.method3034(var8, hash);
               this.field2745 = hash;
            }
         }

         if(primarySeq == null && var3 == null) {
            return var8;
         } else {
            Model var17;
            if(primarySeq != null && var3 != null) {
               var17 = primarySeq.method4660(var8, var2, var3, var4, (byte)-28);
            } else if(primarySeq != null) {
               var17 = primarySeq.method4661(var8, var2, 330035631);
            } else {
               var17 = var3.method4661(var8, var4, 95225227);
            }

            return var17;
         }
      }
   }

   public void method4130(Buffer var1) {
      var1.writeByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipment[equipmentIndices[var2]];
         if(var3 == 0) {
            var1.writeByte(-1);
         } else {
            var1.writeByte(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.writeByte(this.bodyColors[var2]);
      }

   }

   public void method4129(boolean var1) {
      if(this.isFemale != var1) {
         this.method4152((int[])null, this.bodyColors, var1, -1);
      }
   }

   public void method4126(int var1, boolean var2) {
      int var3 = this.bodyColors[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = field2742[var1].length - 1;
            }
         } while(!NetCache.method4466(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= field2742[var1].length) {
               var3 = 0;
            }
         } while(!NetCache.method4466(var1, var3));
      }

      this.bodyColors[var1] = var3;
      this.method4131();
   }

   public int method4134() {
      return this.npcTransformId == -1?(this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20):305419896 + PacketBufferNode.getNpcDefinition(this.npcTransformId).id;
   }

   public void method4152(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < DevicePcmPlayerProvider.KitDefinition_fileCount; ++var6) {
               KitDefinition var7 = class223.method4125(var6);
               if(var7 != null && !var7.nonSelectable && var5 + (var3?7:0) == var7.bodypartID) {
                  var1[equipmentIndices[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipment = var1;
      this.bodyColors = var2;
      this.isFemale = var3;
      this.npcTransformId = var4;
      this.method4131();
   }

   @Override
   public int[] getEquipmentIds() {
      return this.equipment;
   }

   public int getEquipmentId(KitType var1) {
      int var2 = this.getEquipmentIds()[var1.getIndex()];
      return var2 < 512?-1:var2 - 512;
   }

   public int getKitId(KitType var1) {
      int var2 = this.getEquipmentIds()[var1.getIndex()];
      return var2 >= 256 && var2 < 512?var2 - 256:-1;
   }

   @Override
   public void setTransformedNpcId(int var1) {
      this.npcTransformId = var1;
   }

   @Override
   public void setHash() {
      this.method4131();
   }

   ModelData method4133() {
      if(this.npcTransformId != -1) {
         return PacketBufferNode.getNpcDefinition(this.npcTransformId).method4406();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipment[var2];
            if(var3 >= 256 && var3 < 512 && !class223.method4125(var3 - 256).method4706()) {
               var1 = true;
            }

            if(var3 >= 512 && !Occluder.getItemDefinition(var3 - 512).method4556(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.equipment[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = class223.method4125(var5 - 256).method4708();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = Occluder.getItemDefinition(var5 - 512).method4540(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyColors[var5] < field2742[var5].length) {
                  var8.method2770(HorizontalAlignment.field3270[var5], field2742[var5][this.bodyColors[var5]]);
               }

               if(this.bodyColors[var5] < DevicePcmPlayerProvider.field153[var5].length) {
                  var8.method2770(field2748[var5], DevicePcmPlayerProvider.field153[var5][this.bodyColors[var5]]);
               }
            }

            return var8;
         }
      }
   }

   public static boolean method4159() {
      long var0 = class33.method680();
      int var2 = (int)(var0 - NetCache.field3273);
      NetCache.field3273 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      NetCache.NetCache_loadTime += var2;
      if(NetCache.NetCache_pendingResponsesCount == 0 && NetCache.NetCache_pendingPriorityResponsesCount == 0 && NetCache.NetCache_pendingWritesCount == 0 && NetCache.NetCache_pendingPriorityWritesCount == 0) {
         return true;
      } else if(NetCache.NetCache_socket == null) {
         return false;
      } else {
         boolean var10000;
         try {
            if(NetCache.NetCache_loadTime > 30000) {
               throw new IOException();
            }

            NetFileRequest var3;
            Buffer var4;
            while(NetCache.NetCache_pendingPriorityResponsesCount < 200 && NetCache.NetCache_pendingPriorityWritesCount > 0) {
               var3 = (NetFileRequest)NetCache.NetCache_pendingPriorityWrites.method6348();
               var4 = new Buffer(4);
               var4.writeByte(1);
               var4.write24BitInteger((int)var3.key);
               NetCache.NetCache_socket.vmethod5817(var4.array, 0, 4);
               NetCache.NetCache_pendingPriorityResponses.put(var3, var3.key);
               --NetCache.NetCache_pendingPriorityWritesCount;
               ++NetCache.NetCache_pendingPriorityResponsesCount;
            }

            while(NetCache.NetCache_pendingResponsesCount < 200 && NetCache.NetCache_pendingWritesCount > 0) {
               var3 = (NetFileRequest)NetCache.NetCache_pendingWritesQueue.method4251();
               var4 = new Buffer(4);
               var4.writeByte(0);
               var4.write24BitInteger((int)var3.key);
               NetCache.NetCache_socket.vmethod5817(var4.array, 0, 4);
               var3.unlinkDual();
               NetCache.NetCache_pendingResponses.put(var3, var3.key);
               --NetCache.NetCache_pendingWritesCount;
               ++NetCache.NetCache_pendingResponsesCount;
            }

            for(int var15 = 0; var15 < 100; ++var15) {
               int var16 = NetCache.NetCache_socket.vmethod5838();
               if(var16 < 0) {
                  throw new IOException();
               }

               if(var16 == 0) {
                  break;
               }

               NetCache.NetCache_loadTime = 0;
               byte var5 = 0;
               if(WorldMapEvent.NetCache_currentResponse == null) {
                  var5 = 8;
               } else if(NetCache.field3271 == 0) {
                  var5 = 1;
               }

               int var6;
               int var7;
               int var8;
               int var10;
               if(var5 > 0) {
                  var6 = var5 - NetCache.NetCache_responseHeaderBuffer.offset;
                  if(var6 > var16) {
                     var6 = var16;
                  }

                  NetCache.NetCache_socket.vmethod5832(NetCache.NetCache_responseHeaderBuffer.array, NetCache.NetCache_responseHeaderBuffer.offset, var6);
                  if(NetCache.field3287 != 0) {
                     for(var7 = 0; var7 < var6; ++var7) {
                        NetCache.NetCache_responseHeaderBuffer.array[NetCache.NetCache_responseHeaderBuffer.offset + var7] ^= NetCache.field3287;
                     }
                  }

                  NetCache.NetCache_responseHeaderBuffer.offset += var6;
                  if(NetCache.NetCache_responseHeaderBuffer.offset < var5) {
                     break;
                  }

                  if(WorldMapEvent.NetCache_currentResponse == null) {
                     NetCache.NetCache_responseHeaderBuffer.offset = 0;
                     var7 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                     var8 = NetCache.NetCache_responseHeaderBuffer.readUnsignedShort();
                     int var9 = NetCache.NetCache_responseHeaderBuffer.readUnsignedByte();
                     var10 = NetCache.NetCache_responseHeaderBuffer.readInt();
                     long var11 = (long)(var8 + (var7 << 16));
                     NetFileRequest var13 = (NetFileRequest)NetCache.NetCache_pendingPriorityResponses.method6346(var11);
                     UserComparator10.field1809 = true;
                     if(var13 == null) {
                        var13 = (NetFileRequest)NetCache.NetCache_pendingResponses.method6346(var11);
                        UserComparator10.field1809 = false;
                     }

                     if(var13 == null) {
                        throw new IOException();
                     }

                     int var14 = var9 == 0?5:9;
                     WorldMapEvent.NetCache_currentResponse = var13;
                     FaceNormal.NetCache_responseArchiveBuffer = new Buffer(var10 + var14 + WorldMapEvent.NetCache_currentResponse.padding);
                     FaceNormal.NetCache_responseArchiveBuffer.writeByte(var9);
                     FaceNormal.NetCache_responseArchiveBuffer.writeInt(var10);
                     NetCache.field3271 = 8;
                     NetCache.NetCache_responseHeaderBuffer.offset = 0;
                  } else if(NetCache.field3271 == 0) {
                     if(NetCache.NetCache_responseHeaderBuffer.array[0] == -1) {
                        NetCache.field3271 = 1;
                        NetCache.NetCache_responseHeaderBuffer.offset = 0;
                     } else {
                        WorldMapEvent.NetCache_currentResponse = null;
                     }
                  }
               } else {
                  var6 = FaceNormal.NetCache_responseArchiveBuffer.array.length - WorldMapEvent.NetCache_currentResponse.padding;
                  var7 = 512 - NetCache.field3271;
                  if(var7 > var6 - FaceNormal.NetCache_responseArchiveBuffer.offset) {
                     var7 = var6 - FaceNormal.NetCache_responseArchiveBuffer.offset;
                  }

                  if(var7 > var16) {
                     var7 = var16;
                  }

                  NetCache.NetCache_socket.vmethod5832(FaceNormal.NetCache_responseArchiveBuffer.array, FaceNormal.NetCache_responseArchiveBuffer.offset, var7);
                  if(NetCache.field3287 != 0) {
                     for(var8 = 0; var8 < var7; ++var8) {
                        FaceNormal.NetCache_responseArchiveBuffer.array[var8 + FaceNormal.NetCache_responseArchiveBuffer.offset] ^= NetCache.field3287;
                     }
                  }

                  FaceNormal.NetCache_responseArchiveBuffer.offset += var7;
                  NetCache.field3271 += var7;
                  if(var6 != FaceNormal.NetCache_responseArchiveBuffer.offset) {
                     if(NetCache.field3271 != 512) {
                        break;
                     }

                     NetCache.field3271 = 0;
                  } else {
                     if(16711935L == WorldMapEvent.NetCache_currentResponse.key) {
                        AbstractWorldMapIcon.NetCache_reference = FaceNormal.NetCache_responseArchiveBuffer;

                        for(var8 = 0; var8 < 256; ++var8) {
                           Archive var17 = NetCache.NetCache_archives[var8];
                           if(var17 != null) {
                              AbstractWorldMapIcon.NetCache_reference.offset = var8 * 8 + 5;
                              var10 = AbstractWorldMapIcon.NetCache_reference.readInt();
                              int var18 = AbstractWorldMapIcon.NetCache_reference.readInt();
                              var17.method4269(var10, var18);
                           }
                        }
                     } else {
                        NetCache.NetCache_crc.reset();
                        NetCache.NetCache_crc.update(FaceNormal.NetCache_responseArchiveBuffer.array, 0, var6);
                        var8 = (int)NetCache.NetCache_crc.getValue();
                        if(var8 != WorldMapEvent.NetCache_currentResponse.crc) {
                           try {
                              NetCache.NetCache_socket.vmethod5821();
                           } catch (Exception var20) {
                              ;
                           }

                           ++NetCache.NetCache_crcMismatches;
                           NetCache.NetCache_socket = null;
                           NetCache.field3287 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                           var10000 = false;
                           return var10000;
                        }

                        NetCache.NetCache_crcMismatches = 0;
                        NetCache.NetCache_ioExceptions = 0;
                        WorldMapEvent.NetCache_currentResponse.archive.method4297((int)(WorldMapEvent.NetCache_currentResponse.key & 65535L), FaceNormal.NetCache_responseArchiveBuffer.array, (WorldMapEvent.NetCache_currentResponse.key & 16711680L) == 16711680L, UserComparator10.field1809);
                     }

                     WorldMapEvent.NetCache_currentResponse.unlink();
                     if(UserComparator10.field1809) {
                        --NetCache.NetCache_pendingPriorityResponsesCount;
                     } else {
                        --NetCache.NetCache_pendingResponsesCount;
                     }

                     NetCache.field3271 = 0;
                     WorldMapEvent.NetCache_currentResponse = null;
                     FaceNormal.NetCache_responseArchiveBuffer = null;
                  }
               }
            }

            var10000 = true;
         } catch (IOException var21) {
            try {
               NetCache.NetCache_socket.vmethod5821();
            } catch (Exception var19) {
               ;
            }

            ++NetCache.NetCache_ioExceptions;
            NetCache.NetCache_socket = null;
            return false;
         }

         return var10000;
      }
   }

   static HorizontalAlignment[] method4161() {
      return new HorizontalAlignment[]{HorizontalAlignment.field3265, HorizontalAlignment.field3267, HorizontalAlignment.HorizontalAlignment_centered};
   }

   static int method4127(int var0) {
      return (int)Math.pow(2.0D, (double)(7.0F + (float)var0 / 256.0F));
   }

   static final void method4162(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = MusicPatchPcmStream.method3798(var0, var1, WorldMapRectangle.plane) - var2;
         var0 -= GrandExchangeOfferOwnWorldComparator.cameraX;
         var3 -= Varcs.cameraY;
         var1 -= WorldMapIcon_1.cameraZ;
         int var4 = Rasterizer3D.Rasterizer3D_sine[IgnoreList.cameraPitch];
         int var5 = Rasterizer3D.Rasterizer3D_cosine[IgnoreList.cameraPitch];
         int var6 = Rasterizer3D.Rasterizer3D_sine[WorldMapSection2.cameraYaw];
         int var7 = Rasterizer3D.Rasterizer3D_cosine[WorldMapSection2.cameraYaw];
         int var8 = var6 * var1 + var0 * var7 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var5 * var1 + var4 * var3 >> 16;
         if(var1 >= 50) {
            Client.viewportTempX = var0 * Client.viewportZoom / var1 + Client.viewportWidth / 2;
            Client.viewportTempY = Client.viewportHeight / 2 + var8 * Client.viewportZoom / var1;
         } else {
            Client.viewportTempX = -1;
            Client.viewportTempY = -1;
         }

      } else {
         Client.viewportTempX = -1;
         Client.viewportTempY = -1;
      }
   }
}
