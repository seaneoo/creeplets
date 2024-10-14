package dev.seano.creeplets.registry;

import dev.seano.creeplets.Creeplets;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Items {

	public static final Item CREEPLET_SPAWN_EGG = Registry.register(Registries.ITEM, Creeplets.id("creeplet_spawn_egg"),
		new SpawnEggItem(Entities.CREEPLET, 894731, 0, new Item.Settings()));

	public static final Item UNSTABLE_GUNPOWDER = Registry.register(Registries.ITEM, Creeplets.id("unstable_gunpowder"),
		new Item(new Item.Settings()));

	public static final BlockItem UNSTABLE_TNT = Registry.register(Registries.ITEM, Creeplets.id("unstable_tnt"),
		new BlockItem(Blocks.UNSTABLE_TNT, new Item.Settings()));

	public static void init() {
		Creeplets.LOGGER.debug("Initializing mod items");

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
			.register(
				fabricItemGroupEntries -> fabricItemGroupEntries.addAfter(net.minecraft.item.Items.CREEPER_SPAWN_EGG,
					CREEPLET_SPAWN_EGG));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
			.register(fabricItemGroupEntries -> fabricItemGroupEntries.addAfter(net.minecraft.item.Items.GUNPOWDER,
				UNSTABLE_GUNPOWDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE)
			.register(
				fabricItemGroupEntries -> fabricItemGroupEntries.addAfter(net.minecraft.item.Items.TNT, UNSTABLE_TNT));
	}
}
