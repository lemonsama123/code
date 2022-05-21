package poj.problem1182;

import java.io.*;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] readLine() throws Exception{
        String s = reader.readLine();
        String[] strs = s.split(" ");
        int[] res = new int[strs.length];
        for(int i = 0; i < strs.length; i ++ ){
            res[i] = Integer.parseInt(strs[i]);
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        int[] ints = readLine();
        int N = ints[0];
        int K = ints[1];
        init(3 * N);
        int[] T = new int[K];
        int[] X = new int[K];
        int[] Y = new int[K];
        for (int i = 0; i < K; i++) {
            int[] ints1 = readLine();
            T[i] = ints1[0];
            X[i] = ints1[1];
            Y[i] = ints1[2];
        }
        int ans = 0;
        for (int i = 0; i < K; i++) {
            int t = T[i];
            int x = X[i] - 1, y = Y[i] - 1;
            if (x < 0 || N <= x || y < 0 || N <= y) {
                ++ans;
                continue;
            }
            if (t == 1) {
                if (connected(x, y + N) || connected(x, y + 2 * N)) {
                    ++ans;
                } else {
                    union(x, y);
                    union(x + N, y + N);
                    union(x + N * 2, y + N * 2);
                }
            } else {
                if (connected(x, y) || connected(x, y + 2 * N)) {
                    ++ans;
                } else {
                    union(x, y + N);
                    union(x + N, y + 2 * N);
                    union(x + 2 * N, y);
                }
            }
        }
        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
        reader.close();
    }

    static int[] root;
    static int[] rank;

    public static void init(int n) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    public static int find(int x) {
        return root[x] == x ? x : (root[x] = find(root[x]));
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            ++rank[rootX];
        }
    }

    public static boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}