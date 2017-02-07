import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    public void save(Resume r) {
        if (size == ARRAY_SIZE - 1) {
            System.out.println("Массив заполнен! Больше элементов вставить нельзя!");
            return;
        }
        if (findResume(r)) {
            System.out.println("ERROR!");
            return;
        }
        storage[size] = r;
        size++;
    }

    protected boolean findResume(Resume resume) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {
                return true;
            }
        }
        return false;
    }

    protected boolean findResumeById(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}