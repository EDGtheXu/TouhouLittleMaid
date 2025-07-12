package com.github.tartaricacid.touhoulittlemaid.capability;

import net.minecraft.nbt.IntTag;

public class ChatTokensCapability {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addCount(int count) {
        this.count += count;
    }

    public void removeCount(int count) {
        this.count -= count;
        if (this.count < 0) {
            this.count = 0;
        }
    }

    public IntTag serialize() {
        return IntTag.valueOf(this.count);
    }

    public void deserialize(IntTag nbt) {
        this.count = nbt.getAsInt();
    }
}
