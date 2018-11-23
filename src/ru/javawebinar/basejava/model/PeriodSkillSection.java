package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeriodSkillSection implements Section {

    private List<Organization> organizations = new ArrayList<>();

    public PeriodSkillSection() {
    }

    @Override
    public void save(Object[] text) {
        Organization sectionBlock = new Organization((String) text[0], (String) text[1], (LocalDate) text[2], (LocalDate) text[3], (String) text[4], (String) text[5]);
        organizations.add(sectionBlock);
    }

    @Override
    public void clear() {
        organizations.clear();
    }
}
