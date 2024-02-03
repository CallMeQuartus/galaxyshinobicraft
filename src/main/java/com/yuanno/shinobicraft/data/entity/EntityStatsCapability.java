package com.yuanno.shinobicraft.data.entity;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EntityStatsCapability implements ICapabilitySerializable<CompoundTag> {

    public static final Capability<IEntityStats> INSTANCE = CapabilityManager.get(new CapabilityToken<>() {});
    private final IEntityStats instance = new EntityStatsBase();

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return INSTANCE.orEmpty(cap, LazyOptional.of(() -> this.instance));
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();

        nbt.putInt("ninjaLevel", this.instance.getNinjaLevel());
        nbt.putInt("ninjutsuLevel", this.instance.getNinjutsuLevel());
        nbt.putInt("taijutsuLevel", this.instance.getTaijutsuLevel());
        nbt.putInt("genjutsuLevel", this.instance.getGenjutsuLevel());
        nbt.putInt("kenjutsuLevel", this.instance.getKenjutsuLevel());
        nbt.putInt("medicaljutsuLevel", this.instance.getMedicaljutsuLevel());
        nbt.putInt("fuuinjutsuLevel", this.instance.getFuuinjutsuLevel());
        nbt.putInt("dojutsuLevel", this.instance.getDojutsuLevel());
        nbt.putInt("summoningLevel", this.instance.getSummoningLevel());
        nbt.putInt("senjutsuLevel", this.instance.getSenjutsuLevel());

        nbt.putDouble("ninjutsuExperience", this.instance.getNinjutsuExperience());
        nbt.putDouble("taijutsuExperience", this.instance.getTaijutsuExperience());
        nbt.putDouble("genjutsuExperience", this.instance.getGenjutsuExperience());
        nbt.putDouble("kenjutsuExperience", this.instance.getKenjutsuExperience());
        nbt.putDouble("medicaljutsuExperience", this.instance.getMedicalExperience());
        nbt.putDouble("fuuinjutsuExperience", this.instance.getFuuinjutsuExperience());
        nbt.putDouble("dojutsuExperience", this.instance.getDojutsuExperience());
        nbt.putDouble("summoningExperience", this.instance.getSummoningExperience());
        nbt.putDouble("senjutsuExperience", this.instance.getSenjutsuExperience());

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.instance.setNinjaLevel(nbt.getInt("ninjaLevel"));
        this.instance.setNinjutsuLevel(nbt.getInt("ninjutsuLevel"));
        this.instance.setTaijutsuLevel(nbt.getInt("taijutsuLevel"));
        this.instance.setGenjutsuLevel(nbt.getInt("genjutsuLevel"));
        this.instance.setKenjutsuLevel(nbt.getInt("kenjutsuLevel"));
        this.instance.setMedicaljutsuLevel(nbt.getInt("medicaljutsuLevel"));
        this.instance.setFuuinjutsuLevel(nbt.getInt("fuuinjutsuLevel"));
        this.instance.setDojutsuLevel(nbt.getInt("dojutsuLevel"));
        this.instance.setSummoningLevel(nbt.getInt("summoningLevel"));
        this.instance.setSenjutsuLevel(nbt.getInt("senjutsuLevel"));

        this.instance.setNinjutsuExperience(nbt.getDouble("ninjutsuExperience"));
        this.instance.setTaijutsuExperience(nbt.getDouble("taijutsuExperience"));
        this.instance.setGenjutsuExperience(nbt.getDouble("genjutsuExperience"));
        this.instance.setKenjutsuExperience(nbt.getDouble("kenjutsuExperience"));
        this.instance.setMedicalExperience(nbt.getDouble("medicaljutsuExperience"));
        this.instance.setFuuinjutsuExperience(nbt.getDouble("fuuinjutsuExperience"));
        this.instance.setDojutsuExperience(nbt.getDouble("dojutsuExperience"));
        this.instance.setSummoningExperience(nbt.getDouble("summoningExperience"));
        this.instance.setSenjutsuExperience(nbt.getDouble("senjutsuExperience"));
    }

    @Nullable
    public static IEntityStats get(final LivingEntity entity) {
        IEntityStats props = entity.getCapability(INSTANCE, null).orElse(null);
        if (props != null) {
            props.setOwner(entity);
        }
        return props;
    }

}
