package me.unreal.testmod;

import me.unreal.testmod.block.ModBlocks;
import me.unreal.testmod.component.ModDataComponentTypes;
import me.unreal.testmod.effect.ModEffects;
import me.unreal.testmod.enchantment.ModEnchantmentEffects;
import me.unreal.testmod.item.ModItemGroups;
import me.unreal.testmod.item.ModItems;
import me.unreal.testmod.potion.ModPotions;
import me.unreal.testmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
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
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModEnchantmentEffects.registerEnchantmentEffects();

		FuelRegistryEvents.BUILD.register((builder, context) ->
				builder.add(ModItems.STARLIGHT_ASHES, 600));

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		AttackEntityCallback.EVENT.register(((playerEntity, world, hand, entity, entityHitResult) ->
		{
			if (entity instanceof SheepEntity sheepEntity) {
				if (playerEntity.getMainHandStack().getItem() == Items.END_ROD) {
					playerEntity.sendMessage(Text.literal("GOD DAMMIT!!! YOURE SICK!!!!!"), true);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 10));
				}
				return ActionResult.PASS;
			}
			return ActionResult.PASS;
		}));

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});

		LOGGER.info("Hello Fabric world!");
	}
}