package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<Integer, Resume> storage = new HashMap<>();

    @Override
    public void clearStorage() {
        storage.clear();
    }

    @Override
    protected void addToStorage(Resume resume, int index) {
        storage.put(size, resume);
        size++;
    }

    @Override
    protected int findIndexOfResume(String uuid) {
        for (Map.Entry<Integer, Resume> mapEntry : storage.entrySet()) {
            if (mapEntry.getValue().getUuid().equals(uuid)) {
                return mapEntry.getKey();
            }
        }
        return -1;
    }

    @Override
    protected Resume getValueStorage(int index) {
        return storage.get(index);
    }

    @Override
    protected void deleteFromStorage(int index) {
        storage.remove(index);
    }

    @Override
    public Resume[] getAllFromStorage() {
        List<Resume> list = new ArrayList<>();
        for (Map.Entry map : storage.entrySet()) {
            list.add((Resume) map.getValue());
        }
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public void updateStorage(int index, Resume resume) {
        storage.put(index, resume);
    }
}
