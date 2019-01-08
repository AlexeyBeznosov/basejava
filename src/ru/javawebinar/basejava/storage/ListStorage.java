package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    private List<Resume> storage = new ArrayList<>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void addToStorage(Resume resume, Integer index) {
        storage.add(resume);
    }

    @Override
    protected Resume getValueStorage(Integer index) {
        return storage.get(index);
    }

    @Override
    protected Integer findIndexOfResume(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void deleteFromStorage(Integer index) {
        storage.remove(index.intValue());
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void updateStorage(Integer index, Resume resume) {
        storage.set(index, resume);
    }

    @Override
    protected boolean checkIndexExist(Integer index) {
        return index >= 0;
    }
}
