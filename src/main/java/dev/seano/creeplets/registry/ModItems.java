package dev.seano.creeplets.registry;

import dev.seano.creeplets.CreepletsMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
    public static final Item CREEPLET_SPAWN_EGG = new SpawnEggItem(ModEntities.CREEPLET, 0x47c536
        , 0x299326, new FabricItemSettings());

    public static void register() {
        Registry.register(Registries.ITEM, CreepletsMod.identifier("creeplet_spawn_egg"),
            ModItems.CREEPLET_SPAWN_EGG);
        registerItemGroups();
    }

    private static void registerItemGroups() {
        //noinspection UnstableApiUsage
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
            .register(entries -> entries.addAfter(Items.CREEPER_SPAWN_EGG,
                ModItems.CREEPLET_SPAWN_EGG));
    }
}
