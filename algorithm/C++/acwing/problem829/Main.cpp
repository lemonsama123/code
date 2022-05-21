#include <bits/stdc++.h>

using namespace std;

const int N = 100010;

int m, q[N], hh, tt = -1;

int main() {
    cin >> m;
    while (m--) {
        string op;
        int x;
        cin >> op;
        if (op == "push") scanf("%d", &x), q[++tt] = x;
        else if (op == "pop") hh++;
        else if (op == "empty") cout << (hh <= tt ? "NO" : "YES") << endl;
        else if (op == "query") cout << q[hh] << endl;
    }
    return 0;
}