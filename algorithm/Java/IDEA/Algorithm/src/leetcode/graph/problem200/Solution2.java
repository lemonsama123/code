package leetcode.graph.problem200;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0 || sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == newColor) {
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        int max = Math.max(m, n);
        int oldColor = image[sr][sc];
        Queue<Integer> queue = new LinkedList<>();
        int[] help = {-1, 0, 1, 0, -1};
        queue.add(sr * max + sc);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                int poll = queue.poll();
                int x = poll / max;
                int y = poll % max;
                image[x][y] = newColor;
                for (int i = 0; i < 4; i++) {
                    int r = x + help[i];
                    int c = y + help[i + 1];
                    if (r >= 0 && c >= 0 && r < m && c < n && image[r][c] == oldColor) {
                        queue.add(r * max + c);
                    }
                }
            }
        }
        return image;
    }
}