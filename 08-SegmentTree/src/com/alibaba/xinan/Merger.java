package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2019/01/22 22:07
 */
public interface Merger<E> {

    E merge(E e1, E e2);
}
