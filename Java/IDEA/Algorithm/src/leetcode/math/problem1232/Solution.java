package leetcode.math.problem1232;

public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0];
        int deltaY = coordinates[0][1];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1];
        int B = -coordinates[1][0];
        for (int i = 0; i < coordinates.length; i++) {
            if (A * coordinates[i][0] + B * coordinates[i][1] != 0) {
                return false;
            }
        }
        return true;
    }
}