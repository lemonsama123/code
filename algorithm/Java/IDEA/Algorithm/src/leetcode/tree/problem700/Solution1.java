package leetcode.tree.problem700;

/**
 * 解决方案
 *
 * @author Lemon
 * @date 2022/03/05
 */
public class Solution1 {
    /**
     * 递归
     *
     * @param root 根
     * @param val  瓦尔
     * @return {@link TreeNode}
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
    }
}
