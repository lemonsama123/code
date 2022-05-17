package leetcode.graph.problem797;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> ans = new ArrayList<>();
       if (graph == null || graph.length == 0) {
           return ans;
       }
       Queue<List<Integer>> queue = new LinkedList<>();
       List<Integer> path = new ArrayList<>();
       path.add(0);
       queue.add(path);
       while (!queue.isEmpty()) {
           List<Integer> poll = queue.poll();
           int node = poll.get(poll.size() - 1);
           for (int next : graph[node]) {
               List<Integer> temp = new ArrayList<>(poll);
               temp.add(next);
               if (next == graph.length - 1) {
                   ans.add(new ArrayList<>(temp));
               } else {
                   queue.add(new ArrayList<>(temp));
               }
           }
       }
       return ans;
    }
}