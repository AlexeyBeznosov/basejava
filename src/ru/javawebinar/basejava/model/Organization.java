package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {

    private String name;
    private String url;
    private List<PeriodDescription> descriptions = new ArrayList<>();

    public Organization(String name, String url, List<PeriodDescription> descriptions) {
        this.name = name;
        this.url = url;
        this.descriptions = descriptions;
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

    public void addPeriod(PeriodDescription periodDescription) {
        descriptions.add(periodDescription);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        Organization that = (Organization) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(descriptions, that.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, descriptions);
    }
}
