package acwing.other.discretization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Main {

	static ArrayList<Integer> alls;

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		int[] nums = nextLine();
		int n = nums[0];
		int m = nums[1];
		int[] a = new int[300010];
		int[] s = new int[300010];
		alls = new ArrayList<>();
		ArrayList<int[]> add = new ArrayList<>();
		ArrayList<int[]> query = new ArrayList<int[]>();
		for (int i = 0; i < n; ++i) {
			nums = nextLine();
			int x = nums[0];
			int c = nums[1];
			add.add(new int[] { x, c });
			alls.add(x);
		}
		for (int i = 0; i < m; ++i) {
			nums = nextLine();
			int l = nums[0];
			int r = nums[1];
			query.add(new int[] { l, r });
			alls.add(l);
			alls.add(r);
		}
		Collections.sort(alls);
		alls = new ArrayList<>(new LinkedHashSet<>(alls));
		for (int[] item : add) {
			int x = find(item[0]);
			a[x] += item[1];
		}
		for (int i = 1; i <= alls.size(); ++i) {
			s[i] = s[i - 1] + a[i];
		}
		for (int[] item : query) {
			int l = find(item[0]);
			int r = find(item[1]);
			println(s[r] - s[l - 1]);
		}
		close();
	}

	static int find(int x) {
		int l = 0, r = alls.size() - 1;
		while (l < r) {
			int mid = (l + r) >> 1;
			if (alls.get(mid) >= x) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return r + 1;
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

	static void println(Object o) throws IOException {
		writer.write(String.valueOf(o.toString()));
		writer.newLine();
	}

	static void close() throws IOException {
		writer.flush();
		writer.close();
		reader.close();
	}
}
