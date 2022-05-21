#include <bits/stdc++.h>
#define read(x) scanf("%d", &x)
using namespace std;
const int N = 1e5 + 5;
int n, m, a, b, fa[N], cnt[N];
string act;

void init()
{
    for (int i = 1; i <= n; i++)
    {
        fa[i] = i;
        cnt[i] = 1;
    }
}

int find(int x)
{
    if (fa[x] == x)
        return x;
    else
        return fa[x] = find(fa[x]);
}

void merge(int a, int b)
{
    int x = find(a);
    int y = find(b);
    fa[x] = y;
    cnt[y] += cnt[x];
}

bool ask(int a, int b)
{
    return find(a) == find(b);
}

int main()
{
    read(n), read(m);
    init();
    while (m--)
    {
        cin >> act;
        if (act == "C")
        {
            read(a), read(b);
            if (!ask(a, b))
                merge(a, b);
        }
        else if (act == "Q1")
        {
            read(a), read(b);
            ask(a, b) ? printf("Yes\n") : printf("No\n");
        }
        else
        {
            read(a);
            printf("%d\n", cnt[find(a)]);
        }
    }
    return 0;
}
