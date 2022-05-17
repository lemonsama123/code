package leetcode.tree.problem173;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

public class BSTIterator2 {

    TreeNode cur;
    Stack<TreeNode> stack;

    public BSTIterator2(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }
}