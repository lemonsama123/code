package acwing.other.double_pointer.problem799;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 自动生成的方法存根
		int n = nextInt();
		int[] arr = nextLine();
		int[] s = new int[n + 1];
		int res = 0;
		for (int i = 0, j = 0; i < n; ++i) {
			++s[arr[i]];
			while (s[arr[i]] > 1) {
				--s[arr[j]];
				++j;
			}
			res = Math.max(res, i - j + 1);
		}
		print(res);
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

	static int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(reader.readLine());
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
