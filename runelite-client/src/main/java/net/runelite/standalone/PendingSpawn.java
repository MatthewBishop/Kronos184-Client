package net.runelite.standalone;

public final class PendingSpawn extends Node {
   static Sprite redHintArrowSprite;
   int plane;
   int field632;
   int field631;
   int y;
   int x;
   int type;
   int orientation;
   int objectId;
   int hitpoints;
   int delay;
   int field626;
   int id;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }
}
