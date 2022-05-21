#include <iostream>
typedef long long ll;
int a, b, p;

int main() {
    scanf("%d%d%d", &a, &b, &p);
    int res = 1 % p;
    while (b) {
        if (b & 1) res = (ll)res * a % p;
        b >>= 1;
        a = (ll)a * a % p;
    }
    printf("%d", res);
    return 0;
}