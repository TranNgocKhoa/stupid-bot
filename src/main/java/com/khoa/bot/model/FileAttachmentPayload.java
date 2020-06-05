package com.khoa.bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileAttachmentPayload extends Payload {
    private String url;
    @JsonProperty("isReusable")
    private boolean isReusable;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isReusable() {
        return isReusable;
    }

    public void setIsReusable(boolean isReusable) {
        this.isReusable = isReusable;
    }
}
