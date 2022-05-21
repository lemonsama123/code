#include <iostream>

using namespace std;

const int N = 10e5 + 10;

int n, k;
int q[N];

int quickSort(int l, int r, int k) {
    if (l == r) {
        return q[l];
    }
    int x = q[(l + r) >> 1];
    int i = l - 1;
    int j = r + 1;
    while (i < j) {
        while (q[++i] < x);
        while (q[--j] > x);
        if (i < j) {
            swap(q[i], q[j]);
        }
    }
    int sl = j - l + 1;
    if (k <= sl) {
        return quickSort(l, j, k);
    }
    return quickSort(j + 1, r, k - sl);
}

int main() {
    scanf("%d%d", &n, &k);
    for (int i = 0; i < n; ++i) {
        scanf("%d", q + i);
    }
    printf("%d", quickSort(0, n - 1, k));
    return 0;
}