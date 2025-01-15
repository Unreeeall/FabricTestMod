package me.unreal.testmod.item;

import me.unreal.testmod.TestMod;
import me.unreal.testmod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
        });
    }
}
