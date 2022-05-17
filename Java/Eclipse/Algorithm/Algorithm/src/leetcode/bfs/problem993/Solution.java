package leetcode.bfs.problem993;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    int x;
    TreeNode xParent;
    int xDepth;
    boolean xFound;

    int y;
    TreeNode yParent;
    int yDepth;
    boolean yFound;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        this.x = x;
        this.y = y;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);
        update(root, null, 0);
        while (!nodeQueue.isEmpty()) {
            TreeNode parent = nodeQueue.poll();
            int parentDepth = depthQueue.poll();
            System.out.println(parentDepth);
            if (parent.left != null) {
                nodeQueue.add(parent.left);
                depthQueue.add(parentDepth + 1);
                update(parent.left, parent, parentDepth + 1);
            }
            if (parent.right != null) {
                nodeQueue.add(parent.right);
                depthQueue.add(parentDepth + 1);
                update(parent.right, parent, parentDepth + 1);
            }
            if (xFound && yFound) {
                break;
            }
        }
        return xDepth == yDepth && xParent != yParent;
    }

    public void update(TreeNode node, TreeNode parent, int depth) {
        if (node.val == this.x) {
            this.xParent = parent;
            this.xDepth = depth;
            this.xFound = true;
        } else if (node.val == this.y) {
            this.yParent = parent;
            this.yDepth = depth;
            this.yFound = true;
        }
    }
}