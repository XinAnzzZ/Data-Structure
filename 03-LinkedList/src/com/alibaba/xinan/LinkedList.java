package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/23 0023 21:16
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

    
}
