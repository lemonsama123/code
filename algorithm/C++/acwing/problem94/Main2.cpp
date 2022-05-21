#include <iostream>
#include <vector>

using namespace std;

int n;
int chosen[20];
bool visied[20];

void calc(int x) {
    if (x == n + 1) {
        for (int i = 1; i <= n; ++i) printf("%d ", chosen[i]);
        puts("");
        return;
    }
    for (int i = 1; i <= n; ++i) {
        if (visied[i]) continue;
        chosen[x] = i;
        visied[i] = true;
        calc(x + 1);
        visied[i] = false;
    }
}

int main() {
    scanf("%d", &n);
    calc(1);
    return 0;
}