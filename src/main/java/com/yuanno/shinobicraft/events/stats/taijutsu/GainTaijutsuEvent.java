package com.yuanno.shinobicraft.events.stats.taijutsu;

import com.yuanno.shinobicraft.Main;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class GainTaijutsuEvent {

    @SubscribeEvent
    public static void onAttackEvent(LivingAttackEvent event)
    {
        if (event.getSource().getEntity() instanceof Player player && player.getMainHandItem().isEmpty())
        {
            if (player.level.isClientSide)
                return;
            TaijutsuEvent taijutsuEvent = new TaijutsuEvent(player);
            MinecraftForge.EVENT_BUS.post(taijutsuEvent);
        }
    }
}
