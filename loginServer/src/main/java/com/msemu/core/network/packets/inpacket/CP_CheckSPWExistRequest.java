package com.msemu.core.network.packets.inpacket;

import com.msemu.commons.network.packets.InPacket;
import com.msemu.core.network.LoginClient;
import com.msemu.core.network.packets.outpacket.login.LP_CheckSPWExistResult;

/**
 * Created by Weber on 2018/4/19.
 */
public class CP_CheckSPWExistRequest extends InPacket<LoginClient> {
    public CP_CheckSPWExistRequest(short opcode) {
        super(opcode);
    }

    @Override
    public void read() {

    }

    @Override
    public void runImpl() {
        client.write(new LP_CheckSPWExistResult(3, false));
    }
}