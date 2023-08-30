package dev.seano.creeplets;

import dev.seano.creeplets.datagen.CreepletModelsProvider;
import dev.seano.creeplets.datagen.lang.EnglishLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CreepletsModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(CreepletModelsProvider::new);
        pack.addProvider(EnglishLangProvider::new);
    }
}
