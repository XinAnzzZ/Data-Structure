package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/23 21:16
 */
@SuppressWarnings("unused")
public class LinkedList<E> {

    private class Node {

        Node next;

        E e;

        public Node(Node next, E e) {
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

    private Node dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

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
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(pre.next, e);
        size++;
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Failed. Illegal index.");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set Failed. Illegal index.");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    public boolean contains(E e) {
        Node current = dummyHead.next;
        while (current.next != null) {
            if (current.e.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove Failed. Illegal index.");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node target = current.next;
        current.next = target.next;
        target.next = null;
        size--;

        return target.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList: [");

        Node current = dummyHead.next;
        for (int i = 0; i < size; i++) {
            res.append(current);
            if (current.next != null) {
                res.append("->");
            }
            current = current.next;
        }
        res.append("]");

        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        System.out.println(linkedList.remove(1));
    }
}
