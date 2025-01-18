package me.unreal.testmod.item;

import me.unreal.testmod.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import java.util.EnumMap;


public class ModArmorMaterials {

    static ArmorMaterial PINK_GARNET_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(new EnumMap<>(EquipmentType.class), (map) -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 4);
        map.put(EquipmentType.CHESTPLATE, 6);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 4);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f, ModTags.Items.PINK_GARNET_REPAIR, ModEquipmentAssetKeys.PINK_GARNET);
}
