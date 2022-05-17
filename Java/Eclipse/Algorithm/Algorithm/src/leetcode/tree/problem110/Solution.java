package leetcode.tree.problem110;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) == -1;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 1;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}

