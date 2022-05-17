package poj.graph.problem1258;

import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * 使用类+优先级队列的prim
 * 相较于朴素prim，实现较为简单
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = scanner.nextInt();
                }
            }
            System.out.println(prim(graph, 0));
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
        int count = n - 1;
        int res = 0;
        while (!pq.isEmpty() && count != 0) {
            Edge edge = pq.poll();
            if (!visited[edge.to]) {
                visited[edge.to] = true;
                res += edge.cost;
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        int distance = graph[edge.to][i];
                        pq.add(new Edge(edge.to, i, distance));
                    }
                }
                --count;
            }
        }
        return res;
    }
}
