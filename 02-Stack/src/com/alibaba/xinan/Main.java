package com.alibaba.xinan;

import java.util.*;

/**
 * 括号校验算法
 *
 * @author XinAnzzZ
 * @date 2018/10/21 0021 21:05
 */
public class Main {

    private static Map<Character, Character> characterMap = new HashMap<>(8);

    private static List<Character> leftBrackets = new ArrayList<>();

    static {
        initBracketsList();
        initCharacterMap();
    }


    public static void main(String[] args) {
        String string = "{{}}[](";
        System.out.println(isValid(string));
    }

    private static boolean isValid(String target) {
        Stack<Character> stack = new Stack<>();
        char[] targetCharArray = target.toCharArray();

        for (char character : targetCharArray) {
            if (leftBrackets.contains(character)) {
                stack.push(character);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if (characterMap.get(character).equals(stack.peek())) {
                stack.pop();
                continue;
            }
            return false;
        }

        return stack.isEmpty();
    }

    private static void initBracketsList() {
        leftBrackets.add('[');
        leftBrackets.add('(');
        leftBrackets.add('{');
    }

    private static void initCharacterMap() {
        characterMap.put(')', '(');
        characterMap.put(']', '[');
        characterMap.put('}', '{');
    }
}
