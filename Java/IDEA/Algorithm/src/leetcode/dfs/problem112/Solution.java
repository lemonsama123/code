package leetcode.dfs.problem112;

public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) {
          return false;
      }
      if (root.left == null && root.right == null) {
          return targetSum == root.val;
      }
      return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
