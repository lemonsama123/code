#include <iostream>
using namespace std;

// 快速排序算法模板
void quick_sort(int q[], int l, int r) {
    if (l >= r) return;
    
    int i = l - 1, j = r + 1, x = q[l];
    while (i < j) {
        do i ++ ; while (q[i] < x);
        do j -- ; while (q[j] > x);
        if (i < j) swap(q[i], q[j]);
        else break;
    }
    quick_sort(q, l, j), quick_sort(q, j + 1, r);
}