package dev.seano.creeplets.registry;

import dev.seano.creeplets.CreepletsMod;
import dev.seano.creeplets.block.CreepletTntBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    public static final Block CREEPLET_TNT = register("creeplet_tnt",
            new CreepletTntBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.BRIGHT_RED).breakInstantly().sounds(BlockSoundGroup.GRASS)
                    .burnable()
                    .nonOpaque().solidBlock((state, world, pos) -> false)));

    public static void init() {}

    public static Block register(String key, Block block) {
        Registry.register(Registries.BLOCK, CreepletsMod.identifier(key), block);
        return block;
    }
}
