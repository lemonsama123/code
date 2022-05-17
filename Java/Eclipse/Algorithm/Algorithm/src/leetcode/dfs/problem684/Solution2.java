package leetcode.dfs.problem684;

public class Solution2 {

    int[] root;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int from = edge[0];
            int to = edge[1];
            if (isConnected(from - 1, to - 1)) {
                return edge;
            } else {
                union(from - 1, to - 1);
            }
        }
        return new int[]{};
    }


    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        root[x] = find(root[x]);
        return root[x];
    }


    public void union(int x, int y) {
        root[find(x)] = root[find(y)];
    }


    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

}