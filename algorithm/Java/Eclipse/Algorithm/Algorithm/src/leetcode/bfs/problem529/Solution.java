package leetcode.bfs.problem529;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int m;
    int n;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.m = board.length;
        this.n = board[0].length;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        bfs(board, click[0], click[1]);
        return board;
    }

    private static final int[] help = {1, -1, -1, 0, 1, 0, -1, 1, 1};

    public void bfs(char[][] board, int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[m * n];
        queue.add(x * n + y);
        visited[x * n + y] = true;
        board[x][y] = 'B';
        while (!queue.isEmpty()) {
            int count = 0;
            int poll = queue.poll();
            int tx = poll / n;
            int ty = poll % n;
            for (int i = 0; i < 8; i++) {
                int r = tx + help[i];
                int c = ty + help[i + 1];
                if (r >= 0 && c >= 0 && r < m && c < n && board[r][c] == 'M') {
                    ++count;
                }
            }
            if (count != 0) {
                board[tx][ty] = (char) (count + '0');
            } else {
                for (int i = 0; i < 8; i++) {
                    int r = tx + help[i];
                    int c = ty + help[i + 1];
                    if (r >= 0 && c >= 0 && r < m && c < n && board[r][c] == 'E' && !visited[r * n + c]) {
                        board[r][c] = 'B';
                        queue.add(r * n + c);
                        visited[r * n + c] = true;
                    }
                }
            }
        }
    }
}