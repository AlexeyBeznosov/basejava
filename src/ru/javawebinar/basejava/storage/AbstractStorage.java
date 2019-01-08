package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<T> implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR_BY_FULLNAME_UUID = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    @Override
    public void save(Resume resume) {
        T index = getNotExistedIndex(resume.getUuid());
        addToStorage(resume, index);
    }

    @Override
    public Resume get(String uuid) {
        T index = getExistedIndex(uuid);
        return getValueStorage(index);
    }

    @Override
    public void delete(String uuid) {
        T index = getExistedIndex(uuid);
        deleteFromStorage(index);
    }

    @Override
    public void update(Resume resume) {
        T index = getExistedIndex(resume.getUuid());
        updateStorage(index, resume);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getAll();
        list.sort(RESUME_COMPARATOR_BY_FULLNAME_UUID);
        return list;
    }

    private T getExistedIndex(String uuid) {
        T index = findIndexOfResume(uuid);
        if (checkIndexExist(index)) {
            return index;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private T getNotExistedIndex(String uuid) {
        T index = findIndexOfResume(uuid);
        if (!checkIndexExist(index)) {
            return index;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract void updateStorage(T index, Resume resume);

    protected abstract void deleteFromStorage(T index);

    protected abstract Resume getValueStorage(T index);

    protected abstract void addToStorage(Resume resume, T index);

    protected abstract T findIndexOfResume(String uuid);

    protected abstract boolean checkIndexExist(T index);

    protected abstract List<Resume> getAll();
}
