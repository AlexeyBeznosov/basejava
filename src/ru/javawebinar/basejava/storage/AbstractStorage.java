package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR_BY_FULLNAME_UUID = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    @Override
    public void save(Resume resume) {
        SK key = getNotExistedSearchKey(resume.getUuid());
        addToStorage(resume, key);
    }

    @Override
    public Resume get(String uuid) {
        SK key = getExistedSearchKey(uuid);
        return getFromStorage(key);
    }

    @Override
    public void delete(String uuid) {
        SK key = getExistedSearchKey(uuid);
        deleteFromStorage(key);
    }

    @Override
    public void update(Resume resume) {
        SK key = getExistedSearchKey(resume.getUuid());
        updateStorage(key, resume);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getAll();
        list.sort(RESUME_COMPARATOR_BY_FULLNAME_UUID);
        return list;
    }

    private SK getExistedSearchKey(String uuid) {
        SK key = getSearchKey(uuid);
        if (isExist(key)) {
            return key;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK key = getSearchKey(uuid);
        if (!isExist(key)) {
            return key;
        } else {
            throw new ExistStorageException(uuid);
        }
    }

    protected abstract void updateStorage(SK key, Resume resume);

    protected abstract void deleteFromStorage(SK key);

    protected abstract Resume getFromStorage(SK key);

    protected abstract void addToStorage(Resume resume, SK key);

    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK key);

    protected abstract List<Resume> getAll();
}
