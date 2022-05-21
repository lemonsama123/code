package leetcode.dfs.problem94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
               stack.push(root);
               root = root.left;
            } else {
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }

        }
        return ans;
    }
}
