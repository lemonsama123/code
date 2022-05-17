#include <iostream>
#include <vector>

//FIXME: 结果数倒的？
using namespace std;

int n, m;
vector<int> chosen;

void calc(int x) {
    if (chosen.size() > m || chosen.size() + (n - x + 1) < m) return;
    if (x == n + 1) {
        for (int i = 0; i < chosen.size(); ++i) printf("%d ", chosen[i]);
        puts("");
        return;
    }
    calc(x + 1);
    chosen.push_back(x);
    calc(x + 1);
    chosen.pop_back();
}


int main() {
    scanf("%d%d", &n, &m);
    calc(1);
    return 0;
}