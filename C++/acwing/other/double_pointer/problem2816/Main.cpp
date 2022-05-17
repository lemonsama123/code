#include <iostream>

using namespace std;

const int N = 10e5 + 10;

int n, m;
int a[N], b[N];
#define in(x) scanf("%d", &x);

int main() {
    in(n);
    in(m);
    for (int i = 0; i < n; ++i) in(a[i]);
    for (int i = 0; i < m; ++i) in(b[i]);
    int j = 0;
    for (int i = 0; i < m; ++i) {
        if (j < n && a[j] == b[i]) {
            ++j;
        }
    }
    if (j == n) {
        printf("Yes");
    } else {
        printf("No");
    }
    return 0;
}