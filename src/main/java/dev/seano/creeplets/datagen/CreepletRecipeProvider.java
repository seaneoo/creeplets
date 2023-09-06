package dev.seano.creeplets.datagen;

import dev.seano.creeplets.registry.ModBlocks;
import dev.seano.creeplets.registry.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class CreepletRecipeProvider extends FabricRecipeProvider {

    public CreepletRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.CREEPLET_TNT, 2)
                .input('#', Ingredient.ofItems(Blocks.SAND, Blocks.RED_SAND))
                .input('X', ModItems.CREEPLET_GUNPOWDER).pattern("X#X").pattern("#X#")
                .pattern("X#X")
                .criterion("has_creeplet_gunpowder",
                        conditionsFromItem(ModItems.CREEPLET_GUNPOWDER))
                .offerTo(exporter);
    }
}
