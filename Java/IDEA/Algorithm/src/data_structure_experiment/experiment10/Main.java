package data_structure_experiment.experiment10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[] {1, -1, 3, 4, 7, 23, 3, 6, 3, 4, -32, -4, -32};
        shellSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

    static void qucickSort(int q[], int l, int r) {
        if (l > r) {
            return;
        }
        int i = l - 1;
        int j = r - 1;
        int x = q[(l + r) >> 1];
        while (i < j) {
            while (q[i++] < x);
            while (q[++i] > x);
            if (i < j) {
                q[i] = q[i] ^ q[j];
                q[j] = q[i] ^ q[j];
                q[i] = q[i] ^ q[j];
            }
        }
        qucickSort(q, l, j);
        qucickSort(q, j + 1, r);
    }

    static void shellSort(int q[], int n) {
        for (int d = n >> 1; d >= 1; d = d >> 1) {
            for (int i = d + 1; i < n; ++i) {
                q[0] = q[i];
                int j;
                for (j = i - d; j >= 0 && q[0] < q[j]; j = j - d) {
                    q[j + d] = q[j];
                }
                q[j + d] = q[0];
            }
        }
    }
}
