package leetcode.bfs.problem130;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int m;
    int n;
    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                bfs(board, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                bfs(board, i, n - 1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static final int[] help = {-1, 0, 1, 0, -1};
    public void bfs(char[][] board, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        board[x][y] = 'A';
        queue.add(x * n + y);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int x1 = poll / n;
            int y1 = poll % n;
            for (int i = 0; i < 4; i++) {
                int r = x1 + help[i];
                int c = y1 + help[i + 1];
                if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 'O') {
                    queue.add(r * n + c);
                    board[r][c] = 'A';
                }
            }
        }
    }
}