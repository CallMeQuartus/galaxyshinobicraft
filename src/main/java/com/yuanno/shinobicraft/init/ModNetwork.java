package com.yuanno.shinobicraft.init;

import com.yuanno.shinobicraft.networking.ShinobiNetwork;
import com.yuanno.shinobicraft.networking.client.COpenClanChoiceScreenPacket;
import com.yuanno.shinobicraft.networking.client.COpenPlayerScreenPacket;
import com.yuanno.shinobicraft.networking.server.SOpenClanChoiceScreenPacket;
import com.yuanno.shinobicraft.networking.server.SOpenPlayerScreenPacket;
import com.yuanno.shinobicraft.networking.server.SSyncDnaPacket;
import com.yuanno.shinobicraft.networking.server.SSyncEntityStatsDataPacket;

/**
 * Registering of the packets
 */
public class ModNetwork {

    public static void init()
    {
        // SERVER SIDE
        ShinobiNetwork.registerPacket(SSyncEntityStatsDataPacket.class, SSyncEntityStatsDataPacket::encode, SSyncEntityStatsDataPacket::decode, SSyncEntityStatsDataPacket::handle);
        ShinobiNetwork.registerPacket(SOpenPlayerScreenPacket.class, SOpenPlayerScreenPacket::encode, SOpenPlayerScreenPacket::decode, SOpenPlayerScreenPacket::handle);
        ShinobiNetwork.registerPacket(SSyncDnaPacket.class, SSyncDnaPacket::encode, SSyncDnaPacket::decode, SSyncDnaPacket::handle);
        ShinobiNetwork.registerPacket(SOpenClanChoiceScreenPacket.class, SOpenClanChoiceScreenPacket::encode, SOpenClanChoiceScreenPacket::decode, SOpenClanChoiceScreenPacket::handle);


        // CLIENT SIDE
        ShinobiNetwork.registerPacket(COpenPlayerScreenPacket.class, COpenPlayerScreenPacket::encode, COpenPlayerScreenPacket::decode, COpenPlayerScreenPacket::handle);
        ShinobiNetwork.registerPacket(COpenClanChoiceScreenPacket.class, COpenClanChoiceScreenPacket::encode, COpenClanChoiceScreenPacket::decode, COpenClanChoiceScreenPacket::handle);

    }
}
