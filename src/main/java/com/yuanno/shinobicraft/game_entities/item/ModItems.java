package com.yuanno.shinobicraft.game_entities.item;

import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.game_entities.item.custom.HeadbandItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    public static final RegistryObject<ArmorItem> HEADBAND_UNION = ITEMS.register("headband_union",
            () -> new HeadbandItem(ArmorTiers.WOOL, EquipmentSlot.HEAD, new Item.Properties()));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }


    //Wool Tier for HeadBands Only
    public static class ArmorTiers {
        public static final ArmorMaterial WOOL = new ModArmorMaterial(
                "wool",
                500,
                new int[] { 20, 40, 50, 10 },
                300,
                SoundEvents.ARMOR_EQUIP_LEATHER,
                0.0f,
                0.0f,
                () -> Ingredient.of(Items.WHITE_WOOL));
    }
}

