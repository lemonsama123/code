package leetcode.graph.problem733;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0] == null || image[0].length == 0 || sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    int[] help = {-1, 0, 1, 0, -1};
    public void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (image[r][c] == newColor) {
            return;
        }
        image[r][c] = newColor;
        for (int i = 0; i < 4; i++) {
            int x = r + help[i];
            int y = c + help[i + 1];
            if (x >= 0 && y >= 0 && x < image.length && y < image[0].length && image[r][c] == oldColor) {
                dfs(image, x, y, oldColor, newColor);
            }
        }
    }
}