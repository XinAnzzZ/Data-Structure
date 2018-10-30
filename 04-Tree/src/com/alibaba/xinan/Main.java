package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/29 17:30
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {5, 8, 9, 4, 2};
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i : arr) {
            tree.add(i);
        }
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(3));
        tree.preOrder();
    }
}
