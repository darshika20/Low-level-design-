package com.darshikajha.cache.storage;

import com.darshikajha.exceptions.StorageFullException;

public interface Storage<Key, Value>{

    void save(Key key, Value value) throws StorageFullException;

    boolean isMaxCapacityReached();

    Value get(Key key);

    void remove(Key keyToBeEvicted);
}
