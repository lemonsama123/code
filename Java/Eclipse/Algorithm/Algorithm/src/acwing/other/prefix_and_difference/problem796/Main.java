package acwing.other.prefix_and_difference.problem796;

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
		int m = nums[1];
		int q = nums[2];
		int[][] a = new int[n + 1][m + 1];
		int[][] s = new int[n + 1][m + 1];
		for (int i = 1; i <= n; ++i) {
			nums = readLine();
			for (int j = 1; j <= m; ++j) {
				a[i][j] = nums[j - 1];
				s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + a[i][j];
			}
		}
		while (q-- != 0) {
			nums = readLine();
			int x1 = nums[0];
			int y1 = nums[1];
			int x2 = nums[2];
			int y2 = nums[3];
			writer.write(s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1] + "\n");
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
