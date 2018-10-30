package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/29 17:31
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        E e;

        Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        addElement(root, new Node(e));
    }

    private Node addElement(Node root, Node node) {
        if (root == null) {
            size++;
            return node;
        }
        if (root.left.e.compareTo(node.e) > 0) {
            root.right = addElement(root.right, node);
        } else if (root.left.e.compareTo(node.e) < 0) {
            root.left = addElement(root.left, node);
        }
        return root;
    }
}
