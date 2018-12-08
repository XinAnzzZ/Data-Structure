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

        private Node(E e) {
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
        E min = getMin();
        root = removeMin(root);
        return min;
    }

    /*** 删掉以node为根的二分搜索树中的最小节点，返回删除节点后新的二分搜索树的根 */
    private Node removeMin(Node node) {

        // 终止条件
        if (node.left == null) {
            // 如果左孩子为null，说明当前节点就是二分搜索树的最小节点，那么删除这个节点即可。
            // 但是这个节点可能还有右子树，所以我们需要将当前节点的右子树保存起来，删掉当前节点只有再放到原来的树上
            return removeRight(node);
        }

        // 注意，前面这个node和后面的node不是同一个node，后面的node是前面node的孩子。
        node.left = removeMin(node.left);
        return node;
    }

    /*** 删除最大元素 */
    public E removeMax() {
        E max = getMax();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node node) {

        if (node.right == null) {
            return removeLeft(node);
        }

        node.right = removeMax(node.right);
        return node;
    }

    /*** 从树中删除元素为e的节点 */
    public void remove(E e) {
        root = remove(root, e);
    }

    /*** 删除以node为根的二分搜索树中的值为e的节点，返回删除节点后新的二分搜索树的根 */
    private Node remove(Node node, E e) {
        if (node == null) {
            throw new IllegalArgumentException("The element you want to remove doesn't exist !");
        }

        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }

        // 找到了要删除的元素

        // 只有右子树
        if (node.left == null) {
            return removeRight(node);
        }

        // 只有左子树
        if (node.right == null) {
            return removeLeft(node);
        }

        // 既有右子树又有左子树
        return removeMiddle(node);
    }

    private Node removeMiddle(Node node) {
        Node rightNode = node.right;
        Node leftNode = node.left;

        node.left = null;
        node.right = null;
        // 这里不应该size--，因为在下面的removeMin(rightNode)中进行了一次size--
        // size--;

        // 找到右子树中的最小值，也就是后继
        Node successor = rightNode;
        while (successor.left != null) {
            successor = successor.left;
        }
        // 删除右子树最小值
        rightNode = removeMin(rightNode);

        successor.right = rightNode;
        successor.left = leftNode;
        return successor;
    }

    private Node removeLeft(Node node) {
        Node leftNode = node.left;
        node.left = null;
        size--;
        return leftNode;
    }

    private Node removeRight(Node node) {
        Node rightNode = node.right;
        node.right = null;
        size--;
        return rightNode;
    }
}
