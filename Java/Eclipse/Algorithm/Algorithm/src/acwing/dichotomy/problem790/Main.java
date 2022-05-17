package acwing.dichotomy.problem790;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        double l = -10000;
        double r = 10000;
        while (r - l > 1e-7) {
            double mid = (l + r) / 2;
            if (mid * mid * mid > n) {
                r = mid;
            } else {
                l = mid;
            }
        }
        System.out.printf("%.6f", l);
        scanner.close();
    }
}
