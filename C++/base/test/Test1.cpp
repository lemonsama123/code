#include <iostream>

using namespace std;



int f(int n) {
    int x;
    if (n == 0) {
        return 1;
    } else {
        cin >> x;
        return x * x * f(n - 1);
    }
}

int main() {
    int n;
    cin >> n;
    cout << f(n) << endl;
    system("pause");
    return 0;
}