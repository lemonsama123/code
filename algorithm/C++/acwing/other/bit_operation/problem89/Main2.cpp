#include <iostream>
using namespace std;
typedef unsigned long long ull;
typedef long long ll;
typedef long double ld;
ll a, b, p;
int main() {
    scanf("%lld%lld%lld", &a, &b, &p);
    a %= p, b %= p;
    ull c = (ld) a * b / p;
    ull x = a * b, y = c * p;
    ll res = (ll) (x % p) - (ll) (y % p);
    if (res < 0) res += p;
    cout << res; 
    return 0;
}