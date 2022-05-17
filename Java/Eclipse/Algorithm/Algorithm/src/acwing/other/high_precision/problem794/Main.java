package acwing.other.high_precision.problem794;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		BigInteger a = new BigInteger(reader.readLine());
		BigInteger b = new BigInteger(reader.readLine());
		System.out.println(a.divide(b));
		System.out.println(a.mod(b));
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
