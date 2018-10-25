package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    private ArrayList<Resume> storage = new ArrayList<>();

    @Override
    protected void addToStorage(Resume resume, int index) {
        storage.add(resume);
        size++;
    }

    @Override
    protected Resume getValueStorage(int index) {
        return storage.get(index);
    }

    @Override
    protected int findIndexOfResume(String uuid) {
        return storage.indexOf(new Resume(uuid));
    }

    @Override
    protected void deleteFromStorage(int index) {
        storage.remove(index);
    }

    @Override
    protected Resume[] getAllFromStorage() {
        return storage.toArray(new Resume[size]);
    }

    @Override
    protected void clearStorage() {
        storage.clear();
    }

    @Override
    protected void updateStorage(int index, Resume resume) {
        storage.set(index, resume);
    }
}
