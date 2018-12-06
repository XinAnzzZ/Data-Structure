package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/12/06 21:23
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> tree;

    public BinarySearchTreeSet() {
        tree = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        tree.add(e);
    }

    @Override
    public void remove(E e) {
        tree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return tree.contains(e);
    }

    @Override
    public int size() {
        return tree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
