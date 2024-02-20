package com.yuanno.shinobicraft.events.stats.kenjutsu;

import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.events.stats.taijutsu.TaijutsuEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MODID)
public class GainKenjutsuEvent {

    @SubscribeEvent
    public static void onAttackEvent(LivingAttackEvent event)
    {
        if (event.getSource().getEntity() instanceof Player player)
        {
            if (player.level.isClientSide)
                return;
            ItemStack itemStack = player.getMainHandItem();
            if (itemStack.getItem().asItem() instanceof SwordItem || itemStack.getItem().asItem() instanceof BowItem) {
                KenjutsuEvent kenjutsuEvent = new KenjutsuEvent(player);
                MinecraftForge.EVENT_BUS.post(kenjutsuEvent);
            }
        }
    }
}
