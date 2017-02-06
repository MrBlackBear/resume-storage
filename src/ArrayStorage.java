/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[ARRAY_SIZE];
    int size = 0;
    private static int ARRAY_SIZE = 10000;

    void clear() {
        storage = new Resume[ARRAY_SIZE];
        size = 0;
    }

    public void update(Resume r){
        if(!findResume(r)){
            System.out.println("ERROR!");
        }
        storage[findResumePosition(r.uuid)] = r;
    }

    void save(Resume r) {
        if (size == ARRAY_SIZE - 1) {
            System.out.println("Массив заполнен! Больше элементов вставить нельзя!");
            return;
        }
        if (!findResume(r)) {
                System.out.println("ERROR!");
                return;
        }
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        if (findResumeById(uuid)) {
            int i = findResumePosition(uuid);
            return storage[i];
        }else{
            System.out.println("ERROR!");
        }
        return null;
    }

    void delete(String uuid) {
        if (findResumeById(uuid)) {
            int i = findResumePosition(uuid);
            for (int j = i; j < this.size() - i - 1; j++) {
                storage[i] = storage[i + 1];
            }
            size--;
        } else {
            System.out.println("ERROR!");
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
        return size;
    }

    private boolean findResume(Resume resume){
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(resume.uuid)){
                return true;
            }
        }
        return false;
    }

    private boolean findResumeById(String uuid){
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)){
                return true;
            }
        }
        return false;
    }

    private int findResumePosition(String uuid){
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)){
                return i;
            }
        }
        return -1;
    }
}