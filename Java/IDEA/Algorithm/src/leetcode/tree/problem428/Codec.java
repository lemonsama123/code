package leetcode.tree.problem428;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {

    public String serialize(Node root) {
        if (root == null) {
            return "#";
        }
        Queue<Node> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                ans.append("#,");
                continue;
            }
            ans.append(root.val + ",");
            for (Node node : root.children) {
                queue.add(node);
            }
            ans.append("%,");
        }
        System.out.println(ans.toString());
        return ans.toString();
    }


    public Node deserialize(String data) {
        if ("#".equals(data)) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        String[] values = data.split(",");
        Node root = new Node(Integer.valueOf(values[0]));
        queue.add(root);
        for (int i = 0; i < values.length; i++) {
            Node poll = queue.poll();
            List<Node> children = new ArrayList<>();
            for (; i < values.length; i++) {
                if ("%".equals(values[i])) {
                    continue;
                } else if (!"#".equals(values[i])) {
                    Node node = new Node(Integer.valueOf(values[i]));
                    children.add(node);
                    queue.add(node);
                }
            }
            poll.children = children;
        }
        return root;
    }
}