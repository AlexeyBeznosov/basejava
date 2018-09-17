import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int sizeOfStorage;

    void clear() {
        if (sizeOfStorage > 0) {
            Arrays.fill(storage, 0, sizeOfStorage, null);
            sizeOfStorage = 0;
        }
    }

    void save(Resume r) {
        if (isValidResume(r)) {
            int index = findIndexOfResume(r);
            if (index < 0) {
                if (sizeOfStorage < storage.length) {
                    storage[sizeOfStorage] = r;
                    sizeOfStorage++;
                }
            } else {
                System.out.println("Resume in storage");
            }
        }
    }

    Resume get(String uuid) {
        if (isValidResume(uuid)) {
            Resume resume = getResume(uuid);
            int index = findIndexOfResume(resume);
            if (index >= 0) {
                return storage[index];
            } else {
                System.out.println("no resume with this uuid in storage");
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (isValidResume(uuid)) {
            Resume resume = getResume(uuid);
            int index = findIndexOfResume(resume);
            if (index >= 0) {
                storage[index] = storage[sizeOfStorage - 1];
                storage[sizeOfStorage - 1] = null;
                sizeOfStorage--;
            } else {
                System.out.println("no resume with this uuid in storage");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = Arrays.copyOf(storage, sizeOfStorage);
        return resumes;
    }

    int size() {
        return sizeOfStorage;
    }

    void update(Resume resume) {
        if (isValidResume(resume)) {
            int index = findIndexOfResume(resume);
            if (index >= 0) {
                storage[index] = resume;
            } else {
                System.out.println("no resume with this uuid in storage");
            }
        }
    }

    int findIndexOfResume(Resume resume) {
        for (int i = 0; i < sizeOfStorage; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {
                return i;
            }
        }
        return -1;
    }

    boolean isValidResume(Resume resume) {
        if (resume != null) {
            if (isValidResume(resume.uuid)) {
                return true;
            }
        } else {
            System.out.println("incorrect resume");
        }
        return false;
    }

    boolean isValidResume(String uuid) {
        if (uuid != null) {
            return true;
        } else {
            System.out.println("incorrect uuid");
        }
        return false;
    }

    Resume getResume(String uuid) {
        Resume resume = new Resume();
        resume.uuid = uuid;
        return resume;
    }
}
