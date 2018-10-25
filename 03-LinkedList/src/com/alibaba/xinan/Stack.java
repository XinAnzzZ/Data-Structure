package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/25 10:51
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 入栈
     *
     * @param e the element has been added
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return the element has been remove
     */
    E pop();

    /**
     * 得到栈顶元素
     *
     * @return the element top of the stack
     */
    E peek();
}
