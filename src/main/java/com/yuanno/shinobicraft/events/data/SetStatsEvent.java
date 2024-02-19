package com.yuanno.shinobicraft.events.data;

import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.data.dna.DnaCapability;
import com.yuanno.shinobicraft.data.dna.IDna;
import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import com.yuanno.shinobicraft.init.ModValues;
import com.yuanno.shinobicraft.networking.ShinobiNetwork;
import com.yuanno.shinobicraft.networking.server.SOpenClanChoiceScreenPacket;
import com.yuanno.shinobicraft.networking.server.SSyncDnaPacket;
import com.yuanno.shinobicraft.networking.server.SSyncEntityStatsDataPacket;
import com.yuanno.shinobicraft.releases.Release;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class SetStatsEvent {

    @SubscribeEvent
    public static void setStatsEvent(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (player.level.isClientSide)
            return;

        IEntityStats entityStats = EntityStatsCapability.get(player);
        IDna dna = DnaCapability.get(player);
        if (dna.getClan().isEmpty())
            ShinobiNetwork.sendTo(new SOpenClanChoiceScreenPacket(), player);

        ShinobiNetwork.sendTo(new SSyncEntityStatsDataPacket(player), (ServerPlayer) player);
        ShinobiNetwork.sendTo(new SSyncDnaPacket(player), (ServerPlayer) player);
    }

    // handling of first stats are done here later add kekkei genkai etc.

}
