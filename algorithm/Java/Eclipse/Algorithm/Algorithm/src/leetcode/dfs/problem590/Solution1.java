package leetcode.dfs.problem590;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return ans;
        }
        for (Node node : root.children) {
            postorder(node);
        }
        ans.add(root.val);
        return ans;
    }
}