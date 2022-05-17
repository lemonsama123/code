//package leetcode.dfs.problem549;
//
//import java.io.*;
//
//public class Solution {
//
//    int ans = 0;
//
//    public int longestConsecutive(TreeNode root) {
//        dfs(root);
//        return ans;
//    }
//
//    public int dfs(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = dfs(root.left) + 1;
//        int right = dfs(root.left) + 1;
//
//    }
//}