package leetcode.dfs.problem298;

public class Solution {

    int ans = 0;

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        if (root.left != null && root.left.val != root.val + 1) {
            left = 1;
        }
        if (root.right != null && root.right.val != root.val + 1) {
            right = 1;
        }
        ans = Math.max(Math.max(left, right), ans);
        return Math.max(left, right);
    }
}