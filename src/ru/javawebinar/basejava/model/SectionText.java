package ru.javawebinar.basejava.model;

public class SectionText implements Section {

    private String text;

    public SectionText() {
        this("");
    }

    public SectionText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public void save(Object[] text) {
        this.text = (String) text[0];
    }

    @Override
    public void clear() {
        text = "";
    }
}
