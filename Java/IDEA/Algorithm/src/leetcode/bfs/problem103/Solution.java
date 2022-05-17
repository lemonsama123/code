package leetcode.bfs.problem103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (curSize-- != 0) {
                root = queue.poll();
                if ((ans.size() & 1) != 0) {
                    list.addFirst(root.val);
                } else {
                    list.add(root.val);
                }
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}