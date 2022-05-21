package poj.dfs.problem2386;

import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static char[][] grid;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'W') {
                    dfs(i, j);
                    ++count;
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        grid[x][y] = '.';
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = x + i;
                int c = y + j;
                if (r >= 0 && c >= 0 && r < N && c < M && grid[r][c] == 'W') {
                    dfs(r, c);
                }
            }
        }
    }
}
