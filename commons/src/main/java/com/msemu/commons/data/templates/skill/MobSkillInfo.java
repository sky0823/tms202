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

package com.msemu.commons.data.templates.skill;

import com.msemu.commons.data.enums.MobSkillStat;
import com.msemu.commons.data.loader.dat.DatSerializable;
import com.msemu.commons.utils.types.Position;
import lombok.Getter;
import lombok.Setter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Weber on 2018/4/23.
 */
@Getter
@Setter
public class MobSkillInfo implements DatSerializable {

    private short id;
    private short level;
    private Map<MobSkillStat, String> mobSkillStats = new HashMap<>();
    private Position lt;
    private Position rb;
    private Position lt2;
    private Position rb2;
    private Position lt3;
    private Position rb3;
    private Set<Integer> ints = new HashSet<>();

    public void putMobSkillStat(MobSkillStat mss, String value) {
        getMobSkillStats().put(mss, value);
    }

    public int getSkillStatIntValue(MobSkillStat mobSkillStat) {
        if (!getMobSkillStats().containsKey(mobSkillStat)) {
            return 0;
        }
        return Integer.parseInt(getSkillStat(mobSkillStat));
    }

    public String getSkillStat(MobSkillStat mobSkillStat) {
        return getMobSkillStats().get(mobSkillStat);
    }

    public void addIntToList(int value) {
        getInts().add(value);
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {
        dos.writeShort(id);
        dos.writeShort(level);
        dos.writeInt(mobSkillStats.size());
        for (Map.Entry<MobSkillStat, String> entry : mobSkillStats.entrySet()) {
            dos.writeUTF(entry.getKey().name());
            dos.writeUTF(entry.getValue());
        }
        dos.writeInt(lt.getX());
        dos.writeInt(lt.getY());
        dos.writeInt(rb.getX());
        dos.writeInt(lt2.getX());
        dos.writeInt(lt2.getY());
        dos.writeInt(rb2.getX());
        dos.writeInt(rb2.getY());
        dos.writeInt(lt3.getX());
        dos.writeInt(lt3.getY());
        dos.writeInt(rb3.getX());
        dos.writeInt(rb3.getY());
        dos.writeInt(ints.size());
        for (Integer value : ints) {
            dos.writeInt(value);
        }
    }

    @Override
    public DatSerializable load(DataInputStream dis) throws IOException {
        setId(dis.readShort());
        setLevel(dis.readShort());
        int mobStatSize = dis.readInt();
        for (int i = 0; i < mobStatSize; i++) {
            getMobSkillStats().put(MobSkillStat.valueOf(dis.readUTF()), dis.readUTF());
        }
        lt = new Position();
        lt.setX(dis.readInt());
        lt.setY(dis.readInt());
        rb = new Position();
        rb.setX(dis.readInt());
        rb.setY(dis.readInt());
        lt2 = new Position();
        lt2.setX(dis.readInt());
        lt2.setY(dis.readInt());
        rb2 = new Position();
        rb2.setX(dis.readInt());
        rb2.setY(dis.readInt());
        lt2 = new Position();
        lt2.setX(dis.readInt());
        lt2.setY(dis.readInt());
        rb3 = new Position();
        rb3.setX(dis.readInt());
        rb3.setY(dis.readInt());
        int intsSize = dis.readInt();
        for (int i = 0; i < intsSize; i++) {
            ints.add(dis.readInt());
        }
        return this;
    }
}
