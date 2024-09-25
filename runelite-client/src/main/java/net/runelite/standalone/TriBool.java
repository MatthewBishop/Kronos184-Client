package net.runelite.standalone;

public class TriBool {
   public static final TriBool TriBool_true;
   public static final TriBool TriBool_false;
   public static final TriBool TriBool_unknown;

   static {
      TriBool_unknown = new TriBool();
      TriBool_true = new TriBool();
      TriBool_false = new TriBool();
   }
}
