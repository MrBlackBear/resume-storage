/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        storage = new Resume[10000];
        size = 0;
    }

    void save(Resume r) {
        if (size == 9999) {
            System.out.println("Массив заполнен! Больше элементов вставить нельзя!");
            return;
        }
        for (int i = 0; i < this.size; i++) {
            if (storage[i].toString().equals(r)) {
                System.out.println("Такой элемент уже есть в массиве! Повторяющиеся элементы вставлять нельзя!");
                return;
            }
        }
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;

    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].toString().equals(uuid)) {
                for (int j = i; j < this.size() - i - 1; j++) {
                    storage[i] = storage[i + 1];
                }
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        final Resume[] newStorage = new Resume[this.size()];
        for (int j = 0; j < this.size(); j++) {
            newStorage[j] = storage[j];
        }
        return newStorage;
    }

    int size() {
        return this.size;
    }
}