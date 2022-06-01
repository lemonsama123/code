#include <bits/stdc++.h>

using namespace std;

const int N = 10e6 + 10;
int n;
int a[N], b[N];
int temp[N];

void mergeSort(int q[], int l, int r) { //�鲢����
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

void quickSort(int q[], int l, int r) { //��������
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

void randomArray(int n, int l, int r) {//�����������
	srand(time(0));  
	for(int i = 0; i < n; i++){
        int x = rand() % (r - l + 1) + l;
        a[i] = b[i] = x;
	}
}

void printArray(int *a, int n, ofstream& outfile) { //��ӡ����
    cout << "[";    
	for(int i = 0; i < n; i++) {
        outfile << a[i] << " ";
    }
	outfile << "]" << endl;
}

int main() {
    srand(time(0));
    clock_t start, finish;
    double t1 = 0;
    double t2 = 0;
    for (int i = 1; i <= 2000000000; ++i) {
        int n = rand() % (1000000000 - 1 + 1) + 1;
        randomArray(n, 0, 1000000000);
        start = clock();
        quickSort(a, 0, n - 1);
        finish = clock();
        t1 += (double)(finish - start) / CLOCKS_PER_SEC;
        start = clock();
        mergeSort(b, 0, n - 1);
        finish = clock();
        t2 += (double)(finish - start) / CLOCKS_PER_SEC;
    }
    cout << "��������ƽ��ʱ�䣺" << t1 / 2000000000. << "ms" << endl;
    cout << "�鲢����ƽ��ʱ�䣺" << t2 / 2000000000. << "ms" << endl;
    system("pause");
    return 0;
}