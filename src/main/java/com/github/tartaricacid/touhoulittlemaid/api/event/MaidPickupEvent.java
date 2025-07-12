package com.github.tartaricacid.touhoulittlemaid.api.event;

import com.github.tartaricacid.touhoulittlemaid.entity.item.EntityPowerPoint;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;

public abstract class MaidPickupEvent extends Event {
    private final EntityMaid maid;
    private final boolean simulate;
    private boolean canPickup = false;

    public MaidPickupEvent(EntityMaid maid, boolean simulate) {
        this.maid = maid;
        this.simulate = simulate;
    }

    public EntityMaid getMaid() {
        return maid;
    }

    public boolean isSimulate() {
        return simulate;
    }

    public boolean isCanPickup() {
        return canPickup;
    }

    public void setCanPickup(boolean canPickup) {
        this.canPickup = canPickup;
    }

    @Override
    public boolean isCancelable() {
        return true;
    }

    public static class ItemResultPre extends MaidPickupEvent {
        private final ItemEntity entityItem;

        public ItemResultPre(EntityMaid maid, ItemEntity entityItem, boolean simulate) {
            super(maid, simulate);
            this.entityItem = entityItem;
        }

        public ItemEntity getEntityItem() {
            return entityItem;
        }
    }

    public static class ItemResultPost extends MaidPickupEvent {
        /**
         * 女仆捡起的物品，复制的对象
         */
        private final ItemStack pickupItem;

        public ItemResultPost(EntityMaid maid, ItemStack pickupItem) {
            super(maid, false);
            this.pickupItem = pickupItem;
        }

        public ItemStack getPickupItem() {
            return pickupItem;
        }

        @Override
        public boolean isCancelable() {
            return false;
        }
    }

    public static class ExperienceResult extends MaidPickupEvent {
        private final ExperienceOrb experienceOrb;

        public ExperienceResult(EntityMaid maid, ExperienceOrb experienceOrb, boolean simulate) {
            super(maid, simulate);
            this.experienceOrb = experienceOrb;
        }

        public ExperienceOrb getExperienceOrb() {
            return experienceOrb;
        }
    }

    public static class ArrowResult extends MaidPickupEvent {
        private final AbstractArrow arrow;

        public ArrowResult(EntityMaid maid, AbstractArrow arrow, boolean simulate) {
            super(maid, simulate);
            this.arrow = arrow;
        }

        public AbstractArrow getArrow() {
            return arrow;
        }
    }

    public static class PowerPointResult extends MaidPickupEvent {
        private final EntityPowerPoint powerPoint;

        public PowerPointResult(EntityMaid maid, EntityPowerPoint powerPoint, boolean simulate) {
            super(maid, simulate);
            this.powerPoint = powerPoint;
        }

        public EntityPowerPoint getPowerPoint() {
            return powerPoint;
        }
    }
}
