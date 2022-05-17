package leetcode.dfs.problem889;

import java.util.HashMap;

public class Solution {

    int[] preorder;
    int[] postorder;
    HashMap<Integer, Integer> preorderHashMap;
    HashMap<Integer, Integer> postorderHashMap;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        preorderHashMap = new HashMap<>();
        postorderHashMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderHashMap.put(preorder[i], i);
        }
        for (int i = 0; i < postorder.length; i++) {
            postorderHashMap.put(postorder[i], i);
        }
        return constructFromPrePost(0, preorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode constructFromPrePost(int preorderStart, int preorderEnd, int postorderStart, int postorderEnd) {
        if (preorderStart > preorderEnd || postorderStart > postorderEnd) {
            return null;
        }
        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);



        root.left = constructFromPrePost(preorderStart + 1, preorderHashMap.get(postorderHashMap.get(rootValue) - 1) - 1, postorderStart, postorderHashMap.get(preorder[preorderStart + 1]));
        root.right = constructFromPrePost(preorderHashMap.get(postorderHashMap.get(rootValue) - 1), preorderEnd, postorderHashMap.get(preorder[preorderStart + 1]) + 1, postorderEnd - 1);
        return root;
    }
}