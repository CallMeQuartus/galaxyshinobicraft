package com.yuanno.shinobicraft.data.dna;

import com.yuanno.shinobicraft.releases.Release;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;

import java.util.ArrayList;

public class DnaDataBase implements IDna {

    private LivingEntity owner;
    private ArrayList<Release> releases = new ArrayList<>();
    private ArrayList<String> dojutsus = new ArrayList<>();
    private String clan = "";
    public IDna setOwner(LivingEntity entity)
    {
        this.owner = entity;
        return this;
    }

    public void addRelease(Release release)
    {
        this.releases.add(release);
    }
    public void removeRelease(Release release)
    {
        this.releases.remove(release);
    }
    public ArrayList<Release> getReleases()
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

    public void setClan(String clan)
    {
        this.clan = clan;
    }

    public String getClan()
    {
        return this.clan;
    }
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();

        nbt.putInt("releases", this.releases.size());
        for (int i = 0; i < this.releases.size(); i++)
        {
            nbt.putString("release" + i, this.releases.get(i).getRelease());
        }
        nbt.putInt("dojutsus", this.dojutsus.size());
        for (int i = 0; i < this.dojutsus.size(); i++)
        {
            nbt.putString("dojutsu" + i, this.dojutsus.get(i));
        }
        nbt.putString("clan", this.clan);

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        int releases = nbt.getInt("releases");
        for (int i = 0; i < releases; i++)
        {
            this.addRelease(new Release(nbt.getString("release" + i)));
        }
        int dojutsus = nbt.getInt("dojutsus");
        for (int i = 0; i < dojutsus; i++)
        {
            this.addDojutsu(nbt.getString("dojutsu" + i));
        }
        this.setClan(nbt.getString("clan"));
    }
}
