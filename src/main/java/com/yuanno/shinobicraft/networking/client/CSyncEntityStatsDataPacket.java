package com.yuanno.shinobicraft.networking.client;

import com.yuanno.shinobicraft.data.dna.DnaCapability;
import com.yuanno.shinobicraft.data.dna.IDna;
import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CSyncEntityStatsDataPacket {
    private int entityId;
    private CompoundTag data;

    public CSyncEntityStatsDataPacket() {
    }

    public CSyncEntityStatsDataPacket(LivingEntity entity) {
        this.data = new CompoundTag();
        this.data = EntityStatsCapability.get(entity).serializeNBT();
        this.entityId = entity.getId();
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(this.entityId);
        buffer.writeNbt(this.data);
    }

    public static CSyncEntityStatsDataPacket decode(FriendlyByteBuf buffer) {
        CSyncEntityStatsDataPacket msg = new CSyncEntityStatsDataPacket();
        msg.entityId = buffer.readInt();
        msg.data = buffer.readNbt();
        return msg;
    }

    public static void handle(CSyncEntityStatsDataPacket message, final Supplier<NetworkEvent.Context> ctx) {
        if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
            ctx.get().enqueueWork(() -> {
                Player player = ctx.get().getSender();
                IEntityStats dna = EntityStatsCapability.get(player);
                dna.deserializeNBT(message.data);
            });
        }
        ctx.get().setPacketHandled(true);
    }
}
