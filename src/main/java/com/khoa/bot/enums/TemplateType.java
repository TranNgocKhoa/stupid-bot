package com.khoa.bot.enums;

public enum TemplateType {
    GENERIC("generic"),
    BUTTON("button"),
    MEDIA("media"),
    RECEIPT("receipt");

    private final String code;

    TemplateType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
