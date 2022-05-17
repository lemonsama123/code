#include <iostream>

using namespace std;

const int N = 100010;
int n, q;
int a[N];

int main() {
    scanf("%d%d", &n, &q);
    for (int i = 0; i < n; ++i) {
        scanf("%d", a + i);
    }
    while (q--) {
        int x;
        scanf("%d", &x);
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (a[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (a[l] != x) {
            printf("-1 -1\n");
        } else {
            printf("%d ", l);
            l = 0;
            r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (a[mid] <= x) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            printf("%d\n", l);
        }
    }
    
    return 0;
}