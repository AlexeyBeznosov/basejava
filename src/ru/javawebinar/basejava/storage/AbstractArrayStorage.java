package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clearStorage() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected Resume getValueStorage(Object index) {
        return storage[(int) index];
    }

    @Override
    public void addToStorage(Resume resume, Object index) {
        if (size < STORAGE_LIMIT) {
            add(resume, (int) index);
            size++;
        } else {
            throw new StorageException(resume.getUuid(), "storage overflow");
        }
    }

    @Override
    protected void deleteFromStorage(Object index) {
        del((int) index);
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void updateStorage(Object index, Resume resume) {
        storage[(int) index] = resume;
    }

    @Override
    protected boolean checkIndexExist(Object index) {
        return ((int) index) >= 0;
    }

    protected abstract void add(Resume resume, int index);

    protected abstract void del(int index);
}
