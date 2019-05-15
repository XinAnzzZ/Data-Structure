package com.alibaba.xinan;

import java.util.Random;

/**
 * @author XinAnzzZ
 * @date 2018/10/29 17:30
 */
public class MainTest {

    public static void main(String[] args) {
        int[] arr = {20, 10, 30, 5, 17, 28, 32, 34, 29, 18, 13, 8, 3, 9, 11};
        BinarySearchTree2<Integer> tree = new BinarySearchTree2<>();
        for (int i : arr) {
            tree.add(i);
        }
        System.out.println(tree.getMin());
        System.out.println(tree.getMax());


    }

    public void testRemoveMin() {
        BinarySearchTree2<Integer> bst = new BinarySearchTree2<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            bst.add(random.nextInt(10000));
        }

        System.out.println("min:" + bst.removeMin());
        System.out.println("max:" + bst.removeMax());
        bst.inOrder();
    }
}
