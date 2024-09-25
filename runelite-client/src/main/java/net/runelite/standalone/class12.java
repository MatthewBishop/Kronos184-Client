package net.runelite.standalone;

final class class12 implements class16 {
   static AbstractArchive Widget_fontsArchive;
   static int selectedItemWidget;

   public Object vmethod210(Buffer var1) {
      return Long.valueOf(var1.method5502());
   }

   void method143(Long var1, Buffer var2) {
      var2.method5485(var1.longValue());
   }

   public void vmethod213(Object var1, Buffer var2) {
      this.method143((Long)var1, var2);
   }

   public static int method154(CharSequence var0, int var1) {
      return SoundCache.method2476(var0, var1, true);
   }

   public static int method153(long var0) {
      return (int)(var0 >>> 0 & 127L);
   }

   public static int method155(int var0) {
      return var0 >> 11 & 63;
   }

   static int method148(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.method6346(((long)var0.id << 32) + (long)var0.childIndex);
      return var1 != null?var1.integer:var0.clickMask;
   }
}
