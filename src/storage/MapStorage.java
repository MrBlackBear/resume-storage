package storage;

import model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {
    private Map<Integer, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.put((Integer) searchKey, r);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put((Integer) searchKey, r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove(searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        ArrayList<Resume> list = (ArrayList<Resume>) map.values();
        Collections.sort(list, (o1, o2) -> o1.getFullName().compareTo(o2.getFullName()));
        return list;
    }

    @Override
    public int size() {
        return map.size();
    }
}