package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void addToStorage(Resume resume, Object index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Object findIndexOfResume(String uuid) {
        return uuid;
    }

    @Override
    protected boolean checkIndexExist(Object index) {
        return storage.containsKey((String) index);
    }

    @Override
    protected Resume getValueStorage(Object index) {
        return storage.get((String) index);
    }

    @Override
    protected void deleteFromStorage(Object index) {
        storage.remove((String) index);
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[]{});
    }

    @Override
    public void updateStorage(Object index, Resume resume) {
        storage.put((String) index, resume);
    }
}
