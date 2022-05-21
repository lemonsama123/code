package leetcode.tree.problem236;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return p.val < root.val && q.val < root.val ? lowestCommonAncestor(root.left, p, q) : p.val > root.val && q.val > root.val ? lowestCommonAncestor(root.right, p, q) : root;
    }
}

