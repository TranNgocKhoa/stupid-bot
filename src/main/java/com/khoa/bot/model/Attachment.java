package com.khoa.bot.model;

import com.khoa.bot.enums.AttachmentType;

public class Attachment {
    private AttachmentType type;
    private Payload payload;

    public AttachmentType getType() {
        return type;
    }

    public void setType(AttachmentType type) {
        this.type = type;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }
}
