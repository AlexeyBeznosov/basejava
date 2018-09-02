import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int sizeOfStorage = size();
        if (sizeOfStorage > 0) {
            Arrays.fill(storage, 0, sizeOfStorage - 1, null);
        }
    }

    void save(Resume r) {
        int index = size();
        if (index < storage.length) {
            storage[index] = r;
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
        int sizeOfStorage = size();
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
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = Arrays.copyOf(storage, size());
        return resumes;
    }

    int size() {
        int count = 0;
        while (storage[count] != null) {
            count++;
            if (count == storage.length) {
                break;
            }
        }
        return count;
    }
}
