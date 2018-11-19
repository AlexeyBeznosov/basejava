package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class SectionTwo implements Section {

    private List<String> list = new ArrayList<>();

    public SectionTwo() {
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public void save(Object[] text) {
        list.add((String) text[0]);
    }

    @Override
    public void clear() {
        list.clear();
    }
}
