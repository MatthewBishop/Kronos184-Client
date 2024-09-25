package net.runelite.standalone;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.Angle;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

public final class GameObject implements net.runelite.api.GameObject {
   static Sprite[] mapMarkerSprites;
   int plane;
   public long tag;
   int orientation;
   int startX;
   int centerY;
   int centerX;
   int height;
   int startY;
   public Entity entity;
   int flags;
   int lastDrawn;
   int field1718;
   int endY;
   int endX;

   GameObject() {
      this.tag = 0L;
      this.flags = 0;
   }

   public Point getCanvasLocation(int var1) {
      return Perspective.localToCanvas(ViewportMouse.client, this.getLocalLocation(), this.getPlane(), var1);
   }

   public Polygon getConvexHull() {
      Model var1 = this.getModel();
      if(var1 == null) {
         return null;
      } else {
         int var2 = Perspective.getTileHeight(ViewportMouse.client, new LocalPoint(this.getX(), this.getY()), ViewportMouse.client.getPlane());
         return var1.getConvexHull(this.getX(), this.getY(), this.getRsOrientation(), var2);
      }
   }

   @Override
   public long getHash() {
      return this.tag;
   }

   public Model getModel() {
      Entity var1 = this.getEntity();
      return var1 == null?null:(var1 instanceof Model ?(Model)var1:var1.getModel());
   }

   @Override
   public Entity getEntity() {
      return this.entity;
   }

   @Override
   public int getRsOrientation() {
      return this.orientation;
   }

   @Override
   public int getX() {
      return this.centerX;
   }

   public LocalPoint getLocalLocation() {
      return new LocalPoint(this.getX(), this.getY());
   }

   @Override
   public int getY() {
      return this.centerY;
   }

   @Override
   public int getPlane() {
      return this.plane;
   }

   public int getId() {
      long var1 = this.getHash();
      return (int)(var1 >>> 17 & 4294967295L);
   }

   public WorldPoint getWorldLocation() {
      return WorldPoint.fromLocal(ViewportMouse.client, this.getX(), this.getY(), this.getPlane());
   }

   public Point getCanvasLocation() {
      return this.getCanvasLocation(0);
   }

   public Polygon getCanvasTilePoly() {
      return Perspective.getCanvasTilePoly(ViewportMouse.client, this.getLocalLocation());
   }

   public Point getCanvasTextLocation(Graphics2D var1, String var2, int var3) {
      return Perspective.getCanvasTextLocation(ViewportMouse.client, var1, this.getLocalLocation(), var2, var3);
   }

   public Point getMinimapLocation() {
      return Perspective.localToMinimap(ViewportMouse.client, this.getLocalLocation());
   }

   public Point getSceneMinLocation() {
      return new Point(this.startX, this.startY);
   }

   public Point getSceneMaxLocation() {
      return new Point(this.endX, this.endY);
   }

   public Shape getClickbox() {
      return Perspective.getClickbox(ViewportMouse.client, this.getModel(), this.getRsOrientation(), this.getLocalLocation());
   }

   public Angle getOrientation() {
      int var1 = this.getRsOrientation();
      int var2 = this.flags >> 6 & 3;
      return new Angle(var1 + var2 * 512);
   }

}
