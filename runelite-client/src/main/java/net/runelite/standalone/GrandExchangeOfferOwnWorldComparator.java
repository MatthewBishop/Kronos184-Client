package net.runelite.standalone;

import java.io.File;
import java.util.Comparator;

public class GrandExchangeOfferOwnWorldComparator implements Comparator {
   static int field344;
   public static AbstractArchive KitDefinition_modelsArchive;
   public static File cacheDir;
   static Archive archive12;
   static Font fontPlain11;
   static int cameraX;
   static Widget field345;
   boolean filterWorlds;

   int method811(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if(var2.world == var1.world) {
         return 0;
      } else {
         if(this.filterWorlds) {
            if(Client.worldId == var1.world) {
               return -1;
            }

            if(var2.world == Client.worldId) {
               return 1;
            }
         }

         return var1.world < var2.world?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method811((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   static Message method823(int var0) {
      return (Message)Messages.Messages_hashTable.get((long)var0);
   }

   public static ObjectDefinition getObjectDefinition(int var0) {
      ObjectDefinition var1 = (ObjectDefinition)ObjectDefinition.ObjectDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectDefinition.ObjectDefinition_archive.method4020(6, var0, (short)-5157);
         var1 = new ObjectDefinition();
         var1.id = var0;
         if(var2 != null) {
            var1.method4717(new Buffer(var2));
            //TODO: Custom Object Definitions
            var1.postDecode();
         }

         var1.method4728();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.boolean1 = false;
         }

         ObjectDefinition.ObjectDefinition_cached.method3034(var1, (long)var0);
         return var1;
      }
   }
}
