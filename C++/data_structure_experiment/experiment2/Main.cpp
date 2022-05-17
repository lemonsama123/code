#include <bits/stdc++.h>

using namespace std;

void updata(vector<stack<int>> &tracks_buf, int &min_buf, int &min_tra) {
    for (int i = 0; i < tracks_buf.size(); i++) {
        if (!tracks_buf[i].empty() && min_buf > tracks_buf[i].top()) {
            min_buf = tracks_buf[i].top();
            min_tra = i;
        }
    }
}

bool trans(int n, int d, vector<stack<int>> &tracks_buf, int &min_buf, int &min_tra) {
    int min_gap = n + 1;   
    int prefer_track = -1; 
    for (int i = 0; i < tracks_buf.size(); i++) {
        if (!tracks_buf[i].empty() && tracks_buf[i].top() > d && (tracks_buf[i].top() - d) < min_gap) {
            min_gap = tracks_buf[i].top() - d;
            prefer_track = i;
        }
    }
    if (-1 != prefer_track) {
        tracks_buf[prefer_track].push(d);
        updata(tracks_buf, min_buf, min_tra);
        return true;
    } else {
        for (int i = 0; i < tracks_buf.size(); i++) {
            if (tracks_buf[i].empty()) {
                tracks_buf[i].push(d);
                updata(tracks_buf, min_buf, min_tra);
                return true;
            }
        }
        return false;
    }
}

bool fun(vector<int> &datas, deque<int> &results, int n, int k) {
    int min_buf = n + 1;              
    int min_tra = 0;                  
    vector<stack<int>> tracks_buf(k);

    int need = 1; 
    while (!datas.empty()) {
        int d = datas.back();
        datas.pop_back();
        if (d == need)  {
            results.push_front(need);
            need++;
            while (min_buf == need)  {
                results.push_front(need);
                need++;
                tracks_buf[min_tra].pop();
                min_buf = n + 2;
                min_tra = 0;
                updata(tracks_buf, min_buf, min_tra);
            }
        } else  {
            if (!trans(n, d, tracks_buf, min_buf, min_tra)) {
                return false;
            }
        }
    }
    return true;
}

int main() {
    printf("请输入待重排的车厢数：");
    int m;
    scanf("%d", &m);
    int arr[1000];
    printf("请输入入轨序列：");
    for (int i = 0; i < m; ++i) {
        scanf("%d", arr + i);
    }
    deque<int> results;
    vector<int> vec(arr, arr + m);
    int n = vec.size();
    int k = 3; 
// 5 8 1 7 4 2 9 6 3
    if (fun(vec, results, n, k)) {
        cout << k << "条缓冲铁轨可以将按照";
        copy(vec.begin(), vec.end(), ostream_iterator<int>(cout));
        cout << "此序列的" << n << "节车厢重新排好挂到火车头上。" << endl;
        cout << "排好后的序列是：" << endl;
        copy(results.begin(), results.end(), ostream_iterator<int>(cout));
        cout << endl;
    } else {
        cout << "重排失败！" << endl;
    }
    system("pause");
}