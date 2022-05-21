#include <iostream>
#include <vector>

using namespace std;

int n, m;
vector<int> chosen;

void calc(int x) {
    if (chosen.size() == m) {
        for (int i = 0; i < chosen.size(); ++i) printf("%d ", chosen[i]);
        puts("");
        return;
    }
    for (int i = x; i <= n; ++i) {
        chosen.push_back(i);
        calc(i + 1);
        chosen.pop_back();
    }
}

int main() {
    scanf("%d%d", &n, &m);
    calc(1);
    return 0;
}