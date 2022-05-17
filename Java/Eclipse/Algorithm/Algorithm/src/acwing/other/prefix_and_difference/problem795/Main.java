package acwing.other.prefix_and_difference.problem795;

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
		int[] a = new int[n + 1];
		int[] s = new int[n + 1];
		nums = readLine();
		for (int i = 1; i <= n; ++i) {
			a[i] = nums[i - 1];
			s[i] = s[i - 1] + a[i];
		}
		while (m-- != 0) {
			nums = readLine();
			int l = nums[0];
			int r = nums[1];
			writer.write(s[r] - s[l - 1] + "\n");
		}
		writer.flush();
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
