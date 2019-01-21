package com.alibaba.xinan;

import java.util.*;

/**
 * @author XinAnzzZ
 * @date 2019/01/21 20:35
 */
public class Solution2 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        // 首先遍历数组，进行频率的统计，将统计结果放入map中。
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        /*
        下面的代码可以简写为下面一行代码
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        这一行代码还可以继续简化为下面这行代码
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        */
        java.util.PriorityQueue<Integer> queue = new java.util.PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            if (queue.size() < k) {
                queue.add(key);
            } else if (map.get(queue.peek()) < map.get(key)) {
                queue.remove();
                queue.add(key);
            }
        }

        return new ArrayList<>(queue);
    }
}
