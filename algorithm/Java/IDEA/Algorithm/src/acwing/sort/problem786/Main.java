package acwing.sort.problem786;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s1 = reader.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        int[] q = new int[n];
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(s[i]);
        }
        quickSort(q, 0, n - 1);
        System.out.println(q[k - 1]);
        writer.flush();
        writer.close();
        reader.close();
    }

    static void quickSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l - 1;
        int j = r + 1;
        int x = q[(l + r) >> 1];
        while (i < j) {
            do {
                ++i;
            } while (q[i] < x);
            do {
                --j;
            } while (q[j] > x);
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            } else {
                break;
            }
        }
        quickSort(q, l, j);
        quickSort(q, j + 1, r);
    }
}
