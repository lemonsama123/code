package leetcode.dfs.problem111;

public class Solution {
    public int minDepth(TreeNode root) {
      if (root == null) {
          return 0;
      }
      return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return root.right == null ? dfs(root.left) + 1 : dfs(root.right) + 1;
        }
        return Math.min(dfs(root.left), dfs(root.right)) + 1;
    }
}