package com.darshikajha.algorithms;

public class DoublyLinkedListNode<Key> {

    public Key val;
    public DoublyLinkedListNode<Key> next;
    public DoublyLinkedListNode<Key> prev;

    public DoublyLinkedListNode(Key val) {
        this.val = val;
    }

    public DoublyLinkedListNode() {
    }
}
