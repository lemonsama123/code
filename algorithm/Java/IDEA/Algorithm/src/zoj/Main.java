package zoj;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        boolean isNeg = N < 0;
        boolean isEven = N % 2 == 0;
        double ans = 0;
        int total = 0;
        N = Math.abs(N);
        while (N != 0) {
            if (N % 10 == 2) {
                ans++;
            }
            N /= 10;
            total++;
        }
        ans /= total;
        if (isNeg) {
            ans *= 1.5;
        }
        if (isEven) {
            ans *= 2;
        }
        System.out.println(String.format("%.2f", ans * 100) + "%");
    }
}
