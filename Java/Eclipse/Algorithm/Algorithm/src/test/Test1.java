package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test1 {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		printf("%d\n%.2f", 101, 12.324f);
		println();
		print(3);
		close();
		String string = new String();
		string.matches("");
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

	static void println(Object o) throws IOException {
		writer.write(String.valueOf(o.toString()));
		writer.newLine();
	}

	static void println() throws IOException {
		writer.newLine();
	}

	static void close() throws IOException {
		writer.flush();
		writer.close();
		reader.close();
	}
}
