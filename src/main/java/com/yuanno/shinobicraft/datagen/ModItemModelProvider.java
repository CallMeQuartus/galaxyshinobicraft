package com.yuanno.shinobicraft.datagen;
/*
My Apologies for the Janky code, I ended up copying over strait from the in-built
Item Model Provider, just because 1.19 gen is so much different from 1.20.
My apologies, but thanks for your patience!
 */

import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.game_entities.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class ModItemModelProvider extends ModelProvider<ItemModelBuilder> {

    public ModItemModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, ITEM_FOLDER, ItemModelBuilder::new, existingFileHelper);
    }

    protected void registerModels() {
        simpleItem(ModItems.HEADBAND_UNION);
    }

    public ItemModelBuilder basicItem(Item item)
    {
        return basicItem(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)));
    }

    public ItemModelBuilder basicItem(ResourceLocation item)
    {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", new ResourceLocation(item.getNamespace(), "item/" + item.getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<ArmorItem> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Main.MODID,"item/" + item.getId().getPath()));
    }

    @NotNull
    @Override
    public String getName() {
        return "Item Models: " + modid;
    }
}
