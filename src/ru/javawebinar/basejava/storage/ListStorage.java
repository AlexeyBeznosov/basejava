package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    private ArrayList<Resume> storage = new ArrayList<>();

    @Override
    public int getSize() {
        return storage.size();
    }

    @Override
    protected void addToStorage(Resume resume, int index) {
        storage.add(resume);
    }

    @Override
    protected Resume getValueStorage(int index, String uuid) {
        return storage.get(index);
    }

    @Override
    protected int findIndexOfResume(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void deleteFromStorage(int index, String uuid) {
        storage.remove(index);
    }

    @Override
    protected Resume[] getAllFromStorage() {
        return storage.toArray(new Resume[storage.size()]);
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
