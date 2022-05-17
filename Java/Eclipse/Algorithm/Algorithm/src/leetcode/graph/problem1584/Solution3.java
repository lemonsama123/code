package leetcode.graph.problem1584;
//Kruskal
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3 {

    int[] root;
    int[] rank;

    public void init(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        root[x] = find(root[x]);
        return root[x];
    }

    public void union(int x, int y) {
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

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    //points 是以边集数组的形式输入
    public int kruskal(int[][] points) {
        int n = points.length;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];
                int cost = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                priorityQueue.offer(new Edge(i, j, cost));
            }
        }
        init(n);
        int count = n - 1;
        int ans = 0;
        while (!priorityQueue.isEmpty() && count != 0) {
            Edge curEdge = priorityQueue.poll();
            if (!connected(curEdge.from, curEdge.to)) {
                union(curEdge.from, curEdge.to);
                --count;
                ans += curEdge.cost;
            }
        }
        return ans;
    }

    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        return kruskal(points);
    }
}

class Edge {

    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}