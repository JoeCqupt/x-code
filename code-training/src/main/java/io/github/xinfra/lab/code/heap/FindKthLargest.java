package io.github.xinfra.lab.code.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest {

    class Solution {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> queue = new PriorityQueue<>(
                    (v1, v2)-> Integer.compare(v1, v2)
            );

            for (int num : nums){
                if (queue.size()<k){
                    queue.add(num);
                }else {
                    if (num>queue.peek()){
                        queue.poll();
                        queue.add(num);
                    }
                }
            }
            return queue.peek();
        }
    }

}
