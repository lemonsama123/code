package leetcode.tree.problem297;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                ans.append("#,");
                continue;
            }
            ans.append(root.val + ",");
            queue.add(root.left);
            queue.add(root.right);
        }
        return ans.toString();
    }

    public TreeNode deserialize(String data) {
        if ("#".equals(data)) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode poll = queue.poll();
            if (!"#".equals(values[i])) {
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                poll.left = left;
                queue.add(left);
            }
            if (!"#".equals(values[++i])) {
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                poll.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}



