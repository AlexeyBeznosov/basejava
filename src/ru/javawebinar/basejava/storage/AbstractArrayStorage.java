package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clearStorage() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected Resume getValueStorage(int index, String uuid) {
        return storage[index];
    }

    @Override
    public void addToStorage(Resume resume, int index) {
        if (size < STORAGE_LIMIT) {
            add(resume, index);
            size++;
        } else {
            throw new StorageException(resume.getUuid(), "storage overflow");
        }
    }

    @Override
    protected void deleteFromStorage(int index, String uuid) {
        del(index);
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAllFromStorage() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void updateStorage(int index, Resume resume) {
        storage[index] = resume;
    }

    protected abstract void add(Resume resume, int index);

    protected abstract void del(int index);
}
