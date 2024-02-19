package com.yuanno.shinobicraft.networking.client;

import com.yuanno.shinobicraft.data.dna.DnaCapability;
import com.yuanno.shinobicraft.data.dna.IDna;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CSyncDnaPacket {
    private int entityId;
    private CompoundTag data;

    public CSyncDnaPacket() {
    }

    public CSyncDnaPacket(LivingEntity entity) {
        this.data = new CompoundTag();
        this.data = DnaCapability.get(entity).serializeNBT();
        this.entityId = entity.getId();
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(this.entityId);
        buffer.writeNbt(this.data);
    }

    public static CSyncDnaPacket decode(FriendlyByteBuf buffer) {
        CSyncDnaPacket msg = new CSyncDnaPacket();
        msg.entityId = buffer.readInt();
        msg.data = buffer.readNbt();
        return msg;
    }

    public static void handle(CSyncDnaPacket message, final Supplier<NetworkEvent.Context> ctx) {
        if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
            ctx.get().enqueueWork(() -> {
                Player player = ctx.get().getSender();
                IDna dna = DnaCapability.get(player);
                dna.deserializeNBT(message.data);
            });
        }
        ctx.get().setPacketHandled(true);
    }
}
