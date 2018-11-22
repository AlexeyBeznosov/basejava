package ru.javawebinar.basejava.model;

import java.util.Objects;

public class Contact {

    private String text;
    private String url;

    public Contact() {
    }

    public Contact(String text, String url) {
        this.text = text;
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(text, contact.text) &&
                Objects.equals(url, contact.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, url);
    }
}
