package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AbstractStorageTest {
    private static final Resume resume = new Resume("uuid1", "fullName1");
    private static final Resume resumeSave = new Resume("uuid4", "fullName4");

    protected Storage storage;
    protected final String UUID_1 = "uuid1";
    protected final String FULL_NAME_1 = "fullName1";
    protected final String UUID_2 = "uuid2";
    protected final String FULL_NAME_2 = "fullName2";
    protected final String UUID_3 = "uuid3";
    protected final String FULL_NAME_3 = "fullName3";

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1, FULL_NAME_1));
        storage.save(new Resume(UUID_2, FULL_NAME_2));
        storage.save(new Resume(UUID_3, FULL_NAME_3));
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
        Resume resumeReceive = storage.get(UUID_1);
        assertEquals(resume, resumeReceive);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        storage.get(resume.getUuid());
    }

    @Test
    public void getAllSorted() throws Exception {
        Resume[] arrayExpected = new Resume[]{new Resume(UUID_1, FULL_NAME_1), new Resume(UUID_2, FULL_NAME_2), new Resume(UUID_3, FULL_NAME_3)};
        assertArrayEquals(arrayExpected, storage.getAllSorted().toArray());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() throws Exception {
        storage.update(resume);
        Resume resumeReceive = storage.get(resume.getUuid());
        assertEquals(resume, resumeReceive);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    @Test
    public void fillResume() {
        ResumeTestData resumeTestData = new ResumeTestData();
        resumeTestData.fillResume();
    }
}