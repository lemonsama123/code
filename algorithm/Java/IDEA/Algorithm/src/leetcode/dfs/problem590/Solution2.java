package leetcode.dfs.problem590;

import java.util.*;

public class Solution2 {
    public List<Integer> postorder(Node root) {
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
                for (Node node : root.children) {
                    stack.add(node);
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}