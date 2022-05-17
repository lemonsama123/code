package poj.graph.problem1789;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
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
        int[] minCost = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == start) {
                continue;
            }
            minCost[i] = graph[start][i];
        }
        visited[start] = true;
        int res = 0;
        for (int i = 1; i < n; i++) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minValue > minCost[j]) {
                    minIndex = j;
                    minValue = minCost[j];
                }
            }
            res += minValue;
            visited[minIndex] = true;
            minCost[minIndex] = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minCost[j] > graph[minIndex][j]) {
                    minCost[j] = graph[minIndex][j];
                }
            }
        }
        return res;
    }
}
