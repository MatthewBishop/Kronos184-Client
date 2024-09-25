package net.runelite.standalone;

import java.util.ArrayList;
import java.util.List;
import net.runelite.api.DecorativeObject;
import net.runelite.api.GroundObject;
import net.runelite.api.Point;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.DecorativeObjectChanged;
import net.runelite.api.events.DecorativeObjectDespawned;
import net.runelite.api.events.DecorativeObjectSpawned;
import net.runelite.api.events.GameObjectChanged;
import net.runelite.api.events.GameObjectDespawned;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GroundObjectChanged;
import net.runelite.api.events.GroundObjectDespawned;
import net.runelite.api.events.GroundObjectSpawned;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.events.WallObjectChanged;
import net.runelite.api.events.WallObjectDespawned;
import net.runelite.api.events.WallObjectSpawned;
import org.slf4j.Logger;

public final class Tile extends Node implements net.runelite.api.Tile {
   public static NodeDeque[][][] lastGroundItems;
   public static GameObject lastGameObject;
   static Archive archive13;
   int plane;
   int[] gameObjectEdgeMasks;
   TileModel model;
   BoundaryObject boundaryObject;
   TilePaint paint;
   int field1496;
   boolean drawSecondary;
   int y;
   int x;
   boolean drawPrimary;
   int drawGameObjectEdges;
   FloorDecoration floorDecoration;
   int originalPlane;
   int gameObjectsEdgeMask;
   GameObject[] gameObjects;
   int gameObjectsCount;
   public WallObject previousWallObject;
   public DecorativeObject previousDecorativeObject;
   public GroundObject previousGroundObject;
   public GameObject[] previousGameObjects;
   int minPlane;
   int field1501;
   boolean drawGameObjects;
   int field1482;
   TileItemPile tileItemPile;
   Tile linkedBelowTile;
   WallDecoration wallDecoration;

   static {
      lastGroundItems = new NodeDeque[4][104][104];
   }

   Tile(int var1, int var2, int var3) {
      this.gameObjects = new GameObject[5];
      this.gameObjectsChanged(-1);
      this.gameObjectEdgeMasks = new int[5];
      this.gameObjectsEdgeMask = 0;
      this.originalPlane = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @Override
   public int getPlane() {
      return this.plane;
   }

   @Override
   public net.runelite.api.TileItemPile getItemLayer() {
      return this.tileItemPile;
   }

   @Override
   public WallObject getWallObject() {
      return this.boundaryObject;
   }

   @Override
   public DecorativeObject getDecorativeObject() {
      return this.wallDecoration;
   }

   @Override
   public GroundObject getGroundObject() {
      return this.floorDecoration;
   }

   public void gameObjectsChanged(int var1) {
      if(var1 != -1) {
         if(this.previousGameObjects == null) {
            this.previousGameObjects = new GameObject[5];
         }

         GameObject var2 = this.previousGameObjects[var1];
         GameObject var3 = (GameObject)this.getGameObjects()[var1];
         this.previousGameObjects[var1] = var3;
         GameObject var4 = lastGameObject;
         lastGameObject = var3;
         if(var3 != var2) {
            if(var3 == null || var3 != var4) {
               boolean var5 = false;
               boolean var6 = false;
               Entity var7;
               if(var3 != null) {
                  var7 = var3.getEntity();
                  var5 = var7 instanceof NPC || var7 instanceof Projectile || var7 instanceof GraphicsObject;
               }

               if(var2 != null) {
                  var7 = var2.getEntity();
                  var6 = var7 instanceof NPC || var7 instanceof Projectile || var7 instanceof GraphicsObject;
               }

               Logger var9 = ViewportMouse.client.getLogger();
               if(var3 == null) {
                  if(var6) {
                     return;
                  }

                  var9.trace("Game object despawn: {}", Integer.valueOf(var2.getId()));
                  GameObjectDespawned var8 = new GameObjectDespawned();
                  var8.setTile(this);
                  var8.setGameObject(var2);
                  ViewportMouse.client.getCallbacks().post(GameObjectDespawned.class, var8);
               } else if(var2 == null) {
                  if(var5) {
                     return;
                  }

                  var9.trace("Game object spawn: {}", Integer.valueOf(var3.getId()));
                  GameObjectSpawned var10 = new GameObjectSpawned();
                  var10.setTile(this);
                  var10.setGameObject(var3);
                  ViewportMouse.client.getCallbacks().post(GameObjectSpawned.class, var10);
               } else {
                  if(var5 && var6) {
                     return;
                  }

                  var9.trace("Game object change: {} -> {}", Integer.valueOf(var2.getId()), Integer.valueOf(var3.getId()));
                  GameObjectChanged var11 = new GameObjectChanged();
                  var11.setTile(this);
                  var11.setPrevious(var2);
                  var11.setGameObject(var3);
                  ViewportMouse.client.getCallbacks().post(GameObjectChanged.class, var11);
               }

            }
         }
      }
   }

   @Override
   public net.runelite.api.GameObject[] getGameObjects() {
      return this.gameObjects;
   }

   public void wallObjectChanged(int var1) {
      WallObject var2 = this.previousWallObject;
      WallObject var3 = this.getWallObject();
      this.previousWallObject = var3;
      if(var3 == null && var2 != null) {
         WallObjectDespawned var6 = new WallObjectDespawned();
         var6.setTile(this);
         var6.setWallObject(var2);
         ViewportMouse.client.getCallbacks().post(WallObjectDespawned.class, var6);
      } else if(var3 != null && var2 == null) {
         WallObjectSpawned var5 = new WallObjectSpawned();
         var5.setTile(this);
         var5.setWallObject(var3);
         ViewportMouse.client.getCallbacks().post(WallObjectSpawned.class, var5);
      } else if(var3 != null) {
         WallObjectChanged var4 = new WallObjectChanged();
         var4.setTile(this);
         var4.setPrevious(var2);
         var4.setWallObject(var3);
         ViewportMouse.client.getCallbacks().post(WallObjectChanged.class, var4);
      }

   }

   public void decorativeObjectChanged(int var1) {
      DecorativeObject var2 = this.previousDecorativeObject;
      DecorativeObject var3 = this.getDecorativeObject();
      this.previousDecorativeObject = var3;
      if(var3 == null && var2 != null) {
         DecorativeObjectDespawned var6 = new DecorativeObjectDespawned();
         var6.setTile(this);
         var6.setDecorativeObject(var2);
         ViewportMouse.client.getCallbacks().post(DecorativeObjectDespawned.class, var6);
      } else if(var3 != null && var2 == null) {
         DecorativeObjectSpawned var5 = new DecorativeObjectSpawned();
         var5.setTile(this);
         var5.setDecorativeObject(var3);
         ViewportMouse.client.getCallbacks().post(DecorativeObjectSpawned.class, var5);
      } else if(var3 != null) {
         DecorativeObjectChanged var4 = new DecorativeObjectChanged();
         var4.setTile(this);
         var4.setPrevious(var2);
         var4.setDecorativeObject(var3);
         ViewportMouse.client.getCallbacks().post(DecorativeObjectChanged.class, var4);
      }

   }

   public void groundObjectChanged(int var1) {
      GroundObject var2 = this.previousGroundObject;
      GroundObject var3 = this.getGroundObject();
      this.previousGroundObject = var3;
      if(var3 == null && var2 != null) {
         GroundObjectDespawned var6 = new GroundObjectDespawned();
         var6.setTile(this);
         var6.setGroundObject(var2);
         ViewportMouse.client.getCallbacks().post(GroundObjectDespawned.class, var6);
      } else if(var3 != null && var2 == null) {
         GroundObjectSpawned var5 = new GroundObjectSpawned();
         var5.setTile(this);
         var5.setGroundObject(var3);
         ViewportMouse.client.getCallbacks().post(GroundObjectSpawned.class, var5);
      } else if(var3 != null) {
         GroundObjectChanged var4 = new GroundObjectChanged();
         var4.setTile(this);
         var4.setPrevious(var2);
         var4.setGroundObject(var3);
         ViewportMouse.client.getCallbacks().post(GroundObjectChanged.class, var4);
      }

   }

   public void itemLayerChanged(int var1) {
      int var2 = this.x;
      int var3 = this.y;
      int var4 = ViewportMouse.client.getPlane();
       NodeDeque[][][] var5 = Client.groundItems;
      NodeDeque var6 = lastGroundItems[var4][var2][var3];
      NodeDeque var7 = var5[var4][var2][var3];
      ItemDespawned var11;
      if(var6 != var7) {
         if(var6 != null) {
            Node var8 = var6.sentinel;

            for(Node var9 = var8.getNext(); var9 != var8; var9 = var9.getNext()) {
               TileItem var10 = (TileItem)var9;
               var11 = new ItemDespawned(this, var10);
               ViewportMouse.client.getCallbacks().post(ItemDespawned.class, var11);
            }
         }

         lastGroundItems[var4][var2][var3] = var7;
      }

      TileItem var18 = ViewportMouse.client.getLastItemDespawn();
      if(var18 != null) {
         ViewportMouse.client.setLastItemDespawn((TileItem)null);
      }

      TileItemPile var19 = (TileItemPile)this.getItemLayer();
      if(var19 == null) {
         if(var18 != null) {
            ItemDespawned var20 = new ItemDespawned(this, var18);
            ViewportMouse.client.getCallbacks().post(ItemDespawned.class, var20);
         }

      } else if(var7 == null) {
         if(var18 != null) {
            var11 = new ItemDespawned(this, var18);
            ViewportMouse.client.getCallbacks().post(ItemDespawned.class, var11);
         }

      } else {
         Node var21 = var7.sentinel;
         Object var12 = null;
         Node var13 = var21.getPrevious();
         boolean var14 = false;
         if(var21 != var13) {
            TileItem var15 = (TileItem)var13;
            if(var2 != var15.getX() || var3 != var15.getY()) {
               var12 = var15;
            }
         }

         Node var22 = var21.getNext();
         TileItem var16;
         if(var12 == null && var21 != var22) {
            var16 = (TileItem)var22;
            if(var2 != var16.getX() || var3 != var16.getY()) {
               var12 = var16;
               var14 = true;
            }
         }

         if(var18 != null && var18 != var13 && var18 != var22) {
            ItemDespawned var23 = new ItemDespawned(this, var18);
            ViewportMouse.client.getCallbacks().post(ItemDespawned.class, var23);
         }

         if(var12 != null) {
            do {
               var16 = (TileItem)var12;
               var16.setX(var2);
               var16.setY(var3);
               ItemSpawned var17 = new ItemSpawned(this, var16);
               ViewportMouse.client.getCallbacks().post(ItemSpawned.class, var17);
               var12 = var14?((Node)var12).getNext():((Node)var12).getPrevious();
            } while(var12 != var21 && (((TileItem)var12).getX() != var2 || ((TileItem)var12).getY() != var3));

         }
      }
   }

   public Point getSceneLocation() {
      return new Point(this.x, this.y);
   }

   public WorldPoint getWorldLocation() {
      return WorldPoint.fromScene(ViewportMouse.client, this.x, this.y, this.getPlane());
   }

   public LocalPoint getLocalLocation() {
      return LocalPoint.fromScene(this.x, this.y);
   }

   public boolean hasLineOfSightTo(net.runelite.api.Tile var1) {
      if(this.getPlane() != var1.getPlane()) {
         return false;
      } else {
         CollisionMap[] var2 = ViewportMouse.client.getCollisionMaps();
         if(var2 == null) {
            return false;
         } else {
            int var3 = this.getPlane();
            int[][] var4 = var2[var3].getFlags();
            Point var5 = this.getSceneLocation();
            Point var6 = var1.getSceneLocation();
            if(var5.getX() == var6.getX() && var5.getY() == var6.getY()) {
               return true;
            } else {
               int var7 = var6.getX() - var5.getX();
               int var8 = var6.getY() - var5.getY();
               int var9 = Math.abs(var7);
               int var10 = Math.abs(var8);
               int var11 = 131072;
               int var12 = 131072;
               if(var7 < 0) {
                  var11 |= 4096;
               } else {
                  var11 |= 65536;
               }

               if(var8 < 0) {
                  var12 |= 1024;
               } else {
                  var12 |= 16384;
               }

               int var13;
               int var14;
               int var15;
               int var16;
               int var17;
               int var18;
               if(var9 > var10) {
                  var13 = var5.getX();
                  var14 = var5.getY() << 16;
                  var15 = (var8 << 16) / var9;
                  var14 += 32768;
                  if(var8 < 0) {
                     --var14;
                  }

                  var16 = var7 < 0?-1:1;

                  while(var13 != var6.getX()) {
                     var13 += var16;
                     var17 = var14 >>> 16;
                     if((var4[var13][var17] & var11) != 0) {
                        return false;
                     }

                     var14 += var15;
                     var18 = var14 >>> 16;
                     if(var18 != var17 && (var4[var13][var18] & var12) != 0) {
                        return false;
                     }
                  }
               } else {
                  var13 = var5.getY();
                  var14 = var5.getX() << 16;
                  var15 = (var7 << 16) / var10;
                  var14 += 32768;
                  if(var7 < 0) {
                     --var14;
                  }

                  var16 = var8 < 0?-1:1;

                  while(var13 != var6.getY()) {
                     var13 += var16;
                     var17 = var14 >>> 16;
                     if((var4[var17][var13] & var12) != 0) {
                        return false;
                     }

                     var14 += var15;
                     var18 = var14 >>> 16;
                     if(var18 != var17 && (var4[var18][var13] & var11) != 0) {
                        return false;
                     }
                  }
               }

               return true;
            }
         }
      }
   }

   public List getGroundItems() {
      net.runelite.api.TileItemPile var1 = this.getItemLayer();
      if(var1 == null) {
         return null;
      } else {
         ArrayList var2 = new ArrayList();

         for(Object var3 = var1.getBottom(); var3 instanceof net.runelite.api.TileItem; var3 = ((net.runelite.api.Node)var3).getNext()) {
            var2.add((net.runelite.api.TileItem)var3);
         }

         return var2;
      }
   }

   @Override
   public int getRenderLevel() {
      return this.originalPlane;
   }

   @Override
   public net.runelite.api.TilePaint getTilePaint() {
      return this.paint;
   }

   @Override
   public net.runelite.api.TileModel getTileModel() {
      return this.model;
   }

   @Override
   public Tile getBridge() {
      return this.linkedBelowTile;
   }

   public static PacketBufferNode method2444() {
      PacketBufferNode var0;
      if(PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0) {
         var0 = new PacketBufferNode();
      } else {
         var0 = PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
      }

      var0.clientPacket = null;
      var0.clientPacketLength = 0;
      var0.packetBuffer = new PacketBuffer(5000);
      return var0;
   }
}
