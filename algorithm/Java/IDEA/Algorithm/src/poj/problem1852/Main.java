package poj.problem1852;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int len = scanner.nextInt();
            int n = scanner.nextInt();
            int minTime = 0;
            int maxTime = 0;
            for (int j = 0; j < n; j++) {
                int cur = scanner.nextInt();
                minTime = Math.max(minTime, Math.min(cur, len - cur));
                maxTime = Math.max(maxTime, Math.max(cur, len - cur));
            }
            System.out.println(minTime + " " + maxTime);
            scanner.nextLine();
        }
        scanner.close();
    }
}
