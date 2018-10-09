package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.*;

public class AbstractArrayStorageTest {
    private Storage storage;
    private final String UUID_1 = "uuid1";
    private final String UUID_2 = "uuid2";
    private final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void save() throws Exception {
        Resume resumeSave = createResume();
        storage.save(resumeSave);
        Resume resumeReceive = storage.get(resumeSave.getUuid());
        assertEquals(resumeSave, resumeReceive);
    }

    @Test
    public void get() throws Exception {
        save();
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        Resume resume = createResume();
        storage.save(resume);
        storage.delete(resume.getUuid());
        storage.get(resume.getUuid());
    }

    @Test
    public void getAll() throws Exception {
        Resume[] arrayExpected = new Resume[]{new Resume("uuid1"), new Resume("uuid2"), new Resume("uuid3")};
        assertArrayEquals(arrayExpected, storage.getAll());
    }

    @Test
    public void update() throws Exception {
        Resume resumeUpdate = createResume();
        storage.save(resumeUpdate);
        storage.update(resumeUpdate);
        Resume resumeReceive = storage.get(resumeUpdate.getUuid());
        assertEquals(resumeUpdate, resumeReceive);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        while (true) {
            Resume resume = new Resume();
            try {
                storage.save(resume);
            } catch (StorageException e) {
                if (storage.size() < AbstractArrayStorage.STORAGE_LIMIT) {
                    fail();
                }
                throw e;
            }
        }
    }

    private Resume createResume() {
        return new Resume("uuid4");
    }
}