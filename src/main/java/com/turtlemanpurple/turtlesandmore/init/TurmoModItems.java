/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.turtlemanpurple.turtlesandmore.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import java.util.function.Function;

import com.turtlemanpurple.turtlesandmore.item.*;
import com.turtlemanpurple.turtlesandmore.TurmoMod;

public class TurmoModItems {
	public static Item TURTLE_INGOT;
	public static Item RAW_TURTLE_ORE;
	public static Item TURTLE_SHIELD;
	public static Item TURTLE_ORE;
	public static Item DEEPSLATE_TURTLE_ORE;
	public static Item TURTLE_HAMMER;
	public static Item TELEPORT_WAND;
	public static Item TURTLE_PICKAXE;
	public static Item LIGHTSABER;
	public static Item KYBER_CRYSTAL;
	public static Item LIGHTSABER_BLADE;
	public static Item LIGHTSABER_HILT;
	public static Item LIGHTSABER_HANDLE;
	public static Item TURTLE_STICK;
	public static Item TURTLE_UPGRADE;
	public static Item TURTLES_AND_MORE;
	public static Item TURTLE_STONE;
	public static Item SHELL_TILE;
	public static Item AQUA_GLASS;
	public static Item GLOW_ALGAE;
	public static Item CORAL_COLUMN;
	public static Item MYSTIC_SAND;
	public static Item WATERFALL_BLOCK;
	public static Item TURTLE_AXE;
	public static Item TURTLE_SHOVEL;
	public static Item TURTLE_HOE;
	public static Item TURTLE_SWORD_STAGE_1;
	public static Item TURTLE_SWORD_STAGE_2;
	public static Item TURTLE_SWORD_STAGE_3;
	public static Item TURTLE_SWORD_STAGE_4;
	public static Item TURTLE_SWORD;
	public static Item TURTLE_SHARD;
	public static Item TURTLE_ARMOR_HELMET;
	public static Item TURTLE_ARMOR_CHESTPLATE;
	public static Item TURTLE_ARMOR_LEGGINGS;
	public static Item TURTLE_ARMOR_BOOTS;
	public static Item COMMAND_PAD;

	public static void load() {
		TURTLE_INGOT = register("turtle_ingot", TurtleIngotItem::new);
		RAW_TURTLE_ORE = register("raw_turtle_ore", RawTurtleOreItem::new);
		TURTLE_SHIELD = register("turtle_shield", TurtleShieldItem::new);
		TURTLE_ORE = block(TurmoModBlocks.TURTLE_ORE, "turtle_ore", new Item.Properties().fireResistant());
		DEEPSLATE_TURTLE_ORE = block(TurmoModBlocks.DEEPSLATE_TURTLE_ORE, "deepslate_turtle_ore", new Item.Properties().fireResistant());
		TURTLE_HAMMER = register("turtle_hammer", TurtleHammerItem::new);
		TELEPORT_WAND = register("teleport_wand", TeleportWandItem::new);
		TURTLE_PICKAXE = register("turtle_pickaxe", TurtlePickaxeItem::new);
		LIGHTSABER = register("lightsaber", LightsaberItem::new);
		KYBER_CRYSTAL = register("kyber_crystal", KyberCrystalItem::new);
		LIGHTSABER_BLADE = register("lightsaber_blade", LightsaberBladeItem::new);
		LIGHTSABER_HILT = register("lightsaber_hilt", LightsaberHiltItem::new);
		LIGHTSABER_HANDLE = register("lightsaber_handle", LightsaberHandleItem::new);
		TURTLE_STICK = register("turtle_stick", TurtleStickItem::new);
		TURTLE_UPGRADE = register("turtle_upgrade", TurtleUpgradeItem::new);
		TURTLES_AND_MORE = register("turtles_and_more", TurtlesAndMoreItem::new);
		TURTLE_STONE = block(TurmoModBlocks.TURTLE_STONE, "turtle_stone");
		SHELL_TILE = block(TurmoModBlocks.SHELL_TILE, "shell_tile");
		AQUA_GLASS = block(TurmoModBlocks.AQUA_GLASS, "aqua_glass");
		GLOW_ALGAE = block(TurmoModBlocks.GLOW_ALGAE, "glow_algae");
		CORAL_COLUMN = block(TurmoModBlocks.CORAL_COLUMN, "coral_column");
		MYSTIC_SAND = block(TurmoModBlocks.MYSTIC_SAND, "mystic_sand");
		WATERFALL_BLOCK = block(TurmoModBlocks.WATERFALL_BLOCK, "waterfall_block");
		TURTLE_AXE = register("turtle_axe", TurtleAxeItem::new);
		TURTLE_SHOVEL = register("turtle_shovel", TurtleShovelItem::new);
		TURTLE_HOE = register("turtle_hoe", TurtleHoeItem::new);
		TURTLE_SWORD_STAGE_1 = register("turtle_sword_stage_1", TurtleSwordStage1Item::new);
		TURTLE_SWORD_STAGE_2 = register("turtle_sword_stage_2", TurtleSwordStage2Item::new);
		TURTLE_SWORD_STAGE_3 = register("turtle_sword_stage_3", TurtleSwordStage3Item::new);
		TURTLE_SWORD_STAGE_4 = register("turtle_sword_stage_4", TurtleSwordStage4Item::new);
		TURTLE_SWORD = register("turtle_sword", TurtleSwordItem::new);
		TURTLE_SHARD = register("turtle_shard", TurtleShardItem::new);
		TURTLE_ARMOR_HELMET = register("turtle_armor_helmet", TurtleArmorItem.Helmet::new);
		TURTLE_ARMOR_CHESTPLATE = register("turtle_armor_chestplate", TurtleArmorItem.Chestplate::new);
		TURTLE_ARMOR_LEGGINGS = register("turtle_armor_leggings", TurtleArmorItem.Leggings::new);
		TURTLE_ARMOR_BOOTS = register("turtle_armor_boots", TurtleArmorItem.Boots::new);
		COMMAND_PAD = register("command_pad", CommandPadItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> I register(String name, Function<Item.Properties, ? extends I> supplier) {
		return (I) Items.registerItem(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TurmoMod.MODID, name)), (Function<Item.Properties, Item>) supplier);
	}

	private static Item block(Block block, String name) {
		return block(block, name, new Item.Properties());
	}

	private static Item block(Block block, String name, Item.Properties properties) {
		return Items.registerItem(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TurmoMod.MODID, name)), prop -> new BlockItem(block, prop), properties);
	}
}