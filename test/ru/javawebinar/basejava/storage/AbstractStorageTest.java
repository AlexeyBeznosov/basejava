package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class AbstractStorageTest {
    private static final String UUID1 = "uuid1";
    private static final Resume resume = ResumeTestData.getResume(UUID1, "fullname1");
    private static final Resume resumeUpdate = ResumeTestData.getResume(UUID1, "updateFullname");
    private static final String UUID4 = "uuid4";
    private static final Resume resumeSave = ResumeTestData.getResume(UUID4, "fullname4");

    protected Storage storage;
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
        Resume resumeReceive = storage.get(UUID4);
        assertEquals(resumeSave, resumeReceive);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(resume);
    }

    @Test
    public void get() throws Exception {
        assertEquals(resume, storage.get(UUID1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAllSorted() throws Exception {
        assertEquals(Arrays.asList(RESUME1, RESUME2, RESUME3), storage.getAllSorted());
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
        storage.update(resumeUpdate);
        assertEquals(resumeUpdate, storage.get(UUID1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(resumeSave);
    }
}