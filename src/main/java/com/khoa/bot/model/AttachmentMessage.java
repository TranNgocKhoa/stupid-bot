package com.khoa.bot.model;

public class AttachmentMessage extends Message {
    private Attachment attachment;

    @Override
    public Attachment getAttachment() {
        return attachment;
    }

    @Override
    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }
}
