#include <iostream>
#define in(x) scanf("%d", &x)

using namespace std;

const int N = 10e6 + 10;

int m, e[N], l[N], r[N], idx;

void insert(int k, int x) {
    e[idx] = x;
    l[idx] = k, r[idx] = r[k];
    l[r[k]] = idx, r[k] = idx++;
}

void remove(int k) {
    l[r[k]] = l[k];
    r[l[k]] = r[k];
}

int main() {
    in(m);
    r[0] = 1, l[1] = 0, idx = 2;
    while (m--) {
        string op;
        cin >> op;
        int k, x;
        if (op == "L") {
            in(x);
            insert(0, x);
        } else if (op == "R") {
            in(x);
            insert(l[1], x);
        } else if (op == "D") {
            in(k);
            remove(k + 1);
        } else if (op == "IL") {
            in(k), in(x);
            insert(l[k + 1], x);
        } else if (op == "IR") {
            in(k), in(x);
            insert(k + 1, x);
        }
    }
    for (int i = r[0]; i != 1; i = r[i]) printf("%d ", e[i]);
    puts("");
    return 0;
}