import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    public void save(Resume r) {
        if (size == ARRAY_SIZE - 1) {
            System.out.println("Массив заполнен! Больше элементов вставить нельзя!");
            return;
        }
        if (getIndex(r.getUuid()) >= 0) {
            System.out.println("ERROR!");
            return;
        }
        int index = Math.abs(Arrays.binarySearch(storage, 0, size, r) + 1);
        for (int k = size; k > index; k--) {
            storage[k] = storage[k - 1];
        }
        storage[index] = r;
        size++;
    }
}