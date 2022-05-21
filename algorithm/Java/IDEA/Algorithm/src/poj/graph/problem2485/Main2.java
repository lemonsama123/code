package poj.graph.problem2485;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {

    static int[] root;
    static int[] rank;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                int[][] graph = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        graph[j][k] = scanner.nextInt();
                    }
                }
                System.out.println(kruskal(graph));
            }
        }
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
        int count = n - 1;
        int res = Integer.MIN_VALUE;
        while (!pq.isEmpty() && count != 0) {
            Edge edge = pq.poll();
            if (!connected(edge.from, edge.to)) {
                union(edge.from, edge.to);
                res = Math.max(res, edge.cost);
                --count;
            }
        }
        return res;
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