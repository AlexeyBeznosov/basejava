package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Organization {

    private String name;
    private String url;
    private List<PeriodDescription> descriptions = new ArrayList<>();

    public Organization(String name, String url, LocalDate dateOfBegin, LocalDate dateOfEnd, String title, String text) {
        this.name = name;
        this.url = url;
        PeriodDescription periodDescription = new PeriodDescription(dateOfBegin, dateOfEnd, title, text);
        descriptions.add(periodDescription);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void addPeriod(LocalDate dateOfBegin, LocalDate dateOfEnd, String title, String text) {
        PeriodDescription periodDescription = new PeriodDescription(dateOfBegin, dateOfEnd, title, text);
        descriptions.add(periodDescription);
    }
}
