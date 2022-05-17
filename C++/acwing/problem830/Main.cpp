#include <iostream>
#define in(x) scanf("%d", x)

using namespace std;

const int N = 100010;

int n, stk[N], tt;

int main() {
    in(&n);
    while (n--) {
        int x;
        in(&x);
        while (tt && stk[tt] >= x) tt--;
        if (tt) printf("%d ", stk[tt]);
        else printf("-1 ");
        stk[++tt] = x;
    }
    return 0;
}