package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

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
    protected void addToStorage(Resume resume, Resume key) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected boolean isExist(Resume key) {
        return key != null;
    }

    @Override
    protected Resume getFromStorage(Resume key) {
        return storage.get(key.getUuid());
    }

    @Override
    protected void deleteFromStorage(Resume key) {
        storage.remove(key.getUuid());
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void updateStorage(Resume key, Resume resume) {
        storage.put(key.getUuid(), resume);
    }
}
