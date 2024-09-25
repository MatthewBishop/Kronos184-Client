package net.runelite.standalone;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Area;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

public final class TileItemPile implements net.runelite.api.TileItemPile {
   int tileHeight;
   Entity third;
   long tag;
   Entity second;
   int y;
   int x;
   Entity first;
   public int itemLayerPlane;
   int height;

   public Point getCanvasLocation(int var1) {
      return Perspective.localToCanvas(ViewportMouse.client, this.getLocalLocation(), this.getPlane(), var1);
   }

   public Area getClickbox() {
      throw new UnsupportedOperationException();
   }

   @Override
   public Entity getBottom() {
      return this.first;
   }

   @Override
   public Entity getMiddle() {
      return this.second;
   }

   @Override
   public Entity getTop() {
      return this.third;
   }

   @Override
   public long getHash() {
      return this.tag;
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
      return this.itemLayerPlane;
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
      this.itemLayerPlane = var1;
   }

   public net.runelite.api.Model getModelBottom() {
      Entity var1 = this.getBottom();
      return var1 == null?null:(var1 instanceof net.runelite.api.Model?(net.runelite.api.Model)var1:var1.getModel());
   }

   public net.runelite.api.Model getModelMiddle() {
      Entity var1 = this.getMiddle();
      return var1 == null?null:(var1 instanceof net.runelite.api.Model?(net.runelite.api.Model)var1:var1.getModel());
   }

   public net.runelite.api.Model getModelTop() {
      Entity var1 = this.getTop();
      return var1 == null?null:(var1 instanceof net.runelite.api.Model?(net.runelite.api.Model)var1:var1.getModel());
   }

   @Override
   public int getHeight() {
      return this.height;
   }
}
