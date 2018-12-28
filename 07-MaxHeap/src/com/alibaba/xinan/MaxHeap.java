package com.alibaba.xinan;

import java.util.ArrayList;
import java.util.Arrays;

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

    /*** heapify */
    public MaxHeap(E[] arr) {
        data = new ArrayList<>(arr.length);
        data.addAll(Arrays.asList(arr));

        int index = getParentIndex(arr.length - 1);
        for (int i = index; i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(E e) {
        data.add(e);
        int index = data.size() - 1;
        // 如果父节点的值小于新节点的值，进行位置互换
        while (index > 0 && data.get(getParentIndex(index)).compareTo(e) < 0) {
            data.set(index, data.get(getParentIndex(index)));
            data.set(getParentIndex(index), e);
            index = getParentIndex(index);
        }
    }

    /*** 提取最大值 */
    public E extractMax() {
        E result = getMax();
        E remove = data.remove(size() - 1);

        if (size() == 0) {
            return result;
        }
        data.set(0, remove);

        siftDown(0);
        return result;
    }

    /*** 下沉 */
    private void siftDown(int index) {
        // 如果说左孩子的索引值小于 size 说明左孩子存在，当左孩子不存在的时候 循环终止
        while (getLeftChildIndex(index) < size()) {
            // 假设左右孩子中左孩子的值较大
            int maxIndex = getLeftChildIndex(index);

            // 如果右孩子存在且有孩子的值大于左孩子，则最大值的索引等于右孩子
            if (getRightChildIndex(index) < size()
                    && data.get(maxIndex).compareTo(data.get(getRightChildIndex(index))) < 0) {
                maxIndex = getRightChildIndex(index);
            }
            // 如果当前节点值小于左右孩子节点中较大的那个值，则进行位置互换，否则跳出循环
            if (data.get(index).compareTo(data.get(maxIndex)) < 0) {
                // 互换位置
                E e = data.get(index);
                data.set(index, data.get(maxIndex));
                data.set(maxIndex, e);

                index = maxIndex;
            } else {
                break;
            }
        }
    }

    public E getMax() {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("The heap is empty !");
        }
        return data.get(0);
    }

    /*** 根据孩子节点索引获取父节点的索引 */
    private int getParentIndex(int childIndex) {
        if (childIndex == 0) {
            throw new IllegalArgumentException("The root node doesn't have parent node !");
        }
        return (childIndex - 1) / 2;
    }

    /*** 根据父节点索引获取左孩子索引 */
    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    /*** 根据父节点索引获取右孩子索引 */
    private int getRightChildIndex(int parentIndex) {
        return (parentIndex + 1) * 2;
    }

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 6, 2};
        MaxHeap<Integer> heap = new MaxHeap<>(arr);
        System.out.println(heap);
    }
}
