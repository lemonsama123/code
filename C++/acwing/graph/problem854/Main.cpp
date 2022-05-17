#include <bits/stdc++.h>

using namespace std;

const int N = 201, INF = 0x3f3f3f3f;
int d[N][N];
int n, m, k;

void floyd() {
    for (int k = 1; k <= n; ++k) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
            }
        }
    }
}

int main() {
    scanf("%d%d%d", &n, &m ,&k);
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <=n; ++j) {
            if (i == j) {
                d[i][j] = 0;
            } else {
                d[i][j] = INF;
            }
        }
    }

    for (int i = 1; i <= m; ++i) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        d[a][b] = min(d[a][b], c);
    }

    floyd();

    for (int i = 0; i < k; ++i) {
        int x, y;
        scanf("%d%d", &x, &y);
        if (d[x][y] > INF / 2) {
            cout << "impossible" << endl;
        } else {
            cout << d[x][y] << endl;
        }
    }
}