package com.yuanno.shinobicraft.events.data;

import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import com.yuanno.shinobicraft.networking.ShinobiNetwork;
import com.yuanno.shinobicraft.networking.server.SSyncEntityStatsDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class SetStatsEvent {

    @SubscribeEvent
    public static void setStatsEvent(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (player.level.isClientSide)
            return;

        IEntityStats entityStats = EntityStatsCapability.get(player);
        // checks if the player has stats attached if not add them
        if (entityStats.getNinjaLevel() == 0)
        {
            statsHandling(entityStats);
            ShinobiNetwork.sendTo(new SSyncEntityStatsDataPacket(player), (ServerPlayer) player);
        }


    }

    // handling of first stats are done here later add kekkei genkai etc.
    public static void statsHandling(IEntityStats entityStats)
    {
        entityStats.setNinjaLevel(1);
        entityStats.setNinjutsuLevel(1);
        entityStats.setTaijutsuLevel(1);
        entityStats.setGenjutsuLevel(1);
        entityStats.setKenjutsuLevel(1);
        entityStats.setMedicaljutsuLevel(1);
        entityStats.setFuuinjutsuLevel(1);
        entityStats.setDojutsuLevel(1);
        entityStats.setSummoningLevel(1);
        entityStats.setSenjutsuLevel(1);
        entityStats.setNinjutsuExperience(0);
        entityStats.setTaijutsuExperience(0);
        entityStats.setGenjutsuExperience(0);
        entityStats.setKenjutsuExperience(0);
        entityStats.setMedicalExperience(0);
        entityStats.setFuuinjutsuExperience(0);
        entityStats.setDojutsuExperience(0);
        entityStats.setSummoningExperience(0);
        entityStats.setSenjutsuExperience(0);
    }
}
