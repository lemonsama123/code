package leetcode.dfs.problem684;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution1 {

    HashMap<Integer, List<Integer>> adj;
    HashSet<Integer> visited;

    public int[] findRedundantConnection(int[][] edges) {
        adj = new HashMap<>();
        visited = new HashSet<>();
        for (int[] edge : edges) {
            //当前点在以添加，直接 dfs 看看能不能添加这条边
            if (adj.containsKey(edge[0])/* && adj.containsKey(edge[1])*/) {
                //dfs 之前重置 visited
                visited.clear();
                if (dfs(edge[0], edge[1])) {
                    return edge;
                }
            }
            //未提及或者需要添加
            addEdge(edge[0], edge[1]);
            addEdge(edge[1], edge[0]);
        }
        return null;
    }

    //添加边
    public void addEdge(int from, int to) {
        if (adj.containsKey(from)) {
            adj.get(from).add(to);
            return;
        }
        List<Integer> successors = new ArrayList<>();
        successors.add(to);
        adj.put(from, successors);
    }

    //dfs 判断可达性
    public boolean dfs(int from, int to) {
        if (from == to) {   //相等当然可达
            return true;
        }
        //已访问的打标记
        visited.add(from);
        for (int next : adj.get(from)) {
            if (!visited.contains(next)) { // 未打标记当然未访问
                if (dfs(next, to)) { //
                    return true;
                }
            }
        }
        return false;
    }
}