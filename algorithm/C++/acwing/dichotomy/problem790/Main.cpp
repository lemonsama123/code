#include <iostream>

using namespace std;

int main() {
    float n;
    scanf("%f", &n);
    const double eps = 1e-7;   
    double l = -10000;
    double r = 10000;
    while (r - l > eps) {
        double mid = (l + r) / 2;
        if (mid * mid * mid > n) {
            r = mid;
        } else {
            l = mid;
        }
    }
    printf("%.6f", l);
    return 0;
}