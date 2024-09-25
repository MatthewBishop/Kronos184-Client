package net.runelite.standalone;

public class WorldMapArchiveLoader {
   AbstractArchive archive;
   int percentLoaded;
   String cacheName;
   boolean loaded;

   WorldMapArchiveLoader(AbstractArchive var1) {
      this.percentLoaded = 0;
      this.loaded = false;
      this.archive = var1;
   }

   int method6238() {
      if(this.percentLoaded < 33) {
         if(!this.archive.method4022(WorldMapCacheName.field248.name, this.cacheName)) {
            return this.percentLoaded;
         }

         this.percentLoaded = 33;
      }

      if(this.percentLoaded == 33) {
         if(this.archive.method4108(WorldMapCacheName.field242.name, this.cacheName) && !this.archive.method4022(WorldMapCacheName.field242.name, this.cacheName)) {
            return this.percentLoaded;
         }

         this.percentLoaded = 66;
      }

      if(this.percentLoaded == 66) {
         if(!this.archive.method4022(this.cacheName, WorldMapCacheName.field246.name)) {
            return this.percentLoaded;
         }

         this.percentLoaded = 100;
         this.loaded = true;
      }

      return this.percentLoaded;
   }

   int method6241() {
      return this.percentLoaded;
   }

   boolean method6240() {
      return this.loaded;
   }

   void method6239(String var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(var1 != this.cacheName) {
            this.cacheName = var1;
            this.percentLoaded = 0;
            this.loaded = false;
            this.method6238();
         }
      }
   }
}
