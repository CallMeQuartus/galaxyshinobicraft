package com.yuanno.shinobicraft.client.screens;

import com.mojang.blaze3d.vertex.PoseStack;
import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.api.RendererHelper;
import com.yuanno.shinobicraft.data.dna.DnaCapability;
import com.yuanno.shinobicraft.data.dna.IDna;
import com.yuanno.shinobicraft.data.entity.EntityStatsCapability;
import com.yuanno.shinobicraft.data.entity.IEntityStats;
import com.yuanno.shinobicraft.init.ModValues;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

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
                // Close the screen after a clan is selected
                this.onClose();
            });
            this.addRenderableWidget(button);
        }
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
