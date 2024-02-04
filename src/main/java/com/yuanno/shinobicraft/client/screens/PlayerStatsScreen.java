package com.yuanno.shinobicraft.client.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

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

        this.font.draw(matrixStack, "Player Stats", posX, posY, 0xFFFFFF);

        this.font.draw(matrixStack, "Ninja Level: " + this.entityStats.getNinjaLevel(), posX, posY + 20, 0xFFFFFF);
        this.font.draw(matrixStack, "Ninjutsu Level: " + this.entityStats.getNinjutsuLevel(), posX, posY + 40, 0xFFFFFF);
        this.font.draw(matrixStack, "Taijutsu Level: " + this.entityStats.getTaijutsuLevel(), posX, posY + 60, 0xFFFFFF);
        this.font.draw(matrixStack, "Genjutsu Level: " + this.entityStats.getGenjutsuLevel(), posX, posY + 80, 0xFFFFFF);
        this.font.draw(matrixStack, "Kenjutsu Level: " + this.entityStats.getKenjutsuLevel(), posX, posY + 100, 0xFFFFFF);
        this.font.draw(matrixStack, "Medicaljutsu Level: " + this.entityStats.getMedicaljutsuLevel(), posX, posY + 120, 0xFFFFFF);
        this.font.draw(matrixStack, "Fuuinjutsu Level: " + this.entityStats.getFuuinjutsuLevel(), posX, posY + 140, 0xFFFFFF);
        this.font.draw(matrixStack, "Dojutsu Level: " + this.entityStats.getDojutsuLevel(), posX, posY + 160, 0xFFFFFF);
        this.font.draw(matrixStack, "Summoning Level: " + this.entityStats.getSummoningLevel(), posX, posY + 180, 0xFFFFFF);
        this.font.draw(matrixStack, "Senjutsu Level: " + this.entityStats.getSenjutsuLevel(), posX, posY + 200, 0xFFFFFF);
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
