package net.runelite.standalone;

public class WorldMapIcon_1 extends AbstractWorldMapIcon {
   static boolean mouseCam;
   static byte[][] regionLandArchives;
   static int cameraZ;
   final WorldMapRegion region;
   int subHeight;
   int subWidth;
   WorldMapLabel label;
   int element;
   final int objectDefId;

   WorldMapIcon_1(Coord var1, Coord var2, int var3, WorldMapRegion var4) {
      super(var1, var2);
      this.objectDefId = var3;
      this.region = var4;
      this.method2259();
   }

   WorldMapLabel vmethod2273() {
      return this.label;
   }

   int vmethod2257() {
      return this.subHeight;
   }

   int vmethod2269() {
      return this.subWidth;
   }

   public int vmethod2277() {
      return this.element;
   }

   void method2259() {
      this.element = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(this.objectDefId).method4733().mapIconId;
      this.label = this.region.method248(Decimator.method2498(this.element));
      WorldMapElement var1 = Decimator.method2498(this.vmethod2277());
      Sprite var2 = var1.method4369(false);
      if(var2 != null) {
         this.subWidth = var2.subWidth;
         this.subHeight = var2.subHeight;
      } else {
         this.subWidth = 0;
         this.subHeight = 0;
      }

   }

   static final void method2278() {
      FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
      FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
      KitDefinition.KitDefinition_cached.clear();
      ObjectDefinition.ObjectDefinition_cached.clear();
      ObjectDefinition.ObjectDefinition_cachedModelData.clear();
      ObjectDefinition.ObjectDefinition_cachedEntities.clear();
      ObjectDefinition.ObjectDefinition_cachedModels.clear();
      NPCDefinition.NpcDefinition_cached.clear();
      NPCDefinition.NpcDefinition_cachedModels.clear();
      InterfaceParent.method1138();
      SequenceDefinition.SequenceDefinition_cached.clear();
      SequenceDefinition.SequenceDefinition_cachedFrames.clear();
      class213.method3933();
      VarbitDefinition.VarbitDefinition_cached.clear();
      MusicPatch.method3761();
      GrandExchangeEvent.method6483();
      HealthBarDefinition.HealthBarDefinition_cached.clear();
      HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
      StructDefinition.StructDefinition_cached.clear();
      TextureProvider.method2859();
      WorldMapElement.WorldMapElement_cachedSprites.clear();
      UserComparator1.method6398();
      Widget.Widget_cachedSprites.clear();
      Widget.Widget_cachedModels.clear();
      Widget.Widget_cachedFonts.clear();
      Widget.Widget_cachedSpriteMasks.clear();
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).method2845();
      Script.Script_cached.clear();
      class4.archive0.method4036();
      WorldMapLabelSize.archive1.method4036();
      BoundaryObject.archive3.method4036();
      GrandExchangeOfferAgeComparator.archive4.method4036();
      class11.archive5.method4036();
      class212.archive6.method4036();
      Language.archive7.method4036();
      GrandExchangeOfferAgeComparator.archive8.method4036();
      AttackOption.archive9.method4036();
      Client.archive10.method4036();
      ClanMate.archive11.method4036();
      GrandExchangeOfferOwnWorldComparator.archive12.method4036();
   }
}
