package data_structure_experiment.experiment2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {

    static LinkedList<Node> e1 = new LinkedList<>();
    static LinkedList<Node> e2 = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coef1 = scanner.nextLine();
        String exp1 = scanner.nextLine();
        String coef2 = scanner.nextLine();
        String exp2 = scanner.nextLine();
        scanner.close();
        init(coef1, exp1, coef2, exp2);
        print(e1);
        print(e2);
        sum();
        print(e1);
    }

    //对两个多项式求和
    static void sum() {
        Iterator<Node> iterator1 = e1.iterator();
        Iterator<Node> iterator2 = e2.iterator();
        for (int i = 0, j = 0; i < e1.size() && j < e2.size(); ++i) {
            if (e1.get(i).exp < e2.get(j).exp) {
               continue;
            } else if (e1.get(i).exp > e2.get(j).exp) {
                e1.add(i, e2.get(j));
                ++j;
            } else if (e1.get(i).exp == e2.get(j).exp) {
                e1.get(i).coef += e2.get(j).coef;
                if (e1.get(i).coef == 0) {
                    e1.remove(i);
                }
                ++j;
            }
        }
    }

    //打印多项式
    static void print(LinkedList<Node> e) {
        for (int i = 0; i < e.size(); i++) {
            Node node = e.get(i);
            if (i != e.size() - 1) {
                if (node.exp == 0) {
                    System.out.print(node.coef + "+");
                } else if (node.coef == 1) {
                    System.out.print("X^" + node.exp + "+");
                } else if (node.coef == -1) {
                    System.out.print("-X^" + node.exp + "+");
                } else if (node.coef < 0) {
                    System.out.print("\b" + node.coef + "X^" + node.exp + "+");
                } else {
                    System.out.print(node.coef + "X^" + node.exp + "+");
                }
            } else {
                if (node.exp == 0) {
                    System.out.println(node.coef);
                } else if (node.coef == 1) {
                    System.out.println("X^" + node.exp);
                } else if (node.coef < 0) {
                    System.out.println("\b" + node.coef + "X^" + node.exp);
                } else {
                    System.out.println(node.coef + "X^" + node.exp);
                }
            }
        }
    }

    static void init(String coef1, String exp1, String coef2, String exp2) {
        String[] strs1 = coef1.split(" ");
        String[] strs2 = exp1.split(" ");
        for (int i = 0; i < strs1.length; i++) {
            int coef = Integer.parseInt(strs1[i]);
            int exp = Integer.parseInt(strs2[i]);
            e1.add(new Node(coef, exp));
        }
        strs1 = coef2.split(" ");
        strs2 = exp2.split(" ");
        for (int i = 0; i < strs1.length; i++) {
            int coef = Integer.parseInt(strs1[i]);
            int exp = Integer.parseInt(strs2[i]);
            e2.add(new Node(coef, exp));
        }
    }
}

//描述多项式的每一项的类：
class Node {

    int coef;
    int exp;

    public Node(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }
}
