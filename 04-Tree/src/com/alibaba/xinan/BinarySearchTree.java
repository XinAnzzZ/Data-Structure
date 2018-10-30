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
        addElement(root, e);
    }

    /**
     * 在 node 节点的位置插入一个元素 e
     *
     * @param node the node
     * @param e    the element
     * @return the new node
     */
    private Node addElement(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) > 0) {
            node.right = addElement(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = addElement(node.left, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }

        return true;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.right);
        preOrder(node.left);
    }
}
