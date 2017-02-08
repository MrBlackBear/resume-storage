/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    public void save(Resume r) {
        if (size == ARRAY_SIZE - 1) {
            System.out.println("Массив заполнен! Больше элементов вставить нельзя!");
            return;
        }
        if (getIndex(r.getUuid()) >= 0) {
            System.out.println("ERROR!");
            return;
        }
        storage[size] = r;
        size++;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}