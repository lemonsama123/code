#include <iostream>
using namespace std;
typedef long long ll;
ll a, b, p;
int main() {
    cin >> a >> b >> p;
    ll ans = 0;
    while (b) {
        if (b & 1) ans = (ans + a) % p;
        a = a * 2 % p;
        b >>= 1;
    }
    printf("%lld", ans);
    return 0;
}