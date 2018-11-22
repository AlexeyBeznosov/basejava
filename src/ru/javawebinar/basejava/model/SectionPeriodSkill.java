package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;

public class SectionPeriodSkill implements Section {

    private List<SectionBlock> blocks = new ArrayList<>();

    public SectionPeriodSkill() {
    }

    @Override
    public void save(Object[] text) {
        SectionBlock sectionBlock = new SectionBlock();
        sectionBlock.fillBlock(text);
        blocks.add(sectionBlock);
    }

    @Override
    public void clear() {
    }
}
