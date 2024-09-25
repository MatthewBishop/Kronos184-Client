package net.runelite.standalone;

import java.awt.Component;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public final class MouseWheelHandler implements MouseWheel, MouseWheelListener {
   int rotation;

   MouseWheelHandler() {
      this.rotation = 0;
   }

   void method733(Component var1) {
      var1.removeMouseWheelListener(this);
   }

   public synchronized int vmethod3454() {
      int var1 = this.rotation;
      this.rotation = 0;
      return var1;
   }

   void method734(Component var1) {
      var1.addMouseWheelListener(this);
   }

   public synchronized void copy$mouseWheelMoved(MouseWheelEvent var1) {
      this.rotation += var1.getWheelRotation();
   }

   public synchronized void mouseWheelMoved(MouseWheelEvent var1) {
      var1 = ViewportMouse.client.getCallbacks().mouseWheelMoved(var1);
      if(!var1.isConsumed()) {
         this.copy$mouseWheelMoved(var1);
      }

   }
}
