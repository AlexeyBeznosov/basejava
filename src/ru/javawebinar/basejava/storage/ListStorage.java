package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    private ArrayList<Resume> storage = new ArrayList<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void addToStorage(Resume resume, Object index) {
        storage.add(resume);
    }

    @Override
    protected Resume getValueStorage(Object index) {
        return storage.get((int) index);
    }

    @Override
    protected Object findIndexOfResume(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void deleteFromStorage(Object index) {
        storage.remove((int) index);
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    protected void clearStorage() {
        storage.clear();
    }

    @Override
    protected void updateStorage(Object index, Resume resume) {
        storage.set((int) index, resume);
    }

    @Override
    protected boolean checkIndexExist(Object index) {
        return ((int) index) >= 0;
    }
}