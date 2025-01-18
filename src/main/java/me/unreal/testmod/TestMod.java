package me.unreal.testmod;

import me.unreal.testmod.block.ModBlocks;
import me.unreal.testmod.component.ModDataComponentTypes;
import me.unreal.testmod.item.ModItemGroups;
import me.unreal.testmod.item.ModItems;
import me.unreal.testmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItemGroups.registerItemGroups(); //Initialize item groups
		ModItems.registerModItems(); // Initialize items
		ModBlocks.registerModBlocks(); // Initialize blocks
		ModDataComponentTypes.registerDataComponentTypes();

		FuelRegistryEvents.BUILD.register((builder, context) ->
				builder.add(ModItems.STARLIGHT_ASHES, 600));

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		LOGGER.info("Hello Fabric world!");
	}
}