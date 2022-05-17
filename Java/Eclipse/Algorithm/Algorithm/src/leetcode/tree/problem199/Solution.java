package leetcode.tree.problem199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- != 0) {
				root = queue.poll();
				if (size == 0) {
					list.add(root.val);
				}
				if (root.left != null) {
					queue.offer(root.left);
				}
				if (root.right != null) {
					queue.offer(root.right);
				}
			}
		}
		return list;
	}
}
