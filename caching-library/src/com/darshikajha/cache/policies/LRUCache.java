package com.darshikajha.cache.policies;

import java.util.Map;

import com.darshikajha.algorithms.DoublyLinkedList;
import com.darshikajha.algorithms.DoublyLinkedListNode;

public class LRUCache<Key> implements EvictionPolicy<Key>{

    private DoublyLinkedList<Key> dll;
    private Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUCache(DoublyLinkedList<Key> dll, Map<Key, DoublyLinkedListNode<Key>> mapper) {
        this.dll = dll;
        this.mapper = mapper;
    }

    @Override
    public void keyAccessed(Key key) {
        if(mapper.containsKey(key)){
            dll.detachNode(mapper.get(key));
            mapper.remove(key);
        }
        DoublyLinkedListNode<Key> node = dll.attachNodeAtFirst(key);
        mapper.put(key, node);
        System.out.println("Key added in front in Cache");
    }

    @Override
    public Key evictKey() {
        if(mapper.isEmpty()) {
            throw new RuntimeException("No key found to evict from cache!!");
        } else {
            DoublyLinkedListNode<Key> node = dll.detachNodeFromLast();
            mapper.remove(node.val);
            return node.val;
        }
    }
}
