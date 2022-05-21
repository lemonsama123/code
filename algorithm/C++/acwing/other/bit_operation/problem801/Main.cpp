#include <iostream>

using namespace std;

const int N = 10e5;
int n;
#define in(x) scanf("%d", x);

int lowbit(int x) {
    return x & (~x + 1);
}

int main() {
    in(&n);
    for (int i = 0; i < n; ++i) {
        int x;
        in(&x);
        int res = 0;
        while (x) {
            ++res;
            x -= lowbit(x);
        }
        printf("%d ", res);
    }
    return 0;
}