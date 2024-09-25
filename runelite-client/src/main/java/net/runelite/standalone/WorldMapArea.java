package net.runelite.standalone;

import java.util.Iterator;
import java.util.LinkedList;

import net.runelite.api.WorldMapData;

public class WorldMapArea implements WorldMapData {
   static int field140;
   String internalName;
   Coord origin;
   int regionLowX;
   int zoom;
   int backGroundColor;
   String externalName;
   int regionLowY;
   int id;
   LinkedList sections;
   boolean isMain;
   int regionHighY;
   int regionHighX;

   public WorldMapArea() {
      this.id = -1;
      this.backGroundColor = -1;
      this.zoom = -1;
      this.origin = null;
      this.regionLowX = Integer.MAX_VALUE;
      this.regionHighX = 0;
      this.regionLowY = Integer.MAX_VALUE;
      this.regionHighY = 0;
      this.isMain = false;
   }

   WorldMapSection method423(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      WorldMapSectionType[] var3 = new WorldMapSectionType[]{WorldMapSectionType.WORLDMAPSECTIONTYPE0, WorldMapSectionType.WORLDMAPSECTIONTYPE2, WorldMapSectionType.WORLDMAPSECTIONTYPE3, WorldMapSectionType.WORLDMAPSECTIONTYPE1};
      WorldMapSectionType var4 = (WorldMapSectionType)NetSocket.getEnumeratedTypeIndex(var3, var2);
      Object section = null;
      switch(var4.type) {
      case 0:
         section = new WorldMapSection2();
         break;
      case 1:
         section = new class30();
         break;
      case 2:
         section = new WorldMapSection0();
         break;
      case 3:
         section = new WorldMapSection1();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSection) section).decode(var1);
      return (WorldMapSection) section;
   }

   public int method359() {
      return this.zoom;
   }

   public Coord method352(int var1, int var2) {
      Iterator var3 = this.sections.iterator();

      WorldMapSection var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSection)var3.next();
      } while(!var4.vmethod5844(var1, var2));

      return var4.vmethod5846(var1, var2);
   }

   void method351() {
      Iterator var1 = this.sections.iterator();

      while(var1.hasNext()) {
         WorldMapSection var2 = (WorldMapSection)var1.next();
         var2.vmethod5850(this);
      }

   }

   public int[] method369(int var1, int var2, int var3) {
      Iterator var4 = this.sections.iterator();

      WorldMapSection var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSection)var4.next();
      } while(!var5.vmethod5843(var1, var2, var3));

      return var5.vmethod5845(var1, var2, var3);
   }

   public int method392() {
      return this.origin.x;
   }

   public boolean method350(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.regionLowX && var3 <= this.regionHighX) {
         if(var4 >= this.regionLowY && var4 <= this.regionHighY) {
            Iterator var5 = this.sections.iterator();

            WorldMapSection var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSection)var5.next();
            } while(!var6.vmethod5844(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public boolean method361(int var1, int var2, int var3) {
      Iterator var4 = this.sections.iterator();

      WorldMapSection var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSection)var4.next();
      } while(!var5.vmethod5843(var1, var2, var3));

      return true;
   }

   public int method362() {
      return this.regionLowY;
   }

   public boolean method405() {
      return this.isMain;
   }

   public void decode(Buffer var1, int var2) {
      this.id = var2;
      this.internalName = var1.readString();
      this.externalName = var1.readString();
      this.origin = new Coord(var1.readInt());
      this.backGroundColor = var1.readInt();
      var1.readUnsignedByte();
      this.isMain = var1.readUnsignedByte() == 1;
      this.zoom = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.sections = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.sections.add(this.method423(var1));
      }

      this.method351();
   }

   public int method360() {
      return this.regionLowX;
   }

   int method358() {
      return this.backGroundColor;
   }

   public String method357() {
      return this.externalName;
   }

   @Override
   public boolean surfaceContainsPosition(int var1, int var2) {
      return this.method350(var1, var2);
   }

   public Coord method367() {
      return new Coord(this.origin);
   }

   public int method410() {
      return this.regionHighX;
   }

   public int method353() {
      return this.origin.plane;
   }

   public int method363() {
      return this.regionHighY;
   }

   public String method356() {
      return this.internalName;
   }

   public int method414() {
      return this.origin.y;
   }

   public int method354() {
      return this.id;
   }

   static void method424(int var0, ArchiveDisk var1, Archive var2) {
      byte[] var3 = null;
      NodeDeque var4 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
         for(ArchiveDiskAction var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var5 != null; var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
            if((long)var0 == var5.key && var1 == var5.archiveDisk && var5.type == 0) {
               var3 = var5.data;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4287(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method5306(var0);
         var2.method4287(var1, var0, var8, true);
      }
   }

   public static void method425(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2) {
      HitSplatDefinition.HitSplatDefinition_archive = var0;
      GrandExchangeOfferNameComparator.field321 = var1;
      HitSplatDefinition.HitSplatDefinition_fontsArchive = var2;
   }
}
