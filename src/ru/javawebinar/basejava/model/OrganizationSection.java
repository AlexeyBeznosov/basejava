package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrganizationSection implements Section {

    private List<Organization> organizations = new ArrayList<>();

    public OrganizationSection() {
    }

    @Override
    public void save(Object[] text) {
        Organization organization = null;
        for (Organization tempOrganization : organizations) {
            if (tempOrganization.getName().equals((String) text[0])) {
                organization = tempOrganization;
                organization.addPeriod((LocalDate) text[2], (LocalDate) text[3], (String) text[4], (String) text[5]);
            }
        }
        if (organization == null) {
            organization = new Organization((String) text[0], (String) text[1], (LocalDate) text[2], (LocalDate) text[3], (String) text[4], (String) text[5]);
            organizations.add(organization);
        }
    }

    @Override
    public void clear() {
        organizations.clear();
    }
}
