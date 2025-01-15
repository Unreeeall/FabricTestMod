package me.unreal.testmod.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.List;

import static net.minecraft.component.type.ConsumableComponents.food;

public class ModConsumableComponents {
    public static final ConsumableComponent BROCCOLI;


    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.EAT).sound(SoundEvents.ENTITY_GENERIC_EAT).consumeParticles(true);
    }

    static {
        BROCCOLI = food().consumeSeconds(5f).finishSound(SoundEvents.AMBIENT_CAVE).consumeEffect(new ApplyEffectsConsumeEffect(List.of(
                new StatusEffectInstance(StatusEffects.SPEED, 5, 5),
                new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 120, 1)))).build();
    }

}
