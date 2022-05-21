//package data_structure_experiment.experiment2;
//
//public class Main {
//
//    static Node p;
//    static Node q;
//
//    public static void main(String[] args) {
//        init();
//        printList(p);
//        printList(q);
//        Node p1 = new Node(-1, -1, p);
//        Node q1 = new Node(-1, -1, q);
//        Node h1 = p;
//        Node h2 = q;
//        while (p != null && q != null) {
//            if (p.exp < q.exp) {
//                p = p.next;
//                p1 = p1.next;
//            } else if (p.exp > q.exp) {
//                p1.next = q;
//                q1.next = q.next;
//                q.next = p;
//                q = q1.next;
//            } else if (p.exp == q.exp) {
//                p.coef += q.coef;
//                if (p.coef == 0) {
//                    p1 = p;
//                    p = p.next.next;
//                    p1.next = p;
//                } else {
//                    p1 = p1.next;
//                    p = p.next;
//                }
//                q1 = q;
//                q = q.next.next;
//                q1.next = q;
//            }
//        }
//        while (p != null) {
//            p1 = p1.next;
//            p = p.next;
//        }
//        if (q != null) {
//            p1.next = q;
//        }
//        printList(h1);
//    }
//
//    static void init() {
//        p = new Node(3, 0, null);
//        Node temp = p;
//        temp.next = new Node(4, 3, null);
//        temp = temp.next;
//        temp.next = new Node(3, 4, null);
//        q = new Node(3, 2, null);
//        temp = q;
//        temp.next = new Node(4, 3, null);
//        temp = temp.next;
//        temp.next = new Node(5, 5, null);
//    }
//
//    static void printList(Node head) {
//        if (head == null) {
//            return;
//        }
//        System.out.print(head.coef + "x^" + head.exp);
//        head = head.next;
//        while (head != null) {
//            System.out.print("+");
//            System.out.print(head.coef + "x^" + head.exp);
//            head = head.next;
//        }
//        System.out.println();
//    }
//}
//
//class Node {
//
//    int coef;
//    int exp;
//    Node next;
//
//    public Node(int coef, int exp, Node next) {
//        this.coef = coef;
//        this.exp = exp;
//        this.next = next;
//    }
//}
