package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class Period {

    private LocalDate dateOfBegin;
    private LocalDate dateOfEnd;

    public Period(LocalDate dateOfBegin, LocalDate dateOfEnd) {
        this.dateOfBegin = dateOfBegin;
        this.dateOfEnd = dateOfEnd;
    }

    public LocalDate getDateOfBegin() {
        return dateOfBegin;
    }

    public void setDateOfBegin(LocalDate dateOfBegin) {
        this.dateOfBegin = dateOfBegin;
    }

    public LocalDate getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(LocalDate dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }
}
