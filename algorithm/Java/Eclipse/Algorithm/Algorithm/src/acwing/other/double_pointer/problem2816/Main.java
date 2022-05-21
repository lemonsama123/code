package acwing.other.double_pointer.problem2816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		int[] a = nextLine();
		int n = a[0];
		int m = a[1];
		a = nextLine();
		int[] b = nextLine();
		int j = 0;
		for (int i = 0; i < m; ++i) {
			if (j < n && a[j] == b[i]) {
				++j;
			}
		}
		if (j == n) {
			print("Yes");
		} else {
			print("No");
		}
		close();
	}

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] nextLine() throws IOException {
		String[] strs = reader.readLine().split(" ");
		int[] res = new int[strs.length];
		for (int i = 0; i < res.length; ++i) {
			res[i] = Integer.parseInt(strs[i]);
		}
		return res;
	}

	static void print(Object o) throws IOException {
		writer.write(String.valueOf(o.toString()));
	}

	static void close() throws IOException {
		writer.flush();
		writer.close();
		reader.close();
	}
}
