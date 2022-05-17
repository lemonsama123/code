package leetcode.dfs.problem106;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> indexInInorder;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.indexInInorder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexInInorder.put(inorder[i], i);
        }
        return buildTree(0, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int postorderStart, int postorderEnd, int inorderStart, int inorderEnd) {
        if (postorderStart > postorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        int vauleOfCurNode = postorder[postorderEnd];
        int indexOfCurNode = indexInInorder.get(vauleOfCurNode);
        TreeNode cur = new TreeNode(vauleOfCurNode);
        cur.left = buildTree(postorderStart, postorderStart + indexOfCurNode - inorderStart - 1, inorderStart, indexOfCurNode - 1);
        cur.right = buildTree(postorderStart + indexOfCurNode - inorderStart , postorderEnd - 1, indexOfCurNode + 1, inorderEnd);
        return cur;
    }
}