package ru.javawebinar.basejava.model;

public class SectionOne implements Section {

    private String text;

    public SectionOne() {
        this("");
    }

    public SectionOne(String text) {
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
