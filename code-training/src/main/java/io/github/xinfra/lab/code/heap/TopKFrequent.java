package io.github.xinfra.lab.code.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequent {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.compute(n, (key, v) -> v == null ? 1 : v + 1);
            }

            Queue<int[]> queue = new PriorityQueue<>(
                    (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));

            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (queue.size() < k) {
                    queue.add(new int[]{e.getKey(), e.getValue()});
                } else {
                    if (e.getValue() > queue.peek()[1]) {
                        queue.poll();
                        queue.add(new int[]{e.getKey(), e.getValue()});
                    }
                }
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = queue.poll()[0];
            }
            return result;
        }
    }

    // todo ： bucket sort
}
