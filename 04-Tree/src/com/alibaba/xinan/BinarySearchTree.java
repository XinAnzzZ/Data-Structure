package com.alibaba.xinan;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author XinAnzzZ
 * @date 2018/10/29 17:31
 */
@SuppressWarnings("unused")
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        E e;

        Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return e.toString();
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
        root = addElement(root, e);
    }

    /*** 在 node 节点的位置插入一个元素 e */
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

    /*** 深度优先搜索，和前序遍历结果一致，需要借用基础数据结构：栈 */
    public void depthFirstSearch() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    /*** 广度优先搜索：需要借助基础数据结构：队列 */
    public void breadthFirstSearch() {
        if (root == null) {
            return;
        }

        LinkedList<Node> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            root = list.removeFirst();
            System.out.println(root);
            if (root.left != null) {
                list.addLast(root.left);
            }
            if (root.right != null) {
                list.addLast(root.right);
            }
        }
    }

    /*** 前序遍历 */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /*** 中序遍历 */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node);
        inOrder(node.right);
    }

    /*** 后序遍历 */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node);
    }

    /*** 得到最小元素 */
    public E getMin() {
        if (size == 0) {
            throw new IllegalArgumentException("The tree is empty !");
        }
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node.e;
    }

    /*** 得到最大元素 */
    public E getMax() {
        if (size == 0) {
            throw new IllegalArgumentException("The tree is empty !");
        }
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.e;
    }

    /*** 删除最小元素 */
    public E removeMin() {

        return null;
    }

    /*** 删除最大元素 */
    public E removeMax() {
        return null;
    }
}
