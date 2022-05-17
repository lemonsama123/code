package leetcode.dfs.problem589;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            ans.add(root.val);
            if (root.children != null) {
                ListIterator<Node> nodeListIterator = root.children.listIterator(root.children.size() - 1);
                while (nodeListIterator.hasPrevious()) {
                   stack.push(nodeListIterator.previous());
                }
            }
        }
      return ans;
    }
}
