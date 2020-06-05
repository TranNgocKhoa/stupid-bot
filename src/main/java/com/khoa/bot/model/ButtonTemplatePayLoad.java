package com.khoa.bot.model;

import com.khoa.bot.model.component.Button;

import java.util.List;

public class ButtonTemplatePayLoad extends TemplatePayload {
    private String text;
    private List<Button> button;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }
}
