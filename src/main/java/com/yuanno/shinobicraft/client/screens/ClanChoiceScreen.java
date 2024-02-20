package com.yuanno.shinobicraft.client.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.api.RendererHelper;
import com.yuanno.shinobicraft.data.dna.DnaCapability;
import com.yuanno.shinobicraft.data.dna.IDna;
import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import com.yuanno.shinobicraft.init.ModValues;
import com.yuanno.shinobicraft.networking.ShinobiNetwork;
import com.yuanno.shinobicraft.networking.client.CSyncDnaPacket;
import com.yuanno.shinobicraft.networking.client.CSyncEntityStatsDataPacket;
import com.yuanno.shinobicraft.networking.server.SSyncEntityStatsDataPacket;
import com.yuanno.shinobicraft.releases.Release;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;

/**
 * A screen that displays the player's stats.
 */
public class ClanChoiceScreen extends Screen {

    private final Player player;
    private final IEntityStats entityStats;
    private final IDna dna;
    public ClanChoiceScreen() {
        super(Component.empty());
        this.player = Minecraft.getInstance().player;
        this.entityStats = EntityStatsCapability.get(player);
        this.dna = DnaCapability.get(player);
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);

        int posX = (this.width - 256) / 2;
        int posY = (this.height - 256) / 2;


        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    public void init() {
        super.init();
        int buttonWidth = 110;
        int buttonHeight = 20;
        int posX = this.width / 2;
        int posY = this.height / 2;
        int localX = posX - 187;
        int localY = posY - 80;
        for (int i = 0; i < ModValues.CLANS.size(); i++) {
            String clan = ModValues.CLANS.get(i);
            if (i % 4 == 0 && i != 0) {
                localX += 115;
                localY = posY - 80;
            }
            localY += 22;
            Button button = new Button(localX, localY, buttonWidth, buttonHeight, Component.translatable(clan), buttonS -> {
                // Set player's clan to the current clan
                this.dna.setClan(clan);
                statsHandling(this.entityStats);
                dnaHandling(this.dna);
                ShinobiNetwork.sendToServer(new CSyncEntityStatsDataPacket(player));
                ShinobiNetwork.sendToServer(new CSyncDnaPacket(player));
                this.onClose();
            }, (but, matrixStack, mouseX, mouseY) -> {
                this.renderTooltip(matrixStack, Component.translatable(ModValues.CLAN_DESCRIPTIONS.get(clan)), mouseX, mouseY);
            });
            this.addRenderableWidget(button);
        }
    }

    public static void statsHandling(IEntityStats entityStats)
    {
        entityStats.setNinjaLevel(1);
        entityStats.setNinjutsuLevel(1);
        entityStats.setTaijutsuLevel(1);
        entityStats.setGenjutsuLevel(1);
        entityStats.setKenjutsuLevel(1);
        entityStats.setMedicaljutsuLevel(1);
        entityStats.setFuuinjutsuLevel(1);
        entityStats.setDojutsuLevel(1);
        entityStats.setSummoningLevel(1);
        entityStats.setSenjutsuLevel(1);
        entityStats.setNinjutsuExperience(0);
        entityStats.setTaijutsuExperience(0);
        entityStats.setGenjutsuExperience(0);
        entityStats.setKenjutsuExperience(0);
        entityStats.setMedicalExperience(0);
        entityStats.setFuuinjutsuExperience(0);
        entityStats.setDojutsuExperience(0);
        entityStats.setSummoningExperience(0);
        entityStats.setSenjutsuExperience(0);
    }

    public static void dnaHandling(IDna dna)
    {
        // special checks for dojutsu
        if (dna.getClan().equals(ModValues.UCHIHA))
            dna.addDojutsu(ModValues.SHARINGAN);
        else if (dna.getClan().equals(ModValues.HYUGA))
            dna.addDojutsu(ModValues.BYAKUGAN);
        else if (dna.getClan().equals(ModValues.CHINOIKE))
            dna.addDojutsu(ModValues.KETSURYUGAN);

        Release firstRelease = new Release();
        // if uchiha always have fire as first release
        if (dna.getClan().equals(ModValues.UCHIHA))
            firstRelease = ModValues.FIRE_RELEASE;
        else
            firstRelease = getRandomRelease(ModValues.NATURE_RELEASES);
        Release secondRelease = new Release();
        Release thirdRelease = new Release();
        do
        {
            secondRelease = getRandomRelease(ModValues.NATURE_RELEASES);
        } while (secondRelease.equals(firstRelease));
        do {
            thirdRelease = getRandomRelease(ModValues.NATURE_RELEASES);
        } while (thirdRelease.equals(firstRelease) || thirdRelease.equals(secondRelease));

        // check for sarutobi, at least 3 nature releases
        if (dna.getClan().equals(ModValues.SARUTOBI))
        {
            dna.addRelease(firstRelease);
            dna.addRelease(secondRelease);
            dna.addRelease(thirdRelease);
            // 50% chance to get a fourth release
            if (ModValues.random.nextInt(100) < 50)
            {
                Release fourthRelease = new Release();
                do {
                    fourthRelease = getRandomRelease(ModValues.NATURE_RELEASES);
                } while (fourthRelease.equals(firstRelease) || fourthRelease.equals(secondRelease) || fourthRelease.equals(thirdRelease));
                dna.addRelease(fourthRelease);
                return;
            }

            // 10% chance to get a fifth release
            if (ModValues.random.nextInt(100) < 10)
            {
                for (int i = 0; i < ModValues.NATURE_RELEASES.size(); i++)
                {
                    dna.addRelease(ModValues.NATURE_RELEASES.get(i));
                }
                return;
            }

            if (ModValues.random.nextInt(100) < 10)
            {
                Release advancedRelease = getRandomRelease(ModValues.ADVANCED_RELEASES);
                dna.addRelease(advancedRelease);
                for (int i = 0; i < advancedRelease.getSubReleases().size(); i++)
                {
                    if (!dna.getReleases().contains(advancedRelease.getSubReleases().get(i)))
                        dna.addRelease(advancedRelease.getSubReleases().get(i));
                }
                return;
            }
        }

        // 10% chance of kekkei genkai
        if (ModValues.random.nextInt(100) < 10)
        {
            if (dna.getClan().equals(ModValues.UCHIHA))
                dna.addRelease(ModValues.FIRE_RELEASE);
            Release advancedRelease = getRandomRelease(ModValues.ADVANCED_RELEASES);
            dna.addRelease(advancedRelease);
            for (int i = 0; i < advancedRelease.getSubReleases().size(); i++)
            {
                if (!dna.getReleases().contains(advancedRelease.getSubReleases().get(i)))
                    dna.addRelease(advancedRelease.getSubReleases().get(i));
            }
            return;
        }

        // 10% chance of 3 releases
        if (ModValues.random.nextInt(100) < 10)
        {
            dna.addRelease(firstRelease);
            dna.addRelease(secondRelease);
            dna.addRelease(thirdRelease);
            return;
        }

        if (ModValues.random.nextInt(100) < 50)
        {
            dna.addRelease(firstRelease);
            dna.addRelease(secondRelease);
            return;
        }

        dna.addRelease(firstRelease);
    }

    public static Release getRandomRelease(ArrayList<Release> releases)
    {
        int randomIndex = ModValues.random.nextInt(releases.size());
        return releases.get(randomIndex);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }


    public static void open()
    {
        Minecraft.getInstance().setScreen(new ClanChoiceScreen());
    }
}
