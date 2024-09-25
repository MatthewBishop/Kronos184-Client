package net.runelite.standalone;

import java.applet.Applet;

public class RunException extends RuntimeException {
   public static String localPlayerName;
   public static int[] SpriteBuffer_spriteHeights;
   public static int RunException_revision;
   public static Applet RunException_applet;
   static SoundSystem soundSystem;
   Throwable throwable;
   String message;

   RunException(Throwable var1, String var2) {
      this.message = var2;
      this.throwable = var1;
   }

}
