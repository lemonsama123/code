package poj.graph.problem1789;

import java.util.PriorityQueue;
import java.util.Scanner;

//内测爆了
public class Main2 {

    static int[] root;
    static int[] rank;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            char[][] c = new char[n][7];
            for (int i = 0; i < n; i++) {
                c[i] = new char[7];
                c[i] = scanner.next().toCharArray();
            }
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    int distance = 0;
                    for (int k = 0; k < 7; k++) {
                        distance += c[i][k] == c[j][k] ? 0 : 1;
                    }
                    graph[i][j] = distance;
                }
            }
            System.out.println(String.format("The highest possible quality is 1/%d.", kruskal(graph)));
        }
        scanner.close();
    }

    public static int kruskal(int[][] graph) {
        int n = graph.length;
        init(n);
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(new Edge(i, j, graph[i][j]));
            }
        }
        int ans = 0;
        int count = n - 1;
        while (!pq.isEmpty() && count != 0) {
            Edge edge = pq.poll();
            if (!connected(edge.from, edge.to)) {
                union(edge.from, edge.to);
                ans += edge.cost;
                --count;
            }
        }
        return ans;
    }

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
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                ++rank[rootX];
            }
        }
    }

    public static boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
