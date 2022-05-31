#include <bits/stdc++.h>

using namespace std;

const int N = 10e6 + 10;
int n;
int a[N], b[N];
int temp[N];

void mergeSort(int q[], int l, int r) { //归并排序
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

void quickSort(int q[], int l, int r) { //快速排序
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

void randomArray(int n, int l, int r) {//生成随机数组
	srand(time(0));  
	for(int i = 0; i < n; i++){
        int x = rand() % (r - l + 1) + l;
        a[i] = b[i] = x;
	}
}

void printArray(int *a, int n, ofstream& outfile) { //打印数组
    cout << "[";    
	for(int i = 0; i < n; i++) {
        outfile << a[i] << " ";
		// printf("%d ",);
    }
	outfile << "]" << endl;
}

int main() {
    srand(time(0));
    int n = N;
    randomArray(n, 10, 100000);
    clock_t start, finish;
    ofstream outfile;
    outfile.open("res.out");

    for (int i = 1; i <= 2000; ++i) {
        // printf(, i);
        outfile << "第" << i << "次测试：" << endl;
        // printArray(a, n, outfile);
        start = clock();
        quickSort(a, 0, n);
        finish = clock();
        // printArray(a, n, outfile);
        outfile << "快速排序花费时间：" << finish - start  << endl;
        // printArray(b, n, outfile);
        start = clock();
        mergeSort(b, 0, n - 1);
        finish = clock();
        outfile << "归并排序花费时间：" << finish - start << endl << endl;
        // printArray(b, n, outfile);
    }
    outfile.close();
    system("pause");
    return 0;
}
