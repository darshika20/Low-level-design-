package com.darshikajha.Factory;

import java.util.HashMap;
import java.util.Map;

import com.darshikajha.algorithms.DoublyLinkedList;
import com.darshikajha.algorithms.DoublyLinkedListNode;
import com.darshikajha.cache.Cache;
import com.darshikajha.cache.policies.EvictionPolicy;
import com.darshikajha.cache.policies.LRUCache;
import com.darshikajha.cache.storage.HashMapBasedStorage;
import com.darshikajha.cache.storage.Storage;

public class CacheFactory {

    public Cache getDefaultCache() {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList();
        Map<String , DoublyLinkedListNode<String >> mapper = new HashMap<>();
        EvictionPolicy evictionPolicy = new LRUCache(doublyLinkedList,mapper);
        Storage<String , String > storage = new HashMapBasedStorage<>(new HashMap<>(), 5);
        return new Cache(evictionPolicy, storage);
    }
}
