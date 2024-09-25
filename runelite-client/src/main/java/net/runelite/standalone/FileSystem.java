package net.runelite.standalone;

import java.io.File;
import java.util.Hashtable;

public class FileSystem {
   public static File FileSystem_cacheDir;
   static Hashtable FileSystem_cacheFiles;
   public static boolean FileSystem_hasPermissions;

   static {
      FileSystem_hasPermissions = false;
      FileSystem_cacheFiles = new Hashtable(16);
   }
}
