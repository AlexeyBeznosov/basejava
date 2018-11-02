package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clearStorage() {
        storage.clear();
    }

    @Override
    protected void addToStorage(Resume resume, Object index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Object findIndexOfResume(String uuid) {
        return storage.containsKey(uuid) ? uuid : "";
    }

    @Override
    protected boolean checkIndexExist(Object index) {
        return !((String) index).equals("");
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
        List<Resume> list = new ArrayList<>();
        for (Map.Entry map : storage.entrySet()) {
            list.add((Resume) map.getValue());
        }
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public void updateStorage(Object index, Resume resume) {
        storage.put((String) index, resume);
    }
}
