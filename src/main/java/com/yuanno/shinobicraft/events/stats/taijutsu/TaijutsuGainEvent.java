package com.yuanno.shinobicraft.events.stats.taijutsu;

import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.data.dna.DnaCapability;
import com.yuanno.shinobicraft.data.dna.IDna;
import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import com.yuanno.shinobicraft.init.ModValues;
import com.yuanno.shinobicraft.networking.ShinobiNetwork;
import com.yuanno.shinobicraft.networking.server.SSyncEntityStatsDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class TaijutsuGainEvent {

    @SubscribeEvent
    public static void gainingTaijutsu(TaijutsuEvent event)
    {
        Player player = event.getPlayer();
        IEntityStats entityStats = EntityStatsCapability.get(player);
        IDna dna = DnaCapability.get(player);
        double maxTaijutsuExperience = entityStats.getTaijutsuLevel() * 100;
        double currentExperience = entityStats.getTaijutsuExperience();
        double extraExperience = 3;
        if (dna.getClan().equals(ModValues.LEE))
            extraExperience *= 1.5;
        if (currentExperience + extraExperience >= maxTaijutsuExperience)
        {
            entityStats.setTaijutsuExperience(0);
            entityStats.alterTaijutsuLevel(1);
        }
        else
            entityStats.alterTaijutsuExperience(extraExperience);
        ShinobiNetwork.sendTo(new SSyncEntityStatsDataPacket(player), (ServerPlayer) player);

    }
}
