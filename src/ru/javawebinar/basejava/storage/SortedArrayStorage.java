package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void add(Resume resume) {
        int i = size - 1;
        while (i >= 0) {
            if (storage[i].compareTo(resume) > 0) {
                storage[i + 1] = storage[i];
                i--;
            } else {
                break;
            }
        }
        storage[i + 1] = resume;
    }

    @Override
    public void del(int index) {
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
            storage[i + 1] = null;
        }
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    protected int findIndexOfResume(String uuid) {
        Resume searchResume = new Resume();
        searchResume.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchResume);
    }
}
