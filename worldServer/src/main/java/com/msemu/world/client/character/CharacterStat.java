package com.msemu.world.client.character;

import com.msemu.commons.database.Schema;
import com.msemu.commons.network.packets.OutPacket;
import com.msemu.commons.utils.types.FileTime;
import com.msemu.core.network.GameClient;
import com.msemu.world.constants.JobConstants;
import com.msemu.world.constants.MapleJob;

import javax.persistence.*;

/**
 * Created by Weber on 2018/3/29.
 */
@Schema
@Entity
@Table(name = "characterStats")
public class CharacterStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "characterId")
    private int characterId;
    @Column(name = "characterIdForLog")
    private int characterIdForLog;
    @Column(name = "worldIdForLog")
    private int worldIdForLog;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private int gender;
    @Column(name = "skin")
    private int skin;
    @Column(name = "face")
    private int face;
    @Column(name = "hair")
    private int hair;
    @Column(name = "mixBaseHairColor")
    private int mixBaseHairColor;
    @Column(name = "mixAddHairColor")
    private int mixAddHairColor;
    @Column(name = "mixHairBaseProb")
    private int mixHairBaseProb;
    @Column(name = "level")
    private int level;
    @Column(name = "job")
    private int job;
    @Column(name = "str")
    private int str;
    @Column(name = "dex")
    private int dex;
    @Column(name = "inte")
    private int inte;
    @Column(name = "luk")
    private int luk;
    @Column(name = "hp")
    private int hp;
    @Column(name = "maxHp")
    private int maxHp;
    @Column(name = "mp")
    private int mp;
    @Column(name = "maxMp")
    private int maxMp;
    @Column(name = "ap")
    private int ap;
    @Column(name = "sp")
    private int sp;
    @Column(name = "exp")
    private long exp;
    @Column(name = "pop")
    private int pop; // fame
    @Column(name = "money")
    private long money;
    @Column(name = "wp")
    private int wp;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "extendSP")
    private ExtendSP extendSP;
    @Column(name = "posMap")
    private long posMap;
    @Column(name = "portal")
    private int portal;
    @Column(name = "subJob")
    private int subJob;
    @Column(name = "defFaceAcc")
    private int defFaceAcc;
    @Column(name = "fatigue")
    private int fatigue;
    @Column(name = "lastFatigueUpdateTime")
    private int lastFatigueUpdateTime;
    @Column(name = "charismaExp")
    private int charismaExp;
    @Column(name = "insightExp")
    private int insightExp;
    @Column(name = "willExp")
    private int willExp;
    @Column(name = "craftExp")
    private int craftExp;
    @Column(name = "senseExp")
    private int senseExp;
    @Column(name = "charmExp")
    private int charmExp;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "nonCombatStatDayLimit")
    private NonCombatStatDayLimit nonCombatStatDayLimit;
    @Column(name = "pvpExp")
    private int pvpExp;
    @Column(name = "pvpGrade")
    private int pvpGrade;
    @Column(name = "pvpPoint")
    private int pvpPoint;
    @Column(name = "pvpModeLevel")
    private int pvpModeLevel;
    @Column(name = "pvpModeType")
    private int pvpModeType;
    @Column(name = "eventPoint")
    private int eventPoint;
    @Column(name = "albaActivityID")
    private int albaActivityID;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "albaStartTime")
    private FileTime albaStartTime;
    @Column(name = "albaDuration")
    private int albaDuration;
    @Column(name = "albaSpecialReward")
    private int albaSpecialReward;
    @Column(name = "burning")
    private boolean burning;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "characterCard")
    private CharacterCard characterCard;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "accountLastLogout")
    private SystemTime accountLastLogout;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "lastLogout")
    private FileTime lastLogout;
    @Column(name = "gachExp")
    private int gachExp;

    public CharacterStat() {
        extendSP = new ExtendSP(5);
        nonCombatStatDayLimit = new NonCombatStatDayLimit();
        albaStartTime = new FileTime(0);
        lastLogout = new FileTime(0);
        characterCard = new CharacterCard(0, 0, (byte) 0);
        accountLastLogout = new SystemTime(1970, 1);
        // TODO fill in default vals
    }

    public CharacterStat(String name, int job) {
        this();
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public short getAp() {
        return (short) ap;
    }

    public short getDex() {
        return (short) dex;
    }

    public int getHp() {
        return hp;
    }

    public short getInt() {
        return (short) inte;
    }

    public short getJob() {
        return (short) job;
    }

    public short getLevel() {
        return (short) level;
    }

    public short getCharismaExp() {
        return (short) charismaExp;
    }

    public short getLuk() {
        return (short) luk;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public int getMp() {
        return mp;
    }

    public short getPop() { //Fame
        return (short) pop;
    }

    public short getSp() {
        return (short) sp;
    }

    public short getStr() {
        return (short) str;
    }

    public short getWp() {
        return (short) wp;
    }

    public long getExp() {
        return (short) exp;
    }

    public long getMoney() {
        return money;
    }

    public ExtendSP getExtendSP() {
        return extendSP;
    }

    public int getCharacterId() {
        return characterId;
    }

    public int getCharacterIdForLog() {
        return characterId;
    }

    public int getFace() {
        return face;
    }

    public int getGender() {
        return gender;
    }

    public int getHair() {
        return hair;
    }

    public int getMixAddHairColor() {
        return mixAddHairColor;
    }

    public int getMixBaseHairColor() {
        return mixBaseHairColor;
    }

    public int getMixHairBaseProb() {
        return mixHairBaseProb;
    }

    public int getSkin() {
        return skin;
    }

    public int getWorldIdForLog() {
        return worldIdForLog;
    }

    public short getCharmExp() {
        return (short) charmExp;
    }

    public short getCraftExp() {
        return (short) craftExp;
    }

    public int getAlbaActivityID() {
        return albaActivityID;
    }

    public int getEventPoint() {
        return eventPoint;
    }

    public int getPortal() {
        return portal;
    }

    public int getAlbaDuration() {
        return albaDuration;
    }

    public short getInsightExp() {
        return (short) insightExp;
    }

    public int getAlbaSpecialReward() {
        return albaSpecialReward;
    }

    public int getPvpExp() {
        return pvpExp;
    }

    public int getPvpGrade() {
        return pvpGrade;
    }

    public int getPvpModeLevel() {
        return pvpModeLevel;
    }

    public int getPvpModeType() {
        return pvpModeType;
    }

    public int getPvpPoint() {
        return pvpPoint;
    }

    public short getSenseExp() {
        return (short) senseExp;
    }

    public short getWillExp() {
        return (short) willExp;
    }

    public long getPosMap() {
        return posMap == 0 ? 931000000 : posMap;
    }

    public CharacterCard getCharacterCard() {
        return characterCard;
    }

    public NonCombatStatDayLimit getNonCombatStatDayLimit() {
        return nonCombatStatDayLimit;
    }

    public FileTime getAlbaStartTime() {
        return albaStartTime;
    }

    public int getDefFaceAcc() {
        return defFaceAcc;
    }

    public int getFatigue() {
        return fatigue;
    }

    public int getLastFatigueUpdateTime() {
        return lastFatigueUpdateTime;
    }

    public int getSubJob() {
        return subJob;
    }

    public SystemTime getAccountLastLogout() {
        return accountLastLogout;
    }



    public void encode(OutPacket<GameClient> outPacket) {
        outPacket.encodeInt(getCharacterId());
        outPacket.encodeInt(getCharacterIdForLog());
        outPacket.encodeInt(getWorldIdForLog());
        outPacket.encodeString(getName(), 15);
        outPacket.encodeByte(getGender());
        outPacket.encodeByte(0); // unk
        outPacket.encodeByte(getSkin());
        outPacket.encodeInt(getFace());
        outPacket.encodeInt(getHair());
        outPacket.encodeByte(-1/*getMixBaseHairColor()*/);
        outPacket.encodeByte(getMixAddHairColor());
        outPacket.encodeByte(getMixHairBaseProb());
        outPacket.encodeByte(getLevel());
        outPacket.encodeShort(getJob());
        outPacket.encodeShort(getStr());
        outPacket.encodeShort(getDex());
        outPacket.encodeShort(getInt());
        outPacket.encodeShort(getLuk());
        outPacket.encodeInt(getHp());
        outPacket.encodeInt(getMaxHp());
        outPacket.encodeInt(getMp());
        outPacket.encodeInt(getMaxMp());
        outPacket.encodeShort(getAp());
        if (JobConstants.isSeparatedSp(getJob())) {
            getExtendSP().encode(outPacket);
        } else {
            outPacket.encodeShort(getSp());
        }
        outPacket.encodeLong(getExp());
        outPacket.encodeInt(getPop());
        outPacket.encodeInt(getWp()); // 神之子武器點數
        outPacket.encodeLong(getGachExp());
        outPacket.encodeFT(FileTime.getTime());
        outPacket.encodeInt((int) getPosMap());
        outPacket.encodeByte(getPortal());
        outPacket.encodeShort(getSubJob());
        if (MapleJob.is惡魔(getJob()) || MapleJob.is傑諾(getJob()) || MapleJob.is幻獸師(getJob())) {
            outPacket.encodeInt(getDefFaceAcc());
        }
        outPacket.encodeShort(getFatigue());
        outPacket.encodeInt(getLastFatigueUpdateTime());

        outPacket.encodeInt(getCharismaExp());
        outPacket.encodeInt(getInsightExp());
        outPacket.encodeInt(getWillExp());
        outPacket.encodeInt(getCraftExp());
        outPacket.encodeInt(getSenseExp());
        outPacket.encodeInt(getCharmExp());

        getNonCombatStatDayLimit().encode(outPacket);

        outPacket.encodeInt(getPvpExp());
        outPacket.encodeByte(getPvpGrade());
        outPacket.encodeInt(getPvpPoint());
        outPacket.encodeByte(6);
        outPacket.encodeByte(7);
        /* Fuck that, setting the above byte lower than 2 will make all 3rd and 4th job that have the property
         ((skillID % 10000) / 10000 == 0) be bugged (you see the maxLevel, but can't actually use it). ?????????????*/
        //outPacket.encodeByte(getPvpModeType());
        outPacket.encodeInt(getEventPoint());
//        outPacket.encodeByte(getAlbaActivityID()); // part time job
//        getAlbaStartTime().encode(outPacket); // long
//        outPacket.encodeInt(getAlbaDuration());
//        outPacket.encodeByte(getAlbaSpecialReward());
        outPacket.encodeInt(0);
        getCharacterCard().encode(outPacket);
        getLastLogout().encodeR(outPacket);
        //
        outPacket.encodeLong(0);
        outPacket.encodeLong(0);
        outPacket.encodeInt(0);
        outPacket.encodeInt(0);
        outPacket.encodeInt(0);
        outPacket.encodeByte(0);
        //
        outPacket.encodeZeroBytes(25);
        outPacket.encodeByte(0);
        outPacket.encodeByte(0);
        outPacket.encodeByte(0);
        outPacket.encodeByte(0);
        outPacket.encodeByte(isBurning()); // bBurning 不確定
    }

    public FileTime getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(FileTime lastLogout) {
        this.lastLogout = lastLogout;
    }

    public boolean isBurning() {
        return burning;
    }

    public void setBurning(boolean burning) {
        this.burning = burning;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGachExp() {
        return gachExp;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public void setCharacterIdForLog(int characterIdForLog) {
        this.characterIdForLog = characterIdForLog;
    }

    public void setWorldIdForLog(int worldIdForLog) {
        this.worldIdForLog = worldIdForLog;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setSkin(int skin) {
        this.skin = skin;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public void setHair(int hair) {
        this.hair = hair;
    }

    public void setMixAddHairColor(int mixAddHairColor) {
        this.mixAddHairColor = mixAddHairColor;
    }

    public void setMixHairBaseProb(int mixHairBaseProb) {
        this.mixHairBaseProb = mixHairBaseProb;
    }

    public void setMixBaseHairColor(int mixBaseHairColor) {
        this.mixBaseHairColor = mixBaseHairColor;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setInt(int inte) {
        this.inte = inte;
    }

    public void setLuk(int luk) {
        this.luk = luk;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public void setWp(int wp) {
        this.wp = wp;
    }

    public void setPosMap(long posMap) {
        this.posMap = posMap;
    }

    public void setPortal(int portal) {
        this.portal = portal;
    }

    public void setSubJob(int subJob) {
        this.subJob = subJob;
    }

    public void setDefFaceAcc(int defFaceAcc) {
        this.defFaceAcc = defFaceAcc;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public void setLastFatigueUpdateTime(int lastFatigueUpdateTime) {
        this.lastFatigueUpdateTime = lastFatigueUpdateTime;
    }

    public void setCharismaExp(int charismaExp) {
        this.charismaExp = charismaExp;
    }

    public void setInsightExp(int insightExp) {
        this.insightExp = insightExp;
    }

    public void setWillExp(int willExp) {
        this.willExp = willExp;
    }

    public void setCraftExp(int craftExp) {
        this.craftExp = craftExp;
    }

    public void setSenseExp(int senseExp) {
        this.senseExp = senseExp;
    }

    public void setCharmExp(int charmExp) {
        this.charmExp = charmExp;
    }

    public void setPvpExp(int pvpExp) {
        this.pvpExp = pvpExp;
    }

    public void setPvpGrade(int pvpGrade) {
        this.pvpGrade = pvpGrade;
    }

    public void setPvpPoint(int pvpPoint) {
        this.pvpPoint = pvpPoint;
    }

    public void setPvpModeLevel(int pvpModeLevel) {
        this.pvpModeLevel = pvpModeLevel;
    }

    public void setPvpModeType(int pvpModeType) {
        this.pvpModeType = pvpModeType;
    }

    public void setEventPoint(int eventPoint) {
        this.eventPoint = eventPoint;
    }

    public void setAlbaActivityID(int albaActivityID) {
        this.albaActivityID = albaActivityID;
    }

    public void setAlbaDuration(int albaDuration) {
        this.albaDuration = albaDuration;
    }

    public void setAlbaSpecialReward(int albaSpecialReward) {
        this.albaSpecialReward = albaSpecialReward;
    }

    public void setGachExp(int gachExp) {
        this.gachExp = gachExp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExtendSP(ExtendSP extendSP) {
        this.extendSP = extendSP;
    }

    public void setNonCombatStatDayLimit(NonCombatStatDayLimit nonCombatStatDayLimit) {
        this.nonCombatStatDayLimit = nonCombatStatDayLimit;
    }

    public void setAlbaStartTime(FileTime albaStartTime) {
        this.albaStartTime = albaStartTime;
    }

    public void setCharacterCard(CharacterCard characterCard) {
        this.characterCard = characterCard;
    }

    public void setAccountLastLogout(SystemTime accountLastLogout) {
        this.accountLastLogout = accountLastLogout;
    }


}

