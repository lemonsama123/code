#include <iostream>

using namespace std;

const int N = 100000 + 10;

int e[N], ne[N], idx, head, n;

void init() {
    head = -1;
    idx = 0;
}

void add_to_head(int x) {
    e[idx] = x, ne[idx] = head, head = idx++;
}

void add(int k, int x) {
    e[idx] = x, ne[idx] = ne[k], ne[k] = idx++;
}

void remove(int k) {
    ne[k] = ne[ne[k]];
}

int main() {
    scanf("%d", &n);
    init();
    while (n--) {
        char op[2];
        scanf("%s", op);
        if (*op == 'H') {
            int x;
            scanf("%d", &x);
            add_to_head(x);
        } else if (*op == 'I') {
            int k, x;
            scanf("%d%d", &k, &x);
            add(k - 1, x);
        } else if (*op == 'D') {
            int k;
            scanf("%d", &k);
            if (!k) head = ne[head];
            else remove(k - 1);
        }
    }
    for (int i = head; i != -1; i = ne[i]) printf("%d ", e[i]);
    puts("");
    return 0;
}