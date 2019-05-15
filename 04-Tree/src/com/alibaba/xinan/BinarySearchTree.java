package com.alibaba.xinan;


/**
 * 二分搜索树
 *
 * @author XinAnzzZ
 * @since 2019-05-15
 */
@SuppressWarnings("unused")
public class BinarySearchTree<E extends Comparable<E>> {

    class Node {
        Node left, right;
        E e;

        Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node root;

    private int size;

    /**
     * 向树中添加一个元素，若元素已存在，则不插入 -- 非递归写法
     */
    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
            return;
        }

        Node current = this.root;
        for (; ; ) {
            if (e.compareTo(current.e) < 0) {
                if (current.left != null) {
                    current = current.left;
                    continue;
                }
                current.left = new Node(e);
                size++;
                return;
            } else if (e.compareTo(current.e) > 0) {
                if (current.right != null) {
                    current = current.right;
                    continue;
                }
                current.right = new Node(e);
                size++;
                return;
            } else {
                // 元素存在则不添加
                return;
            }
        }
    }

    /**
     * 向树中添加一个节点，若元素已存在，则不插入 -- 递归写法
     */
    public void addRecursive(E e) {
        root = addElement(root, e);
    }

    /**
     * 向给定节点中添加元素 e，返回节点的根
     *
     * @param node 要添加元素的节点
     * @param e    要添加的元素
     * @return 添加完成后的根节点
     */
    private Node addElement(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = addElement(node.left, e);
        } else {
            node.right = addElement(node.right, e);
        }
        return node;
    }

    /**
     * 查询是否包含元素 e
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }

    /**
     * 从树中删除元素 e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 从已 node 为根的树中删除元素为 e 的节点，并且返回新的树的根
     *
     * @param node 要删除的树的根节点
     * @param e    要删除的节点的元素
     * @return 删除后新的树的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            throw new IllegalArgumentException("要删除的元素不存在！");
        }

        // 如果要删除的节点比当前节点小，说明要删除的节点在左子树中
        if (e.compareTo(node.e) < 0) {
            // 从左子树删除，并且将删除后得到的新的树挂在当前节点在左边
            node.left = remove(node.left, e);
            // 返回删除后的树的根
            return node;
        }

        // 要删除的节点在右子树中
        if (e.compareTo(node.e) > 0) {
            // 从右子树中删除，并且将删除后得到的新的子树挂在当前节点的右边
            node.right = remove(node.right, e);
            return node;
        }

        // 如果走到这里，说明 e.compareTo(node.e) = true，即当前节点就是要删除的节点

        // 如果当前节点的左子树为空，说明要删除的节点是以（当前节点为根的子树）中的最小值
        if (node.left == null) {
            return removeMin(node);
        }

        // 如果右子树为空，说明要删除的节点是（当前节点为根的子树）中的最大值
        if (node.right == null) {
            return removeMax(node);
        }

        // 左右子树都不为空，找到前驱或者后继来替代当前节点，这里使用前驱
        Node predecessor = getMax(node.left);

        // 将删除前驱后的左子树和右子树挂在前驱上，并且返回前驱
        predecessor.left = removeMax(node.left);
        predecessor.right = node.right;
        return predecessor;
    }

    /**
     * 从以 node 为根的二叉树中删除最小节点
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            size--;
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 从以 node 为根的二叉树中删除最大节点
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            size--;
            return node.left;
        }
        return null;
    }

    /**
     * 从以 node 为根的二叉树中找到元素值最小的节点
     */
    private Node getMin(Node node) {

        if (node == null) {
            throw new IllegalArgumentException("根节点为空，不存在最小节点！");
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 从以 node 为根的二叉树中找到元素值最大的节点
     */
    private Node getMax(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("根节点为空，不存在最大节点");
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.addRecursive(9);
        tree.addRecursive(3);
        tree.addRecursive(6);
        tree.addRecursive(1);
        tree.addRecursive(4);
        tree.addRecursive(7);
        tree.addRecursive(14);
        tree.addRecursive(12);
        tree.addRecursive(18);
        tree.addRecursive(16);

        tree.remove(3);
        System.out.println("test");
    }
}
