package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/23 21:16
 */
public class LinkedList<E> {

    private class Node<E> {
        public Node<E> next;

        public E e;

        public Node(Node<E> next, E e) {
            this.next = next;
            this.e = e;
        }

        public Node(E e) {
            this(null, e);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node<E> head;

    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param e     element
     * @param index index
     */
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed. Illegal index.");
        }
        if (index == 0) {
            addFirst(e);
        }
        Node<E> pre = head;
        for (int i = 0; i <= index - 1; i++) {
            pre = pre.next;
        }
        pre.next = new Node<>(pre.next, e);
        size++;
    }

    public void addFirst(E e) {
        head = new Node<>(head, e);
        size++;
    }

    public void addLast(E e) {
        add(e, size);
    }
}
