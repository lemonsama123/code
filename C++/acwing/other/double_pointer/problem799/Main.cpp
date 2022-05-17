#include <iostream>

using namespace std;

const int N = 10e6 + 10;

int n;
int q[N], s[N];

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) {
        scanf("%d", q + i);
    }
    int res = 0;
    for (int i = 0, j = 0; i < n; ++i) {
        ++s[q[i]];
        while (j < i && s[q[i]] > 1) {
            --s[q[j]];
            ++j;
        }
        res = max(res, i - j + 1);
    }
    printf("%d", res);
    return 0;
}