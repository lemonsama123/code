#include <iostream>

using namespace std;

const int N = 10e5 + 10;
int q[N];
int temp[N];
int n;
long long count;

void mergeSort(int q[], int l, int r) {
    if (l >= r) {
        return;
    }
    int mid = (l + r) >> 1;
    mergeSort(q, l, mid);
    mergeSort(q, mid + 1, r);
    int k = 0;
    int i = l;
    int j = mid + 1;
    while (i <= mid && j <= r) {
        if (q[i] <= q[j]) {
            temp[k++] = q[i++];
        } else {
            count += (mid - i + 1);
            temp[k++] = q[j++];
        }
    }
    while (i <= mid) {
        temp[k++] = q[i++];
    }
    while (j <= r) {
        temp[k++] = q[j++];
    }
    for (i = l, j = 0; i <= r; ++i, ++j) {
        q[i] = temp[j];
    }
}

int main() {
    count = 0;
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        scanf("%d", q + i);
    }
    mergeSort(q, 0, n - 1);
    cout << count;
    return 0;
}