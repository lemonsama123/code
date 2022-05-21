package leetcode.dfs.problem79;

public class Solution {

    char[][] board;
    String word;
    int m;
    int n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        this.board = board;
        this.word = word;
        this.m = board.length;
        this.n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[] directions = {-1, 0, 1, 0, -1};

    public boolean backtracking(int x, int y, int curIndex) {
        if (board[x][y] != word.charAt(curIndex)) {
            return false;
        }
        if (curIndex == word.length() - 1) {
            return true;
        }
        boolean find = false;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int r = x + directions[i];
            int c = y + directions[i + 1];
            if (r >= 0 && c >=0 && r < m && c < n && !visited[r][c] && backtracking(r, c, curIndex + 1)) {
                find = true;
                break;
            }
        }
        visited[x][y] = false;
        return find;
    }
}
