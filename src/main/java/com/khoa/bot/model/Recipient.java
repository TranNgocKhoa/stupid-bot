package com.khoa.bot.model;

public class Recipient {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static Recipient of(String id) {
        Recipient recipient = new Recipient();
        recipient.setId(id);

        return recipient;
    }
}
