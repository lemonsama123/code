package leetcode.dfs.problem37;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    int[] line = new int[9];
    int[] column = new int[9];
    int[][] block = new int[3][3];
    boolean valid = false;
    List<Integer> spaces = new ArrayList<>();
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(i * 9 + j);
                } else {
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }

        backtracking(0);
    }

    public void backtracking(int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int space = spaces.get(pos);
        int i = space / 9;
        int j = space % 9;
        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            backtracking(pos + 1);
            flip(i, j, digit);
        }
    }

    public void flip(int i, int j, int digit) {
        line[i] ^= (1 << digit);
        column[j] ^= (1 << digit);
        block[i / 3][j / 3] ^= (1 << digit);
    }
}
