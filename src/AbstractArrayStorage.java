import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected Resume[] storage = new Resume[ARRAY_SIZE];
    protected int size = 0;
    protected static final int ARRAY_SIZE = 10000;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume get(String uuid) {
        int i = getIndex(uuid);
        if (i >= 0) {
            return storage[i];
        } else {
            System.out.println("ERROR!");
        }
        return null;
    }

    public void update(Resume r) {
        int i = getIndex(r.getUuid());
        if (i < 0) {
            System.out.println("ERROR!");
        }
        storage[i] = r;
    }

    public void delete(String uuid) {
        int i = getIndex(uuid);
        if (i >= 0) {
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
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract int getIndex(String uuid);
}