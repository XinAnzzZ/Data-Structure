package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/26 10:24
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        E e;
        Node next;

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

    private Node head, tail;

    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 入队
     */
    @Override
    public void enqueue(E e) {
        // 入队是操作尾部，所以判断tail即可
        if (tail == null) {
            // tail为空说明链表为空，同时head也是空的
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("the queue is empty");
        }

        Node target = head;
        head = head.next;
        target.next = null;

        // 如果出队之后head为空，说明队列中已不存在任何元素，需要维护一下tail
        if (head == null) {
            tail = null;
        }
        size--;
        return target.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalStateException("the queue is empty");
        }

        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: head [");

        Node current = head;
        while (current != null) {
            res.append(current);
            res.append("->");
            current = current.next;
        }
        res.append("NULL] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        int count = 10;
        for (int i = 0; i < count; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);

            if (i % 3 == 2) {
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }
}
