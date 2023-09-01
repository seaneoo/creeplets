package dev.seano.creeplets.datagen.lang;

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
        translationBuilder.add(ModItems.CREEPLET_SPAWN_EGG, "Creeplet Spawn Egg");
        translationBuilder.add("creeplets.midnightconfig.title", "Creeplets Config");

//        try {
//            String fileName = String.format("assets/%s/lang/en_us.existing.json",
//                CreepletsMod.MOD_ID);
//            Optional<Path> existingFilePath = this.dataOutput.getModContainer().findPath(fileName);
//            if (existingFilePath.isPresent()) translationBuilder.add(existingFilePath.get());
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to add existing language file!", e);
//        }
    }
}
