package leetcode.tree.problem700;

public class Solution2 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (val == root.val) {
                break;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return root;
    }
}
