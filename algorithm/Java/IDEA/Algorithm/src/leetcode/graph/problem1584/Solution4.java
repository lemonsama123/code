package leetcode.graph.problem1584;
//Prim

public class Solution4 {

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
        return prim(adjMat, 0);
    }

    public int prim(int[][] graph, int startPoint) {
        int result = 0;

        int[] lowcost = new int[graph.length];
        int[] closest = new int[graph.length];
        int minDis = Integer.MAX_VALUE;

        for (int i = 0; i < lowcost.length; i++) {//lowcost和closest的初始值
            lowcost[i] = graph[startPoint][i];
            closest[i] = startPoint;
        }

        for (int i = 0; i < lowcost.length - 1; i++) {//除了startPoint之外的n-1个点
            minDis = Integer.MAX_VALUE;
            int index = startPoint;
            for (int j = 0; j < lowcost.length; j++) {
                if (lowcost[j] != 0 && lowcost[j] < minDis) {
                    minDis = lowcost[j];
                    index = j;
                }
            }
            result += minDis;
            lowcost[index] = 0;
            for (int j = 0; j < lowcost.length; j++) {//更新lowcost和closest
                if (graph[index][j] != 0 && graph[index][j] < lowcost[j]) {
                    lowcost[j] = graph[index][j];
                    closest[j] = index;
                }
            }
        }
        return result;
    }
}