package ru.javawebinar.basejava.model;

public enum ContactType {

    PHON_NUMBER("Телефон"),
    SKYPE("SKYPE"),
    EMAIL("Почта"),
    LINKEDIN("Linkedin"),
    GITHUB("Github"),
    STACKOVERFLOW("STACKOVERFLOW"),
    HOME_PAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
