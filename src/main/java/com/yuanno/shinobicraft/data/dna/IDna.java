package com.yuanno.shinobicraft.data.dna;

import com.yuanno.shinobicraft.releases.Release;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.ArrayList;

public interface IDna extends INBTSerializable<CompoundTag> {

    IDna setOwner(LivingEntity entity);

    void addRelease(String release);
    void removeRelease(String release);
    ArrayList<String> getReleases();

    void addDojutsu(String dojutsu);
    void removeDojutsu(String dojutsu);
    ArrayList<String> getDojutsus();

    void addSpecialRelease(Release release);
    void removeSpecialRelease(Release release);
    ArrayList<Release> getSpecialReleases();
}
