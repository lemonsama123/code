#include <bits/stdc++.h>

using namespace std;

const int N = 100010;

//邻接表存储
//n个点m条边
int n, m;
//邻接表，静态链表表示
int h[N], e[N], ne[N], idx;
//入度
int d[N];
//队列
int q[N];

//添加数据
void add(int a, int b) {
    e[idx] = b, ne[idx] = h[a], h[a] = idx ++ ;
}

bool topsort() {
    int hh = 0, tt = -1;
    for (int i = 1; i <= n; i ++ ) {
        if (!d[i]) {
            q[ ++ tt] = i;
        }
    }
    while (hh <= tt) {
        int t = q[hh ++ ];
        for (int i = h[t]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (-- d[j] == 0)
                q[ ++ tt] = j;
        }      
    }
    return tt == n - 1;
}

int main() {
    scanf("%d%d", &n, &m);
    memset(h, -1, sizeof h);
    for (int i = 0;     i < m; i ++ ) {
        int a, b;
        scanf("%d%d", &a, &b);
        add(a, b);
        d[b] ++ ;
    }
    if (!topsort()) {
        puts("-1");
    } else {
        for (int i = 0; i < n; i ++ ) printf("%d ", q[i]);
        puts("");
    }
    system("pause");
    return 0;
}



