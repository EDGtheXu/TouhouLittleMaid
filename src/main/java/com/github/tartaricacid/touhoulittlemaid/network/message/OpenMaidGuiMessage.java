package com.github.tartaricacid.touhoulittlemaid.network.message;

import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.TabIndex;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class OpenMaidGuiMessage {
    private final int entityId;
    private final int tabId;

    public OpenMaidGuiMessage(int entityId, int tabId) {
        this.entityId = entityId;
        this.tabId = tabId;
    }

    public OpenMaidGuiMessage(int entityId) {
        this(entityId, TabIndex.MAIN);
    }

    public static void encode(OpenMaidGuiMessage message, FriendlyByteBuf buf) {
        buf.writeVarInt(message.entityId);
        buf.writeVarInt(message.tabId);
    }

    public static OpenMaidGuiMessage decode(FriendlyByteBuf buf) {
        int entityId = buf.readVarInt();
        int tabId = buf.readVarInt();
        return new OpenMaidGuiMessage(entityId, tabId);
    }

    public static void handle(OpenMaidGuiMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        if (context.getDirection().getReceptionSide().isServer()) {
            context.enqueueWork(() -> handle(message, contextSupplier.get().getSender()));
        }
        context.setPacketHandled(true);
    }

    private static void handle(OpenMaidGuiMessage message, @Nullable ServerPlayer player) {
        if (player == null) {
            return;
        }
        Entity entity = player.level.getEntity(message.entityId);
        if (entity instanceof EntityMaid maid && stillValid(player, maid)) {
            maid.openMaidGui(player, message.tabId);
        }
    }

    private static boolean stillValid(Player playerIn, EntityMaid maid) {
        return maid.isOwnedBy(playerIn) && !maid.isSleeping() && maid.isAlive() && maid.distanceTo(playerIn) < 5.0F;
    }
}
