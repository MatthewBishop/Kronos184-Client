package net.runelite.standalone;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;

import net.runelite.api.GroundObject;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

public final class FloorDecoration implements GroundObject {
   public static int canvasWidth;
   int tileHeight;
   int flags;
   public long tag;
   int y;
   int x;
   public Entity entity;
   public int groundObjectPlane;

   public Point getCanvasLocation(int var1) {
      return Perspective.localToCanvas(ViewportMouse.client, this.getLocalLocation(), this.getPlane(), var1);
   }

   public Polygon getConvexHull() {
      Model var1 = this.getModel();
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

   public Model getModel() {
      Entity var1 = this.getEntity();
      return var1 == null?null:(var1 instanceof net.runelite.api.Model?(Model)var1:var1.getModel());
   }

   @Override
   public Entity getEntity() {
      return this.entity;
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
      return this.groundObjectPlane;
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
      this.groundObjectPlane = var1;
   }

   public Shape getClickbox() {
      return Perspective.getClickbox(ViewportMouse.client, this.getModel(), 0, this.getLocalLocation());
   }

   public static ServerBuild method2433(int var0) {
      ServerBuild[] var1 = new ServerBuild[]{ServerBuild.BUILDLIVE, ServerBuild.LIVE, ServerBuild.RC, ServerBuild.WIP};
      ServerBuild[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         ServerBuild var4 = var2[var3];
         if(var0 == var4.field2757) {
            return var4;
         }
      }

      return null;
   }

   static final void method2432(int var0, int var1, int var2, int var3, Sprite var4, SpriteMask var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.camAngleY & 2047;
         int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
         int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.width / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         PendingSpawn.redHintArrowSprite.method6125(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         class214.method3936(var0, var1, var2, var3, var4, var5);
      }

   }
}
