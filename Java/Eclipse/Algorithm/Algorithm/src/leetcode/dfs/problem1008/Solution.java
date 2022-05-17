package leetcode.dfs.problem1008;

public class Solution {

    int length;
    int[] preorder;
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        length = preorder.length;
        return bstFromPreorder(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    public TreeNode bstFromPreorder(int slow, int upper) {
        if (index == length) {
            return null;
        }
        int cur = preorder[index];
        if (cur < slow || cur > upper) {
            return null;
        }
        TreeNode root = new TreeNode(cur);
        root.left = bstFromPreorder(slow, root.val);
        root.right = bstFromPreorder(root.val, upper);
        return root;
    }
}
