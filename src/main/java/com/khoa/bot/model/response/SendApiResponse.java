package com.khoa.bot.model.response;

public class SendApiResponse {
    private String recipientId;
    private String messageId;

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "SendApiResponse{" +
                "recipientId='" + recipientId + '\'' +
                ", messageId='" + messageId + '\'' +
                '}';
    }
}
