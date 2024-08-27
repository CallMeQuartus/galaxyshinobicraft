package com.yuanno.shinobicraft.entity.client.armor;
import com.yuanno.shinobicraft.game_entities.item.custom.HeadbandItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class HeadbandRenderer extends GeoArmorRenderer<HeadbandItem> {
    public HeadbandRenderer() {
        super(new HeadbandModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}