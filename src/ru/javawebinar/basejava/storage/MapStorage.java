package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public int getSize() {
        return storage.size();
    }

    @Override
    public void clearStorage() {
        storage.clear();
    }

    @Override
    protected void addToStorage(Resume resume, int index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected int findIndexOfResume(String uuid) {
        for (Map.Entry<String, Resume> mapEntry : storage.entrySet()) {
            if (mapEntry.getKey().equals(uuid)) {
                return 0;
            }
        }
        return -1;
    }

    @Override
    protected Resume getValueStorage(int index, String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void deleteFromStorage(int index, String uuid) {
        storage.remove(uuid);
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
        storage.put(resume.getUuid(), resume);
    }
}
