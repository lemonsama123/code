package leetcode.tree.problem236;

/**
 * 二叉树公共祖先的一般求解方法
 * 没有用到搜索二叉树的条件
 *
 * @author Lemon
 * @date 2022/03/05
 */
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
