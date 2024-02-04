package com.yuanno.shinobicraft.client.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

/**
 * A screen that displays the player's stats.
 */
public class PlayerStatsScreen extends Screen {

    private final Player player;
    private final IEntityStats entityStats;
    public PlayerStatsScreen() {
        super(Component.empty());
        this.player = Minecraft.getInstance().player;
        this.entityStats = EntityStatsCapability.get(player);
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);

        int posX = (this.width - 256) / 2;
        int posY = (this.height - 256) / 2;

        this.font.draw(matrixStack, ChatFormatting.BOLD + "Player Stats", posX + 85, posY + 20, 0xFFFFFF);

        // words
        int leftShift = posX - 40;
        this.font.draw(matrixStack, ChatFormatting.BOLD + "Ninja Level: ", leftShift, posY + 50, 0xFFFFFF);
        this.font.draw(matrixStack, ChatFormatting.BOLD + "Ninjutsu Level: ", leftShift, posY + 65, 0xFFFFFF);
        this.font.draw(matrixStack, ChatFormatting.BOLD + "Taijutsu Level: ", leftShift, posY + 80, 0xFFFFFF);
        this.font.draw(matrixStack, ChatFormatting.BOLD + "Genjutsu Level: ", leftShift, posY + 95, 0xFFFFFF);
        this.font.draw(matrixStack, ChatFormatting.BOLD + "Kenjutsu Level: ", leftShift, posY + 110, 0xFFFFFF);
        this.font.draw(matrixStack, ChatFormatting.BOLD + "Medicaljutsu Level: ", leftShift, posY + 125, 0xFFFFFF);
        this.font.draw(matrixStack, ChatFormatting.BOLD + "Fuuinjutsu Level: ", leftShift, posY + 140, 0xFFFFFF);
        this.font.draw(matrixStack, ChatFormatting.BOLD + "Dojutsu Level: ", leftShift, posY + 155, 0xFFFFFF);
        this.font.draw(matrixStack, ChatFormatting.BOLD + "Summoning Level: ", leftShift, posY + 170, 0xFFFFFF);
        this.font.draw(matrixStack, ChatFormatting.BOLD + "Senjutsu Level: ", leftShift, posY + 185, 0xFFFFFF);

        // levels
        int rightShift = posX + 85;
        this.font.draw(matrixStack, "" + this.entityStats.getNinjaLevel(), rightShift, posY + 50, 0xFFFFFF);
        this.font.draw(matrixStack, "" + this.entityStats.getNinjutsuLevel(), rightShift, posY + 65, 0xFFFFFF);
        this.font.draw(matrixStack, "" + this.entityStats.getTaijutsuLevel(), rightShift, posY + 80, 0xFFFFFF);
        this.font.draw(matrixStack, "" + this.entityStats.getGenjutsuLevel(), rightShift, posY + 95, 0xFFFFFF);
        this.font.draw(matrixStack, "" + this.entityStats.getKenjutsuLevel(), rightShift, posY + 110, 0xFFFFFF);
        this.font.draw(matrixStack, "" + this.entityStats.getMedicaljutsuLevel(), rightShift, posY + 125, 0xFFFFFF);
        this.font.draw(matrixStack, "" + this.entityStats.getFuuinjutsuLevel(), rightShift, posY + 140, 0xFFFFFF);
        this.font.draw(matrixStack, "" + this.entityStats.getDojutsuLevel(), rightShift, posY + 155, 0xFFFFFF);
        this.font.draw(matrixStack, "" + this.entityStats.getSummoningLevel(), rightShift, posY + 170, 0xFFFFFF);
        this.font.draw(matrixStack, "" + this.entityStats.getSenjutsuLevel(), rightShift, posY + 185, 0xFFFFFF);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }


    public static void open()
    {
        Minecraft.getInstance().setScreen(new PlayerStatsScreen());
    }
}
