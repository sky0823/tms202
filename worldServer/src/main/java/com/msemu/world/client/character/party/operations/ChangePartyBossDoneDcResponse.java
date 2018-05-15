package com.msemu.world.client.character.party.operations;

import com.msemu.commons.network.packets.OutPacket;
import com.msemu.core.network.GameClient;
import com.msemu.world.enums.PartyResultType;

/**
 * Created by Weber on 2018/5/4.
 */
public class ChangePartyBossDoneDcResponse extends ChangePartyBossDoneResponse {

    public ChangePartyBossDoneDcResponse(int partyBossCharacterId) {
        super(partyBossCharacterId);
    }

    @Override
    public PartyResultType getType() {
        return PartyResultType.PartyRes_ChangePartyBoss_Done_DC;
    }

    @Override
    public void encode(OutPacket<GameClient> outPacket) {
        outPacket.encodeByte(partyBossCharacterId);
        outPacket.encodeByte(true);
    }
}