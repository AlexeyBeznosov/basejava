package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.assertArrayEquals;

public class MapStorageTest extends AbstractStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Override
    public void getAll() throws Exception {
        Resume[] arrayExpected = new Resume[]{new Resume(UUID_2), new Resume(UUID_1), new Resume(UUID_3)};
        assertArrayEquals(arrayExpected, storage.getAll());
    }
}