package ru.javawebinar.basejava.model;

public class TextSection implements Section {

    private String text;

    public TextSection() {
        this("");
    }

    public TextSection(String text) {
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
