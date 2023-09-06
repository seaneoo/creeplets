package dev.seano.creeplets.datagen.lang;

import dev.seano.creeplets.registry.ModBlocks;
import dev.seano.creeplets.registry.ModEntities;
import dev.seano.creeplets.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class EnglishLangProvider extends FabricLanguageProvider {

    public EnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ModEntities.CREEPLET, "Creeplet");
        translationBuilder.add(ModEntities.CREEPLET_TNT, "Primed Creeplet TNT");
        translationBuilder.add(ModBlocks.CREEPLET_TNT, "Creeplet TNT");
        translationBuilder.add(ModItems.CREEPLET_GUNPOWDER, "Creeplet Gunpowder");
        translationBuilder.add(ModItems.CREEPLET_SPAWN_EGG, "Creeplet Spawn Egg");

        translationBuilder.add("creeplets.midnightconfig.title", "Creeplets Config");
        translationBuilder.add("creeplets.midnightconfig.spawnWeight", "Spawn weight");
        translationBuilder.add("creeplets.midnightconfig.fuseTime", "Fuse time");
        translationBuilder.add("creeplets.midnightconfig.explosionRadius", "Explosion radius");
        translationBuilder.add("creeplets.midnightconfig.movementSpeed", "Movement speed");
    }
}
