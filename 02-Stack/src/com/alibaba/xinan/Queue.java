package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/21 0021 23:05
 */
public interface Queue<E> {

    /**
     * add an element to the queue
     *
     * @param e the element to added
     */
    void enqueue(E e);

    /**
     * remove an element in the queue
     *
     * @return the has been removed element
     */
    E dequeue();

    /**
     * get the element at front of the queue
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
