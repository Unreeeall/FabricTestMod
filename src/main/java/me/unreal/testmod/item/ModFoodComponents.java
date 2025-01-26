package me.unreal.testmod.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent  CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodComponent  BROCCOLI = new FoodComponent.Builder().nutrition(4).saturationModifier(1f).build();
    public static final FoodComponent  HONEY_BERRY = new FoodComponent.Builder().nutrition(2).saturationModifier(0.15f).build();

}
