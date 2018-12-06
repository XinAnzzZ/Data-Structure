package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/12/06 21:23
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int size();

    boolean isEmpty();
}
