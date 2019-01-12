package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AbstractStorageTest {
    private static final Resume resume = ResumeTestData.getResume("uuid1", "fullname1");
    private static final Resume resumeSave = ResumeTestData.getResume("uuid4", "fullname4");

    protected Storage storage;
    protected final String UUID1 = "uuid1";
    protected final Resume RESUME1 = ResumeTestData.getResume(UUID1, "fullname1");
    protected final String UUID2 = "uuid2";
    protected final Resume RESUME2 = ResumeTestData.getResume(UUID2, "fullname2");
    protected final String UUID3 = "uuid3";
    protected final Resume RESUME3 = ResumeTestData.getResume(UUID3, "fullname3");

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void save() throws Exception {
        storage.save(resumeSave);
        Resume resumeReceive = storage.get(resumeSave.getUuid());
        assertEquals(resumeSave, resumeReceive);
    }

    @Test
    public void get() throws Exception {
        Resume resumeReceive = storage.get(UUID1);
        assertEquals(resume, resumeReceive);
    }

    @Test
    public void getAllSorted() throws Exception {
        Resume[] arrayExpected = new Resume[]{new Resume(UUID1, "fullname1"), new Resume(UUID2, "fullname2"), new Resume(UUID3, "fullname3")};
        assertArrayEquals(arrayExpected, storage.getAllSorted().toArray());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID1);
        storage.get(UUID1);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        storage.update(resume);
        Resume resumeReceive = storage.get(UUID1);
        assertEquals(resume, resumeReceive);
    }
}