package com.yuanno.shinobicraft.networking.server;

import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkEvent;

public class SSyncEntityStatsDataPacket {
    private int entityId;
    private CompoundTag data;

    public SSyncEntityStatsDataPacket() {
    }

    public SSyncEntityStatsDataPacket(int entityId, CompoundTag data) {

        this.entityId = entityId;
        this.data = data;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(this.entityId);
        buffer.writeNbt(this.data);
    }

    public void decode(FriendlyByteBuf buffer) {
        int entityId = buffer.readInt();
        CompoundTag data = buffer.readNbt();
    }

    public static void handle(SSyncEntityStatsDataPacket message, NetworkEvent.Context ctx) {
        if (ctx.getDirection().getReceptionSide().isClient()) {
            ctx.enqueueWork(() -> {
                SSyncEntityStatsDataPacket.ClientHandler.handle(message);
            });
        }
        ctx.setPacketHandled(true);
    }

    public static class ClientHandler
    {
        @OnlyIn(Dist.CLIENT)
        public static void handle(SSyncEntityStatsDataPacket message)
        {
            Entity target = Minecraft.getInstance().level.getEntity(message.entityId);
            if (target instanceof LivingEntity livingEntity)
            {
                EntityStatsCapability.deserializeNBT(message.data);
            }
        }
    }
}
