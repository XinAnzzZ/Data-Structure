package com.alibaba.xinan;

import java.util.Random;

/**
 * @author XinAnzzZ
 * @date 2018/10/23 21:13
 */
public class Main {

    public static void main(String[] args) {
        int operationCount = 10000000;

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println(testStack(linkedListStack, operationCount));
    }

    private static double testStack(Stack<Integer> stack, int operationCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < operationCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < operationCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}
