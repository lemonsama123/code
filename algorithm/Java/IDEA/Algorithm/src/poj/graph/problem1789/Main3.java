package poj.graph.problem1789;

import java.util.PriorityQueue;
import java.util.Scanner;

//内测爆了
public class Main3 {
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
            System.out.println(String.format("The highest possible quality is 1/%d.", prim(graph, 0)));
        }
        scanner.close();
    }

    public static int prim(int[][] graph, int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        for (int i = 0; i < n; i++) {
            if (i == start) {
                continue;
            }
            pq.add(new Edge(start, i, graph[start][i]));
        }
        int res = 0;
        int count = n -1;
        while (!pq.isEmpty() && count != 0) {
            Edge edge = pq.poll();
            if (!visited[edge.to]) {
                visited[edge.to] = true;
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        pq.add(new Edge(edge.to, i, graph[edge.to][i]));
                    }
                }
                res += edge.cost;
                --count;
            }
        }
        return res;
    }
}
