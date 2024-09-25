package net.runelite.standalone;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public abstract class UserList<T extends User> {
   User[] array;
   HashMap usernamesMap;
   int size;
   final int capacity;
   Comparator comparator;
   HashMap previousUsernamesMap;

   UserList(int var1) {
      this.size = 0;
      this.comparator = null;
      this.capacity = var1;
      this.array = this.vmethod5186(var1);
      this.usernamesMap = new HashMap(var1 / 8);
      this.previousUsernamesMap = new HashMap(var1 / 8);
   }

   abstract User[] vmethod5186(int var1);

   public boolean method4822() {
      return this.capacity == this.size;
   }

   public final boolean method4802(Username var1) {
      User var2 = this.method4815(var1);
      if(var2 == null) {
         return false;
      } else {
         this.method4842(var2);
         return true;
      }
   }

   User method4815(Username var1) {
      return !var1.method4991()?null:(User)this.usernamesMap.get(var1);
   }

   abstract User vmethod5179();

   public boolean isMember(Username var1) {
      return !var1.method4991()?false:(this.usernamesMap.containsKey(var1)?true:this.previousUsernamesMap.containsKey(var1));
   }

   final int method4787(User var1) {
      for(int var2 = 0; var2 < this.size; ++var2) {
         if(this.array[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   final void method4783(User var1) {
      this.usernamesMap.put(var1.username, var1);
      if(var1.previousUsername != null) {
         User var2 = (User)this.previousUsernamesMap.put(var1.previousUsername, var1);
         if(var2 != null && var2 != var1) {
            var2.previousUsername = null;
         }
      }

   }

   final void method4780(User var1, Username var2, Username var3) {
      this.method4782(var1);
      var1.method4882(var2, var3);
      this.method4783(var1);
   }

   public final void method4789(Comparator var1) {
      if(this.comparator == null) {
         this.comparator = var1;
      } else if(this.comparator instanceof AbstractUserComparator) {
         ((AbstractUserComparator)this.comparator).method5007(var1);
      }

   }

   final void method4782(User var1) {
      if(this.usernamesMap.remove(var1.username) == null) {
         throw new IllegalStateException();
      } else {
         if(var1.previousUsername != null) {
            this.previousUsernamesMap.remove(var1.previousUsername);
         }

      }
   }

   final void method4776(User var1) {
      this.array[++this.size - 1] = var1;
   }

   public final void method4788() {
      this.comparator = null;
   }

   final void method4785(int var1) {
      --this.size;
      if(var1 < this.size) {
         System.arraycopy(this.array, var1 + 1, this.array, var1, this.size - var1);
      }

   }

   public int getCount() {
      return this.size;
   }

   public void method4767() {
      this.size = 0;
      Arrays.fill(this.array, (Object)null);
      this.usernamesMap.clear();
      this.previousUsernamesMap.clear();
   }

   /**
    * Method called by the container when an element is added
    * @param var1
    * @param var2
    */
   public void rl$add(Username var1, Username var2) {
   }

   /**
    * Method called by the container when an element is removed
    * @param var1
    */
   public void rl$remove(User var1) {
   }

   public void remove(User var1) {
      this.rl$remove(var1);
   }

   public void add(Username var1, Username var2) {
      this.rl$add(var1, var2);
   }

   User method4777(Username var1, Username var2) {
      if(this.method4815(var1) != null) {
         throw new IllegalStateException();
      } else {
         User var3 = this.vmethod5179();
         var3.method4882(var1, var2);
         this.method4776(var3);
         this.method4783(var3);
         this.add(var1, var2);
         return var3;
      }
   }

   public User findByName(Username var1) {
      User var2 = this.method4815(var1);
      return var2 != null?var2:this.method4773(var1);
   }

   final void method4842(User var1) {
      this.remove(var1);
      int var2 = this.method4787(var1);
      if(var2 != -1) {
         this.method4785(var2);
         this.method4782(var1);
      }
   }

   User method4773(Username var1) {
      return !var1.method4991()?null:(User)this.previousUsernamesMap.get(var1);
   }

   User method4833(Username var1) {
      return this.method4777(var1, (Username)null);
   }

   public final void method4766() {
      if(this.comparator == null) {
         Arrays.sort(this.array, 0, this.size);
      } else {
         Arrays.sort(this.array, 0, this.size, this.comparator);
      }

   }

   public final User method4778(int var1) {
      if(var1 >= 0 && var1 < this.size) {
         return this.array[var1];
      } else {
         throw new ArrayIndexOutOfBoundsException(var1);
      }
   }
}
