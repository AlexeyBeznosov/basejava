package ru.javawebinar.basejava.model;

import java.util.*;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;
    private final String fullName;

    private Map<ContactType, Contact> contacts = new HashMap<>();
    private Map<SectionType, Section> sections = new HashMap<>();

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public List<String> getContacts() {
        List<String> list = new ArrayList<>();
        for (Map.Entry<ContactType, Contact> map : contacts.entrySet()) {
            list.add(map.getValue().getText());
        }
        return list;
    }

    public Map<SectionType, Section> getSections() {
        return new HashMap<>(sections);
    }

    public void addContact(ContactType contactType, String text, String url) {
        contacts.put(contactType, new Contact(text, url));
    }

    public void addSection(SectionType sectionType) {
        Section section = null;
        switch (sectionType) {
            case OBJECTIVE: {
                section = new SectionText();
                break;
            }
            case PERSONAL: {
                section = new SectionText();
                break;
            }
            case ACHIEVEMENT: {
                section = new SectionList();
                break;
            }
            case QUALIFICATIONS: {
                section = new SectionList();
                break;
            }
            case EXPERIENCE: {
                section = new SectionPeriodSkill();
                break;
            }
            case EDUCATION: {
                section = new SectionPeriodSkill();
                break;
            }
        }
        sections.put(sectionType, section);
    }

    public void fillSection(SectionType sectionType, Object[] objects) {
        sections.get(sectionType).save(objects);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    @Override
    public String toString() {
        return uuid + " " + fullName;
    }
}
