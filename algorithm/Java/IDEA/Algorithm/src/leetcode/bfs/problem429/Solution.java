package leetcode.bfs.problem429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> list = new ArrayList<>();
            while (curSize-- != 0) {
                root = queue.poll();
                list.add(root.val);
                for (Node node : root.children) {
                    queue.add(node);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}