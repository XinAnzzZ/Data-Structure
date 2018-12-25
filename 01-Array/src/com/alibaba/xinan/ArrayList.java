package com.alibaba.xinan;

/**
 * 简易版 ArrayList
 *
 * @author XinAnzzZ
 * @date 2018/10/5 10:29
 */
@SuppressWarnings("unused")
public class ArrayList<E> {

    private Object[] element;

    private int size;

    /*** 默认初始容量 */
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        size = 0;
        element = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        this.size = 0;
        this.element = new Object[capacity];
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) element[index];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(element[i]);
            if (i < size--) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
