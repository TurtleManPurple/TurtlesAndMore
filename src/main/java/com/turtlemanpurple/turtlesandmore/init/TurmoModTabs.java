/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.turtlemanpurple.turtlesandmore.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

import com.turtlemanpurple.turtlesandmore.TurmoMod;

public class TurmoModTabs {
	public static ResourceKey<CreativeModeTab> TAB_TURTLES_AND_MORE_TAB = ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(TurmoMod.MODID, "turtles_and_more_tab"));

	public static void load() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_TURTLES_AND_MORE_TAB,
				CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).title(Component.translatable("item_group.turmo.turtles_and_more_tab")).icon(() -> new ItemStack(TurmoModItems.TURTLES_AND_MORE)).displayItems((parameters, tabData) -> {
					tabData.accept(TurmoModItems.TURTLE_INGOT);
					tabData.accept(TurmoModItems.RAW_TURTLE_ORE);
					tabData.accept(TurmoModItems.TURTLE_SHIELD);
					tabData.accept(TurmoModBlocks.TURTLE_ORE.asItem());
					tabData.accept(TurmoModBlocks.DEEPSLATE_TURTLE_ORE.asItem());
					tabData.accept(TurmoModItems.TURTLE_HAMMER);
					tabData.accept(TurmoModItems.TELEPORT_WAND);
					tabData.accept(TurmoModItems.TURTLE_PICKAXE);
					tabData.accept(TurmoModItems.LIGHTSABER);
					tabData.accept(TurmoModItems.KYBER_CRYSTAL);
					tabData.accept(TurmoModItems.LIGHTSABER_BLADE);
					tabData.accept(TurmoModItems.LIGHTSABER_HILT);
					tabData.accept(TurmoModItems.LIGHTSABER_HANDLE);
					tabData.accept(TurmoModItems.TURTLE_STICK);
					tabData.accept(TurmoModItems.TURTLE_UPGRADE);
					tabData.accept(TurmoModItems.TURTLES_AND_MORE);
					tabData.accept(TurmoModBlocks.TURTLE_STONE.asItem());
					tabData.accept(TurmoModBlocks.SHELL_TILE.asItem());
					tabData.accept(TurmoModBlocks.AQUA_GLASS.asItem());
					tabData.accept(TurmoModBlocks.GLOW_ALGAE.asItem());
					tabData.accept(TurmoModBlocks.CORAL_COLUMN.asItem());
					tabData.accept(TurmoModBlocks.MYSTIC_SAND.asItem());
					tabData.accept(TurmoModBlocks.WATERFALL_BLOCK.asItem());
					tabData.accept(TurmoModItems.TURTLE_AXE);
					tabData.accept(TurmoModItems.TURTLE_SHOVEL);
					tabData.accept(TurmoModItems.TURTLE_HOE);
					tabData.accept(TurmoModItems.TURTLE_SWORD_STAGE_1);
					tabData.accept(TurmoModItems.TURTLE_SWORD_STAGE_2);
					tabData.accept(TurmoModItems.TURTLE_SWORD_STAGE_3);
					tabData.accept(TurmoModItems.TURTLE_SWORD_STAGE_4);
					tabData.accept(TurmoModItems.TURTLE_SWORD);
					tabData.accept(TurmoModItems.TURTLE_SHARD);
					tabData.accept(TurmoModItems.TURTLE_ARMOR_HELMET);
					tabData.accept(TurmoModItems.TURTLE_ARMOR_CHESTPLATE);
					tabData.accept(TurmoModItems.TURTLE_ARMOR_LEGGINGS);
					tabData.accept(TurmoModItems.TURTLE_ARMOR_BOOTS);
					tabData.accept(TurmoModItems.COMMAND_PAD);
				}).build());
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(tabData -> {
			tabData.accept(TurmoModItems.TURTLE_INGOT);
			tabData.accept(TurmoModItems.RAW_TURTLE_ORE);
			tabData.accept(TurmoModItems.KYBER_CRYSTAL);
			tabData.accept(TurmoModItems.LIGHTSABER_BLADE);
			tabData.accept(TurmoModItems.LIGHTSABER_HILT);
			tabData.accept(TurmoModItems.TURTLE_SHARD);
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(tabData -> {
			tabData.accept(TurmoModItems.TURTLE_SHIELD);
			tabData.accept(TurmoModItems.TURTLE_HAMMER);
			tabData.accept(TurmoModItems.LIGHTSABER);
			tabData.accept(TurmoModItems.TURTLE_AXE);
			tabData.accept(TurmoModItems.TURTLE_SWORD_STAGE_1);
			tabData.accept(TurmoModItems.TURTLE_SWORD);
			tabData.accept(TurmoModItems.TURTLE_ARMOR_HELMET);
			tabData.accept(TurmoModItems.TURTLE_ARMOR_CHESTPLATE);
			tabData.accept(TurmoModItems.TURTLE_ARMOR_LEGGINGS);
			tabData.accept(TurmoModItems.TURTLE_ARMOR_BOOTS);
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(tabData -> {
			tabData.accept(TurmoModBlocks.TURTLE_ORE.asItem());
			tabData.accept(TurmoModBlocks.DEEPSLATE_TURTLE_ORE.asItem());
			tabData.accept(TurmoModBlocks.TURTLE_STONE.asItem());
			tabData.accept(TurmoModBlocks.GLOW_ALGAE.asItem());
			tabData.accept(TurmoModBlocks.MYSTIC_SAND.asItem());
			tabData.accept(TurmoModBlocks.WATERFALL_BLOCK.asItem());
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(tabData -> {
			tabData.accept(TurmoModItems.TURTLE_HAMMER);
			tabData.accept(TurmoModItems.TELEPORT_WAND);
			tabData.accept(TurmoModItems.TURTLE_PICKAXE);
			tabData.accept(TurmoModItems.TURTLE_AXE);
			tabData.accept(TurmoModItems.TURTLE_SHOVEL);
			tabData.accept(TurmoModItems.TURTLE_HOE);
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(tabData -> {
			tabData.accept(TurmoModBlocks.SHELL_TILE.asItem());
			tabData.accept(TurmoModBlocks.AQUA_GLASS.asItem());
			tabData.accept(TurmoModBlocks.CORAL_COLUMN.asItem());
		});
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.OP_BLOCKS).register(tabData -> {
			tabData.accept(TurmoModItems.COMMAND_PAD, CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
		});
	}
}