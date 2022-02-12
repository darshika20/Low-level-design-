package com.darshikajha.algorithms;

public class DoublyLinkedList<Key> {

    private DoublyLinkedListNode<Key> root = new DoublyLinkedListNode<Key>();
    private DoublyLinkedListNode<Key> tail = new DoublyLinkedListNode<Key>();


    public DoublyLinkedList() {
        this.root.next = tail;
        this.tail.prev = root;
    }

    public void detachNode(DoublyLinkedListNode<Key> node) {
        DoublyLinkedListNode<Key> temp = new DoublyLinkedListNode<Key>();
        temp.next = root;
        while(temp != null && temp != node){
            temp = temp.next;
        }
        if(temp == node) {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public DoublyLinkedListNode<Key> detachNodeFromLast() {
        DoublyLinkedListNode<Key> node = tail.prev;
        tail.prev.prev.next = tail;
        return node;
    }

    public DoublyLinkedListNode<Key> attachNodeAtFirst(Key key) {
        DoublyLinkedListNode<Key> temp = new DoublyLinkedListNode<Key>(key);
        temp.prev = root;
        temp.next = root.next;
        root.next.prev = temp;
        root.next = temp;
        return temp;
    }
}
