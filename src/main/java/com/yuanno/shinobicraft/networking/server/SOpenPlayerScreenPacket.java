package com.yuanno.shinobicraft.networking.server;

import com.yuanno.shinobicraft.client.screens.PlayerStatsScreen;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SOpenPlayerScreenPacket {

	public SOpenPlayerScreenPacket() {
	}



	public void encode(FriendlyByteBuf buffer) {
	}

	public static SOpenPlayerScreenPacket decode(FriendlyByteBuf buffer) {
		SOpenPlayerScreenPacket msg = new SOpenPlayerScreenPacket();
		return msg;
	}

	public static void handle(SOpenPlayerScreenPacket message, final Supplier<NetworkEvent.Context> ctx) {
		if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_CLIENT) {
			ctx.get().enqueueWork(() -> ClientHandler.handle(message));
		}
		ctx.get().setPacketHandled(true);
	}

	public static class ClientHandler {
		@OnlyIn(Dist.CLIENT)
		public static void handle(SOpenPlayerScreenPacket message) {
			PlayerStatsScreen.open();
		}
	}
}
