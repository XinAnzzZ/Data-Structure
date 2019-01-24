package com.alibaba.xinan;

import java.util.TreeMap;

/**
 * @author XinAnzzZ
 * @date 2019/01/24 14:27
 */
public class Trie {

    private Node root;

    private int size;

    private class Node {
        boolean isWord;
        TreeMap<Character, Node> next;

        Node() {
            this(false);
        }

        Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
    }

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    /*** 向字典树中添加一个单词 */
    public void add(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);

            if (!current.isWord) {
                current.isWord = true;
                size++;
            }
        }
    }

    public boolean contains(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.next.get(c) == null) {
                return false;
            }

            current = current.next.get(c);
        }

        return current.isWord;
    }
}
