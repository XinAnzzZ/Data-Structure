package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/5 10:29
 */
public class ArrayList<E> {

    private Object[] element;

    private int size;

    public ArrayList() {
    }

    public ArrayList(int capacity){
        this.size = 0;
        this.element = new Object[capacity];
    }

    public E get(int index) {
        return (E) element[index];
    }
}
