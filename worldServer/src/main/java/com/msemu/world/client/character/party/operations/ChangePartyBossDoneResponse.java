package com.msemu.world.client.character.party.operations;

import com.msemu.commons.network.packets.OutPacket;
import com.msemu.core.network.GameClient;
import com.msemu.world.enums.PartyResultType;

/**
 * Created by Weber on 2018/5/4.
 */
public class ChangePartyBossDoneResponse implements IPartyResult {

    protected int partyBossCharacterId;

    public ChangePartyBossDoneResponse(int partyBossCharacterId) {
        this.partyBossCharacterId = partyBossCharacterId;
    }

    @Override
    public PartyResultType getType() {
        return PartyResultType.PartyRes_ChangePartyBoss_Done;
    }

    @Override
    public void encode(OutPacket<GameClient> outPacket) {
        outPacket.encodeInt(partyBossCharacterId);
        outPacket.encodeByte(false);
    }
}
