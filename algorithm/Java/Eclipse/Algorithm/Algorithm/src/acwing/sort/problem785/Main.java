package acwing.sort.problem785;
/**
 * 快速排序模板
 */

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] q = new int[n];
        String[] s = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            q[i] = Integer.parseInt(s[i]);
        }
        quickSort(q, 0, n - 1);
        for (int i = 0; i < n; i++) {
            writer.write(q[i] + " ");
        }
        writer.flush();
        reader.close();
        writer.close();
    }

    static void quickSort(int[] q, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l - 1;
        int j = r + 1;
        int x = q[(l + r) >> 1];
        while (i < j) {
        	while (q[++i] < x);
        	while (q[--j] > x);
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
// 		这种情况不能取到左边界，上面的不能取到右边界
//      quickSort(q, l, i - 1);
//      quickSort(q, i, r);
    }
}
