package net.runelite.standalone;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import net.runelite.api.Point;
import net.runelite.api.WidgetNode;
import net.runelite.api.events.WidgetHiddenChanged;
import net.runelite.api.events.WidgetPositioned;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;

public class Widget extends Node implements net.runelite.api.widgets.Widget {

   public static EvictingDualNodeHashTable Widget_cachedSprites;
   public static boolean field2576;
   public static EvictingDualNodeHashTable Widget_cachedSpriteMasks;
   static AbstractArchive Widget_archive;
   public static EvictingDualNodeHashTable Widget_cachedModels;
   // $FF: synthetic field
   public static boolean $assertionsDisabled;
   public static int rl$widgetLastPosChanged;
   public static EvictingDualNodeHashTable Widget_cachedFonts;
   public int type;
   public int id;
   public int rawWidth;
   public int y;
   public int heightAlignment;
   public int parentId;
   public int color;
   public int transparencyBot;
   public int mouseOverColor2;
   public int mouseOverColor;
   public int scrollX;
   public boolean fill;
   public int scrollY;
   public int field2662;
   public int scrollHeight;
   public boolean isHidden;
   public int field2688;
   public int rawHeight;
   public int scrollWidth;
   public int x;
   public int height;
   public int lineWid;
   public int transparencyTop;
   public int color2;
   public int rawY;
   public int width;
   public FillMode fillMode;
   public int rawX;
   public int modelId;
   public int modelOffsetX;
   public boolean spriteFlipH;
   public int spriteId;
   int modelId2;
   public int field2634;
   public boolean modelOrthog;
   public int spriteId2;
   public int sequenceId2;
   public int outline;
   public int modelType;
   public int field2700;
   public int spriteAngle;
   int modelType2;
   public int modelAngleZ;
   public int itemQuantityMode;
   public int modelAngleY;
   public int modelZoom;
   public int spriteShadow;
   public int modelOffsetY;
   public int sequenceId;
   public boolean spriteTiling;
   public boolean modelTransparency;
   public boolean field2612;
   public int modelAngleX;
   public boolean spriteFlipV;
   public int[] field2619;
   public int[] inventoryYOffsets;
   public byte[][] field2654;
   public int paddingX;
   public byte[][] field2585;
   public int[] field2581;
   public int textYAlignment;
   public int clickMask;
   public int[] inventoryXOffsets;
   public String text;
   public int rl$x;
   public int rl$y;
   public int rl$parentId;
   public boolean textShadowed;
   public int textLineHeight;
   public int[] inventorySprites;
   public int textXAlignment;
   public String[] itemActions;
   public boolean field2652;
   public String text2;
   public int paddingY;
   public int fontId;
   public int xAlignment;
   public int[] varTransmitTriggers;
   public Object[] onStatTransmit;
   public Object[] onRelease;
   public Object[] onTargetEnter;
   public String spellActionName;
   public boolean hasListener;
   public Object[] onVarTransmit;
   public int[] invTransmitTriggers;
   public Object[] onHold;
   public Object[] onTargetLeave;
   public Object[] onMouseOver;
   public Object[] onInvTransmit;
   public Widget parent;
   public int dragZoneSize;
   public Object[] onDrag;
   public int[] statTransmitTriggers;
   public int dragThreshold;
   public Object[] onLoad;
   public Object[] onClickRepeat;
   public String dataText;
   public Object[] onClick;
   public String[] actions;
   public Object[] onDragComplete;
   public Object[] onMouseRepeat;
   public boolean isScrollBar;
   public Object[] onMouseLeave;
   public int modelFrame;
   public Widget[] children;
   public String buttonText;
   public int[] itemQuantities;
   public String[][] itemAttributes;
   public Object[] onMiscTransmit;
   public Object[] onOp;
   public Object[] onStockTransmit;
   public int[] cs1Comparisons;
   public Object[] onSubChange;
   public Object[] field2695;
   public Object[] onTimer;
   public int itemQuantity;
   public int[] cs1ComparisonValues;
   public int[][] cs1Instructions;
   public Object[] onClanTransmit;
   public Object[] onDialogAbort;
   public Object[] onKey;
   public Object[] onFriendTransmit;
   public Object[] onResize;
   public int modelFrameCycle;
   public int[] itemIds;
   public int mouseOverRedirect;
   public Object[] onScroll;
   public Object[] onChatTransmit;
   public int itemId;
   public String spellName;
   public int buttonType;
   public boolean containsMouse;
   public int[] field2717;
   public int field2591;
   public boolean isClicked;
   public int field2713;
   public boolean field2720;
   public int rootIndex;
   public boolean noScrollThrough;
   public int field2714;
   public int cycle;
   public boolean noClickThrough;
   public int field2653;
   public boolean isIf3;
   public int childIndex;
   public int contentType;
   public int widthAlignment;
   public int yAlignment;

   static {
      Widget_cachedSprites = new EvictingDualNodeHashTable(200);
      Widget_cachedModels = new EvictingDualNodeHashTable(50);
      Widget_cachedFonts = new EvictingDualNodeHashTable(20);
      Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(8);
      field2576 = false;
      rl$$clinit();
   }

   public Widget() {
      this.isIf3 = false;
      this.id = -1;
      this.childIndex = -1;
      this.buttonType = 0;
      this.contentType = 0;
      this.xAlignment = 0;
      this.yAlignment = 0;
      this.widthAlignment = 0;
      this.heightAlignment = 0;
      this.rawX = 0;
      this.rawY = 0;
      this.rawWidth = 0;
      this.rawHeight = 0;
      this.x = 0;
      this.y = 0;
      this.onPositionChanged(-1);
      this.width = 0;
      this.height = 0;
      this.field2688 = 1;
      this.field2662 = 1;
      this.parentId = -1;
      this.isHidden = false;
      this.onHiddenChanged(-1);
      this.scrollX = 0;
      this.scrollY = 0;
      this.scrollWidth = 0;
      this.scrollHeight = 0;
      this.color = 0;
      this.color2 = 0;
      this.mouseOverColor = 0;
      this.mouseOverColor2 = 0;
      this.fill = false;
      this.fillMode = FillMode.SOLID;
      this.transparencyTop = 0;
      this.transparencyBot = 0;
      this.lineWid = 1;
      this.field2612 = false;
      this.spriteId2 = -1;
      this.spriteId = -1;
      this.spriteAngle = 0;
      this.spriteTiling = false;
      this.outline = 0;
      this.spriteShadow = 0;
      this.modelType = 1;
      this.modelId = -1;
      this.modelType2 = 1;
      this.modelId2 = -1;
      this.sequenceId = -1;
      this.sequenceId2 = -1;
      this.modelOffsetX = 0;
      this.modelOffsetY = 0;
      this.modelAngleX = 0;
      this.modelAngleY = 0;
      this.modelAngleZ = 0;
      this.modelZoom = 100;
      this.field2700 = 0;
      this.field2634 = 0;
      this.modelOrthog = false;
      this.modelTransparency = false;
      this.itemQuantityMode = 2;
      this.fontId = -1;
      this.text = "";
      this.text2 = "";
      this.textLineHeight = 0;
      this.textXAlignment = 0;
      this.textYAlignment = 0;
      this.textShadowed = false;
      this.paddingX = 0;
      this.paddingY = 0;
      this.clickMask = 0;
      this.field2652 = false;
      this.dataText = "";
      this.parent = null;
      this.dragZoneSize = 0;
      this.dragThreshold = 0;
      this.isScrollBar = false;
      this.spellActionName = "";
      this.hasListener = false;
      this.mouseOverRedirect = -1;
      this.spellName = "";
      this.buttonText = "Ok";
      this.itemId = -1;
      this.itemQuantity = 0;
      this.modelFrame = 0;
      this.modelFrameCycle = 0;
      this.containsMouse = false;
      this.isClicked = false;
      this.field2591 = -1;
      this.field2653 = 0;
      this.field2713 = 0;
      this.field2714 = 0;
      this.rootIndex = -1;
      this.cycle = -1;
      this.noClickThrough = false;
      this.noScrollThrough = false;
      this.field2720 = false;
      this.rl$$init();
   }

    public Sprite method3973(int var1) {
      field2576 = false;
      if(var1 >= 0 && var1 < this.inventorySprites.length) {
         int var2 = this.inventorySprites[var1];
         if(var2 == -1) {
            return null;
         } else {
            Sprite var3 = (Sprite)Widget_cachedSprites.get((long)var2);
            if(var3 != null) {
               return var3;
            } else {
               var3 = NPCDefinition.method4417(ClientPreferences.Widget_spritesArchive, var2, 0, -1092680498);
               if(var3 != null) {
                  Widget_cachedSprites.method3034(var3, (long)var2);
               } else {
                  field2576 = true;
               }

               return var3;
            }
         }
      } else {
         return null;
      }
   }

   void method3966(Buffer var1) {
      this.isIf3 = false;
      this.type = var1.readUnsignedByte();
      this.buttonType = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.rawX = var1.g2s();
      this.rawY = var1.g2s();
      this.rawWidth = var1.readUnsignedShort();
      this.rawHeight = var1.readUnsignedShort();
      this.transparencyTop = var1.readUnsignedByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.mouseOverRedirect = var1.readUnsignedShort();
      if(this.mouseOverRedirect == 65535) {
         this.mouseOverRedirect = -1;
      }

      int var2 = var1.readUnsignedByte();
      int var3;
      if(var2 > 0) {
         this.cs1Comparisons = new int[var2];
         this.cs1ComparisonValues = new int[var2];

         for(var3 = 0; var3 < var2; ++var3) {
            this.cs1Comparisons[var3] = var1.readUnsignedByte();
            this.cs1ComparisonValues[var3] = var1.readUnsignedShort();
         }
      }

      var3 = var1.readUnsignedByte();
      int var4;
      int var5;
      int var6;
      if(var3 > 0) {
         this.cs1Instructions = new int[var3][];

         for(var4 = 0; var4 < var3; ++var4) {
            var5 = var1.readUnsignedShort();
            this.cs1Instructions[var4] = new int[var5];

            for(var6 = 0; var6 < var5; ++var6) {
               this.cs1Instructions[var4][var6] = var1.readUnsignedShort();
               if(this.cs1Instructions[var4][var6] == 65535) {
                  this.cs1Instructions[var4][var6] = -1;
               }
            }
         }
      }

      if(this.type == 0) {
         this.scrollHeight = var1.readUnsignedShort();
         this.isHidden = var1.readUnsignedByte() == 1;
         this.onHiddenChanged(-1);
      }

      if(this.type == 1) {
         var1.readUnsignedShort();
         var1.readUnsignedByte();
      }

      if(this.type == 2) {
         this.itemIds = new int[this.rawWidth * this.rawHeight];
         this.itemQuantities = new int[this.rawHeight * this.rawWidth];
         this.itemAttributes = new String[this.rawHeight * this.rawWidth][3];
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.clickMask |= 268435456;
         }

         var5 = var1.readUnsignedByte();
         if(var5 == 1) {
            this.clickMask |= 1073741824;
         }

         var6 = var1.readUnsignedByte();
         if(var6 == 1) {
            this.clickMask |= Integer.MIN_VALUE;
         }

         int var7 = var1.readUnsignedByte();
         if(var7 == 1) {
            this.clickMask |= 536870912;
         }

         this.paddingX = var1.readUnsignedByte();
         this.paddingY = var1.readUnsignedByte();
         this.inventoryXOffsets = new int[20];
         this.inventoryYOffsets = new int[20];
         this.inventorySprites = new int[20];

         int var8;
         for(var8 = 0; var8 < 20; ++var8) {
            int var9 = var1.readUnsignedByte();
            if(var9 == 1) {
               this.inventoryXOffsets[var8] = var1.g2s();
               this.inventoryYOffsets[var8] = var1.g2s();
               this.inventorySprites[var8] = var1.readInt();
            } else {
               this.inventorySprites[var8] = -1;
            }
         }

         this.itemActions = new String[5];

         for(var8 = 0; var8 < 5; ++var8) {
            String var11 = var1.readString();
            if(var11.length() > 0) {
               this.itemActions[var8] = var11;
               this.clickMask |= 1 << var8 + 23;
            }
         }
      }

      if(this.type == 3) {
         this.fill = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4 || this.type == 1) {
         this.textXAlignment = var1.readUnsignedByte();
         this.textYAlignment = var1.readUnsignedByte();
         this.textLineHeight = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = var1.readUnsignedByte() == 1;
      }

      if(this.type == 4) {
         this.text = var1.readString();
         this.text2 = var1.readString();
      }

      if(this.type == 1 || this.type == 3 || this.type == 4) {
         this.color = var1.readInt();
      }

      if(this.type == 3 || this.type == 4) {
         this.color2 = var1.readInt();
         this.mouseOverColor = var1.readInt();
         this.mouseOverColor2 = var1.readInt();
      }

      if(this.type == 5) {
         this.spriteId2 = var1.readInt();
         this.spriteId = var1.readInt();
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == 65535) {
            this.modelId = -1;
         }

         this.modelType2 = 1;
         this.modelId2 = var1.readUnsignedShort();
         if(this.modelId2 == 65535) {
            this.modelId2 = -1;
         }

         this.sequenceId = var1.readUnsignedShort();
         if(this.sequenceId == 65535) {
            this.sequenceId = -1;
         }

         this.sequenceId2 = var1.readUnsignedShort();
         if(this.sequenceId2 == 65535) {
            this.sequenceId2 = -1;
         }

         this.modelZoom = var1.readUnsignedShort();
         this.modelAngleX = var1.readUnsignedShort();
         this.modelAngleY = var1.readUnsignedShort();
      }

      if(this.type == 7) {
         this.itemIds = new int[this.rawHeight * this.rawWidth];
         this.itemQuantities = new int[this.rawWidth * this.rawHeight];
         this.itemAttributes = new String[this.rawWidth * this.rawHeight][3];
         this.textXAlignment = var1.readUnsignedByte();
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == 65535) {
            this.fontId = -1;
         }

         this.textShadowed = var1.readUnsignedByte() == 1;
         this.color = var1.readInt();
         this.paddingX = var1.g2s();
         this.paddingY = var1.g2s();
         var4 = var1.readUnsignedByte();
         if(var4 == 1) {
            this.clickMask |= 1073741824;
         }

         this.itemActions = new String[5];

         for(var5 = 0; var5 < 5; ++var5) {
            String var10 = var1.readString();
            if(var10.length() > 0) {
               this.itemActions[var5] = var10;
               this.clickMask |= 1 << var5 + 23;
            }
         }
      }

      if(this.type == 8) {
         this.text = var1.readString();
      }

      if(this.buttonType == 2 || this.type == 2) {
         this.spellActionName = var1.readString();
         this.spellName = var1.readString();
         var4 = var1.readUnsignedShort() & 63;
         this.clickMask |= var4 << 11;
      }

      if(this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5 || this.buttonType == 6) {
         this.buttonText = var1.readString();
         if(this.buttonText.length() == 0) {
            if(this.buttonType == 1) {
               this.buttonText = "Ok";
            }

            if(this.buttonType == 4) {
               this.buttonText = "Select";
            }

            if(this.buttonType == 5) {
               this.buttonText = "Select";
            }

            if(this.buttonType == 6) {
               this.buttonText = "Continue";
            }
         }
      }

      if(this.buttonType == 1 || this.buttonType == 4 || this.buttonType == 5) {
         this.clickMask |= 4194304;
      }

      if(this.buttonType == 6) {
         this.clickMask |= 1;
      }

   }

   void method4001(Buffer var1) {
      var1.readUnsignedByte();
      this.isIf3 = true;
      this.type = var1.readUnsignedByte();
      this.contentType = var1.readUnsignedShort();
      this.rawX = var1.g2s();
      this.rawY = var1.g2s();
      this.rawWidth = var1.readUnsignedShort();
      if(this.type == 9) {
         this.rawHeight = var1.g2s();
      } else {
         this.rawHeight = var1.readUnsignedShort();
      }

      this.widthAlignment = var1.readByte();
      this.heightAlignment = var1.readByte();
      this.xAlignment = var1.readByte();
      this.yAlignment = var1.readByte();
      this.parentId = var1.readUnsignedShort();
      if(this.parentId == 65535) {
         this.parentId = -1;
      } else {
         this.parentId += this.id & -65536;
      }

      this.isHidden = var1.readUnsignedByte() == 1;
      this.onHiddenChanged(-1);
      if(this.type == 0) {
         this.scrollWidth = var1.readUnsignedShort();
         this.scrollHeight = var1.readUnsignedShort();
         this.noClickThrough = var1.readUnsignedByte() == 1;
      }

      if(this.type == 5) {
         this.spriteId2 = var1.readInt();
         this.spriteAngle = var1.readUnsignedShort();
         this.spriteTiling = var1.readUnsignedByte() == 1;
         this.transparencyTop = var1.readUnsignedByte();
         this.outline = var1.readUnsignedByte();
         this.spriteShadow = var1.readInt();
         this.spriteFlipV = var1.readUnsignedByte() == 1;
         this.spriteFlipH = var1.readUnsignedByte() == 1;
      }

      if(this.type == 6) {
         this.modelType = 1;
         this.modelId = var1.readUnsignedShort();
         if(this.modelId == 65535) {
            this.modelId = -1;
         }

         this.modelOffsetX = var1.g2s();
         this.modelOffsetY = var1.g2s();
         this.modelAngleX = var1.readUnsignedShort();
         this.modelAngleY = var1.readUnsignedShort();
         this.modelAngleZ = var1.readUnsignedShort();
         this.modelZoom = var1.readUnsignedShort();
         this.sequenceId = var1.readUnsignedShort();
         if(this.sequenceId == 65535) {
            this.sequenceId = -1;
         }

         this.modelOrthog = var1.readUnsignedByte() == 1;
         var1.readUnsignedShort();
         if(this.widthAlignment != 0) {
            this.field2700 = var1.readUnsignedShort();
         }

         if(this.heightAlignment != 0) {
            var1.readUnsignedShort();
         }
      }

      if(this.type == 4) {
         this.fontId = var1.readUnsignedShort();
         if(this.fontId == 65535) {
            this.fontId = -1;
         }

         this.text = var1.readString();
         this.textLineHeight = var1.readUnsignedByte();
         this.textXAlignment = var1.readUnsignedByte();
         this.textYAlignment = var1.readUnsignedByte();
         this.textShadowed = var1.readUnsignedByte() == 1;
         this.color = var1.readInt();
      }

      if(this.type == 3) {
         this.color = var1.readInt();
         this.fill = var1.readUnsignedByte() == 1;
         this.transparencyTop = var1.readUnsignedByte();
      }

      if(this.type == 9) {
         this.lineWid = var1.readUnsignedByte();
         this.color = var1.readInt();
         this.field2612 = var1.readUnsignedByte() == 1;
      }

      this.clickMask = var1.method5500();
      this.dataText = var1.readString();
      int var2 = var1.readUnsignedByte();
      if(var2 > 0) {
         this.actions = new String[var2];

         for(int var3 = 0; var3 < var2; ++var3) {
            this.actions[var3] = var1.readString();
         }
      }

      this.dragZoneSize = var1.readUnsignedByte();
      this.dragThreshold = var1.readUnsignedByte();
      this.isScrollBar = var1.readUnsignedByte() == 1;
      this.spellActionName = var1.readString();
      this.onLoad = this.method4009(var1);
      this.onMouseOver = this.method4009(var1);
      this.onMouseLeave = this.method4009(var1);
      this.onTargetLeave = this.method4009(var1);
      this.onTargetEnter = this.method4009(var1);
      this.onVarTransmit = this.method4009(var1);
      this.onInvTransmit = this.method4009(var1);
      this.onStatTransmit = this.method4009(var1);
      this.onTimer = this.method4009(var1);
      this.onOp = this.method4009(var1);
      this.onMouseRepeat = this.method4009(var1);
      this.onClick = this.method4009(var1);
      this.onClickRepeat = this.method4009(var1);
      this.onRelease = this.method4009(var1);
      this.onHold = this.method4009(var1);
      this.onDrag = this.method4009(var1);
      this.onDragComplete = this.method4009(var1);
      this.onScroll = this.method4009(var1);
      this.varTransmitTriggers = this.method3969(var1);
      this.invTransmitTriggers = this.method3969(var1);
      this.statTransmitTriggers = this.method3969(var1);
   }

   public void method3976(int var1, String var2) {
      if(this.actions == null || this.actions.length <= var1) {
         String[] var3 = new String[var1 + 1];
         if(this.actions != null) {
            for(int var4 = 0; var4 < this.actions.length; ++var4) {
               var3[var4] = this.actions[var4];
            }
         }

         this.actions = var3;
      }

      this.actions[var1] = var2;
   }

   int[] method3969(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 == 0) {
         return null;
      } else {
         int[] var3 = new int[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = var1.readInt();
         }

         return var3;
      }
   }

   public Model method3974(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4, int var5) {
      if(var2 != -1 && ViewportMouse.client.isInterpolateWidgetAnimations()) {
         var2 = var2 | this.modelFrameCycle << 16 | Integer.MIN_VALUE;
      }

      return (Model)this.copy$getModel(var1, var2, var3, var4, var5);
   }

   public Font method3972() {
      field2576 = false;
      if(this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)Widget_cachedFonts.get((long)this.fontId);
         if(var1 != null) {
            return var1;
         } else {
            var1 = ClanMate.method4989(ClientPreferences.Widget_spritesArchive, class12.Widget_fontsArchive, this.fontId, 0);
            if(var1 != null) {
               Widget_cachedFonts.method3034(var1, (long)this.fontId);
            } else {
               field2576 = true;
            }

            return var1;
         }
      }
   }

   public Sprite method3971(boolean var1, byte var2) {
      if(this.getSpriteId() != -1) {
         net.runelite.api.Sprite var3 = (net.runelite.api.Sprite)Client.widgetSpriteOverrides.get(Integer.valueOf(this.getId()));
         if(var3 != null) {
            return (Sprite)((Sprite)var3);
         }
      }

      return (Sprite)this.copy$getSprite(var1, var2);
   }

   public Rectangle getBounds() {
      Point var1 = this.getCanvasLocation();
      return new Rectangle(var1.getX(), var1.getY(), this.getWidth(), this.getHeight());
   }

   public Point getCanvasLocation() {
      return new Point(this.rl$x, this.rl$y);
   }

   public int getParentId() {
      if(!$assertionsDisabled && !ViewportMouse.client.isClientThread()) {
         throw new AssertionError();
      } else {
         int var1 = this.parentId;
         if(var1 != -1) {
            return var1;
         } else {
            int var2 = this.getId();
            if(WidgetInfo.TO_GROUP(var2) == Client.rootInterface) {
               return -1;
            } else {
               int var3 = this.rl$parentId;
               if(var3 != -1) {
                  NodeHashTable var4 = ViewportMouse.client.getComponentTable();
                  WidgetNode var5 = (WidgetNode)var4.get((long)var3);
                  if(var5 != null && var5.getId() == WidgetInfo.TO_GROUP(var2)) {
                     return var3;
                  }

                  this.rl$parentId = -1;
               }

               int var13 = WidgetInfo.TO_GROUP(this.getId());
               NodeHashTable var14 = ViewportMouse.client.getComponentTable();
               Node[] var6 = var14.buckets;
               Node[] var7 = var6;
               int var8 = var6.length;

               for(int var9 = 0; var9 < var8; ++var9) {
                  Node var10 = var7[var9];

                  for(Object var11 = var10.getNext(); var11 != var10; var11 = ((net.runelite.api.Node)var11).getNext()) {
                     WidgetNode var12 = (WidgetNode)var11;
                     if(var13 == var12.getId()) {
                        return (int)var12.getHash();
                     }
                  }
               }

               return -1;
            }
         }
      }
   }

   @Override
   public int getSpriteId() {
      return this.spriteId2;
   }

   @Override
   public Widget[] getChildren() {
      return this.children;
   }

   @Override
   public int getId() {
      return this.id;
   }

   public Model copy$getModel(SequenceDefinition var1, int var2, boolean var3, PlayerAppearance var4, int var5) {
      field2576 = false;
      int var6;
      int var7;
      if(var3) {
         var6 = this.modelType2;
         var7 = this.modelId2;
      } else {
         var6 = this.modelType;
         var7 = this.modelId;
      }

      if(var6 == 0) {
         return null;
      } else if(var6 == 1 && var7 == -1) {
         return null;
      } else {
         Model var8 = (Model)Widget_cachedModels.get((long)(var7 + (var6 << 16)));
         if(var8 == null) {
            ModelData var9;
            if(var6 == 1) {
               var9 = ModelData.method2823(TaskHandler.Widget_modelsArchive, var7, 0);
               if(var9 == null) {
                  field2576 = true;
                  return null;
               }

               var8 = var9.method2778(64, 768, -50, -10, -50);
            }

            if(var6 == 2) {
               var9 = PacketBufferNode.getNpcDefinition(var7).method4406();
               if(var9 == null) {
                  field2576 = true;
                  return null;
               }

               var8 = var9.method2778(64, 768, -50, -10, -50);
            }

            if(var6 == 3) {
               if(var4 == null) {
                  return null;
               }

               var9 = var4.method4133();
               if(var9 == null) {
                  field2576 = true;
                  return null;
               }

               var8 = var9.method2778(64, 768, -50, -10, -50);
            }

            if(var6 == 4) {
               ItemDefinition var10 = Occluder.getItemDefinition(var7);
               var9 = var10.method4534(10);
               if(var9 == null) {
                  field2576 = true;
                  return null;
               }

               var8 = var9.method2778(var10.ambient + 64, var10.contrast + 768, -50, -10, -50);
            }

            Widget_cachedModels.method3034(var8, (long)(var7 + (var6 << 16)));
         }

         if(var1 != null) {
            var8 = var1.method4669(var8, var2, (byte)-75);
         }

         return var8;
      }
   }

   @Override
   public boolean isSelfHidden() {
      return this.isHidden;
   }

   public net.runelite.api.widgets.Widget getParent() {
      int var1 = this.getParentId();
      return var1 == -1?null:ViewportMouse.client.getWidget(WidgetInfo.TO_GROUP(var1), WidgetInfo.TO_CHILD(var1));
   }

   public Sprite copy$getSprite(boolean var1, byte var2) {
      field2576 = false;
      int var3;
      if(var1) {
         var3 = this.spriteId;
      } else {
         var3 = this.spriteId2;
      }

      if(var3 == -1) {
         return null;
      } else {
         long var4 = ((long)this.spriteShadow << 40) + ((this.spriteFlipH?1L:0L) << 39) + (long)var3 + ((long)this.outline << 36) + ((this.spriteFlipV?1L:0L) << 38);
         Sprite var6 = (Sprite)Widget_cachedSprites.get(var4);
         if(var6 != null) {
            return var6;
         } else {
            var6 = NPCDefinition.method4417(ClientPreferences.Widget_spritesArchive, var3, 0, -1092680498);
            if(var6 == null) {
               field2576 = true;
               return null;
            } else {
               if(this.spriteFlipV) {
                  var6.method6098();
               }

               if(this.spriteFlipH) {
                  var6.method6108();
               }

               if(this.outline > 0) {
                  var6.method6101(this.outline);
               }

               if(this.outline >= 1) {
                  var6.method6104(1);
               }

               if(this.outline >= 2) {
                  var6.method6104(16777215);
               }

               if(this.spriteShadow != 0) {
                  var6.method6105(this.spriteShadow);
               }

               Widget_cachedSprites.method3034(var6, var4);
               return var6;
            }
         }
      }
   }

   @Override
   public int getWidth() {
      return this.width;
   }

   @Override
   public int getHeight() {
      return this.height;
   }

   public WidgetItem getWidgetItem(int var1) {
      int[] var2 = this.itemIds;
      int[] var3 = this.itemQuantities;
      String[][] attributes = this.getItemAttributes();
      if(var2 != null && var3 != null) {
         int var4 = this.getWidth();
         int var5 = this.paddingX;
         int var6 = this.paddingY;
         int var7 = var2[var1];
         int var8 = var3[var1];
         if(var4 <= 0) {
            return null;
         } else {
            int var9 = var1 / var4;
            int var10 = var1 % var4;
            int var11 = var10 * (var5 + 32) + this.rl$x;
            int var12 = var9 * (var6 + 32) + this.rl$y;
            Rectangle var13 = new Rectangle(var11, var12, 32, 32);
            return new WidgetItem(var7 - 1, var8, var1, var13, this, attributes[var1]);
         }
      } else {
         return null;
      }
   }

   public net.runelite.api.widgets.Widget[] getNestedChildren() {
      if(!$assertionsDisabled && !ViewportMouse.client.isClientThread()) {
         throw new AssertionError();
      } else if(this.parentId == this.getId()) {
         return new net.runelite.api.widgets.Widget[0];
      } else {
         NodeHashTable var1 = ViewportMouse.client.getComponentTable();
         WidgetNode var2 = (WidgetNode)var1.get((long)this.getId());
         if(var2 == null) {
            return new Widget[0];
         } else {
            int var3 = var2.getId();
            ArrayList var4 = new ArrayList();
            Widget[] var5 = ViewportMouse.client.getGroup(var3);
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
               Widget var8 = var5[var7];
               if(var8 != null) {
                  if (var8.parentId == -1) {
                     var4.add(var8);
                  }
               }
            }

            return (net.runelite.api.widgets.Widget[])var4.toArray(new Widget[var4.size()]);
         }
      }
   }

   public void broadcastHidden(boolean var1) {
      WidgetHiddenChanged var2 = new WidgetHiddenChanged();
      var2.setWidget(this);
      var2.setHidden(var1);
      ViewportMouse.client.getCallbacks().post(WidgetHiddenChanged.class, var2);
      Widget[] var3 = this.getChildren();
      int var6;
      if(var3 != null) {
         Widget[] var4 = var3;
         int var5 = var3.length;

         for(var6 = 0; var6 < var5; ++var6) {
            Widget var7 = var4[var6];
            if(var7 != null && !var7.isSelfHidden()) {
               var7.broadcastHidden(var1);
            }
         }
      }

      net.runelite.api.widgets.Widget[] var11 = this.getNestedChildren();
      net.runelite.api.widgets.Widget[] var9 = var11;
      var6 = var11.length;

      for(int var10 = 0; var10 < var6; ++var10) {
         net.runelite.api.widgets.Widget var8 = var9[var10];
         if(var8 != null && !var8.isSelfHidden()) {
            ((Widget)var8).broadcastHidden(var1);
         }
      }

   }

   @Override
   public void setChildren(net.runelite.api.widgets.Widget[] var1) {
      this.children = (Widget[])var1;
   }

   public void onPositionChanged(int var1) {
      int var2 = this.getId();
      if(var2 != -1) {
         int var3 = ViewportMouse.client.getGameCycle();
         if(var3 != rl$widgetLastPosChanged) {
            rl$widgetLastPosChanged = var3;
            ViewportMouse.client.getLogger().trace("Posting widget position changed");
            WidgetPositioned var4 = WidgetPositioned.INSTANCE;
            ViewportMouse.client.getCallbacks().postDeferred(WidgetPositioned.class, var4);
         }
      }
   }

   public void onHiddenChanged(int var1) {
      int var2 = this.getId();
      if(var2 != -1) {
         net.runelite.api.widgets.Widget var3 = this.getParent();
         if(var3 != null) {
            if(var3.isHidden()) {
               return;
            }
         } else if(WidgetInfo.TO_GROUP(var2) != Client.rootInterface) {
            return;
         }

         this.broadcastHidden(this.isSelfHidden());
      }
   }

   private void rl$$init() {
      this.rl$parentId = -1;
      this.rl$x = -1;
      this.rl$y = -1;
   }

   public net.runelite.api.Sprite getSprite() {
      return this.method3971(false, (byte)13);
   }

   public void setRenderParentId(int var1) {
      this.rl$parentId = var1;
   }

   public void setRenderX(int var1) {
      this.rl$x = var1;
   }

   public void setRenderY(int var1) {
      this.rl$y = var1;
   }

   public String getText() {
      return this.text.replace(' ', ' ');
   }

   public String getName() {
      return this.dataText.replace(' ', ' ');
   }

   public void setName(String var1) {
      this.dataText = var1.replace(' ', ' ');
   }

   public boolean isHidden() {
      if(!$assertionsDisabled && !ViewportMouse.client.isClientThread()) {
         throw new AssertionError();
      } else if(this.isSelfHidden()) {
         return true;
      } else {
         net.runelite.api.widgets.Widget var1 = this.getParent();
         if(var1 == null) {
            if(WidgetInfo.TO_GROUP(this.getId()) != Client.rootInterface) {
               return true;
            }
         } else if(var1.isHidden()) {
            return true;
         }

         return false;
      }
   }

   public Collection getWidgetItems() {
      int[] var1 = this.itemIds;
      if(var1 == null) {
         return null;
      } else {
         ArrayList var2 = new ArrayList(var1.length);

         for(int var3 = 0; var3 < var1.length; ++var3) {
            if(var1[var3] > 0) {
               WidgetItem var4 = this.getWidgetItem(var3);
               if(var4 != null) {
                  var2.add(var4);
               }
            }
         }

         return var2;
      }
   }

   public net.runelite.api.widgets.Widget getChild(int var1) {
      Widget[] var2 = this.getChildren();
      return var2 != null && var2[var1] != null?var2[var1]:null;
   }

   public net.runelite.api.widgets.Widget[] getDynamicChildren() {
      Widget[] var1 = this.getChildren();
      if(var1 == null) {
         return new net.runelite.api.widgets.Widget[0];
      } else {
         ArrayList var2 = new ArrayList();
         Widget[] var3 = var1;
         int var4 = var1.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            Widget var6 = var3[var5];
            if(var6 != null) {
               if (var6.parentId == this.getId()) {
                  var2.add(var6);
               }
            }
         }

         return (net.runelite.api.widgets.Widget[])var2.toArray(new net.runelite.api.widgets.Widget[var2.size()]);
      }
   }

   public net.runelite.api.widgets.Widget[] getStaticChildren() {
      if(this.parentId == this.getId()) {
         return new net.runelite.api.widgets.Widget[0];
      } else {
         ArrayList var1 = new ArrayList();
         Widget[] var2 = ViewportMouse.client.getGroup(WidgetInfo.TO_GROUP(this.getId()));
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            Widget var5 = var2[var4];
            if(var5 != null) {
               if (var5.parentId == this.getId()) {
                  var1.add(var5);
               }
            }
         }

         return (net.runelite.api.widgets.Widget[])var1.toArray(new Widget[var1.size()]);
      }
   }

   public boolean contains(Point var1) {
      Rectangle var2 = this.getBounds();
      return var2 != null && var2.contains(new java.awt.Point(var1.getX(), var1.getY()));
   }

   public net.runelite.api.widgets.Widget createChild(int var1, int var2) {
      if(!$assertionsDisabled && !ViewportMouse.client.isClientThread()) {
         throw new AssertionError();
      } else {
         Widget var3 = ViewportMouse.client.createWidget();
         var3.setType(var2);
         var3.setParentId(this.getId());
         var3.setId(this.getId());
         var3.setIsIf3(true);
         Object var4 = this.getChildren();
         if(var1 < 0) {
            if(var4 == null) {
               var1 = 0;
            } else {
               var1 = 0;

               for(int var6 = ((Object[])var4).length - 1; var6 >= 0; --var6) {
                  if(((Object[])var4)[var6] != null) {
                     var1 = var6 + 1;
                     break;
                  }
               }
            }
         }

         if(var4 == null) {
            var4 = new Widget[var1 + 1];
            this.setChildren((net.runelite.api.widgets.Widget[])var4);
         } else if(((Object[])var4).length <= var1) {
            Widget[] var5 = new Widget[var1 + 1];
            System.arraycopy(var4, 0, var5, 0, ((Object[])var4).length);
            var4 = var5;
            this.setChildren(var5);
         }

         ((Object[])var4)[var1] = var3;
         var3.setIndex(var1);
         return var3;
      }
   }

   public void revalidate() {
      if(!$assertionsDisabled && !ViewportMouse.client.isClientThread()) {
         throw new AssertionError();
      } else {
         ViewportMouse.client.revalidateWidget(this);
      }
   }

   public void revalidateScroll() {
      if(!$assertionsDisabled && !ViewportMouse.client.isClientThread()) {
         throw new AssertionError();
      } else {
         ViewportMouse.client.revalidateWidget(this);
         ViewportMouse.client.revalidateWidgetScroll(UserComparator5.Widget_interfaceComponents[WidgetInfo.TO_GROUP(this.getId())], this, false);
      }
   }

   public void deleteAllChildren() {
      if(this.getChildren() != null) {
         Arrays.fill(this.getChildren(), (Object)null);
      }

   }

   @Override
   public void setIsIf3(boolean var1) {
      this.isIf3 = var1;
   }

   @Override
   public boolean isIf3() {
      return this.isIf3;
   }

   @Override
   public void setId(int var1) {
      this.id = var1;
   }

   @Override
   public void setIndex(int var1) {
      this.childIndex = var1;
   }

   @Override
   public int getIndex() {
      return this.childIndex;
   }

   @Override
   public void setType(int var1) {
      this.type = var1;
   }

   @Override
   public int getType() {
      return this.type;
   }

   @Override
   public void setContentType(int var1) {
      this.contentType = var1;
   }

   @Override
   public int getContentType() {
      return this.contentType;
   }

   @Override
   public void setXPositionMode(int var1) {
      this.xAlignment = var1;
   }

   @Override
   public int getXPositionMode() {
      return this.xAlignment;
   }

   @Override
   public void setYPositionMode(int var1) {
      this.yAlignment = var1;
   }

   @Override
   public int getYPositionMode() {
      return this.yAlignment;
   }

   @Override
   public void setWidthMode(int var1) {
      this.widthAlignment = var1;
   }

   @Override
   public int getWidthMode() {
      return this.widthAlignment;
   }

   @Override
   public void setHeightMode(int var1) {
      this.heightAlignment = var1;
   }

   @Override
   public int getHeightMode() {
      return this.heightAlignment;
   }

   @Override
   public void setOriginalX(int var1) {
      this.rawX = var1;
   }

   @Override
   public int getOriginalX() {
      return this.rawX;
   }

   @Override
   public void setOriginalY(int var1) {
      this.rawY = var1;
   }

   @Override
   public int getOriginalY() {
      return this.rawY;
   }

   @Override
   public void setOriginalWidth(int var1) {
      this.rawWidth = var1;
   }

   @Override
   public int getOriginalWidth() {
      return this.rawWidth;
   }

   @Override
   public void setOriginalHeight(int var1) {
      this.rawHeight = var1;
   }

   @Override
   public int getOriginalHeight() {
      return this.rawHeight;
   }

   @Override
   public void setRelativeX(int var1) {
      this.x = var1;
   }

   @Override
   public int getRelativeX() {
      return this.x;
   }

   @Override
   public void setRelativeY(int var1) {
      this.y = var1;
   }

   @Override
   public int getRelativeY() {
      return this.y;
   }

   @Override
   public void setWidth(int var1) {
      this.width = var1;
   }

   @Override
   public void setHeight(int var1) {
      this.height = var1;
   }

   @Override
   public void setParentId(int var1) {
      this.parentId = var1;
   }

   @Override
   public void setHidden(boolean var1) {
      this.isHidden = var1;
   }

   @Override
   public void setScrollX(int var1) {
      this.scrollX = var1;
   }

   @Override
   public int getScrollX() {
      return this.scrollX;
   }

   @Override
   public void setScrollY(int var1) {
      this.scrollY = var1;
   }

   @Override
   public int getScrollY() {
      return this.scrollY;
   }

   @Override
   public void setScrollWidth(int var1) {
      this.scrollWidth = var1;
   }

   @Override
   public int getScrollWidth() {
      return this.scrollWidth;
   }

   @Override
   public void setScrollHeight(int var1) {
      this.scrollHeight = var1;
   }

   @Override
   public int getScrollHeight() {
      return this.scrollHeight;
   }

   @Override
   public void setTextColor(int var1) {
      this.color = var1;
   }

   @Override
   public int getTextColor() {
      return this.color;
   }

   @Override
   public void setFilled(boolean var1) {
      this.fill = var1;
   }

   @Override
   public boolean isFilled() {
      return this.fill;
   }

   @Override
   public void setOpacity(int var1) {
      this.transparencyTop = var1;
   }

   @Override
   public int getOpacity() {
      return this.transparencyTop;
   }

   @Override
   public void setSpriteId(int var1) {
      this.spriteId2 = var1;
   }

   @Override
   public void setBorderType(int var1) {
      this.outline = var1;
   }

   @Override
   public int getBorderType() {
      return this.outline;
   }

   @Override
   public int getModelId() {
      return this.modelId;
   }

   @Override
   public void setItemQuantityMode(int var1) {
      this.itemQuantityMode = var1;
   }

   @Override
   public int getItemQuantityMode() {
      return this.itemQuantityMode;
   }

   @Override
   public void setFontId(int var1) {
      this.fontId = var1;
   }

   @Override
   public int getFontId() {
      return this.fontId;
   }

   @Override
   public void setText(String var1) {
      this.text = var1;
   }

   @Override
   public void setXTextAlignment(int var1) {
      this.textXAlignment = var1;
   }

   @Override
   public int getXTextAlignment() {
      return this.textXAlignment;
   }

   @Override
   public void setYTextAlignment(int var1) {
      this.textYAlignment = var1;
   }

   @Override
   public int getYTextAlignment() {
      return this.textYAlignment;
   }

   @Override
   public void setTextShadowed(boolean var1) {
      this.textShadowed = var1;
   }

   @Override
   public boolean getTextShadowed() {
      return this.textShadowed;
   }

   @Override
   public void setClickMask(int var1) {
      this.clickMask = var1;
   }

   @Override
   public int getClickMask() {
      return this.clickMask;
   }

   @Override
   public String[] getActions() {
      return this.actions;
   }

   @Override
   public void setDragDeadZone(int var1) {
      this.dragZoneSize = var1;
   }

   @Override
   public int getDragDeadZone() {
      return this.dragZoneSize;
   }

   @Override
   public void setDragDeadTime(int var1) {
      this.dragThreshold = var1;
   }

   @Override
   public int getDragDeadTime() {
      return this.dragThreshold;
   }

   @Override
   public void setTargetVerb(String var1) {
      this.spellActionName = var1;
   }

   @Override
   public String getTargetVerb() {
      return this.spellActionName;
   }

   @Override
   public void setHasListener(boolean var1) {
      this.hasListener = var1;
   }

   @Override
   public boolean hasListener() {
      return this.hasListener;
   }

   @Override
   public Object[] getOnLoadListener() {
      return this.onLoad;
   }

   @Override
   public void setOnMouseOverListener(Object[] var1) {
      this.onMouseOver = var1;
   }

   @Override
   public void setOnMouseRepeatListener(Object[] var1) {
      this.onMouseRepeat = var1;
   }

   @Override
   public void setOnMouseLeaveListener(Object[] var1) {
      this.onMouseLeave = var1;
   }

   @Override
   public void setOnTargetEnterListener(Object[] var1) {
      this.onTargetEnter = var1;
   }

   @Override
   public void setOnTargetLeaveListener(Object[] var1) {
      this.onTargetLeave = var1;
   }

   @Override
   public Object[] getOnInvTransmit() {
      return this.onInvTransmit;
   }

   @Override
   public void setOnTimerListener(Object[] var1) {
      this.onTimer = var1;
   }

   @Override
   public void setOnOpListener(Object[] var1) {
      this.onOp = var1;
   }

   @Override
   public Object[] getOnOp() {
      return this.onOp;
   }

   @Override
   public void setOnKeyListener(Object[] var1) {
      this.onKey = var1;
   }

   @Override
   public Object[] getOnKeyListener() {
      return this.onKey;
   }

   @Override
   public void setOnDialogAbortListener(Object[] var1) {
      this.onDialogAbort = var1;
   }

   @Override
   public void setItemId(int var1) {
      this.itemId = var1;
   }

   @Override
   public int getItemId() {
      return this.itemId;
   }

   @Override
   public void setItemQuantity(int var1) {
      this.itemQuantity = var1;
   }

   public String[][] getItemAttributes() {
      return this.itemAttributes;
   }

   @Override
   public int getItemQuantity() {
      return this.itemQuantity;
   }

   @Override
   public boolean containsMouse() {
      return this.containsMouse;
   }

   @Override
   public void setNoClickThrough(boolean var1) {
      this.noClickThrough = var1;
   }

   @Override
   public boolean getNoClickThrough() {
      return this.noClickThrough;
   }

   @Override
   public void setNoScrollThrough(boolean var1) {
      this.noScrollThrough = var1;
   }

   @Override
   public boolean getNoScrollThrough() {
      return this.noScrollThrough;
   }

   @Override
   public AbstractFont getFont() {
      return this.method3972();
   }

   @Override
   public void setAction(int var1, String var2) {
      this.method3976(var1, var2);
   }

   public SpriteMask method3975(boolean var1) {
      if(this.spriteId == -1) {
         var1 = false;
      }

      int var2 = var1?this.spriteId:this.spriteId2;
      if(var2 == -1) {
         return null;
      } else {
         long var3 = ((this.spriteFlipV?1L:0L) << 38) + (long)var2 + ((long)this.outline << 36) + ((this.spriteFlipH?1L:0L) << 39) + ((long)this.spriteShadow << 40);
         SpriteMask var5 = (SpriteMask)Widget_cachedSpriteMasks.get(var3);
         if(var5 != null) {
            return var5;
         } else {
            Sprite var6 = this.method3971(var1, (byte)8);
            if(var6 == null) {
               return null;
            } else {
               Sprite var7 = var6.method6137();
               int[] var8 = new int[var7.subHeight];
               int[] var9 = new int[var7.subHeight];

               for(int var10 = 0; var10 < var7.subHeight; ++var10) {
                  int var11 = 0;
                  int var12 = var7.subWidth;

                  int var13;
                  for(var13 = 0; var13 < var7.subWidth; ++var13) {
                     if(var7.pixels[var13 + var10 * var7.subWidth] == 0) {
                        var11 = var13;
                        break;
                     }
                  }

                  for(var13 = var7.subWidth - 1; var13 >= var11; --var13) {
                     if(var7.pixels[var13 + var10 * var7.subWidth] == 0) {
                        var12 = var13 + 1;
                        break;
                     }
                  }

                  var8[var10] = var11;
                  var9[var10] = var12 - var11;
               }

               var5 = new SpriteMask(var7.subWidth, var7.subHeight, var9, var8, var2);
               Widget_cachedSpriteMasks.method3034(var5, var3);
               return var5;
            }
         }
      }
   }

   public void method3970(int var1, int var2) {
      int var3 = this.itemIds[var2];
      this.itemIds[var2] = this.itemIds[var1];
      this.itemIds[var1] = var3;
      var3 = this.itemQuantities[var2];
      this.itemQuantities[var2] = this.itemQuantities[var1];
      this.itemQuantities[var1] = var3;
   }

   Object[] method4009(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if(var2 == 0) {
         return null;
      } else {
         Object[] var3 = new Object[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            int var5 = var1.readUnsignedByte();
            if(var5 == 0) {
               var3[var4] = new Integer(var1.readInt());
            } else if(var5 == 1) {
               var3[var4] = var1.readString();
            }
         }

         this.hasListener = true;
         return var3;
      }
   }

   private static void rl$$clinit() {
      $assertionsDisabled = !Client.class.desiredAssertionStatus();
   }

   /**
    * Custom
    */
   //TODO:: Custom Method
   public static Widget addChild(int id, int childType, int childId) {
      if (childType == 0)
         throw new RuntimeException();
      Widget parent = Canvas.getWidget(id);
      if (parent.children == null)
         parent.children = new Widget[childId + 1];
      if (parent.children.length <= childId) {
         Widget[] var35 = new Widget[childId + 1];
         for (int var10 = 0; var10 < parent.children.length; var10++)
            var35[var10] = parent.children[var10];
         parent.children = var35;
      }
      if (childId > 0 && parent.children[childId - 1] == null)
         throw new RuntimeException("" + (childId - 1));
      Widget child = new Widget();
      child.type = childType;
      child.parentId = child.id = parent.id;
      child.childIndex = childId;
      child.isIf3 = true;
      parent.children[childId] = child;
      WorldMapSectionType.method116(parent);
      return child;
   }

   //TODO:: Custom Method
   public static void setItem(Widget inter, int itemId, int itemAmount, int itemAmountSetting) {
      ItemDefinition def = Occluder.getItemDefinition(itemId);
      inter.itemId = itemId;
      inter.itemQuantity = itemAmount;
      inter.modelAngleX = def.xan2d;
      inter.modelAngleZ = def.yan2d;
      inter.modelAngleY = def.zan2d;
      inter.modelOffsetX = def.offsetX2d;
      inter.modelOffsetY = def.offsetY2d;
      inter.modelZoom = def.zoom2d;
      inter.itemQuantityMode = itemAmountSetting;
      try {
         if (inter.field2700 > 0)
            inter.modelZoom = inter.modelZoom * 32 / inter.field2700;
         else if (inter.width > 0)
            inter.modelZoom = inter.modelZoom * 32 / inter.rawWidth;
      } catch (ArithmeticException e) {
         e.printStackTrace();
      }
   }
}
