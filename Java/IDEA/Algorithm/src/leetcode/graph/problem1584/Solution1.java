package leetcode.graph.problem1584;
//Prim
import java.util.Arrays;

public class Solution1 {

    public int minCostConnectPoints(int[][] points) {
        return prim(points);
    }

    public int prim(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int N = points.length;
        int[][] adjacencyMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                adjacencyMatrix[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adjacencyMatrix[j][i] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        boolean[] visited = new boolean[N];
        int[] minCost = new int[N];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        visited[0] = true;
        for (int i = 1; i < N; i++) {//初始化一下其他顶点与第一个顶点的距离
            minCost[i] = adjacencyMatrix[i][0];
        }
        int res = 0;
        for (int i = 1; i < N; i++) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    continue;
                }
                if (minCost[j] < minValue) {
                    minIndex = j;
                    minValue = minCost[j];
                }
            }
            if (minIndex == -1) {
                break;
            }
            res += minValue;
            visited[minIndex] = true;
            minCost[minIndex] = -1;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && adjacencyMatrix[j][minIndex] < minCost[j]) {
                    minCost[j] = adjacencyMatrix[j][minIndex];
                }
            }
        }
        return res;
    }
}