package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class PeriodDescription {

    private LocalDate dateOfBegin;
    private LocalDate dateOfEnd;
    private String title;
    private String text;


    public PeriodDescription(LocalDate dateOfBegin, LocalDate dateOfEnd, String title, String text) {
        Objects.requireNonNull(dateOfBegin, "date must not be null");
        Objects.requireNonNull(dateOfEnd, "date must not be null");
        Objects.requireNonNull(title, "title must not be null");
        Objects.requireNonNull(text, "text must not be null");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PeriodDescription)) return false;
        PeriodDescription that = (PeriodDescription) o;
        return Objects.equals(dateOfBegin, that.dateOfBegin) &&
                Objects.equals(dateOfEnd, that.dateOfEnd) &&
                Objects.equals(title, that.title) &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBegin, dateOfEnd, title, text);
    }
}
