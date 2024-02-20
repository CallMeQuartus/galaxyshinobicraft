package com.yuanno.shinobicraft.events.stats.kenjutsu;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.Event;

/**
 * Event fired when the user attacks with a weapon
 * only server side
 */
public class KenjutsuEvent extends Event {

    private Player player;

    public KenjutsuEvent(Player player)
    {
        this.player = player;
    }

    public Player getPlayer()
    {
        return this.player;
    }
}
