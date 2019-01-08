package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class PeriodDescription {

    private LocalDate dateOfBegin;
    private LocalDate dateOfEnd;
    private String title;
    private String text;


    public PeriodDescription(LocalDate dateOfBegin, LocalDate dateOfEnd, String title, String text) {
        this.dateOfBegin = dateOfBegin;
        this.dateOfEnd = dateOfEnd;
        this.title = title;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
