package com.github.tartaricacid.touhoulittlemaid.compat.kubejs.event.common;

import com.github.tartaricacid.touhoulittlemaid.api.event.MaidAfterEatEvent;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import dev.latvian.mods.kubejs.event.EventJS;
import net.minecraft.world.item.ItemStack;

public class MaidAfterEatEventJS extends EventJS {
    private final EntityMaid maid;
    private final ItemStack foodAfterEat;

    public MaidAfterEatEventJS(MaidAfterEatEvent event) {
        this.maid = event.getMaid();
        this.foodAfterEat = event.getFoodAfterEat();
    }

    public EntityMaid getMaid() {
        return maid;
    }

    public ItemStack getFoodAfterEat() {
        return foodAfterEat;
    }
}
