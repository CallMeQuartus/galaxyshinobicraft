package com.yuanno.shinobicraft.networking.client;

import com.yuanno.shinobicraft.networking.ShinobiNetwork;
import com.yuanno.shinobicraft.networking.server.SOpenClanChoiceScreenPacket;
import com.yuanno.shinobicraft.networking.server.SOpenPlayerScreenPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class COpenClanChoiceScreenPacket {

	public COpenClanChoiceScreenPacket() {
	}


	public void encode(FriendlyByteBuf buffer) {
	}

	public static COpenClanChoiceScreenPacket decode(FriendlyByteBuf buffer) {
		COpenClanChoiceScreenPacket msg = new COpenClanChoiceScreenPacket();
		return msg;
	}

	public static void handle(COpenClanChoiceScreenPacket message, final Supplier<NetworkEvent.Context> ctx) {
		if (ctx.get().getDirection() == NetworkDirection.PLAY_TO_SERVER) {
			ctx.get().enqueueWork(() -> {
				ShinobiNetwork.sendTo(new SOpenClanChoiceScreenPacket(), ctx.get().getSender());
			});
		}
		ctx.get().setPacketHandled(true);
	}


}
