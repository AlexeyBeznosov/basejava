import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int sizeOfStorage;

    public void clear() {
        Arrays.fill(storage, 0, sizeOfStorage, null);
        sizeOfStorage = 0;
    }

    public void save(Resume resume) {
        int index = findIndexOfResume(resume.uuid);
        if (index < 0) {
            if (sizeOfStorage < storage.length) {
                storage[sizeOfStorage] = resume;
                sizeOfStorage++;
            }
        } else {
            System.out.println("Resume in storage");
        }
    }

    public Resume get(String uuid) {
        int index = findIndexOfResume(uuid);
        if (index >= 0) {
            return storage[index];
        } else {
            System.out.println("no resume with this uuid in storage");
        }
        return null;
    }

    public void delete(String uuid) {
        int index = findIndexOfResume(uuid);
        if (index >= 0) {
            storage[index] = storage[sizeOfStorage - 1];
            storage[sizeOfStorage - 1] = null;
            sizeOfStorage--;
        } else {
            System.out.println("no resume with this uuid in storage");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, sizeOfStorage);
    }

    public int size() {
        return sizeOfStorage;
    }

    public void update(Resume resume) {
        int index = findIndexOfResume(resume.uuid);
        if (index >= 0) {
            storage[index] = resume;
        } else {
            System.out.println("no resume with this uuid in storage");
        }
    }

    private int findIndexOfResume(String uuid) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
