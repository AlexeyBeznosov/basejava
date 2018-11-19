package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionThree implements Section {

    private Map<String, List<PeriodText>> mapHistory = new HashMap<>();

    public SectionThree() {
    }

    @Override
    public void save(Object[] text) {
        PeriodText periodText = new PeriodText((LocalDate) text[1], (LocalDate) text[2], (String) text[3]);
        List<PeriodText> list = mapHistory.getOrDefault((String) text[0], new ArrayList<>());
        list.add(periodText);
        mapHistory.put((String) text[0], list);
    }

    @Override
    public void clear() {
        mapHistory.clear();
    }
}
