package dev.seano.creeplets.registry;

import dev.seano.creeplets.CreepletsMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item CREEPLET_TNT = new BlockItem(ModBlocks.CREEPLET_TNT, new FabricItemSettings());
    public static final Item CREEPLET_SPAWN_EGG = new SpawnEggItem(ModEntities.CREEPLET, 0x47c536, 0x299326, new FabricItemSettings());

    public static void register() {
        Registry.register(Registries.ITEM, CreepletsMod.identifier("creeplet_tnt"), CREEPLET_TNT);
        Registry.register(Registries.ITEM, CreepletsMod.identifier("creeplet_spawn_egg"), CREEPLET_SPAWN_EGG);
        registerItemGroups();
    }

    @SuppressWarnings("UnstableApiUsage")
    private static void registerItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.addAfter(Items.TNT, CREEPLET_TNT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.addAfter(Items.TNT, CREEPLET_TNT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.addAfter(Items.CREEPER_SPAWN_EGG, CREEPLET_SPAWN_EGG));
    }
}
