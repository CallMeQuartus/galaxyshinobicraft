package com.yuanno.shinobicraft.data.dna;

import com.yuanno.shinobicraft.releases.Release;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.ArrayList;

public interface IDna extends INBTSerializable<CompoundTag> {

    IDna setOwner(LivingEntity entity);

    void addRelease(Release release);
    void removeRelease(Release release);
    ArrayList<Release> getReleases();

    void addDojutsu(String dojutsu);
    void removeDojutsu(String dojutsu);
    ArrayList<String> getDojutsus();
}
