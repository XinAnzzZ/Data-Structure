package com.alibaba.xinan;

import java.util.ArrayList;

/**
 * @author XinAnzzZ
 * @date 2018/12/25 18:00
 */
public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public MaxHeap(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /*** 根据孩子节点索引获取父节点的索引 */
    private int getParentIndex(int childIndex) {
        if (childIndex == 0) {
            throw new IllegalArgumentException("the root node doesn't have parent node !");
        }
        return (childIndex - 1) / 2;
    }

    /*** 根据父节点索引获取左孩子索引 */
    private int getLeftChildIndex(int parentIndex) {
        if (parentIndex * 2 + 1 > size() - 1) {
            throw new IllegalArgumentException("the parent node doesn't have left child node !");
        }
        return parentIndex * 2 + 1;
    }

    /*** 根据父节点索引获取右孩子索引 */
    private int getRightChildIndex(int parentIndex) {
        if ((parentIndex + 1) * 2 > size() - 1) {
            throw new IllegalArgumentException("the parent node doesn't have right child node !");
        }
        return (parentIndex + 1) * 2;
    }
}
