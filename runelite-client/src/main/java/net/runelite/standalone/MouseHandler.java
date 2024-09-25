package net.runelite.standalone;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener, FocusListener {
   public static int MouseHandler_y;
   static volatile int MouseHandler_currentButtonVolatile;
   static volatile int MouseHandler_xVolatile;
   public static volatile int MouseHandler_idleCycles;
   public static long MouseHandler_lastPressedTimeMillis;
   static volatile long MouseHandler_lastPressedTimeMillisVolatile;
   static MouseHandler MouseHandler_instance;
   static volatile int MouseHandler_lastPressedYVolatile;
   public static int MouseHandler_lastPressedX;
   public static long MouseHandler_millis;
   static volatile int MouseHandler_lastButtonVolatile;
   public static int MouseHandler_x;
   public static int MouseHandler_currentButton;
   static volatile int MouseHandler_lastPressedXVolatile;
   public static int MouseHandler_lastButton;
   static int[] regions;
   public static int MouseHandler_lastPressedY;
   static volatile long MouseHandler_lastMovedVolatile;
   static volatile int MouseHandler_yVolatile;
   public int isInEvent;

   static {
      MouseHandler_instance = new MouseHandler();
      MouseHandler_idleCycles = 0;
      MouseHandler_currentButtonVolatile = 0;
      MouseHandler_xVolatile = -1;
      MouseHandler_yVolatile = -1;
      MouseHandler_lastMovedVolatile = -1L;
      MouseHandler_currentButton = 0;
      MouseHandler_x = 0;
      MouseHandler_y = 0;
      MouseHandler_millis = 0L;
      MouseHandler_lastButtonVolatile = 0;
      MouseHandler_lastPressedXVolatile = 0;
      MouseHandler_lastPressedYVolatile = 0;
      MouseHandler_lastPressedTimeMillisVolatile = 0L;
      MouseHandler_lastButton = 0;
      MouseHandler_lastPressedX = 0;
      MouseHandler_lastPressedY = 0;
      MouseHandler_lastPressedTimeMillis = 0L;
   }

   final int method833(MouseEvent var1) {
      int var2 = var1.getButton();
      return !var1.isAltDown() && var2 != 2?(!var1.isMetaDown() && var2 != 3?1:2):4;
   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(this.isInEvent == 0) {
         var1 = ViewportMouse.client.getCallbacks().mouseMoved(var1);
      }

      if(!var1.isConsumed()) {
         ++this.isInEvent;

         try {
            this.copy$mouseMoved(var1);
         } finally {
            --this.isInEvent;
         }
      }

   }

   public final void copy$mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void copy$mousePressed(MouseEvent var1) {
      if(MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_lastPressedXVolatile = var1.getX();
         MouseHandler_lastPressedYVolatile = var1.getY();
         MouseHandler_lastPressedTimeMillisVolatile = class33.method680();
         MouseHandler_lastButtonVolatile = this.method833(var1);
         if(MouseHandler_lastButtonVolatile != 0) {
            MouseHandler_currentButtonVolatile = MouseHandler_lastButtonVolatile;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void copy$mouseReleased(MouseEvent var1) {
      if(MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_currentButtonVolatile = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void copy$mouseEntered(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   public final synchronized void copy$mouseExited(MouseEvent var1) {
      if(MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_xVolatile = -1;
         MouseHandler_yVolatile = -1;
         MouseHandler_lastMovedVolatile = var1.getWhen();
      }

   }

   public final synchronized void copy$mouseDragged(MouseEvent var1) {
      this.mouseMoved(var1);
   }

   public final synchronized void copy$mouseMoved(MouseEvent var1) {
      if(MouseHandler_instance != null) {
         MouseHandler_idleCycles = 0;
         MouseHandler_xVolatile = var1.getX();
         MouseHandler_yVolatile = var1.getY();
         MouseHandler_lastMovedVolatile = var1.getWhen();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(this.isInEvent == 0) {
         var1 = ViewportMouse.client.getCallbacks().mouseReleased(var1);
      }

      if(!var1.isConsumed()) {
         ++this.isInEvent;

         try {
            this.copy$mouseReleased(var1);
         } finally {
            --this.isInEvent;
         }
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      var1 = ViewportMouse.client.getCallbacks().mouseClicked(var1);
      if(!var1.isConsumed()) {
         this.copy$mouseClicked(var1);
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(this.isInEvent == 0) {
         var1 = ViewportMouse.client.getCallbacks().mouseDragged(var1);
      }

      if(!var1.isConsumed()) {
         ++this.isInEvent;

         try {
            this.copy$mouseDragged(var1);
         } finally {
            --this.isInEvent;
         }
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(MouseHandler_instance != null) {
         MouseHandler_currentButtonVolatile = 0;
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(this.isInEvent == 0) {
         var1 = ViewportMouse.client.getCallbacks().mouseEntered(var1);
      }

      if(!var1.isConsumed()) {
         ++this.isInEvent;

         try {
            this.copy$mouseEntered(var1);
         } finally {
            --this.isInEvent;
         }
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(this.isInEvent == 0) {
         var1 = ViewportMouse.client.getCallbacks().mouseExited(var1);
      }

      if(!var1.isConsumed()) {
         ++this.isInEvent;

         try {
            this.copy$mouseExited(var1);
         } finally {
            --this.isInEvent;
         }
      }

   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(this.isInEvent == 0) {
         var1 = ViewportMouse.client.getCallbacks().mousePressed(var1);
      }

      if(!var1.isConsumed()) {
         ++this.isInEvent;

         try {
            this.copy$mousePressed(var1);
         } finally {
            --this.isInEvent;
         }
      }

   }
}
