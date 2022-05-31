#include <bits/stdc++.h>

using namespace std;

/*
f[i][j] 表示只看前 i 个物品，总体积是 j 的情况下，总价值是多少

res = max{f[n][0~V]}

f[i][j] = max{f[i - 1][j], f[i - 1][j - v[i]]}

1. 不选第 i 个物品，f[i][j] = f[i - 1][j]
2. 选第 i 个物品，f[i][j] = f[i - 1][j - v[i]]

f[0][0] = 0;

O(NV)
*/ 

const int N = 1010;

int main() {
    

    return 0;
}