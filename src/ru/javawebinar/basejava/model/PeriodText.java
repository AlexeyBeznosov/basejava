package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class PeriodText {

    private LocalDate dateOfBegin;
    private LocalDate dateOfEnd;
    private String text;

    public PeriodText(LocalDate dateOfBegin, LocalDate dateOfEnd, String text) {
        this.dateOfBegin = dateOfBegin;
        this.dateOfEnd = dateOfEnd;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
