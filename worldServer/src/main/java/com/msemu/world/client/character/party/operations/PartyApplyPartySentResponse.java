package com.msemu.world.client.character.party.operations;

import com.msemu.commons.network.packets.OutPacket;
import com.msemu.core.network.GameClient;
import com.msemu.world.enums.PartyResultType;

/**
 * Created by Weber on 2018/5/4.
 */
public class PartyApplyPartySentResponse implements IPartyResult {

    private String charName;

    public PartyApplyPartySentResponse(String charName) {
        this.charName = charName;
    }

    @Override
    public PartyResultType getType() {
        return PartyResultType.PartyRes_ApplyParty_Sent;
    }

    @Override
    public void encode(OutPacket<GameClient> outPacket) {
        outPacket.encodeString(charName);
    }
}
