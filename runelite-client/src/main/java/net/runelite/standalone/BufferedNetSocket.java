package net.runelite.standalone;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;

public class BufferedNetSocket extends AbstractSocket {
   public static int cacheGamebuild;
   BufferedSource source;
   BufferedSink sink;
   Socket socket;

   public BufferedNetSocket(Socket var1, int var2, int var3) throws IOException {
      this.socket = var1;
      this.socket.setSoTimeout(30000);
      this.socket.setTcpNoDelay(true);
      this.socket.setReceiveBufferSize(65536);
      this.socket.setSendBufferSize(65536);
      this.source = new BufferedSource(this.socket.getInputStream(), var2);
      this.sink = new BufferedSink(this.socket.getOutputStream(), var3);
   }

   public int vmethod5815() throws IOException {
      return this.source.method5799();
   }

   public void vmethod5817(byte[] var1, int var2, int var3) throws IOException {
      this.sink.method5789(var1, var2, var3);
   }

   public int vmethod5832(byte[] var1, int var2, int var3) throws IOException {
      return this.source.method5800(var1, var2, var3);
   }

   public boolean vmethod5816(int var1) throws IOException {
      return this.source.method5797(var1);
   }

   public int vmethod5838() throws IOException {
      return this.source.method5810();
   }

   public void vmethod5821() {
      this.sink.method5783();

      try {
         this.socket.close();
      } catch (IOException var2) {
         ;
      }

      this.source.method5801();
   }

   protected void finalize() {
      this.vmethod5821();
   }

   protected void aav() {
      this.vmethod5821();
   }

   protected void aao() {
      this.vmethod5821();
   }

   static boolean method5242() {
      try {
         if(class37.World_request == null) {
            class37.World_request = Client.urlRequester.method3050(new URL(WorldMapSectionType.field59));
         } else if(class37.World_request.isDone()) {
            byte[] bytes = class37.World_request.response();
            Buffer buffer = new Buffer(bytes);
            buffer.readInt();
            World.World_count = buffer.readUnsignedShort();
            World.World_worlds = new World[World.World_count];
            World world;
            for(int var2 = 0; var2 < World.World_count; world.index = var2++) {
               world = World.World_worlds[var2] = new World();
               world.id = buffer.readUnsignedShort();
               world.properties = buffer.readInt();
               world.host = buffer.readString();
               world.activity = buffer.readString();
               world.location = buffer.readUnsignedByte();
               world.population = buffer.g2s();
               world.playerCountChanged(-1);
            }

            WorldMapData_0.method170(World.World_worlds, 0, World.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
            class37.World_request = null;
            boolean var10000 = true;
            return var10000;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class37.World_request = null;
      }

      return false;
   }
}
