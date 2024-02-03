package com.yuanno.shinobicraft.data.entity;

import net.minecraft.world.entity.LivingEntity;

public class EntityStatsBase implements IEntityStats {

    private LivingEntity owner;
    private int ninjaLevel, ninjutsuLevel, taijutsuLevel, genjutsuLevel, kenjutsuLevel, medicaljutsuLevel, fuuinjutsuLevel, dojutsuLevel, summoningLevel, senjutsuLevel;
    private double ninjutsuExperience, taijutsuExperience, genjutsuExperience, kenjutsuExperience, medicalExperience, fuuinjutsuExperience, dojutsuExperience, summoningExperience, senjutsuExperience;

    public IEntityStats setOwner(LivingEntity entity)
    {
        this.owner = entity;
        return this;
    }

    public void setNinjaLevel(int amount)
    {
        this.ninjaLevel = amount;
    }
    public void alterNinjaLevel(int amount)
    {
        this.ninjaLevel += amount;
    }
    public int getNinjaLevel()
    {
        return this.ninjaLevel;
    }
    public void setNinjutsuLevel(int amount)
    {
        this.ninjutsuLevel = amount;
    }
    public void alterNinjutsuLevel(int amount)
    {
        this.ninjutsuLevel += amount;
    }
    public int getNinjutsuLevel()
    {
        return this.ninjutsuLevel;
    }
    public void setTaijutsuLevel(int amount)
    {
        this.taijutsuLevel = amount;
    }
    public void alterTaijutsuLevel(int amount)
    {
        this.taijutsuLevel += amount;
    }
    public int getTaijutsuLevel()
    {
        return this.taijutsuLevel;
    }
    public void setGenjutsuLevel(int amount)
    {
        this.genjutsuLevel = amount;
    }
    public void alterGenjutsuLevel(int amount)
    {
        this.genjutsuLevel += amount;
    }
    public int getGenjutsuLevel()
    {
        return this.genjutsuLevel;
    }
    public void setKenjutsuLevel(int amount)
    {
        this.kenjutsuLevel = amount;
    }
    public void alterKenjutsuLevel(int amount)
    {
        this.kenjutsuLevel += amount;
    }
    public int getKenjutsuLevel()
    {
        return this.kenjutsuLevel;
    }
    public void setMedicaljutsuLevel(int amount)
    {
        this.medicaljutsuLevel = amount;
    }
    public void alterMedicaljutsuLevel(int amount)
    {
        this.medicaljutsuLevel += amount;
    }
    public int getMedicaljutsuLevel()
    {
        return this.medicaljutsuLevel;
    }
    public void setFuuinjutsuLevel(int amount)
    {
        this.fuuinjutsuLevel = amount;
    }
    public void alterFuuinjutsuLevel(int amount)
    {
        this.fuuinjutsuLevel += amount;
    }
    public int getFuuinjutsuLevel()
    {
        return this.fuuinjutsuLevel;
    }
    public void setDojutsuLevel(int amount)
    {
        this.dojutsuLevel = amount;
    }
    public void alterDojutsuLevel(int amount)
    {
        this.dojutsuLevel += amount;
    }
    public int getDojutsuLevel()
    {
        return this.dojutsuLevel;
    }
    public void setSummoningLevel(int amount)
    {
        this.summoningLevel = amount;
    }
    public void alterSummoningLevel(int amount)
    {
        this.summoningLevel += amount;
    }
    public int getSummoningLevel()
    {
        return this.summoningLevel;
    }
    public void setSenjutsuLevel(int amount)
    {
        this.senjutsuLevel = amount;
    }
    public void alterSenjutsuLevel(int amount)
    {
        this.senjutsuLevel += amount;
    }
    public int getSenjutsuLevel()
    {
        return this.senjutsuLevel;
    }
    public void setNinjutsuExperience(double amount)
    {
        this.ninjutsuExperience = amount;
    }
    public void alterNinjutsuExperience(double amount)
    {
        this.ninjutsuExperience += amount;
    }
    public double getNinjutsuExperience()
    {
        return this.ninjutsuExperience;
    }
    public void setTaijutsuExperience(double amount)
    {
        this.taijutsuExperience = amount;
    }
    public void alterTaijutsuExperience(double amount)
    {
        this.taijutsuExperience += amount;
    }
    public double getTaijutsuExperience()
    {
        return this.taijutsuExperience;
    }
    public void setGenjutsuExperience(double amount)
    {
        this.genjutsuExperience = amount;
    }
    public void alterGenjutsuExperience(double amount)
    {
        this.genjutsuExperience += amount;
    }
    public double getGenjutsuExperience()
    {
        return this.genjutsuExperience;
    }
    public void setKenjutsuExperience(double amount)
    {
        this.kenjutsuExperience = amount;
    }
    public void alterKenjutsuExperience(double amount)
    {
        this.kenjutsuExperience += amount;
    }
    public double getKenjutsuExperience()
    {
        return this.kenjutsuExperience;
    }
    public void setMedicalExperience(double amount)
    {
        this.medicalExperience = amount;
    }
    public void alterMedicalExperience(double amount)
    {
        this.medicalExperience += amount;
    }
    public double getMedicalExperience()
    {
        return this.medicalExperience;
    }
    public void setFuuinjutsuExperience(double amount)
    {
        this.fuuinjutsuExperience = amount;
    }
    public void alterFuuinjutsuExperience(double amount)
    {
        this.fuuinjutsuExperience += amount;
    }
    public double getFuuinjutsuExperience()
    {
        return this.fuuinjutsuExperience;
    }
    public void setDojutsuExperience(double amount)
    {
        this.dojutsuExperience = amount;
    }
    public void alterDojutsuExperience(double amount)
    {
        this.dojutsuExperience += amount;
    }
    public double getDojutsuExperience()
    {
        return this.dojutsuExperience;
    }
    public void setSummoningExperience(double amount)
    {
        this.summoningExperience = amount;
    }
    public void alterSummoningExperience(double amount)
    {
        this.summoningExperience += amount;
    }
    public double getSummoningExperience()
    {
        return this.summoningExperience;
    }
    public void setSenjutsuExperience(double amount)
    {
        this.senjutsuExperience = amount;
    }
    public void alterSenjutsuExperience(double amount)
    {
        this.senjutsuExperience += amount;
    }
    public double getSenjutsuExperience()
    {
        return this.senjutsuExperience;
    }

}
