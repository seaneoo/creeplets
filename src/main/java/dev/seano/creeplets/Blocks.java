package dev.seano.creeplets;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.TntBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class Blocks {

	public static final TntBlock UNSTABLE_TNT = Registry.register(Registries.BLOCK, Creeplets.id("unstable_tnt"),
		new TntBlock(AbstractBlock.Settings.create()
			.mapColor(MapColor.BRIGHT_RED)
			.breakInstantly()
			.sounds(BlockSoundGroup.GRASS)
			.burnable()
			.solidBlock(net.minecraft.block.Blocks::never)));

	public static void init() {
		Creeplets.LOGGER.info("Initializing blocks");
	}
}
