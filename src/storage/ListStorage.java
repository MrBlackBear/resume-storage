package storage;

import exception.ExistStorageException;
import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        list.add((Integer) searchKey,r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return list.contains(searchKey);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        if (list.contains(r)){
            throw new ExistStorageException(r.getUuid());
        }
        list.add(r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return list.get((Integer)searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        list.remove(searchKey);
    }


    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) list.toArray();
    }

    @Override
    public int size() {
        return list.size();
    }
}
