package com.yuanno.shinobicraft.data.dna;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nullable;

public class DnaCapability implements ICapabilitySerializable<CompoundTag> {

    public static final Capability<IDna> INSTANCE = CapabilityManager.get(new CapabilityToken<>() {});
    private final IDna instance = new DnaDataBase();

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        return DnaCapability.INSTANCE.orEmpty(cap, LazyOptional.of(() -> this.instance));
    }

    @Override
    public CompoundTag serializeNBT() {
        return this.instance.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.instance.deserializeNBT(nbt);
    }

    public static IDna get(final LivingEntity entity) {
        IDna props = entity.getCapability(INSTANCE, null).orElse(new DnaDataBase());
        props.setOwner(entity);
        return props;
    }

    @Nullable
    public static IDna getLazy(final LivingEntity entity) {
        return entity.getCapability(INSTANCE, null).orElse(null);
    }
}
