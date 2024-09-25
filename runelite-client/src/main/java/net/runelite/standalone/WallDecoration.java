package net.runelite.standalone;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Area;

import net.runelite.api.DecorativeObject;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;

public final class WallDecoration implements DecorativeObject {
   public static int canvasHeight;
   int tileHeight;
   int xOffset;
   int yOffset;
   int orientation2;
   int y;
   int x;
   public Entity entity2;
   int orientation;
   int flags;
   public int decorativeObjectPlane;
   public long tag;
   public Entity entity1;

   WallDecoration() {
      this.tag = 0L;
      this.flags = 0;
   }

   public Point getCanvasLocation(int var1) {
      return Perspective.localToCanvas(ViewportMouse.client, this.getLocalLocation(), this.getPlane(), var1);
   }

   public Polygon getConvexHull() {
      Model var1 = this.getModel1();
      if(var1 == null) {
         return null;
      } else {
         int var2 = Perspective.getTileHeight(ViewportMouse.client, new LocalPoint(this.getX(), this.getY()), ViewportMouse.client.getPlane());
         return var1.getConvexHull(this.getX() + this.getXOffset(), this.getY() + this.getYOffset(), 0, var2);
      }
   }

   public Polygon getConvexHull2() {
      Model var1 = this.getModel2();
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

   public Model getModel1() {
      Entity var1 = this.getEntity1();
      if(var1 == null) {
         return null;
      } else {
         Model var2;
         if(var1 instanceof net.runelite.api.Model) {
            var2 = (Model)var1;
         } else {
            var2 = var1.getModel();
         }

         return var2;
      }
   }

   public Model getModel2() {
      Entity var1 = this.getEntity2();
      if(var1 == null) {
         return null;
      } else {
         Model var2;
         if(var1 instanceof net.runelite.api.Model) {
            var2 = (Model)var1;
         } else {
            var2 = var1.getModel();
         }

         return var2;
      }
   }

   @Override
   public Entity getEntity1() {
      return this.entity1;
   }

   @Override
   public Entity getEntity2() {
      return this.entity2;
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
      return this.decorativeObjectPlane;
   }

   @Override
   public int getXOffset() {
      return this.xOffset;
   }

   @Override
   public int getYOffset() {
      return this.yOffset;
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
      this.decorativeObjectPlane = var1;
   }

   public Shape getClickbox() {
      new Area();
      LocalPoint var2 = this.getLocalLocation();
      Shape var3 = Perspective.getClickbox(ViewportMouse.client, this.getModel1(), 0, new LocalPoint(var2.getX() + this.getXOffset(), var2.getY() + this.getYOffset()));
      Shape var4 = Perspective.getClickbox(ViewportMouse.client, this.getModel2(), 0, var2);
      return var3 == null && var4 == null?null:(var3 != null?var3:var4);
   }

   @Override
   public int getOrientation() {
      return this.orientation2;
   }

   public static ParamDefinition method2913(int var0) {
      ParamDefinition var1 = (ParamDefinition)ParamDefinition.ParamDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ParamDefinition.ParamDefinition_archive.method4020(11, var0, (short)-887);
         var1 = new ParamDefinition();
         if(var2 != null) {
            var1.method4311(new Buffer(var2));
         }

         var1.method4310();
         ParamDefinition.ParamDefinition_cached.method3034(var1, (long)var0);
         return var1;
      }
   }

   static final void method2914() {
      for(int var0 = 0; var0 < Client.npcCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.npcs[var1];
         if(var2 != null) {
            class329.method6315(var2, var2.definition.size);
         }
      }

   }
}
