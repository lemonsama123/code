package acwing.sort.problem787;

/**
 * 归并排序模板
 */

import java.io.*;

public class Main {

	static int n;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(reader.readLine());
		String[] s = reader.readLine().split(" ");
		temp = new int[n];
		int[] q = new int[n];
		for (int i = 0; i < n; i++) {
			q[i] = Integer.parseInt(s[i]);
		}
		mergeSort(q, 0, n - 1);
		for (int i = 0; i < n; i++) {
			writer.write(q[i] + " ");
		}
		writer.flush();
		reader.close();
		writer.close();
	}

	static void mergeSort(int q[], int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = (l + r) >> 1;
		mergeSort(q, l, mid);
		mergeSort(q, mid + 1, r);

		int k = 0;
		int i = l;
		int j = mid + 1;

		while (i <= mid && j <= r) {
			if (q[i] < q[j]) {
				temp[k++] = q[i++];
			} else {
				temp[k++] = q[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = q[i++];
		}
		while (j <= r) {
			temp[k++] = q[j++];
		}
		for (i = l, j = 0; i <= r; i++, j++) {
			q[i] = temp[j];
		}
	}
}
