package dev.seano.creeplets;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Items {

	public static final Item CREEPLET_SPAWN_EGG = Registry.register(Registries.ITEM, Creeplets.id("creeplet_spawn_egg"),
		new SpawnEggItem(Entities.CREEPLET, 894731, 0, new Item.Settings()));

	public static void init() {
		Creeplets.LOGGER.info("Initializing items");

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS)
			.register(
				fabricItemGroupEntries -> fabricItemGroupEntries.addAfter(net.minecraft.item.Items.CREEPER_SPAWN_EGG,
					CREEPLET_SPAWN_EGG));
	}
}
