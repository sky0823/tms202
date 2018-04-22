package com.msemu.commons.data.templates.quest.actions;

import com.msemu.commons.data.enums.QuestActionType;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Weber on 2018/4/22.
 */
public class QuestTransferFieldActData extends QuestActData {

    @Getter
    @Setter
    private int transferField;

    private String portalName = "";

    @Override
    public QuestActionType getType() {
        return QuestActionType.transferField;
    }
}