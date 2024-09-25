package net.runelite.standalone;

import java.util.Locale;

public class Language implements Enumerated {
   static final Language Language_DE;
   public static final Language Language_ES;
   static final Language Language_ES_MX;
   static final Language Language_NL;
   static final Language Language_PT;
   public static final Language Language_FR;
   public static final Language Language_EN;
   static IndexedSprite[] worldSelectFlagSprites;
   static final Language[] Language_valuesOrdered;
   static Archive archive7;
   final String language;
   final int id;
   final String field2207;

   static {
      Language_EN = new Language("EN", "en", "English", class198.field2191, 0, "GB");
      Language_DE = new Language("DE", "de", "German", class198.field2191, 1, "DE");
      Language_FR = new Language("FR", "fr", "French", class198.field2191, 2, "FR");
      Language_PT = new Language("PT", "pt", "Portuguese", class198.field2191, 3, "BR");
      Language_NL = new Language("NL", "nl", "Dutch", class198.field2182, 4, "NL");
      Language_ES = new Language("ES", "es", "Spanish", class198.field2182, 5, "ES");
      Language_ES_MX = new Language("ES_MX", "es-mx", "Spanish (Latin American)", class198.field2191, 6, "MX");
      Language[] var0 = method3837();
      Language_valuesOrdered = new Language[var0.length];
      Language[] var1 = var0;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Language var3 = var1[var2];
         if(Language_valuesOrdered[var3.id] != null) {
            throw new IllegalStateException();
         }

         Language_valuesOrdered[var3.id] = var3;
      }

   }

   Language(String var1, String var2, String var3, class198 var4, int var5, String var6) {
      this.field2207 = var1;
      this.language = var2;
      this.id = var5;
      if(var6 != null) {
         new Locale(var2.substring(0, 2), var6);
      } else {
         new Locale(var2.substring(0, 2));
      }

   }

   String method3819() {
      return this.language;
   }

   public int getId() {
      return this.id;
   }

   public String toString() {
      return this.method3819().toLowerCase(Locale.ENGLISH);
   }

   public String aae() {
      return this.method3819().toLowerCase(Locale.ENGLISH);
   }

   public String aah() {
      return this.method3819().toLowerCase(Locale.ENGLISH);
   }

   public String aak() {
      return this.method3819().toLowerCase(Locale.ENGLISH);
   }

   public static boolean method3835(long var0) {
      boolean var2 = 0L != var0;
      if(var2) {
         boolean var3 = (int)(var0 >>> 16 & 1L) == 1;
         var2 = !var3;
      }

      return var2;
   }

   public static Language method3820(int var0) {
      return var0 >= 0 && var0 < Language_valuesOrdered.length?Language_valuesOrdered[var0]:null;
   }

   static void method3830() {
      AccessFile var0 = null;

      try {
         var0 = class202.method3853("", class10.field66.name, true);
         Buffer var1 = AbstractArchive.clientPreferences.method1145();
         var0.method14(var1.array, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method0(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   static Language[] method3837() {
      return new Language[]{Language_PT, Language_EN, Language_NL, Language_ES, Language_FR, Language_ES_MX, Language_DE};
   }
}
