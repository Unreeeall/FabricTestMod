package me.unreal.testmod.item;

import me.unreal.testmod.TestMod;
import me.unreal.testmod.item.custom.ChiselItem;
import me.unreal.testmod.item.custom.HammerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


import java.util.List;
import java.util.function.Function;

public final class ModItems {

    public static final Item QUARGERMARK = registerItem("quargermark", Item::new, new Item.Settings());

    public static final Item WHEY_ISOLATE = registerItem("whey_isolate", Item::new, new Item.Settings());
    public static final Item PLAIN_WHEY_PROTEIN_POWDER = registerItem("plain_whey_protein_powder", Item::new, new Item.Settings());
    public static final Item CHOCOLATE_WHEY_PROTEIN_POWDER = registerItem("chocolate_whey_protein_powder", Item::new, new Item.Settings());

    public static final Item ISO_CLEAR_POWDER = registerItem("iso_clear_powder", Item::new, new Item.Settings());
    public static final Item WATERMELON_ISO_CLEAR_POWDER = registerItem("watermelon_iso_clear_powder", Item::new, new Item.Settings());
    public static final Item APPLE_ISO_CLEAR_POWDER = registerItem("apple_iso_clear_powder", Item::new, new Item.Settings());

    public static final Item PINK_GARNET = registerItem("pink_garnet", Item::new, new Item.Settings());
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", Item::new, new Item.Settings());

    public static final Item CHISEL = registerItem("chisel", ChiselItem::new, new Item.Settings().maxDamage(32));
    public static final Item CAUILIFLOWER = registerItem("cauliflower", Item::new, new Item.Settings().food(ModFoodComponents.CAULIFLOWER));
    public static final Item BROCCOLI = registerItem("broccoli", Item::new, new Item.Settings().rarity(Rarity.EPIC).food(ModFoodComponents.BROCCOLI, ModConsumableComponents.BROCCOLI));
    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", Item::new, new Item.Settings());


    public static final Item PINK_GARNET_SWORD = registerItem("pink_garnet_sword",
            settings -> new SwordItem(ModToolMaterials.PINK_GARNET, 3, -2.4f, settings),
            new Item.Settings());
    public static final Item PINK_GARNET_PICKAXE = registerItem("pink_garnet_pickaxe",
            settings -> new PickaxeItem(ModToolMaterials.PINK_GARNET, 1, -2.8f, settings),
            new Item.Settings());
    public static final Item PINK_GARNET_SHOVEL = registerItem("pink_garnet_shovel",
            settings -> new ShovelItem(ModToolMaterials.PINK_GARNET, 1.5f, -3.0f, settings),
            new Item.Settings());
    public static final Item PINK_GARNET_HOE = registerItem("pink_garnet_hoe",
            settings -> new HoeItem(ModToolMaterials.PINK_GARNET, 0, -3.0f, settings),
            new Item.Settings());
    public static final Item PINK_GARNET_AXE = registerItem("pink_garnet_axe",
            settings -> new AxeItem(ModToolMaterials.PINK_GARNET, 6, -3.2f, settings),
            new Item.Settings());


    public static final Item PINK_GARNET_HAMMER = registerItem("pink_garnet_hammer",
            settings -> new HammerItem(ModToolMaterials.PINK_GARNET, 7, -3.4f, settings),
            new Item.Settings());


    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet",
            settings -> new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.HELMET, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(15)));
    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate",
            settings -> new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, settings),
            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(15)));
    public static final Item PINK_GARNET_LEGGINS = registerItem("pink_garnet_leggins",
            settings -> new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.LEGGINGS, settings),
            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(15)));
    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots",
            settings -> new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, EquipmentType.BOOTS, settings),
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(15)));






    //HELPER METHODS:
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings)
    {
        final RegistryKey<Item> registerKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TestMod.MOD_ID, name));
        return Items.register(registerKey, factory, settings);
    }

    public static void registerModItems(){
        TestMod.LOGGER.info("Registering Mod Items for" + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(QUARGERMARK);

            entries.add(WHEY_ISOLATE);
            entries.add(PLAIN_WHEY_PROTEIN_POWDER);
            entries.add(CHOCOLATE_WHEY_PROTEIN_POWDER);

            entries.add(ISO_CLEAR_POWDER);
            entries.add(WATERMELON_ISO_CLEAR_POWDER);
            entries.add(APPLE_ISO_CLEAR_POWDER);

            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
            entries.add(CHISEL);
            entries.add(CAUILIFLOWER);
            entries.add(BROCCOLI);
            entries.add(STARLIGHT_ASHES);

            entries.add(PINK_GARNET_SWORD);
            entries.add(PINK_GARNET_PICKAXE);
            entries.add(PINK_GARNET_AXE);
            entries.add(PINK_GARNET_SHOVEL);
            entries.add(PINK_GARNET_HOE);


            entries.add(PINK_GARNET_HAMMER);

            entries.add(PINK_GARNET_HELMET);
            entries.add(PINK_GARNET_CHESTPLATE);
            entries.add(PINK_GARNET_LEGGINS);
            entries.add(PINK_GARNET_BOOTS);


        });
    }
}
