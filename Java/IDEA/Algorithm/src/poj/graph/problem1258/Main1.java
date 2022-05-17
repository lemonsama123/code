package poj.graph.problem1258;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws Exception {
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
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        visited[start] = true;
        for (int i = 0; i < n; i++) {
            if (i == start) {
                continue;
            }
            minCost[i] = graph[i][start];
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    continue;
                }
                if (minCost[j] < minValue) {
                    minIndex = j;
                    minValue = minCost[j];
                }
            }
            res += minValue;
            visited[minIndex] = true;
            minCost[minIndex] = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[j][minIndex] < minCost[j]) {
                    minCost[j] = graph[j][minIndex];
                }
            }
        }
        return res;
    }
}
