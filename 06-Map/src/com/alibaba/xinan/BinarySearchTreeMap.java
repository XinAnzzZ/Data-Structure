package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/12/08 21:24
 */
@SuppressWarnings("unused")
public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;

    private int size;

    private class Node {
        K key;

        V value;

        Node left, right;

        Node() {
            this(null, null);
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public BinarySearchTreeMap() {
    }

    @Override
    public void put(K key, V value) {
        Node newNode = new Node(key, value);
        root = put(root, newNode);
    }

    private Node put(Node node, Node newNode) {
        if (node == null) {
            size++;
            return newNode;
        }

        if (newNode.key.compareTo(node.key) < 0) {
            node.left = put(node.left, newNode);
        } else if (newNode.key.compareTo(node.key) > 0) {
            node.right = put(node.right, newNode);
        } else {
            node.value = newNode.value;
        }

        return node;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    private Node getNode(Node node, K key) {
        Node current = node;
        while (current != null) {
            if (current.key.compareTo(key) < 0) {
                current = current.left;
            } else if (current.key.compareTo(key) > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node == null) {
            return null;
        }
        root = remove(root, key);
        return node.value;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (node.key.compareTo(key) > 0) {
            node.left = remove(node.left, key);
        }
        if (node.key.compareTo(key) < 0) {
            node.right = remove(node.right, key);
        }

        // 当前node即为目标node，删除当前node即可
        // 右子树为空
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        // 左子树为空
        if (node.left == null) {
            return removeRight(node);
        }

        // 左右子树都不为空，找到前驱或者后继进行替换
        Node leftNode = node.left;
        Node rightNode = node.right;
        node.left = null;
        node.right = null;

        Node successor = rightNode;
        while (successor.left != null) {
            successor = successor.left;
        }

        rightNode = removeMin(rightNode);

        successor.left = leftNode;
        successor.right = rightNode;
        return successor;
    }

    private Node removeRight(Node node) {
        Node rightNode = node.right;
        node.right = null;
        size--;
        return rightNode;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean containsKey(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
