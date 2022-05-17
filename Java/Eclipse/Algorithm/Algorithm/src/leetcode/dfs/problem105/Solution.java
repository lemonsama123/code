package leetcode.dfs.problem105;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> indexInInorder;
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.indexInInorder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexInInorder.put(inorder[i], i);
        }
        return  buildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int preorderStart, int preorderEnd, int inorderStart, int inorderEnd) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }
        int valueOfCurNode = preorder[preorderStart];
        int indexOfCurNode = indexInInorder.get(valueOfCurNode);
        TreeNode cur = new TreeNode(valueOfCurNode);
        cur.left = buildTree(preorderStart + 1, indexOfCurNode - inorderStart + preorderStart, inorderStart, indexOfCurNode - 1);
        cur.right = buildTree(indexOfCurNode - inorderStart + preorderStart + 1, preorderEnd, indexOfCurNode + 1, inorderEnd);
        return cur;
    }
}