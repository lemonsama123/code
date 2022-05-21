package data_structure_experiment.experiment6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        postorderTraversal(buildTree(new int[] {6, 8, 7, 4, 5, 1, 3, 2}, new int[] {8, 5, 4, 7, 6, 3, 2, 1}));
    }
    //层序遍历
    static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.print(root.val + " ");
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
    }

    //根据中序后续构造二叉树
    static public Node buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1, hashMap, postorder);
    }

    static public Node buildTree(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd, HashMap<Integer, Integer> hashMap, int[] postorder) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }
        int valOfRoot = postorder[postorderEnd];
        int indexOfRoot = hashMap.get(valOfRoot);
        Node root = new Node(valOfRoot);
        root.left = buildTree(inorderStart, indexOfRoot - 1, postorderStart, postorderStart + indexOfRoot - inorderStart - 1, hashMap, postorder);
        root.right = buildTree(indexOfRoot + 1, inorderEnd, postorderStart + indexOfRoot - inorderStart, postorderEnd - 1, hashMap, postorder);
        return root;
    }

    static void postorderTraversal(Node root) {
        Stack<Pair<Node, Integer>> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(new Pair<>(root, 1));
                root = root.left;
            }
            if (stack.peek().v == 2) {
                System.out.print(stack.pop().k.val + " ");
            } else {
                stack.peek().v = 2;
                root = stack.peek().k.right;
            }
        }
    }
}

class Pair<K, V> {
    K k;
    V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }
}

class Node {

    int val;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

}