#include <iostream>

using namespace std;

const int N = 10e5 + 10;
int n, m;
int p[N];
int size[N];

int find(int x) {
    if (p[x] != x) p[x] = find(p[x]);
    return p[x];
}

void merger(int x, int y) {
     size[find(x)] += size[find(y)];
    p[find(x)] = find(y);
}

int main() {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <=n ; ++i) {
        p[i] = i;
        size[i] = 1;
    }
    while (m--) {
        char op[5];
        int a, b;
        scanf("%s%d%d", op, &a, &b);
        if (op[0] == 'C') merger(a, b);
        else if (op[1] == '1') {
            if (find(a) == find(b)) puts("Yes");
            else puts("No");
        } else {

        }
    }
    return 0;
}