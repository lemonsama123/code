package sfo.problem40;

import java.util.PriorityQueue;

public class Solution1 {
	public int[] getLeastNumbers(int[] arr, int k) {
		int[] res = new int[k];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; ++i) {
			pq.offer(arr[i]);
		}
		while (k-- != 0) {
			res[k] = pq.poll();
		}
		return res;
	}
}