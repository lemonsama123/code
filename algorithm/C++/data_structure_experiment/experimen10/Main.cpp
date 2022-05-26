#include <iostream>

using namespace std;

const int N = 10e6 + 10;
int n;
int q[N];
int temp[N];

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
        if (q[i] < q[j]) {
            temp[k++] = q[i++];
        } else {
            temp[k++] = q[j++];
        }
    }

    while (i <= mid) {
        temp[k++] = q[i++];
    }

    while (j <= r) {
        temp[k++] = q[j++];
    }
	
    for (i = l, j = 0; i <= r; i++, j++) {
        q[i] = temp[j];
    }
}

void quickSort(int q[], int l, int r) {
    if (l >= r) {
        return;
    }
    int i = l - 1;
    int j = r + 1;
    int x = q[(l + r) / 2];
    while (i < j) {
        while (q[++i] < x);
        while (q[--j] > x);
        if (i < j) {
            swap(q[i], q[j]);
        }
    }
    quickSort(q, l, j);
    quickSort(q, j + 1, r);
}

int main() {
    
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        scanf("%d", &q[i]);
    }
    quickSort(q, 0, n - 1);
    for (int i = 0; i < n; ++i) {
        printf("%d ", q[i]);
    }
    return 0;
}