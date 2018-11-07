package com.alibaba.xinan;

/**
 * @author XinAnzzZ
 * @date 2018/10/29 17:30
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 5, 17, 28, 32, 34, 29, 18, 13, 8, 3, 9, 11};
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i : arr) {
            tree.add(i);
        }
        tree.breadthFirstSearch();
    }
}
