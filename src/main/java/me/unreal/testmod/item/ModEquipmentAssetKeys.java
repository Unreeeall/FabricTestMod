package me.unreal.testmod.item;

import me.unreal.testmod.TestMod;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public interface ModEquipmentAssetKeys extends EquipmentAssetKeys {

    RegistryKey<? extends Registry<EquipmentAsset>> MOD_EQUIPMENT_REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.of(TestMod.MOD_ID, "mod_equipment_asset"));
    RegistryKey<EquipmentAsset> PINK_GARNET = register("pink_garnet");



    static RegistryKey<EquipmentAsset> register(String name) {
        return RegistryKey.of(MOD_EQUIPMENT_REGISTRY_KEY, Identifier.of(name));
    }
}
