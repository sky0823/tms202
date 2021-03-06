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

package com.msemu.world.client.field;

import com.msemu.commons.data.templates.skill.SkillInfo;
import com.msemu.commons.utils.types.Rect;
import com.msemu.core.network.GameClient;
import com.msemu.world.client.character.AttackInfo;
import com.msemu.world.client.character.Character;
import com.msemu.world.client.character.skill.Skill;
import com.msemu.world.client.character.stats.Option;
import com.msemu.world.client.character.stats.TemporaryStatManager;
import com.msemu.world.client.field.lifes.Mob;
import com.msemu.world.client.field.lifes.skills.MobTemporaryStat;
import com.msemu.world.data.SkillData;
import com.msemu.world.enums.FieldObjectType;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Weber on 2018/4/11.
 */
public class AffectedArea extends AbstractFieldObject {

    @Getter
    @Setter
    private Rect rect;
    @Getter
    @Setter
    private int charID, skillID, force, option, elemAttr, idk;
    @Getter
    @Setter
    private byte slv, mobOrigin;
    @Getter
    @Setter
    private short delay;
    @Getter
    @Setter
    private boolean flip;
    @Getter
    @Setter
    private Field field;

    public AffectedArea(int objectId) {
        setObjectId(objectId);
    }

    public static AffectedArea getAffectedArea(AttackInfo attackInfo) {
        AffectedArea aa = new AffectedArea(-1);
        aa.setSkillID(attackInfo.skillId);
        aa.setSlv(attackInfo.slv);
        aa.setElemAttr(attackInfo.elemAttr);
        aa.setForce(attackInfo.force);
        aa.setOption(attackInfo.option);
        return aa;
    }

    public static AffectedArea getPassiveAA(int skillID, byte slv) {
        AffectedArea aa = new AffectedArea(-1);
        aa.setSkillID(skillID);
        aa.setSlv(slv);
        return aa;
    }

    public void handleMobInside(Mob mob) {
        Character chr = getField().getCharacterById(getCharID());
        if (chr == null) {
            return;
        }
        TemporaryStatManager tsm = chr.getTemporaryStatManager();
        int skillID = getSkillID();
        Skill skill = chr.getSkill(getSkillID());
        byte slv = getSlv();
        SkillInfo si = SkillData.getInstance().getSkillInfoById(skillID);
        MobTemporaryStat mts = mob.getTemporaryStat();
        Option o = new Option();
        Option o1 = new Option();
        Option o2 = new Option();
        Option o3 = new Option();
        switch (skillID) {
//            case Magician.POISON_MIST:
//            case Archer.火焰衝擊:
//            case Kanna.妖雲召喚:
//                if(!mts.hasBurnFromSkill(skillID)) {
//                    mts.createAndAddBurnedInfo(getCharID(), skill, 1);
//                }
//                break;
//            case Shade.SPIRIT_TRAP:
//                o.nOption = 1;
//                o.rOption = skillID;
//                o.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobBuffStat.Freeze, o);
//                break;
//            case Thief.FRAILTY_CURSE:
//                o.nOption = si.getValue(SkillStat.y, slv);
//                o.rOption = skillID;
//                o.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobBuffStat.Speed, o);
//                o1.nOption = si.getValue(SkillStat.x, slv);
//                o1.rOption = skillID;
//                o1.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobBuffStat.PAD, o);
//                mts.addStatOptionsAndBroadcast(MobBuffStat.PDR, o);
//                mts.addStatOptionsAndBroadcast(MobBuffStat.MAD, o);
//                mts.addStatOptionsAndBroadcast(MobBuffStat.MDR, o);
//                break;
//            case Zero.TIME_DISTORTION:
//                o.nOption = 1;
//                o.rOption = skillID;
//                o.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobBuffStat.Freeze, o);
//                o1.nOption = si.getValue(SkillStat.x, slv);
//                o1.rOption = skillID;
//                o1.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobBuffStat.AddDamParty, o1);
//                o1.nOption = 1;
//                o1.rOption = skillID;
//                o1.tOption = si.getValue(time, slv);
//                mts.addStatOptionsAndBroadcast(MobBuffStat.MagicCrash, o1);
//                break;
        }
    }

    public void handleCharInside(Character chr) {
        TemporaryStatManager tsm = chr.getTemporaryStatManager();
        if (tsm.hasAffectedArea(this)) {
            return;
        }
        tsm.addAffectedArea(this);
        int skillID = getSkillID();
        byte slv = getSlv();
        SkillInfo si = SkillData.getInstance().getSkillInfoById(skillID);
        Option o = new Option();
        Option o1 = new Option();
        Option o2 = new Option();
        Option o3 = new Option();
        switch (skillID) {
//            case Zero.TIME_DISTORTION:
//                o1.nOption = 1;
//                o1.rOption = skillID;
//                o1.tOption = si.getValue(time, slv);
//                //tsm.putCharacterStatValue(DISPEL, o1);  TODO Removes Debuffs
//                o2.nReason = skillID;
//                o2.nValue = si.getValue(indieBooster, slv);
//                o2.tStart = (int) System.currentTimeMillis();
//                tsm.putCharacterStatValue(IndieBooster, o2); //Indie
//                break;
//            case BlazeWizard.BURNING_CONDUIT:
//                o1.nReason = skillID;
//                o1.nValue = si.getValue(indieDamR, slv);
//                o1.tStart = (int) System.currentTimeMillis();
//                tsm.putCharacterStatValue(IndieDamR, o1); //Indie
//                o2.nReason = skillID;
//                o2.nValue = si.getValue(indieBooster, slv);
//                o2.tStart = (int) System.currentTimeMillis();
//                tsm.putCharacterStatValue(IndieBooster, o2); //Indie
//                break;
//            case Kanna.結界_桔梗:
//                o1.nReason = skillID;
//                o1.nValue = si.getValue(bdR, slv);
//                o1.tStart = (int) System.currentTimeMillis();
//                tsm.putCharacterStatValue(IndieBDR, o1); //Indie
//                break;
//            case Kanna.結界_櫻:
//                o1.nOption = si.getValue(SkillStat.x, slv);
//                o1.rOption = skillID;
//                tsm.putCharacterStatValue(DamageReduce, o1);
//                o2.nOption = si.getValue(SkillStat.y, slv);
//                o2.rOption = skillID;
//                tsm.putCharacterStatValue(AsrR, o2);
//                tsm.putCharacterStatValue(TerR, o2);
//                break;
//            case Aran.MAHAS_DOMAIN:
//                // 20% HP/MP Recovery
//                // Dispel
//                break;
        }
        tsm.sendSetStatPacket();
    }

    @Override
    public FieldObjectType getFieldObjectType() {
        return null;
    }

    @Override
    public void enterScreen(GameClient client) {

    }

    @Override
    public void outScreen(GameClient client) {

    }
}