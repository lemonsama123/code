package leetcode.dfs.problem1136;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    boolean[] visited;
    int[] depth;

    public int minimumSemesters(int N, int[][] relations) {
        List<List<Integer>> childList = new ArrayList<>();
        visited = new boolean[N+1];
        depth = new int[N+1];
        int maxDepth = 0;
        for (int i = 0; i < N + 1; i++){
            childList.add(new ArrayList<>());
        }

        for (int i = 0 ;i < relations.length; i++){
            childList.get(relations[i][0]).add(relations[i][1]);
        }
        for (int j = 1;j <= N;j++){
            if (depth[j] == 0){
                int temp = dfs(childList, j);
                if (temp == -1){
                    return -1;
                }
                maxDepth=Math.max(maxDepth, temp);
            }
        }
        return maxDepth;
    }

    public int dfs(List<List<Integer>> childList, int index){
        if (depth[index] != 0){
            return depth[index];
        }
        visited[index] = true;
        for (int i=0; i<childList.get(index).size(); i++){
            if (visited[childList.get(index).get(i)]){
                return -1;
            }
            int temp = dfs(childList, childList.get(index).get(i));
            if (temp == -1){
                return -1;
            }
            depth[index] = Math.max(depth[index], temp);
        }
        visited[index] = false;
        return ++depth[index];
    }
}
