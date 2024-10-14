package dev.seano.creeplets.registry;

import dev.seano.creeplets.Creeplets;
import dev.seano.creeplets.block.UnstableTntBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Blocks {

	public static final UnstableTntBlock UNSTABLE_TNT = Registry.register(Registries.BLOCK,
		Creeplets.id("unstable_tnt"), new UnstableTntBlock(AbstractBlock.Settings.create()));

	public static void init() {
		Creeplets.LOGGER.debug("Initializing mod blocks");
	}
}
