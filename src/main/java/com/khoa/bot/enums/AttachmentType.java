package com.khoa.bot.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AttachmentType {
    AUDIO("audio"),
    VIDEO("video"),
    IMAGE("image"),
    FILE("file"),
    TEMPLATE("template");

    @JsonValue
    private final String value;

    AttachmentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
