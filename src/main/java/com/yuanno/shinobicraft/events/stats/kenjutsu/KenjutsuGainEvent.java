package com.yuanno.shinobicraft.events.stats.kenjutsu;

import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.data.dna.DnaCapability;
import com.yuanno.shinobicraft.data.dna.IDna;
import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import com.yuanno.shinobicraft.events.stats.taijutsu.TaijutsuEvent;
import com.yuanno.shinobicraft.init.ModValues;
import com.yuanno.shinobicraft.networking.ShinobiNetwork;
import com.yuanno.shinobicraft.networking.server.SSyncEntityStatsDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class KenjutsuGainEvent {

    @SubscribeEvent
    public static void gainingKenjutsu(KenjutsuEvent event)
    {
        Player player = event.getPlayer();
        IEntityStats entityStats = EntityStatsCapability.get(player);
        double maxKenjutsuExperience = entityStats.getKenjutsuLevel() * 100;
        double currentExperience = entityStats.getKenjutsuExperience();
        double extraExperience = 3;
        if (currentExperience + extraExperience >= maxKenjutsuExperience)
        {
            entityStats.setKenjutsuExperience(0);
            entityStats.alterKenjutsuLevel(1);
        }
        else
            entityStats.alterKenjutsuExperience(extraExperience);
        ShinobiNetwork.sendTo(new SSyncEntityStatsDataPacket(player), (ServerPlayer) player);

    }
}
