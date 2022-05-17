#include <bits/stdc++.h>

using namespace std;

int main() {
    int n, m;
    scanf("%d%d", &n, &m);
    int* arr = new int[n];
    for (int i = 0; i < n; ++i) {
        arr[i] = i + 1;
    }
    bool visited[n];
    int pre = 0;
    while (true) {
        int next = (pre + m) % n;
        if (pre == next) {
            break;
        }
        if (visited[next]) {
            continue;
        }
        visited[next] = true;
        cout << arr[next] << " ";
        pre = next;
    }
    return 0;
}