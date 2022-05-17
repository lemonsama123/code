package leetcode.tree.problem701;

import java.util.TreeMap;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode temp = new TreeNode(val);
        if (root == null) {
            root = temp;
            return root;
        }
        TreeNode last = root;
        while (last.left != null || last.right != null) {
            if (last.val > val) {
                if (last.left == null) {
                    break;
                }
                last = last.left;
            } else {
                if (last.right == null) {
                    break;
                }
                last = last.right;
            }
        }
        if (last.val > val) {
            last.left = temp;
        } else {
            last.right = temp;
        }
        return root;
    }
}
