package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected Resume getFromStorage(Integer index) {
        return storage[index];
    }

    @Override
    public void addToStorage(Resume resume, Integer index) {
        if (size < STORAGE_LIMIT) {
            add(resume, index);
            size++;
        } else {
            throw new StorageException(resume.getUuid(), "storage overflow");
        }
    }

    @Override
    protected void deleteFromStorage(Integer index) {
        del(index);
        storage[size - 1] = null;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    public List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    public void updateStorage(Integer index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected boolean isExist(Integer index) {
        return (index) >= 0;
    }

    protected abstract void add(Resume resume, int index);

    protected abstract void del(int index);
}
