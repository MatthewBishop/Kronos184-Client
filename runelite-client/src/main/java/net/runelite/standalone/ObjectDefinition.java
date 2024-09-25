package net.runelite.standalone;

public class ObjectDefinition extends DualNode implements net.runelite.api.ObjectDefinition {
   public static AbstractArchive ObjectDefinition_archive;
   public static EvictingDualNodeHashTable ObjectDefinition_cachedEntities;
   public static EvictingDualNodeHashTable ObjectDefinition_cachedModels;
   public static EvictingDualNodeHashTable ObjectDefinition_cachedModelData;
   public static EvictingDualNodeHashTable ObjectDefinition_cached;
   public static AbstractArchive ObjectDefinition_modelsArchive;
   public static boolean ObjectDefinition_isLowDetail;
   static ModelData[] field3461;
   short[] recolorFrom;
   public int int1;
   public int sizeX;
   short[] retextureTo;
   public int interactType;
   public int id;
   short[] recolorTo;
   public int mapIconId;
   public boolean clipped;
   int ambient;
   int offsetHeight;
   int transformVarbit;
   IterableNodeHashTable params;
   public int int4;
   public int ambientSoundId;
   public boolean boolean2;
   public int int5;
   boolean isSolid;
   int offsetX;
   public int[] transforms;
   int offsetY;
   int modelSizeY;
   public int mapSceneId;
   public int int3;
   boolean isRotated;
   int modelHeight;
   public int[] soundEffectIds;
   int transformVarp;
   public String[] actions;
   int modelSizeX;
   public int int6;
   int contrast;
   public String name;
   int[] models;
   public boolean modelClipped;
   short[] retextureFrom;
   int clipType;
   public int sizeY;
   public boolean boolean1;
   int[] modelIds;
   boolean nonFlatShading;
   public int int2;
   public int animationId;

   static {
      ObjectDefinition_isLowDetail = false;
      ObjectDefinition_cached = new EvictingDualNodeHashTable(4096);
      ObjectDefinition_cachedModelData = new EvictingDualNodeHashTable(500);
      ObjectDefinition_cachedEntities = new EvictingDualNodeHashTable(30);
      ObjectDefinition_cachedModels = new EvictingDualNodeHashTable(30);
      field3461 = new ModelData[4];
   }

   ObjectDefinition() {
      this.name = "null";
      this.sizeX = 1;
      this.sizeY = 1;
      this.interactType = 2;
      this.boolean1 = true;
      this.int1 = -1;
      this.clipType = -1;
      this.nonFlatShading = false;
      this.modelClipped = false;
      this.animationId = -1;
      this.int2 = 16;
      this.ambient = 0;
      this.contrast = 0;
      this.actions = new String[5];
      this.mapIconId = -1;
      this.mapSceneId = -1;
      this.isRotated = false;
      this.clipped = true;
      this.modelSizeX = 128;
      this.modelHeight = 128;
      this.modelSizeY = 128;
      this.offsetX = 0;
      this.offsetHeight = 0;
      this.offsetY = 0;
      this.boolean2 = false;
      this.isSolid = false;
      this.int3 = -1;
      this.transformVarbit = -1;
      this.transformVarp = -1;
      this.ambientSoundId = -1;
      this.int4 = 0;
      this.int5 = 0;
      this.int6 = 0;
   }

   void method4728() {
      if(this.int1 == -1) {
         this.int1 = 0;
         if(this.modelIds != null && (this.models == null || this.models[0] == 10)) {
            this.int1 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.int1 = 1;
            }
         }
      }

      if(this.int3 == -1) {
         this.int3 = this.interactType != 0?1:0;
      }

   }

   public String method4748(int var1, String var2) {
      return class94.method2216(this.params, var1, var2);
   }

   public final boolean method4721() {
      if(this.modelIds == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.modelIds.length; ++var2) {
            var1 &= ObjectDefinition_modelsArchive.method4024(this.modelIds[var2] & 65535, 0);
         }

         return var1;
      }
   }

   public final Entity method4755(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.models == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Object var9 = (Entity)ObjectDefinition_cachedEntities.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4719(var1, var2);
         if(var10 == null) {
            return null;
         }

         if(!this.nonFlatShading) {
            var9 = var10.method2778(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         } else {
            var10.ambient = (short)(this.ambient + 64);
            var10.contrast = (short)(this.contrast + 768);
            var10.method2774();
            var9 = var10;
         }

         ObjectDefinition_cachedEntities.method3034((DualNode)var9, var7);
      }

      if(this.nonFlatShading) {
         var9 = ((ModelData)var9).method2762();
      }

      if(this.clipType >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2354(var3, var4, var5, var6, true, this.clipType);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2763(var3, var4, var5, var6, true, this.clipType);
         }
      }

      return (Entity)var9;
   }

   public final boolean method4738(int var1) {
      if(this.models != null) {
         for(int var4 = 0; var4 < this.models.length; ++var4) {
            if(this.models[var4] == var1) {
               return ObjectDefinition_modelsArchive.method4024(this.modelIds[var4] & 65535, 0);
            }
         }

         return true;
      } else if(this.modelIds == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.modelIds.length; ++var3) {
            var2 &= ObjectDefinition_modelsArchive.method4024(this.modelIds[var3] & 65535, 0);
         }

         return var2;
      }
   }

   void method4716(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.modelIds != null && !ObjectDefinition_isLowDetail) {
               var1.offset += 3 * var3;
            } else {
               this.models = new int[var3];
               this.modelIds = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.modelIds[var4] = var1.readUnsignedShort();
                  this.models[var4] = var1.readUnsignedByte();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 5) {
         var3 = var1.readUnsignedByte();
         if(var3 > 0) {
            if(this.modelIds != null && !ObjectDefinition_isLowDetail) {
               var1.offset += var3 * 2;
            } else {
               this.models = null;
               this.modelIds = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.modelIds[var4] = var1.readUnsignedShort();
               }
            }
         }
      } else if(var2 == 14) {
         this.sizeX = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.sizeY = var1.readUnsignedByte();
      } else if(var2 == 17) {
         this.interactType = 0;
         this.boolean1 = false;
      } else if(var2 == 18) {
         this.boolean1 = false;
      } else if(var2 == 19) {
         this.int1 = var1.readUnsignedByte();
      } else if(var2 == 21) {
         this.clipType = 0;
      } else if(var2 == 22) {
         this.nonFlatShading = true;
      } else if(var2 == 23) {
         this.modelClipped = true;
      } else if(var2 == 24) {
         this.animationId = var1.readUnsignedShort();
         if(this.animationId == 65535) {
            this.animationId = -1;
         }
      } else if(var2 == 27) {
         this.interactType = 1;
      } else if(var2 == 28) {
         this.int2 = var1.readUnsignedByte();
      } else if(var2 == 29) {
         this.ambient = var1.readByte();
      } else if(var2 == 39) {
         this.contrast = var1.readByte() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.recolorFrom = new short[var3];
         this.recolorTo = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.recolorFrom[var4] = (short)var1.readUnsignedShort();
            this.recolorTo[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.retextureFrom = new short[var3];
         this.retextureTo = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.retextureFrom[var4] = (short)var1.readUnsignedShort();
            this.retextureTo[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 62) {
         this.isRotated = true;
      } else if(var2 == 64) {
         this.clipped = false;
      } else if(var2 == 65) {
         this.modelSizeX = var1.readUnsignedShort();
      } else if(var2 == 66) {
         this.modelHeight = var1.readUnsignedShort();
      } else if(var2 == 67) {
         this.modelSizeY = var1.readUnsignedShort();
      } else if(var2 == 68) {
         this.mapSceneId = var1.readUnsignedShort();
      } else if(var2 == 69) {
         var1.readUnsignedByte();
      } else if(var2 == 70) {
         this.offsetX = var1.g2s();
      } else if(var2 == 71) {
         this.offsetHeight = var1.g2s();
      } else if(var2 == 72) {
         this.offsetY = var1.g2s();
      } else if(var2 == 73) {
         this.boolean2 = true;
      } else if(var2 == 74) {
         this.isSolid = true;
      } else if(var2 == 75) {
         this.int3 = var1.readUnsignedByte();
      } else if(var2 != 77 && var2 != 92) {
         if(var2 == 78) {
            this.ambientSoundId = var1.readUnsignedShort();
            this.int4 = var1.readUnsignedByte();
         } else if(var2 == 79) {
            this.int5 = var1.readUnsignedShort();
            this.int6 = var1.readUnsignedShort();
            this.int4 = var1.readUnsignedByte();
            var3 = var1.readUnsignedByte();
            this.soundEffectIds = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.soundEffectIds[var4] = var1.readUnsignedShort();
            }
         } else if(var2 == 81) {
            this.clipType = var1.readUnsignedByte() * 256;
         } else if(var2 == 82) {
            this.mapIconId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.params = UserComparator5.method3374(var1, this.params);
         }
      } else {
         this.transformVarbit = var1.readUnsignedShort();
         if(this.transformVarbit == 65535) {
            this.transformVarbit = -1;
         }

         this.transformVarp = var1.readUnsignedShort();
         if(this.transformVarp == 65535) {
            this.transformVarp = -1;
         }

         var3 = -1;
         if(var2 == 92) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.transforms = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.transforms[var5] = var1.readUnsignedShort();
            if(this.transforms[var5] == 65535) {
               this.transforms[var5] = -1;
            }
         }

         this.transforms[var4 + 1] = var3;
      }

   }

   void method4717(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4716(var1, var2);
      }
   }

   public final Model method4723(int var1, int var2, int[][] var3, int var4, int var5, int var6, SequenceDefinition var7, int var8) {
      long var9;
      if(this.models == null) {
         var9 = (long)(var2 + (this.id << 10));
      } else {
         var9 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var11 = (Model)ObjectDefinition_cachedModels.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method4719(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2778(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         ObjectDefinition_cachedModels.method3034(var11, var9);
      }

      if(var7 == null && this.clipType == -1) {
         return var11;
      } else {
         if(var7 != null) {
            var11 = var7.method4662(var11, var8, var2, (byte)2);
         } else {
            var11 = var11.toSharedModel(true);
         }

         if(this.clipType >= 0) {
            var11 = var11.method2354(var3, var4, var5, var6, false, this.clipType);
         }

         return var11;
      }
   }

   public boolean method4727() {
      if(this.transforms == null) {
         return this.ambientSoundId != -1 || this.soundEffectIds != null;
      } else {
         for(int var1 = 0; var1 < this.transforms.length; ++var1) {
            if(this.transforms[var1] != -1) {
               ObjectDefinition var2 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(this.transforms[var1]);
               if(var2.ambientSoundId != -1 || var2.soundEffectIds != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public int method4725(int var1, int var2) {
      return HealthBar.getParam(this.params, var1, var2);
   }

   public final ObjectDefinition method4733() {
      int var1 = -1;
      if(this.transformVarbit != -1) {
         var1 = WorldMapSprite.getVarbit(this.transformVarbit);
      } else if(this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if(var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1?GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var2):null;
   }

   @Override
   public int getId() {
      return this.id;
   }

   @Override
   public String getName() {
      return this.name;
   }

   @Override
   public String[] getActions() {
      return this.actions;
   }

   @Override
   public int getMapIconId() {
      return this.mapIconId;
   }

   @Override
   public int getMapSceneId() {
      return this.mapSceneId;
   }

   @Override
   public int[] getImpostorIds() {
      return this.transforms;
   }

   @Override
   public ObjectDefinition getImpostor() {
      return this.method4733();
   }

   final ModelData method4719(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(this.models == null) {
         if(var1 != 10) {
            return null;
         }

         if(this.modelIds == null) {
            return null;
         }

         var4 = this.isRotated;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.modelIds.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.modelIds[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)ObjectDefinition_cachedModelData.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2823(ObjectDefinition_modelsArchive, var7 & 65535, 0);
               if(var3 == null) {
                  return null;
               }

               if(var4) {
                  var3.method2772();
               }

               ObjectDefinition_cachedModelData.method3034(var3, (long)var7);
            }

            if(var5 > 1) {
               field3461[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field3461, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.models.length; ++var5) {
            if(this.models[var5] == var1) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.modelIds[var9];
         boolean var10 = this.isRotated ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)ObjectDefinition_cachedModelData.get((long)var5);
         if(var3 == null) {
            var3 = ModelData.method2823(ObjectDefinition_modelsArchive, var5 & 65535, 0);
            if(var3 == null) {
               return null;
            }

            if(var10) {
               var3.method2772();
            }

            ObjectDefinition_cachedModelData.method3034(var3, (long)var5);
         }
      }

      if(this.modelSizeX == 128 && this.modelHeight == 128 && this.modelSizeY == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.offsetX == 0 && this.offsetHeight == 0 && this.offsetY == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, this.recolorFrom == null, null == this.retextureFrom, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2765(256);
         var8.method2784(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2833();
      } else if(var2 == 2) {
         var8.method2759();
      } else if(var2 == 3) {
         var8.method2798();
      }

      if(this.recolorFrom != null) {
         for(var7 = 0; var7 < this.recolorFrom.length; ++var7) {
            var8.method2770(this.recolorFrom[var7], this.recolorTo[var7]);
         }
      }

      if(this.retextureFrom != null) {
         for(var7 = 0; var7 < this.retextureFrom.length; ++var7) {
            var8.method2831(this.retextureFrom[var7], this.retextureTo[var7]);
         }
      }

      if(var4) {
         var8.method2773(this.modelSizeX, this.modelHeight, this.modelSizeY);
      }

      if(var11) {
         var8.method2784(this.offsetX, this.offsetHeight, this.offsetY);
      }

      return var8;
   }

   public final Model method4722(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.models == null) {
         var7 = (long)(var2 + (this.id << 10));
      } else {
         var7 = (long)(var2 + (var1 << 3) + (this.id << 10));
      }

      Model var9 = (Model)ObjectDefinition_cachedModels.get(var7);
      if(var9 == null) {
         ModelData var10 = this.method4719(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2778(this.ambient + 64, this.contrast + 768, -50, -10, -50);
         ObjectDefinition_cachedModels.method3034(var9, var7);
      }

      if(this.clipType >= 0) {
         var9 = var9.method2354(var3, var4, var5, var6, true, this.clipType);
      }

      return var9;
   }

   void postDecode() {
      if (id == 10060) {
         name = "Trading Post";
         actions[0] = "Open";
         actions[1] = "Coffer";
        actions[2] = "Guide";
      } else if(id == 1534) {
         /* home room curtains */
         actions[0] = null;
      } else if(id == 18258) {
         /* custom altar */
         actions[0] = "Pray-at";
         actions[1] = "Spellbook";
      } else if(id == 11833) {
         actions[1] = "Practice";
      } else if(id == 32758) {
         name = "Loyalty Chest";
         actions[0] = "Loot";
         actions[1] = "About";
         actions[2] = null;
         actions[3] = null;
         actions[4] = null;
      } else if(id == 3192) {
         name = "PvP Leaderboard";
         actions[0] = "Edge PKing";
         actions[1] = "Deep Wild PKing";
         actions[2] = null;
         actions[3] = null;
         actions[4] = null;
      } else if(id == 32759) {
         name = "Loyalty Chest";
         actions[0] = null;
         actions[1] = null;
         actions[2] = null;
         actions[3] = null;
         actions[4] = null;
      } else if(id == 31379) { //is this obj ever used?????????
         name = "Donation table";
         int1 = 1;
         sizeX = sizeY = 2;
         boolean2 = false;
         int3 = 1;
         transforms = null;
         modelIds = new int[]{32153};
         transformVarbit = -1;
      } else if(id == 25203) { // decapitated elvarg corpse
         actions[0] = "Loot";
      } else if(id == 29226) {
         name = "Pet list";
         actions[4] = null;
      } else if(id == 6045) {
         actions[0] = "Dump-ore";
      } else if(id == 3581) {
         name = "Ticket exchange";
         actions[0] = "Use";
      } else if(id == 11508 || id == 11509) {
         //curtain
         clipType = 0;
      } else if (id == 31618) { // home portal
         name = "World Portal";
         actions[0] = "Teleport";
         actions[1] = "Teleport-previous";
      } else if(id == 31380) {
         //uhh i hope 31380 isn't ever used
         name = "Rejuvenation pool";
         int1 = 1;
         sizeX = sizeY = 2;
         animationId = 7304;
         int4 = 3;
         boolean1 = false;
         actions[0] = "Drink";
         ambientSoundId = 2149;
         clipType = 1;
         boolean2 = false;
         transforms = null;
         ambient = 40;
         modelIds = new int[]{32101};
         transformVarbit = -1;
      } else if(id == 30352) {
         name = "test";
         actions[1] = "Practice";
      } else if(id == 539) {
         name = "Donator Area";
      } else if(id == 33114) {
         name = "PvP Supply Chest";
         actions[0] = "Check-timer";
      } else if(id == 33115) {
         name = "PvP Supply Chest";
      } else if(id == 31583) {
         name = "PvP Supply Chest";
      } else if(id == 32572) {
         name = "Bloody Chest";
         actions[1] = "Information";
      } else if(id == 32573) {
         name = "Bloody Chest";
         actions[0] = null;
         actions[1] = null;
         actions[2] = null;
         actions[3] = null;
         actions[4] = null;
      } else if (id == 30169) { // Dagannoth kings crack
         actions[0] = "Instance";
         actions[1] = "Peek";
      } else if (id == 1816) { // KBD Lever
         actions[1] = "Instance";
         actions[2] = "Commune";
      } else if (id == 535) { // Thermonuclear smoke devil crevice
         actions[1] = "Instance";
         actions[2] = "Peek";
      } else if (id == 23104) { // Cerberus iron winch
         actions[1] = "Instance";
         actions[2] = "Peek";
      } else if (id == 29705) { // KQ Crack
         actions[0] = "Instance";
         actions[1] = "Peek";
      } else if (id >= 26502 && id <= 26505) { // GWD boss doors
         actions[1] = "Instance";
         actions[2] = "Peek";
      } else if (id == 4407) { // pvm instance portal
         name = "Boss instance portal";
         actions[0] = "Use";
      } else if(id == 19038) { //christmas tree
         name = "Christmas tree";
         actions[0] = "Grab-present";
      } else if(id == 29709) {
         name = "Snowball Exchange";
         actions[0] = "Open";
         actions[1] = "Information";
      } else if (id == 40000) {
         copy(32546);
         name = "Giveaway booth";
         actions[0] = "Use";
      } else if(id == 40001) {
         copy(4525);
         actions[0] = "Exit";
         actions[1] = null;
         actions[4] = null;
      } else if(id == 40002) {
         copy(32424);
         name = "Consumables";
      } else if(id == 40003) {
         copy(32425);
         name = "Equipment";
      } else if(id == 28925) {
         name = "Fun PVP Portal";
      } else if(id == 31622) {
         name = "Ket'ian Wilderness Boss Portal";
      } else if(id == 31621) {
         name = "Wilderness Portal";
      } else if(id == 31626) {
         name = "Tournament Entrance";
      } else if(id == 2654) {
         name = "Bloody Fountain";
         actions[0] = "Drink";
         actions[1] = null;
         modelHeight = 200;
         modelSizeX = 200;
         modelSizeY = 200;
         sizeX = 3;
         sizeY = 3;
      } else if(id == 4470) {
         name = "Donator Zone";
         actions[0] = "Enter";
      } else if(id == 40004) {
         copy(29241);
         actions[4] = null;
      } else if(id == 40005) {
         copy(31858);
         actions[0] = "Pray-at";
         actions[1] = "Spellbook";
         actions[2] = null;
         actions[3] = null;
         actions[4] = null;
      } else if(id == 40006) {
         copy(4537);
         actions[4] = null;
      } else if(id == 40007) {
         copy(13619);
         name = "Fun PVP Portal";
         actions[4] = null;
      } else if(id == 40008) {
         copy(20839);
         name = "Tournament Barrier";
         actions[0] = "Use";
      } else if(id == 40009) {
         copy(26714);
         name = "Mounted Max Cape";
         actions[0] = null;
         actions[1] = null;
         actions[2] = null;
         actions[3] = null;
         actions[4] = null;
      } else if(id == 31846) {
         name = "Tournament Information";
         actions[0] = "Read";
      } else if(id == 29087) {
         name = "Ticket Exchange";
         actions[0] = "Use";
      } else if(id == 172) {
         name = "Crystal Chest";
      } else if (id == 27290) {
         name = "PK Chest";
      } else if (id == 4390) {
         name = "Donator Zone portal";
      }
   }

   private void copy(int id) {
      ObjectDefinition from = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(id);
      name = from.name;
      sizeX = from.sizeX;
      sizeY = from.sizeY;
      clipType = from.clipType;
      boolean1 = from.boolean1;
      int1 = from.int1;
      clipType = from.clipType;
      nonFlatShading = from.nonFlatShading;
      modelClipped = from.modelClipped;
      animationId = from.animationId;
      int2 = from.int2;
      ambient = from.ambient;
      contrast = from.contrast;
      actions = from.actions;
      mapIconId = from.mapIconId;
      mapSceneId = from.mapSceneId;
      isRotated = from.isRotated;
      clipped = from.clipped;
      modelSizeX = from.modelSizeX;
      modelHeight = from.modelHeight;
      modelSizeY = from.modelSizeY;
      offsetX = from.offsetX;
      offsetHeight = from.offsetHeight;
      offsetY = from.offsetY;
      boolean2 = from.boolean2;
      isSolid = from.isSolid;
      int3 = from.int3;
      transformVarbit = from.transformVarbit;
      transformVarp = from.transformVarp;
      ambientSoundId = from.ambientSoundId;
      int4 = from.int4;
      int5 = from.int5;
      int6 = from.int6;
      modelIds = from.modelIds;
   }
}
