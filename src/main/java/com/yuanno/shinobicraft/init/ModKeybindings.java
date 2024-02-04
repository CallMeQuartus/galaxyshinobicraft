package com.yuanno.shinobicraft.init;

import com.yuanno.shinobicraft.Main;
import com.yuanno.shinobicraft.networking.ShinobiNetwork;
import com.yuanno.shinobicraft.networking.client.COpenPlayerScreenPacket;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.controls.KeyBindsList;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

/**
 * Registers the keybinds
 * Also handles what the keybinds will do
 * Might make a completely other class for that later
 */
public class ModKeybindings {

    public static KeyMapping playerScreen = new KeyMapping("key.shinobicraft.stats", GLFW.GLFW_KEY_T, "key.categories.shinobicraft");

    @Mod.EventBusSubscriber(modid = Main.MODID, value = Dist.CLIENT)
    public static class Registration {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event)
        {
            if (playerScreen.consumeClick() && Minecraft.getInstance().screen == null)
            {
                ShinobiNetwork.sendToServer(new COpenPlayerScreenPacket());
            }
        }
    }
    @Mod.EventBusSubscriber(modid = Main.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerKeyBindings(RegisterKeyMappingsEvent event) {
            event.register(playerScreen);
        }
    }
}
