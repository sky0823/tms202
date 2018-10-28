/*
 * MIT License
 *
 * Copyright (c) 2018 msemu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.msemu.world.client.field.lifes;

import com.msemu.commons.network.packets.OutPacket;
import com.msemu.core.network.GameClient;
import com.msemu.core.network.packets.outpacket.reactor.LP_ReactorEnterField;
import com.msemu.core.network.packets.outpacket.reactor.LP_ReactorLeaveField;
import com.msemu.world.enums.FieldObjectType;
import lombok.Getter;
import lombok.Setter;

public class Reactor extends Life {

    @Getter
    private int templacteId;

    @Getter
    @Setter
    private int state;

    @Getter
    @Setter
    private boolean flip;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int ownerId;

    @Override
    public FieldObjectType getFieldObjectType() {
        return FieldObjectType.REACTOR;
    }

    @Override
    public void enterScreen(GameClient client) {
        client.write(new LP_ReactorEnterField(this));
    }

    @Override
    public void outScreen(GameClient client) {
        client.write(new LP_ReactorLeaveField(this));
    }

}
