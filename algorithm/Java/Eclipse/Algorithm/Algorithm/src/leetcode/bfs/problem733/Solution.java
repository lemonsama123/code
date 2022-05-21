package leetcode.bfs.problem733;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int m;
    int n;
    int[] help = {-1, 0, 1, 0, -1};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        m = image.length;
        n = image[0].length;
        if (newColor == image[sr][sc]) {
            return image;
        }
        bfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void bfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sr * n + sc);
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int x = poll / n;
            int y = poll % n;
            for (int i = 0; i < 4; i++) {
                int r = x + help[i];
                int c = y + help[i + 1];
                if (r >= 0 && c >= 0 && r < m && c < n && image[r][c] == oldColor) {
                    image[r][c] = newColor;
                    queue.add(r * n + c);
                }
            }
        }
    }
}