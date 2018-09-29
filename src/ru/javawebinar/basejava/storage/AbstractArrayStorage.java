package ru.javawebinar.basejava.storage;

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
            if (size < storage.length) {
                add(resume);
                size++;
            } else {
                System.out.println("storage is full");
            }
        } else {
            System.out.println("Resume " + resume.getUuid() + " in storage");
        }
    }

    public Resume get(String uuid) {
        int index = findIndexOfResume(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("no resume with uuid: " + uuid + " in storage");
        }
        return null;
    }

    @Override
    public void delete(String uuid) {
        int index = findIndexOfResume(uuid);
        if (index >= 0) {
            del(index);
            size--;
        } else {
            System.out.println("no resume with uuid: " + uuid + " in storage");
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
            System.out.println("no resume with uuid: " + resume.getUuid() + " in storage");
        }
    }

    protected abstract int findIndexOfResume(String uuid);

    protected abstract void add(Resume resume);

    protected abstract void del(int index);
}
