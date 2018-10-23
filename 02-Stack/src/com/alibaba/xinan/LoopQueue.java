package com.alibaba.xinan;

/**
 * 循环队列
 *
 * @author XinAnzzZ
 * @date 2018/10/21 23:05
 */
public class LoopQueue<E> implements Queue<E> {

    private int front;

    private int tail;

    private int size;

    private E[] element;

    private static final int DEFAULT_CAPACITY = 10;

    public LoopQueue() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public LoopQueue(int capacity) {
        // 循环队列中有一个位置将会被浪费，所以创建的时候需要多创建一个空间
        this.element = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public int getCapacity() {
        return element.length - 1;
    }

    @Override
    public void enqueue(E e) {
        // 检查队列是否已满，满则扩容
        if ((tail + 1) % element.length == front) {
            resize(getCapacity() * 2);
        }

        // 添加元素
        element[tail] = e;
        tail = (tail + 1) % element.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        E[] newElement = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newElement[i] = element[(front + i) % element.length];
        }
        element = newElement;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't dequeue from an empty queue!");
        }

        E target = element[front];
        element[front] = null;
        front = (front + 1) % element.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return target;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Can't get front from an empty queue!");
        }
        return element[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.tail;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        stringBuilder.append("front = ");
        stringBuilder.append(front);
        stringBuilder.append(" [");

        for (int i = front; i != tail; i = (i + 1) % element.length) {
            stringBuilder.append(element[i]);
            if ((i + 1) % element.length != tail) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail = ");
        stringBuilder.append(tail);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);

            if (i % 3 == 2) {
                System.out.println(loopQueue.dequeue());
            }
        }
    }
}
