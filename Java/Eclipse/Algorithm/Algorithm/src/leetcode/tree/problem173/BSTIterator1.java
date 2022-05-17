package leetcode.tree.problem173;

import java.util.ArrayList;

public class BSTIterator1 {

    ArrayList<Integer> arrayList;

    public BSTIterator1(TreeNode root) {
        arrayList = new ArrayList<>();
        inorderTraversal(root);
    }

    public int next() {
        int cur = arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);
        return cur;
    }

    public boolean hasNext() {
        return arrayList.size() != 0;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.right);
        arrayList.add(root.val);
        inorderTraversal(root.left);
    }
}