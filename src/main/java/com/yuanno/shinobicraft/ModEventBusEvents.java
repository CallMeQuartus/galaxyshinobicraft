package com.yuanno.shinobicraft;

import com.yuanno.shinobicraft.entity.client.armor.HeadbandRenderer;
import com.yuanno.shinobicraft.game_entities.item.custom.HeadbandItem;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = Main.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(HeadbandItem.class, new HeadbandRenderer());
    }
}