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

package com.msemu.commons.data.loader.wz;

import com.msemu.commons.data.loader.WzDataLoader;
import com.msemu.commons.data.loader.dat.NpcTemplateDatLoader;
import com.msemu.commons.data.templates.NpcTemplate;
import com.msemu.commons.wz.WzFile;
import com.msemu.commons.wz.WzImage;
import com.msemu.commons.wz.properties.WzStringProperty;
import com.msemu.commons.wz.properties.WzSubProperty;
import lombok.Getter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Weber on 2018/4/25.
 */
public class NpcTemplateLoader extends WzDataLoader<Set<NpcTemplate>> {

    @Getter
    Set<NpcTemplate> data = new HashSet<>();

    public NpcTemplateLoader(WzManager wzManager) {
        super(wzManager);
    }

    @Override
    public void load() {
        WzFile npcWZ = wzManager.getWz(WzManager.NPC);
        WzImage npcStrImg = wzManager.getWz(WzManager.STRING).getWzDirectory().getImage("Npc.img");

        npcWZ.getWzDirectory().getImages().forEach(img -> data.add(importNpcImg(img)));
        importStrings(data, npcStrImg);

    }

    private void importStrings(Set<NpcTemplate> data, WzImage npcStrImg) {

        data.forEach(nt -> {
            if (npcStrImg.getFromPath(String.format("%d/name", nt.getId())) != null) {
                nt.setName(npcStrImg.getFromPath(String.format("%d/name", nt.getId())).getString());
            }
        });
    }

    private NpcTemplate importNpcImg(WzImage img) {
        NpcTemplate nt = new NpcTemplate();
        int id = Integer.parseInt(img.getName().replace(".img", ""));
        nt.setId(id);
        if (img.getFromPath("info/script") != null) {
            if (img.getFromPath("info/script") instanceof WzSubProperty) {
                WzSubProperty scriptsProp = (WzSubProperty) img.getFromPath("info/script");
                scriptsProp.getProperties().stream().forEach(each -> {
                    if (each.getFromPath("script") != null) {
                        nt.setScript(each.getFromPath("script").getString());
                    }
                    if (each instanceof WzStringProperty) {
                        nt.setScript(each.getString());
                    }
                });
            } else {
                nt.setScript(img.getFromPath("info/script").getString());
            }
        }
        return nt;
    }

    @Override
    public void saveToDat() throws IOException {
        if (getData().isEmpty())
            load();
        new NpcTemplateDatLoader().saveDat(getData());
    }
}
