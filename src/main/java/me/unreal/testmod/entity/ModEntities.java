package me.unreal.testmod.entity;

import me.unreal.testmod.TestMod;
import me.unreal.testmod.entity.custom.MantisEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {

    /*
    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TestMod.MOD_ID, "mantis"),
            EntityType.Builder.create(MantisEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2.5f).build());

     */

    public static final Identifier id = Identifier.of(TestMod.MOD_ID, "mantis");
    public static final  RegistryKey<EntityType<?>> key = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id);

    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE,
            key, (EntityType.Builder.<MantisEntity>create(MantisEntity::new,
                            SpawnGroup.CREATURE)
            .build(key)));



    public static void registerMobEntities() {
        TestMod.LOGGER.info("Registering Mob Entities for " + TestMod.MOD_ID);
    }
}
