package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR_BY_FULLNAME_UUID = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    @Override
    public void save(Resume resume) {
        Object index = getNotExistedIndex(resume.getUuid());
        addToStorage(resume, index);
    }

    @Override
    public Resume get(String uuid) {
        Object index = getExistedIndex(uuid);
        return getValueStorage(index);
    }

    @Override
    public void delete(String uuid) {
        Object index = getExistedIndex(uuid);
        deleteFromStorage(index);
    }

    @Override
    public void update(Resume resume) {
        Object index = getExistedIndex(resume.getUuid());
        updateStorage(index, resume);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getAll();
        list.sort(RESUME_COMPARATOR_BY_FULLNAME_UUID);
        return list;
    }

    private Object getExistedIndex(String uuid) {
        Object index = findIndexOfResume(uuid);
        if (checkIndexExist(index)) {
            return index;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private Object getNotExistedIndex(String uuid) {
        Object index = findIndexOfResume(uuid);
        if (!checkIndexExist(index)) {
            return index;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract void updateStorage(Object index, Resume resume);

    protected abstract void deleteFromStorage(Object index);

    protected abstract Resume getValueStorage(Object index);

    protected abstract void addToStorage(Resume resume, Object index);

    protected abstract Object findIndexOfResume(String uuid);

    protected abstract boolean checkIndexExist(Object index);

    protected abstract List<Resume> getAll();
}
