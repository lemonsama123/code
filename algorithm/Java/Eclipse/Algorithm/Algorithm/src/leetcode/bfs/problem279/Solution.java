package leetcode.bfs.problem279;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(n);
        visited[n] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            while (curSize-- != 0) {
                int poll = queue.poll();
                for (int i = 1; i * i <= poll; ++i) {
                    if (i * i == poll) {
                        return ans;
                    }
                    if (!visited[poll - i * i]) {
                        queue.offer(poll - i * i);
                        visited[poll - i * i] = true;
                    }
                }
            }
            ans++;
        }
        return 0;
    }
}