package data_structure_experiment.experiment4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        int k = nextInt();
        int[] nums = readLine();
        Queue<Integer>[] queues = new LinkedList[k];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>();
        }
        int newOut = 1;
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            if (nums[i] == newOut) {
                flag = true;
                System.out.print(nums[i] + " ");
                ++newOut;
            } else {
                for (int j = 0; j < k; j++) {
                    if (queues[j].isEmpty()) {
                        continue;
                    }
                    int c = queues[j].peek();
                    if (c == newOut) {
                        flag = true;
                        System.out.print(queues[j].poll() + " ");
                        ++newOut;
                    }
                }
            }
            if (!flag) {
                int first = nums[i];
                int maxValue = Integer.MIN_VALUE;
                int index = -1;
                for (int j = 0; j < k; j++) {
                    if (queues[j].isEmpty()) {
                        continue;
                    }
                    int t = ((LinkedList<Integer>) queues[j]).getLast();
                    if (t < first) {
                        if (t > maxValue) {
                            maxValue = t;
                            index = j;
                        }
                    }
                }
                if (index != -1) {
                    queues[index].offer(nums[i]);
                } else {
                    index = -1;
                    for (int j = 0; j < k; j++) {
                        if (queues[j].isEmpty()) {
                            index = j;
                            break;
                        }
                    }
                    if (index != -1) {
                        queues[index].add(nums[i]);
                    } else {
                        System.out.println("不行");
                        return;
                    }
                }
            }
        }
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] readLine() throws IOException {
        String[] strs =  new StringBuilder(reader.readLine()).reverse().toString().split(" ");
        int[] res = new int[strs.length];
        for (int i = 0; i < res.length; ++i) {
            res[i] = Integer.parseInt(strs[i]);
        }
        return res;
    }

    static int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }

    static void flush() throws IOException {
        writer.flush();
        writer.close();
        reader.close();
    }
}

