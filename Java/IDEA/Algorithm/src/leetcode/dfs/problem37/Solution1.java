package leetcode.dfs.problem37;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][][] block = new boolean[3][3][9];
    boolean finish = false;
    List<Integer> spaces = new ArrayList<>();
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(i * 9 + j);
                } else {
                    int num = board[i][j] - '0' - 1;
                    row[i][num] = true;
                    col[j][num] = true;
                    block[i / 3][j / 3][num] = true;
                }
            }
        }
        backtracking(0);
    }

    public void backtracking(int index) {
        if (index == spaces.size()) {
            finish = true;
            return;
        }
        int coordinate = spaces.get(index);
        int x = coordinate / 9;
        int y = coordinate % 9;
        for (int i = 0; i < 9 && !finish; i++) {
            if (row[x][i] || col[y][i] || block[x / 3][y / 3][i]) {
                continue;
            }
            row[x][i] = true;
            col[y][i] = true;
            block[x / 3][y / 3][i] = true;
            board[x][y] = (char) (i + '0' + 1);
            backtracking(index + 1);
            row[x][i] = false;
            col[y][i] = false;
            block[x / 3][y / 3][i] = false;
        }
    }
}