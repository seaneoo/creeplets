package dev.seano.creeplets.world;

import com.mojang.serialization.Codec;
import dev.seano.creeplets.registry.BiomeModifiers;
import dev.seano.creeplets.registry.Entities;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

public class AddCreepletBiomeModifier implements BiomeModifier {

	private static final int WEIGHT = 100;

	private static final int MIN = 2;

	private static final int MAX = 3;

	@Override
	public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
		if (phase.equals(Phase.ADD)) {
			if (biome.get().getMobSettings().getSpawnerTypes().contains(MobCategory.MONSTER)) {
				builder.getMobSpawnSettings()
					.addSpawn(MobCategory.MONSTER,
						new MobSpawnSettings.SpawnerData(Entities.CREEPLET.get(), WEIGHT, MIN, MAX));
			}
		}
	}

	@Override
	public Codec<? extends BiomeModifier> codec() {
		return BiomeModifiers.ADD_CREEPLET_CODEC.get();
	}
}
