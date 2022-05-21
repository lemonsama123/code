package leetcode.graph.problem1584;
//Prim
import java.util.Arrays;

public class Solution2 {

    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int N = points.length;
        int[][] adjMat = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                adjMat[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adjMat[j][i] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        return prim(adjMat);
    }

    public int prim(int[][] adjacencyMatrix) {
        if (adjacencyMatrix == null || adjacencyMatrix.length == 0 || adjacencyMatrix.length != adjacencyMatrix[0].length) {
            return 0;
        }
        int N = adjacencyMatrix.length;
        boolean[] visited = new boolean[N];
        int[] minCost = new int[N];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        visited[0] = true;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                continue;
            }
            minCost[i] = adjacencyMatrix[i][0];
        }
        int res = 0;
        for (int i = 1; i < N; i++) {
            int minIdx = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (visited[j]) {
                    continue;
                }
                if (minCost[j] < minVal) {
                    minIdx = j;
                    minVal = minCost[j];
                }
            }
            res += minVal;
            visited[minIdx] = true;
            minCost[minIdx] = -1;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && adjacencyMatrix[j][minIdx] < minCost[j]) {
                    minCost[j] = adjacencyMatrix[j][minIdx];
                }
            }
        }
        return res;
    }
}