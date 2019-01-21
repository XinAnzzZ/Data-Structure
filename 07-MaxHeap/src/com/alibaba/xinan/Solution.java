package com.alibaba.xinan;

import java.util.*;

/**
 * LeetCode no.347 Question solution
 *
 * @author XinAnzzZ
 * @date 2019/01/17 16:48
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(nums, 2));
    }

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

        // 这个set中每一个entry就是一个元素及其出现的频率值，也就对应了一个Frequent对象
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Frequent> queue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            // 如果队列里面的元素小于K就直接入队
            if (queue.size() < k) {
                queue.enqueue(new Frequent(entry));
            } else {
                // 如果队首的Frequent对象的频率小于新来的Frequent对象的频率，就将队首的元素出队，新元素入队
                if (queue.getFront().frequency < entry.getValue()) {
                    queue.dequeue();
                    queue.enqueue(new Frequent(entry));
                }
            }
        }
        // 遍历完成之后，队列中剩余的元素就是这所有元素中频率前k大的元素了。

        LinkedList<Integer> list = new LinkedList<>();
        // 将这前k大的元素放进list并且返回
        while (!queue.isEmpty()) {
            list.add(queue.dequeue().e);
        }

        return list;
    }

    private class Frequent implements Comparable<Frequent> {
        int e, frequency;

        Frequent(Map.Entry<Integer, Integer> entry) {
            this.e = entry.getKey();
            this.frequency = entry.getValue();
        }

        @Override
        public int compareTo(Frequent another) {
            return Integer.compare(another.frequency, this.frequency);
        }
    }
}
