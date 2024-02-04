package com.yuanno.shinobicraft.data.dna;

import com.yuanno.shinobicraft.releases.Release;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;

public class DnaDataBase implements IDna {

    private LivingEntity owner;
    private ArrayList<String> releases;
    private ArrayList<String> dojutsus;
    private ArrayList<Release> specialReleases;
    public IDna setOwner(LivingEntity entity)
    {
        this.owner = entity;
        return this;
    }

    public void addRelease(String release)
    {
        this.releases.add(release);
    }
    public void removeRelease(String release)
    {
        this.releases.remove(release);
    }
    public ArrayList<String> getReleases()
    {
        return this.releases;
    }

    public void addDojutsu(String dojutsu)
    {
        this.dojutsus.add(dojutsu);
    }
    public void removeDojutsu(String dojutsu)
    {
        this.dojutsus.remove(dojutsu);
    }
    public ArrayList<String> getDojutsus()
    {
        return this.dojutsus;
    }

    public void addSpecialRelease(Release release)
    {
        this.specialReleases.add(release);
    }
    public void removeSpecialRelease(Release release)
    {
        this.specialReleases.remove(release);
    }
    public ArrayList<Release> getSpecialReleases()
    {
        return this.specialReleases;
    }
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();

        nbt.putInt("releases", this.releases.size());
        for (int i = 0; i < this.releases.size(); i++)
        {
            nbt.putString("release" + i, this.releases.get(i));
        }
        nbt.putInt("dojutsus", this.dojutsus.size());
        for (int i = 0; i < this.dojutsus.size(); i++)
        {
            nbt.putString("dojutsu" + i, this.dojutsus.get(i));
        }

        nbt.putInt("specialReleases", this.specialReleases.size());
        for (int i = 0; i < this.specialReleases.size(); i++)
        {
            nbt.putString("specialRelease" + i, this.specialReleases.get(i).getRelease());
        }
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        int releases = nbt.getInt("releases");
        for (int i = 0; i < releases; i++)
        {
            this.addRelease(nbt.getString("release" + i));
        }
        int dojutsus = nbt.getInt("dojutsus");
        for (int i = 0; i < dojutsus; i++)
        {
            this.addDojutsu(nbt.getString("dojutsu" + i));
        }
        int specialReleases = nbt.getInt("specialReleases");
        for (int i = 0; i < specialReleases; i++)
        {
            this.addSpecialRelease(new Release(nbt.getString("specialRelease" + i)));
        }
    }
}
