#include <bits/stdc++.h>
#define in(x) scanf("%d", &x)
using namespace std;
const int N = 20;
int n;
int d[N][N];
int f[1 << 20][20];

int hamilton() {
    memset(f, 0x3f, sizeof(f));
    f[1][0] = 0;
    for (int i = 1; i < 1 << n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (i >> j & 1) {
                for (int k = 0; k < n; ++k) {
                    f[i][j] = min(f[i][j], f[i^(1<<j)][k] + d[k][j]);
                }
            }
        }
    }
    return f[(1 << n) - 1][n - 1];
}

int main() {
    in(n);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            in(d[i][j]);
        }
    }
    printf("%d", hamilton());
    return 0;
}