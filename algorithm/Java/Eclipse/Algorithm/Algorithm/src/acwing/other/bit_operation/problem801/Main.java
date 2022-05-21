package acwing.other.bit_operation.problem801;

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
		for (int i = 0; i < n; ++i) {
			int res = 0;
			while (arr[i] != 0) {
				arr[i] -= lowbit(arr[i]);
				++res;
			}
			printf("%d ", res);
		}
		close();
	}
	
	static int lowbit(int x) {
		return x & (~x + 1);
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

	static void printf(String format, Object... args) throws IOException {
		writer.write(String.format(format, args));
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
