package com.yuanno.shinobicraft.events.data;

import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.data.dna.DnaCapability;
import com.yuanno.shinobicraft.data.dna.IDna;
import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import com.yuanno.shinobicraft.init.ModValues;
import com.yuanno.shinobicraft.networking.ShinobiNetwork;
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
        // checks if the player has stats attached if not add them
        if (entityStats.getNinjaLevel() == 0)
            statsHandling(entityStats);
        if (dna.getReleases().isEmpty())
            dnaHandling(dna);

        ShinobiNetwork.sendTo(new SSyncEntityStatsDataPacket(player), (ServerPlayer) player);
        ShinobiNetwork.sendTo(new SSyncDnaPacket(player), (ServerPlayer) player);
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
    public static void dnaHandling(IDna dna)
    {
        Release firstRelease = getRandomRelease(ModValues.NATURE_RELEASES);
        Release secondRelease = new Release();
        Release thirdRelease = new Release();
        do
        {
            secondRelease = getRandomRelease(ModValues.NATURE_RELEASES);
        } while (secondRelease.equals(firstRelease));
        do {
            thirdRelease = getRandomRelease(ModValues.NATURE_RELEASES);
        } while (thirdRelease.equals(firstRelease) || thirdRelease.equals(secondRelease));
        // 10% chance of kekkei genkai
        if (ModValues.random.nextInt(100) < 10)
        {
            Release advancedRelease = getRandomRelease(ModValues.ADVANCED_RELEASES);
            dna.addRelease(advancedRelease);
            for (int i = 0; i < advancedRelease.getSubReleases().size(); i++)
            {
                dna.addRelease(advancedRelease.getSubReleases().get(i));
            }
            return;
        }

        // 10% chance of 3 releases
        if (ModValues.random.nextInt(100) < 10)
        {
            dna.addRelease(firstRelease);
            dna.addRelease(secondRelease);
            dna.addRelease(thirdRelease);
            return;
        }

        if (ModValues.random.nextInt(100) < 50)
        {
            dna.addRelease(firstRelease);
            dna.addRelease(secondRelease);
            return;
        }

        dna.addRelease(firstRelease);
    }

    public static String getRandomString(ArrayList<String> arrayList)
    {
        int randomIndex = ModValues.random.nextInt(arrayList.size());
        return arrayList.get(randomIndex);
    }

    public static Release getRandomRelease(ArrayList<Release> releases)
    {
        int randomIndex = ModValues.random.nextInt(releases.size());
        return releases.get(randomIndex);
    }
}
