package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/12/7 16:24
 */
@SuppressWarnings("unused")
public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyHead;

    private int size;

    private class Node {
        K key;

        V value;

        Node next;

        Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Node(K key, V value) {
            this(key, value, null);
        }

        Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        Node node = dummyHead;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                Node target = node.next;
                node.next = target.next;
                target.next = null;
                size--;
                return target.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    private Node getNode(K key) {
        Node node = dummyHead;
        while (node.next != null) {
            if (node.next.key.equals(key)) {
                return node.next;
            }
        }
        return null;
    }
}
