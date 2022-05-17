#include <bits/stdc++.h>

using namespace std;

const int N = 100010;

int m, stk[N], tt = 0;

int main() {
    scanf("%d", &m);
    while (m--) {
        string op;
        cin >> op;
        if (op == "push") {
            int x;
            scanf("%d", &x);
            stk[++tt] = x;
        } else if(op == "pop") tt--;
        else if(op == "empty") cout << (tt ? "NO" : "YES") << endl;
        else if(op == "query") cout << stk[tt] << endl;
    }
    return 0;
}