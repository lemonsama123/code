package base.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException {
		int n = nextInt();
		HashSet<Integer> hashSet = new HashSet<>();
		int a = -1, b = -1, c = -1;
		String x = null, y = null, z = null;
		while (n-- != 0) {
			hashSet.clear();
			String[] strs = reader.readLine().split(" ");
			String name = strs[0];
			int K = Integer.parseInt(strs[1]);
			for (int i = 0; i < K; ++i) {
				hashSet.add(Integer.parseInt(strs[i + 2]));
			}
			if (a == -1) {
				a = hashSet.size();
				x = name;
			} else if (b == -1) {
				b = hashSet.size();
				y = name;
			} else if (c == -1) {
				c = hashSet.size();
				z = name;
			} else if (hashSet.size() > a) {
				c = b;
				z = y;
				b = a;
				y = x;
				a = hashSet.size();
				x = name;
			} else if (hashSet.size() > b) {
				c = b;
				z = y;
				b = hashSet.size();
				y = name;
			} else if (hashSet.size() > c) {
				c = hashSet.size();
				z = name;
			}
		}
		if (a == -1) {
			printf("- - - ");
		} else if (b == -1) {
			print(x + " - -");
		} else if (c == -1) {
			print(x + " " + y + " - ");
		} else {
			print(x + " " + y + " " + z);
		}
		close();
	}

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] nextLine() throws IOException {
		String[] str = reader.readLine().split(" ");
		int[] res = new int[str.length];
		for (int i = 0; i < res.length; ++i) {
			res[i] = Integer.parseInt(str[i]);
		}
		return res;
	}

	static void print(Object arg) throws IOException {
		writer.write(String.valueOf(arg));
	}

	static int nextInt() throws NumberFormatException, IOException {
		return Integer.parseInt(reader.readLine());
	}

	static void printf(String str, Object... args) throws IOException {
		writer.write(String.format(str, args));
	}

	static void close() throws IOException {
		writer.flush();
		writer.close();
		reader.close();
	}
}
