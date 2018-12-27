package com.alibaba.xinan;

import java.util.Random;

/**
 * @author XinAnzzZ
 * @date 2018/12/27 14:02
 */
public class TestCase {

    public static void main(String[] args) {
        int n = 1000000;

        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                System.out.println("ERROR");
            }
        }

        System.out.println("SUCCESS");
    }
}
