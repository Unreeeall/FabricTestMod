package me.unreal.testmod.item.custom;

import com.google.common.collect.ImmutableMap;

import me.unreal.testmod.item.ModArmorMaterials;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,
                            List.of(new StatusEffectInstance(StatusEffects.HASTE, 400, 2, false, false),
                                    new StatusEffectInstance(StatusEffects.JUMP_BOOST, 400, 1, false, false))).build();

    public ModArmorItem(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if (hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffects);
            }
            //RegistryKey<EquipmentAsset> materialAssetId = entry.getKey().assetId(); // Asset ID of the material
            //List<StatusEffectInstance> statusEffects = entry.getValue(); // Effects associated with the material

            // Check if the player is wearing the full set of this material
            //if (hasCorrectArmorOn(materialAssetId, player)) {
            //    addStatusEffectForMaterial(player, mapArmorMaterial, statusEffects);
            //}
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if (!hasPlayerEffect) {
            for (StatusEffectInstance instance : mapStatusEffect) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }


    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                System.out.println("EI1");
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        System.out.println("EI2");

        EquippableComponent equippableComponentBoots = boots.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentLeggings = leggings.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentChestplate = chestplate.getComponents().get(DataComponentTypes.EQUIPPABLE);
        EquippableComponent equippableComponentHelmet = helmet.getComponents().get(DataComponentTypes.EQUIPPABLE);

        System.out.println("EI3" + equippableComponentBoots.assetId().equals(material.assetId()));

        return equippableComponentBoots.assetId().equals(material.assetId()) && equippableComponentLeggings.equals(material.assetId()) &&
                equippableComponentChestplate.equals(material.assetId()) && equippableComponentHelmet.equals(material.assetId());
    }




    //GPT approach
    /*
    private boolean hasCorrectArmorOn(RegistryKey<EquipmentAsset> targetAssetId, PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem armorItem)) {
                //System.out.println("EI1" + armorStack.getItem());
                System.out.println("EI1");
                return false; // Not an ArmorItem
            }

            // Retrieve the EquippableComponent
            EquippableComponent equippable = armorItem.getComponents().get(DataComponentTypes.EQUIPPABLE);
            if (equippable == null || !equippable.assetId().equals(targetAssetId)) {
                //System.out.println("EI2" + armorItem.getComponents());
                //System.out.println("EI3" + armorItem.getComponents().get(DataComponentTypes.EQUIPPABLE));
                System.out.println("EI2 Missing or mismatched assetId");
                return false; // Missing or mismatched assetId
            }
        }
        System.out.println("EI2 All armor pieces match the target assetId");
        return true; // All armor pieces match the target assetId
    }

     */
}