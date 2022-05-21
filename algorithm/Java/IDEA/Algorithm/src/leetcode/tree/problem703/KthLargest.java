package leetcode.tree.problem703;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
          add(num);
        }
    }

    public int add(int val) {
        priorityQueue.add(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}

