package leetcode.dfs.problem130;

public class Solution {

	char[][] board;
	int m;
	int n;
	int[] directions = { -1, 0, 1, 0, -1 };

	public void solve(char[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		this.board = board;
		this.m = board.length;
		this.n = board[0].length;
		for (int i = 0; i < n; i++) {
			if (board[0][i] == 'O') {
				dfs(0, i);
			}
			if (board[m - 1][i] == 'O') {
				dfs(m - 1, i);
			}
		}
		for (int i = 0; i < m; i++) {
			if (board[i][0] == 'O') {
				dfs(i, 0);
			}
			if (board[i][n - 1] == 'O') {
				dfs(i, n - 1);
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

	public void dfs(int r, int c) {
		board[r][c] = 'A';
		for (int i = 0; i < 4; i++) {
			int x = r + directions[i];
			int y = c + directions[i + 1];
			if (x >= 0 && y >= 0 && x < m & y < n && board[x][y] == 'O') {
				dfs(x, y);
			}
		}
	}
}