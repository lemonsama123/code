package poj.graph.problem2485;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {

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
                System.out.println(prim(graph, 0));
            }
        }
        scanner.close();
    }

    public static int prim(int[][] graph, int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for (int i = 0; i < n; i++) {
            if (i != start) {
                pq.add(new Edge(start, i, graph[start][i]));
            }
        }
        visited[start] = true;
        int res = Integer.MIN_VALUE;
        int count = n - 1;
        while (!pq.isEmpty() && count != 0) {
            Edge edge = pq.poll();
            if (!visited[edge.to]) {
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        pq.add(new Edge(edge.to, i, graph[edge.to][i]));
                    }
                }
                visited[edge.to] = true;
                res = Math.max(res, edge.cost);
                --count;
            }
        }
        return res;
    }
}
