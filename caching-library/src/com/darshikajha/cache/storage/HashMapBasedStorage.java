package com.darshikajha.cache.storage;

import java.util.Map;

import com.darshikajha.exceptions.StorageFullException;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value>{

    private Map<Key, Value> map;
    private int size;

    public HashMapBasedStorage(Map<Key, Value> map, int size) {
        this.map = map;
        this.size = size;
    }

    @Override
    public void save(Key key, Value value) throws StorageFullException {
        if(isMaxCapacityReached()) {
            throw new StorageFullException("Cache storage is full!! Please evict some entries!!");
        } else {
            map.put(key,value);
        }
    }

    @Override
    public boolean isMaxCapacityReached() {
        if(map.size() == size){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Value get(Key key) {
        return map.get(key);
    }

    @Override
    public void remove(Key keyToBeEvicted) {
        map.remove(keyToBeEvicted);
    }
}
