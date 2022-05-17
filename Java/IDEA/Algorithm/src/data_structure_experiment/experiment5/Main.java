package data_structure_experiment.experiment5;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Triplet triplet = arrayToTeiple(new int[][] {
                {0, 0, 1, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0, 0},
                {3, 0, 0, 0, 8, 0, 0},
                {0, 0, 0, 5, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 7, 4}
        });
        Triplet B =  tripleTranspose(triplet);
        print(triplet);
        System.out.println();
        print(B);

    }

    static void print(Triplet triplet) {
        System.out.println("行：" + triplet.rows + "，列：" + triplet.cols + "，非零元：" + triplet.nums);
        for (int[] item : triplet.data) {
            System.out.println(item[0] + " " + item[1] + " " + item[2]);
        }
    }

    static Triplet arrayToTeiple(int[][] arr) {
        Triplet triplet = new Triplet();
        triplet.rows = arr.length;
        triplet.cols = arr[0].length;

        int count = 0;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    ++count;
                }
            }
        }
        triplet.nums = count;
        triplet.data = new int[count][3];
        count = 0;
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    triplet.data[count][0] = i;
                    triplet.data[count][1] = j;
                    triplet.data[count++][2] = arr[i][j];
                }
            }
        }
        return triplet;
    }

    static Triplet tripleTranspose(Triplet A) {
        int m = A.rows;
        int n = A.cols;
        int[] num = new int[n];
        int[] cpot = new int[n];

        Triplet B = new Triplet();
        B.rows = n;
        B.cols = m;
        B.nums = A.nums;

        B.data = new int[A.nums][3];

        for (int[] item : A.data) {
            ++num[item[1]];
        }
        for (int i = 1; i < n; ++i) {
            cpot[i] = cpot[i - 1] + num[i - 1];
        }
        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(cpot));
        for (int i = 0; i < A.data.length; ++i) {
            int r = A.data[i][0];
            int c = A.data[i][1];
            B.data[cpot[c]][0] = c;
            B.data[cpot[c]][1] = r;
            B.data[cpot[c]][2] = A.data[i][2];
            cpot[c]++;
        }
        return B;
    }
}

class Triplet {
    int rows;
    int cols;
    int nums;
    int[][] data;
}
