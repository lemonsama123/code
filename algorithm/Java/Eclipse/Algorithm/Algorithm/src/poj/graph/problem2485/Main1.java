package poj.graph.problem2485;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
       for (int i = 0; i < k; i++) {
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                int[][] graph = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        graph[j][l] = scanner.nextInt();
                    }
                }
                System.out.println(prim(graph, 0));
           }
        }
    }

    public static int prim(int[][] graph, int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (i != start) {
                minCost[i] = graph[i][start];
            }
        }
        visited[start] = true;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minCost[j] < minValue) {
                    minIndex = j;
                    minValue = minCost[j];
                }
            }
            ans = Math.max(ans, minValue);
            visited[minIndex] = true;
            minCost[minIndex] = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && minCost[j] > graph[j][minIndex]) {
                    minCost[j] = graph[j][minIndex];
                }
            }
        }
        return ans;
    }
}
