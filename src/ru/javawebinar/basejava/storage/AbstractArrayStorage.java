package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void save(Resume resume) {
        int index = findIndexOfResume(resume.getUuid());
        if (index < 0) {
            if (size < STORAGE_LIMIT) {
                add(resume, index);
                size++;
            } else {
                throw new StorageException(resume.getUuid(), "storage overflow");
            }
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        int index = findIndexOfResume(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = findIndexOfResume(uuid);
        if (index >= 0) {
            del(index);
            storage[size - 1] = null;
            size--;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void update(Resume resume) {
        int index = findIndexOfResume(resume.getUuid());
        if (index >= 0) {
            storage[index] = resume;
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    protected abstract int findIndexOfResume(String uuid);

    protected abstract void add(Resume resume, int index);

    protected abstract void del(int index);
}
