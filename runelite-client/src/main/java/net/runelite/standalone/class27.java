package net.runelite.standalone;

import java.applet.Applet;

import netscape.javascript.JSObject;

public class class27 {
   public static Object method539(Applet var0, String var1) throws Throwable {
      return JSObject.getWindow(var0).call(var1, (Object[])null);
   }

   public static void method538(Applet var0, String var1) throws Throwable {
      JSObject.getWindow(var0).eval(var1);
   }
}
