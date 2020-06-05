package com.khoa.bot.model;

import com.khoa.bot.enums.TemplateType;

public abstract class TemplatePayload extends Payload {
    private TemplateType templateType;

    public TemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(TemplateType templateType) {
        this.templateType = templateType;
    }
}
