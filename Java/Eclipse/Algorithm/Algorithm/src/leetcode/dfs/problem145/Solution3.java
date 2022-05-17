package leetcode.dfs.problem145;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//FIXME: 不懂
public class Solution3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null && root != cur.left && root != cur.right) {
                stack.push(cur.left);
            } else if (cur.right != null && root != cur.right) {
                stack.push(cur.right);
            } else {
                list.add(stack.pop().val);
                root = cur;
            }
        }
        return list;
    }
}