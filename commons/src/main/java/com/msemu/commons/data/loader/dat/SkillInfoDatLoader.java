package com.msemu.commons.data.loader.dat;

import com.msemu.commons.data.loader.DatMappingDataLoader;
import com.msemu.commons.data.templates.skill.SkillInfo;

/**
 * Created by Weber on 2018/4/28.
 */
public class SkillInfoDatLoader extends DatMappingDataLoader<SkillInfo> {
    public SkillInfoDatLoader() {
        super(DatManager.SkillInfo);
    }

    @Override
    protected SkillInfo create() {
        return new SkillInfo();
    }
}
