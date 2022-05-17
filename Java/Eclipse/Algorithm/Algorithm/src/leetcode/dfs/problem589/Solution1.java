package leetcode.dfs.problem589;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
           for (Node node : root.children) {
               preorder(node);
           }
        return ans;
    }
}
