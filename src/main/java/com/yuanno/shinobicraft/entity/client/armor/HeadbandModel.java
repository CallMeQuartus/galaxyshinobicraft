package com.yuanno.shinobicraft.entity.client.armor;

import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.game_entities.item.custom.HeadbandItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HeadbandModel extends AnimatedGeoModel<HeadbandItem> {

    /*
    @Override
    public ResourceLocation getModelLocation(HeadbandItem object) {
        ;
    }

    @Override
    public ResourceLocation getTextureLocation(HeadbandItem object) {

    }

    @Override
    public ResourceLocation getAnimationFileLocation(HeadbandItem animatable) {

}
   */

    @Override
    public ResourceLocation getModelResource(HeadbandItem object) {
        return new ResourceLocation(Main.MODID, "geo/headband.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HeadbandItem object) {
        return new ResourceLocation(Main.MODID, "textures/models/headband/headbandunion.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HeadbandItem animatable) {
        return new ResourceLocation(Main.MODID, "animations/headbandanim.json");
    }
}