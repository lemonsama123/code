package data_structure_experiment.experiment1;

public class Main {
    public static void main(String[] args) {
        for (int n = 1; n <= 10; ++n) {
            for (int m = 1; m <= 10; ++m) {
                System.out.println("n = " + n + ", m = " + m);
                josephRing1(n, m);
                System.out.println();
            }
        }
    }

    static void josephRing1(int n, int m) {
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        int count = 0;
        int cur = 1;
        int flag = n;
        while (flag != 0) {
            if (cur == n + 1) {
                cur = 1;
            }
            if (arr[cur] != 0) {
                ++count;
            }
            if (count == m) {
                count = 0;
                System.out.print(arr[cur] + " ");
                arr[cur] = 0;
                --flag;
            }
            ++cur;
        }
    }
}