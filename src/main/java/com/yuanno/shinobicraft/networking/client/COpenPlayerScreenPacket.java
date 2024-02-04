package com.yuanno.shinobicraft.networking.client;

import com.yuanno.shinobicraft.client.screens.PlayerStatsScreen;
import com.yuanno.shinobicraft.networking.ShinobiNetwork;
import com.yuanno.shinobicraft.networking.server.SOpenPlayerScreenPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class COpenPlayerScreenPacket {

	public COpenPlayerScreenPacket() {
	}


	public void encode(FriendlyByteBuf buffer) {
	}

	public static COpenPlayerScreenPacket decode(FriendlyByteBuf buffer) {
		COpenPlayerScreenPacket msg = new COpenPlayerScreenPacket();
		return msg;
	}

	public static void handle(COpenPlayerScreenPacket message, final Supplier<NetworkEvent.Context> ctx) {
		if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
			ctx.get().enqueueWork(() -> {
				ShinobiNetwork.sendTo(new SOpenPlayerScreenPacket(), ctx.get().getSender());
			});
		}
		ctx.get().setPacketHandled(true);
	}


}
