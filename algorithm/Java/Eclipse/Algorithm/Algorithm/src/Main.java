import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int[][] v = new int[500][500];
		int n = nextInt();
		int[] nums = null;
		for (int i = 0; i < n - 1; ++i) {
			nums = nextLine();
			v[nums[0]][nums[1]] = -1;
			v[nums[1]][nums[0]] = -1;
		}
		int k = nextInt();
		String[] strs = null;
		for (int i = 0; i < n + k - 1; ++i) {
			strs = reader.readLine().trim().split(" ");
			if ("W".equals(strs[0])) {
				writer.write(bfs(Integer.parseInt(strs[1]), 1, v, n) + "\n");
			} else {
				int x = Integer.parseInt(strs[1]);
				int y = Integer.parseInt(strs[2]);
				v[x][y] = 1;
				v[y][x] = 1;
			}
		}
		close();
	}
	
	static int bfs(int x, int y, int[][] v, int n) {
		int count = 0;
		while (x != y) {
			for (int i = x - 1; i >= 1; --i) {
				if (v[x][i] == -1) {
					++count;
				}
				x = i;
				break;
			}
		}
		return count;
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
