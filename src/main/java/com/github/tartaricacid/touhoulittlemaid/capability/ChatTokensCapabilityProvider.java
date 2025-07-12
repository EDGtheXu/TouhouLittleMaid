package com.github.tartaricacid.touhoulittlemaid.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.IntTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ChatTokensCapabilityProvider implements ICapabilitySerializable<IntTag> {
    public static Capability<ChatTokensCapability> CHAT_TOKENS_CAP = CapabilityManager.get(new CapabilityToken<>() {
    });
    private ChatTokensCapability instance = null;

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CHAT_TOKENS_CAP) {
            return LazyOptional.of(this::createCapability).cast();
        }
        return LazyOptional.empty();
    }

    @Nonnull
    private ChatTokensCapability createCapability() {
        if (instance == null) {
            this.instance = new ChatTokensCapability();
        }
        return instance;
    }

    @Override
    public void deserializeNBT(IntTag nbt) {
        createCapability().deserialize(nbt);
    }

    @Override
    public IntTag serializeNBT() {
        return createCapability().serialize();
    }
}
