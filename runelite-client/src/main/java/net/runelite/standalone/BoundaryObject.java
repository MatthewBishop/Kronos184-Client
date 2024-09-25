package net.runelite.standalone;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.WallObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

public final class BoundaryObject implements WallObject {
   static Archive archive3;
   int tileHeight;
   public Entity entity1;
   public Entity entity2;
   int orientationB;
   int y;
   int x;
   int flags;
   int orientationA;
   public int wallPlane;
   public long tag;

   BoundaryObject() {
      this.tag = 0L;
      this.flags = 0;
   }

   public Point getCanvasLocation(int var1) {
      return Perspective.localToCanvas(ViewportMouse.client, this.getLocalLocation(), this.getPlane(), var1);
   }

   public Polygon getConvexHull() {
      Model var1 = this.getModelA();
      if(var1 == null) {
         return null;
      } else {
         int var2 = Perspective.getTileHeight(ViewportMouse.client, new LocalPoint(this.getX(), this.getY()), ViewportMouse.client.getPlane());
         return var1.getConvexHull(this.getX(), this.getY(), 0, var2);
      }
   }

   @Override
   public long getHash() {
      return this.tag;
   }

   public Model getModelB() {
      Entity var1 = this.getEntity2();
      return var1 == null?null:(var1 instanceof net.runelite.api.Model?(Model)var1:var1.getModel());
   }

   @Override
   public Entity getEntity2() {
      return this.entity2;
   }

   public Model getModelA() {
      Entity var1 = this.getEntity1();
      return var1 == null?null:(var1 instanceof net.runelite.api.Model?(Model)var1:var1.getModel());
   }

   @Override
   public Entity getEntity1() {
      return this.entity1;
   }

   @Override
   public int getX() {
      return this.x;
   }

   public LocalPoint getLocalLocation() {
      return new LocalPoint(this.getX(), this.getY());
   }

   @Override
   public int getY() {
      return this.y;
   }

   public int getPlane() {
      return this.wallPlane;
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

   public void setPlane(int var1) {
      this.wallPlane = var1;
   }

   public Shape getClickbox() {
      Shape var1 = Perspective.getClickbox(ViewportMouse.client, this.getModelA(), 0, this.getLocalLocation());
      Shape var2 = Perspective.getClickbox(ViewportMouse.client, this.getModelB(), 0, this.getLocalLocation());
      return var1 == null && var2 == null?null:(var1 != null?var1:var2);
   }

   @Override
   public int getOrientationA() {
      return this.orientationA;
   }

   @Override
   public int getOrientationB() {
      return this.orientationB;
   }

   @Override
   public int getConfig() {
      return this.flags;
   }

   static final boolean method3062(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }
}
