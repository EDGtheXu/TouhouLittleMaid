package com.github.tartaricacid.touhoulittlemaid.init;

import com.github.tartaricacid.touhoulittlemaid.TouhouLittleMaid;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class InitPainting {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS = DeferredRegister.create(Registries.PAINTING_VARIANT, TouhouLittleMaid.MOD_ID);

    public static final RegistryObject<PaintingVariant> WINE_FOX = PAINTING_VARIANTS.register("wine_fox", () -> new PaintingVariant(32, 48));
}
