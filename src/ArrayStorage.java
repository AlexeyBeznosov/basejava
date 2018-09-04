import com.sun.org.apache.regexp.internal.RE;

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
        if (sizeOfStorage < storage.length) {
            storage[sizeOfStorage] = r;
            sizeOfStorage++;
        }
    }

    Resume get(String uuid) {
        for (Resume resume : storage) {
            if (resume != null && uuid != null) {
                if (uuid.equals(resume.uuid)) {
                    return resume;
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        int indexOfDeleteResume = -1;
        for (int i = 0; i < sizeOfStorage; i++) {
            if (uuid.equals(storage[i].uuid)) {
                storage[i] = null;
                indexOfDeleteResume = i;
            }
            if (indexOfDeleteResume >= 0 && indexOfDeleteResume < i) {
                storage[i - 1] = storage[i];
                storage[i] = null;
            }
        }
        if (indexOfDeleteResume >= 0) {
            sizeOfStorage--;
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
}
