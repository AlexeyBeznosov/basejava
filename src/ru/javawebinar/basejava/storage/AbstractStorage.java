package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        Object index = findIndexOfResume(resume.getUuid());
        if (!checkIndexExist(index)) {
            addToStorage(resume, index);
        } else {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    @Override
    public Resume get(String uuid) {
        Object index = findIndexOfResume(uuid);
        if (checkIndexExist(index)) {
            return getValueStorage(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void delete(String uuid) {
        Object index = findIndexOfResume(uuid);
        if (checkIndexExist(index)) {
            deleteFromStorage(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void update(Resume resume) {
        Object index = findIndexOfResume(resume.getUuid());
        if (checkIndexExist(index)) {
            updateStorage(index, resume);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    protected abstract void updateStorage(Object index, Resume resume);

    protected abstract void deleteFromStorage(Object index);

    protected abstract Resume getValueStorage(Object index);

    protected abstract void addToStorage(Resume resume, Object index);

    protected abstract Object findIndexOfResume(String uuid);

    protected abstract boolean checkIndexExist(Object index);
}
