package dev.seano.creeplets.registry;

import dev.seano.creeplets.CreepletsMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item CREEPLET_TNT = register("creeplet_tnt",
            new BlockItem(ModBlocks.CREEPLET_TNT, new FabricItemSettings()));
    public static final Item CREEPLET_GUNPOWDER = register("creeplet_gunpowder",
            new Item(new FabricItemSettings()));
    public static final Item CREEPLET_SPAWN_EGG = register("creeplet_spawn_egg",
            new SpawnEggItem(ModEntities.CREEPLET, 0x47c536, 0x299326, new FabricItemSettings()));

    public static void init() {
        registerItemGroups();
    }

    public static Item register(String key, Item item) {
        Registry.register(Registries.ITEM, CreepletsMod.identifier(key), item);
        return item;
    }

    @SuppressWarnings("UnstableApiUsage")
    private static void registerItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE)
                .register(entries -> entries.addAfter(Items.TNT, CREEPLET_TNT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register(entries -> entries.addAfter(Items.TNT, CREEPLET_TNT));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register(entries -> entries.addAfter(Items.GUNPOWDER, CREEPLET_GUNPOWDER));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
                .register(entries -> entries.addAfter(Items.CREEPER_SPAWN_EGG, CREEPLET_SPAWN_EGG));
    }
}
