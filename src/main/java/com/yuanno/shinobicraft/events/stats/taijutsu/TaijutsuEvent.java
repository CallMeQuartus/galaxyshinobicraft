package com.yuanno.shinobicraft.events.stats.taijutsu;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.Event;

/**
 * Event fired when the user attacks with bare hands
 * only server side
 */
public class TaijutsuEvent extends Event {

    private Player player;

    public TaijutsuEvent(Player player)
    {
        this.player = player;
    }

    public Player getPlayer()
    {
        return this.player;
    }
}
