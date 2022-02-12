package com.darshikajha.cache;

import com.darshikajha.cache.policies.EvictionPolicy;
import com.darshikajha.cache.storage.Storage;
import com.darshikajha.exceptions.InvalidElementException;
import com.darshikajha.exceptions.StorageFullException;

public class Cache<Key,Value>{

    private EvictionPolicy<Key> evictionPolicy;
    private Storage<Key, Value> storage;

    public Cache(EvictionPolicy evictionPolicy, Storage storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public Value get(Key key) throws InvalidElementException {

        Value value = storage.get(key);
        if(value!=null){
            evictionPolicy.keyAccessed(key);
            return value;
        } else {
            throw new InvalidElementException("Key not found!!");
        }

    }

    public void put(Key key, Value value) throws StorageFullException {

        try {
            storage.save(key,value);
        } catch (StorageFullException ex) {
            System.out.println("Got Storage full !! will try to evict");
            Key keyToBeEvicted = evictionPolicy.evictKey();
            storage.remove(keyToBeEvicted);
            storage.save(key,value);
        }
        evictionPolicy.keyAccessed(key);
    }
}
