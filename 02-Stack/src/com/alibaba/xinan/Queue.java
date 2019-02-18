package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/21 23:05
 */
public interface Queue<E> {

    /**
     * inserts the element into the queue
     *
     * @param e the element to add
     */
    void enqueue(E e);

    /**
     * remove the head of this queue
     *
     * @return the has been removed element
     */
    E dequeue();

    /**
     * get the head of this queue
     *
     * @return the element at front of the queue
     */
    E getFront();

    /**
     * get the queue's size
     *
     * @return the queue's size
     */
    int size();

    /**
     * whether is empty or not
     *
     * @return {@code true} if the queue is empty
     */
    boolean isEmpty();
}
