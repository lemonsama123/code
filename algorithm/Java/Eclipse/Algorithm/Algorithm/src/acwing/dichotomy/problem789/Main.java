package acwing.dichotomy.problem789;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		int[] nums = readLine();
		int n = nums[0];
		int q = nums[1];
		int a[] = readLine();
		while (q-- != 0) {
			int x = nextInt();
			int l = 0;
			int r = n - 1;
			while (l < r) {
				int mid = (l + r) >> 1;
				if (a[mid] >= x) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			if (x != a[l]) {
				writer.write("-1 -1\n");
			} else {
				writer.write(l + " ");
				l = 0;
				r = n - 1;
				while (l < r) {
					int mid = (l + r + 1) >> 1;
					if (a[mid] <= x) {
						l = mid;
					} else {
						r = mid - 1;
					}
				}
				writer.write(l + "\n");
			}
		}
		flush();
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
