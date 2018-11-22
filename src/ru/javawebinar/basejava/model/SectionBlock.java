package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class SectionBlock {

    private Organization organization;
    private Period period;
    private Position position;

    public SectionBlock() {
    }

    public SectionBlock(Organization organization, Period period, Position position) {
        this.organization = organization;
        this.period = period;
        this.position = position;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void fillBlock(Object[] text) {
        organization = new Organization((String) text[0], (String) text[1]);
        period = new Period((LocalDate) text[2], (LocalDate) text[3]);
        position = new Position((String) text[4], (String) text[5]);
    }
}
