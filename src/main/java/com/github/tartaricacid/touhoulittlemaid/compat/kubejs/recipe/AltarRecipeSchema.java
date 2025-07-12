package com.github.tartaricacid.touhoulittlemaid.compat.kubejs.recipe;

import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface AltarRecipeSchema {
    RecipeKey<?> OUTPUT = AltarComponent.INSTANCE.key("output");
    RecipeKey<?> INGREDIENTS = ItemComponents.INPUT_ARRAY.key("ingredients");
    RecipeKey<Float> POWER = NumberComponent.FLOAT.key("power").optional(0.2f);
    RecipeSchema SCHEMA = new RecipeSchema(OUTPUT, INGREDIENTS, POWER);
}
