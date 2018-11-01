package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public int size() {
        return getSize();
    }

    @Override
    public void save(Resume resume) {
        int index = findIndexOfResume(resume.getUuid());
        if (index < 0) {
            addToStorage(resume, index);
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = findIndexOfResume(uuid);
        if (index >= 0) {
            return getValueStorage(index, uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void delete(String uuid) {
        int index = findIndexOfResume(uuid);
        if (index >= 0) {
            deleteFromStorage(index, uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public Resume[] getAll() {
        return getAllFromStorage();
    }

    @Override
    public void clear() {
        clearStorage();
    }

    @Override
    public void update(Resume resume) {
        int index = findIndexOfResume(resume.getUuid());
        if (index >= 0) {
            updateStorage(index, resume);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    protected abstract void updateStorage(int index, Resume resume);

    protected abstract void clearStorage();

    protected abstract void deleteFromStorage(int index, String uuid);

    protected abstract Resume getValueStorage(int index, String uuid);

    protected abstract void addToStorage(Resume resume, int index);

    protected abstract int findIndexOfResume(String uuid);

    protected abstract Resume[] getAllFromStorage();

    protected abstract int getSize();
}
