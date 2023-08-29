package dev.seano.creeplets;

import dev.seano.creeplets.entity.CreepletEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreepletsMod implements ModInitializer {
    public static final String MOD_ID = "creeplets";

    public static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(MOD_ID);
    }

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(Entities.CREEPLET, CreepletEntity.createCreeperAttributes());

        Registry.register(Registries.ITEM, identifier("creeplet_spawn_egg"), Items.CREEPLET_SPAWN_EGG);

        //noinspection UnstableApiUsage
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.addAfter(net.minecraft.item.Items.CREEPER_SPAWN_EGG, Items.CREEPLET_SPAWN_EGG));
    }

    public static Identifier identifier(String path) {
        return new Identifier(MOD_ID, path);
    }

    static class Entities {
        public static final EntityType<CreepletEntity> CREEPLET = Registry.register(Registries.ENTITY_TYPE, identifier("creeplet"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CreepletEntity::new).dimensions(EntityDimensions.fixed(0.3f, 0.85f)).build());
    }

    static class Items {
        public static final Item CREEPLET_SPAWN_EGG = new SpawnEggItem(Entities.CREEPLET, 894731, 0, new FabricItemSettings());
    }
}
