package acwing.other.double_pointer.problem800;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		int[] A = nextLine();
		int n = A[0];
		int m = A[1];
		int x = A[2];
		A = nextLine();
		int[] B = nextLine();
		for (int i = 0, j = m - 1; i < n; ++i) {
			while (j >= 0 && A[i] + B[j] > x) {
				--j;
			}
			if (A[i] + B[j] == x) {
				printf("%d %d", i, j);
				break;
			}
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

	static void printf(String format, Object... args) throws IOException {
		writer.write(String.format(format, args));
	}

	static void close() throws IOException {
		writer.flush();
		writer.close();
		reader.close();
	}
}
