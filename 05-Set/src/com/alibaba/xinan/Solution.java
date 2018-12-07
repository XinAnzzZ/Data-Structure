package com.alibaba.xinan;

import java.util.TreeSet;

/**
 * LeetCode no.804 question solution
 *
 * @author XinAnzzZ
 * @date 2018/12/7 15:21
 */
public class Solution {

    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        TreeSet<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(arr[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}