package ru.javawebinar.basejava.storage;

import org.junit.Test;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import static org.junit.Assert.fail;

public class AbstractArrayStorageTest extends AbstractStorageTest {

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        while (storage.size() < AbstractArrayStorage.STORAGE_LIMIT) {
            try {
                storage.save(new Resume());
            } catch (StorageException e) {
                fail();
            }
        }
        storage.save(new Resume());
    }
}