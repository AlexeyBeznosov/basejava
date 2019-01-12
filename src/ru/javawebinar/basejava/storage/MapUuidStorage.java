package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {

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
    protected void addToStorage(Resume resume, String key) {
        storage.put(key, resume);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String key) {
        return storage.containsKey(key);
    }

    @Override
    protected Resume getFromStorage(String key) {
        return storage.get(key);
    }

    @Override
    protected void deleteFromStorage(String key) {
        storage.remove(key);
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void updateStorage(String key, Resume resume) {
        storage.put(key, resume);
    }
}
