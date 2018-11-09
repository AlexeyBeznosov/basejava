package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

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
        storage.put(((Resume) index).getUuid(), resume);
    }

    @Override
    protected Object findIndexOfResume(String uuid) {
        return new Resume(uuid, "");
    }

    @Override
    protected boolean checkIndexExist(Object index) {
        return storage.containsKey(((Resume) index).getUuid());
    }

    @Override
    protected Resume getValueStorage(Object index) {
        return storage.get(((Resume) index).getUuid());
    }

    @Override
    protected void deleteFromStorage(Object index) {
        storage.remove(((Resume) index).getUuid());
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>(storage.values());
        list.sort(RESUME_COMPARATOR_BY_FULLNAME);
        return list;
    }

    @Override
    public void updateStorage(Object index, Resume resume) {
        storage.put(((Resume) index).getUuid(), resume);
    }
}
