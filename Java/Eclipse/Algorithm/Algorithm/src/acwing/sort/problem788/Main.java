package acwing.sort.problem788;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int[] temp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 自动生成的方法存根
		int N = nextInt();
		int[] q = readLine();
		temp = new int[q.length];
		writer.write(mergeSort(q, 0, N - 1) + " ");
		flush();
	}
	
	static long mergeSort(int q[], int l, int r) {
		if (l >= r) {
			return 0;
		}
		long res = 0;
		int mid = (l + r) >> 1;
		res += (mergeSort(q, l, mid) + mergeSort(q, mid + 1, r));
		int k = 0;
		int i = l;
		int j = mid + 1;
		while (i <= mid && j <= r) {
			if (q[i] <= q[j]) {
				temp[k++] = q[i++];
			} else {
				res += (mid - i + 1);
				temp[k++] = q[j++];
			}
		}
		while (i <= mid) {
			temp[k++] = q[i++];
		}
		while (j <= r) {
			temp[k++] = q[j++];
		}
		for (i = l, j = 0; i <= r; ++i, ++j) {
			q[i] = temp[j];
		}
		return res;
	}

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] readLine() throws IOException {
		String[] strs = reader.readLine().split(" ");
		int[] res = new int[strs.length];
		for (int i = 0; i < res.length; ++i) {
			res[i] = Integer.parseInt(strs[i]);
		}
		return res;
	}
	
	static int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(reader.readLine());
	}
	
	static void flush() throws IOException {
		writer.flush();
		writer.close();
		reader.close();
	}
			
}
