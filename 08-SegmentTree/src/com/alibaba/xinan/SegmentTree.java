package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2019/01/22 21:50
 */
public class SegmentTree<E> {

    private E[] tree;

    private E[] data;

    private Merger<E> merger;

    @SuppressWarnings("unchecked")
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        this.data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);

        this.tree = (E[]) new Object[4 * arr.length];
        buildTree(0, 0, data.length - 1);
    }

    /*** 在 treeIndex 位置创建一个区间为 [left, right] 的线段树 */
    private void buildTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }

        int leftChildIndex = this.getLeftChildIndex(treeIndex);
        int rightChildIndex = this.getRightChildIndex(treeIndex);

        int middle = left + (right - left) / 2;

        buildTree(leftChildIndex, left, middle);
        buildTree(rightChildIndex, middle + 1, right);

        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    /*** 查询一段区间的值 */
    public E get(int queryLeft, int queryRight) {
        if (queryLeft > queryRight || queryLeft < 0 || queryRight > data.length - 1) {
            throw new IllegalArgumentException();
        }
        return get(0, 0, data.length - 1, queryLeft, queryRight);
    }

    public void update(int index, E e) {
        if (index < 0 || index > data.length - 1) {
            throw new IllegalArgumentException();
        }

        update(0, 0, data.length - 1, index, e);
    }

    private void update(int treeIndex, int left, int right, int index, E e) {
        if (left == right) {
            tree[treeIndex] = e;
            return;
        }

        int leftChildIndex = getLeftChildIndex(treeIndex);
        int rightChildIndex = getRightChildIndex(treeIndex);

        int mid = left + (right - left) / 2;
        if (index > mid) {
            update(rightChildIndex, mid + 1, right, index, e);
        } else {
            update(leftChildIndex, left, mid, index, e);
        }

        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
    }

    /**
     * 在给定区间内查询给定区间上的值
     *
     * @param treeIndex  节点的索引值
     * @param left       被查询的区间左端点
     * @param right      被查询的区间右端点
     * @param queryLeft  要查询的区间的左端点
     * @param queryRight 要查询的区间的右端点
     * @return 被查询区间的值
     */
    private E get(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (left == queryLeft && right == queryRight) {
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        if (queryLeft > mid) {
            return get(getRightChildIndex(treeIndex), mid + 1, right, queryLeft, queryRight);
        }
        if (queryRight <= mid) {
            return get(getLeftChildIndex(treeIndex), left, mid, queryLeft, queryRight);
        }

        E e1 = get(getLeftChildIndex(treeIndex), left, mid, queryLeft, mid);
        E e2 = get(getRightChildIndex(treeIndex), mid + 1, right, mid + 1, queryRight);
        return merger.merge(e1, e2);
    }

    public int size() {
        return this.data.length;
    }

    /*** 根据父节点索引获取左孩子索引 */
    private int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    /*** 根据父节点索引获取右孩子索引 */
    private int getRightChildIndex(int parentIndex) {
        return (parentIndex + 1) * 2;
    }

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> tree = new SegmentTree<>(nums, (e1, e2) -> e1 + e2);
        System.out.println(tree.get(0, 2));
        System.out.println(tree.get(2, 5));
        System.out.println(tree.get(0, 5));

        tree.update(3, 5);
        System.out.println(tree.get(0, 2));
        System.out.println(tree.get(2, 5));
        System.out.println(tree.get(0, 5));
    }
}
