/*
 * @Author: justjuice
 * @Date: 2022-05-31 19:43:44
 * @Last Modified time: 2022-05-31 19:43:44
 * @Difficult:
 */
#include <iostream>
#include <ctime>
#include <cstdlib>
#include <algorithm>
using namespace std;

clock_t start, end1;

int Partition(int r[], int first, int end)
{
    int i = first;
    int j = end; 
    while (i < j)
    {
        while (i < j && r[i] <= r[j])
            j--; //鍙充晶鎵弿
        if (i < j)
        {
            swap(r[i], r[j]); //灏嗚緝灏忚褰曚氦鎹㈠埌鍓嶉�?
            i++;
        }
        while (i < j && r[i] <= r[j])
            i++; //宸︿晶鎵弿
        if (i < j)
        {
            swap(r[j], r[i]); //灏嗚緝澶ц褰曚氦鎹㈠埌鍚庨潰
            j--;
        }
    }
    return i; // i涓鸿酱鍊艰褰曠殑鏈€缁堜綅�??
}

void QuickSort(int r[], int first, int end)
{
    if (first < end)
    {                                         //閫掑綊缁撴潫
        int pivot = Partition(r, first, end); //涓€娆″垝�??
        QuickSort(r, first, pivot - 1);       //閫掑綊鍦板宸︿晶瀛愬簭鍒楄繘琛屽揩閫熸帓�??
        QuickSort(r, pivot + 1, end);         //閫掑綊鍦板鍙充晶瀛愬簭鍒楄繘琛屽揩閫熸帓�??
    }
}

void ShellSort(int r[], int n)
{
    int d, i, j;
    for (d = n / 2; d >= 1; d = d / 2) //浠ュ閲忎负d杩涜鐩存帴鎻掑叆鎺掑簭
    {
        for (i = d + 1; i <= n; i++)
        {
            r[0] = r[i]; //鏆傚瓨琚彃鍏ヨ褰?
            for (j = i - d; j > 0 && r[0] < r[j]; j = j - d)
                r[j + d] = r[j]; //璁板綍鍚庣Щd涓綅缃?
            r[j + d] = r[0];
        }
    }
}

void Random(int a[], int n, int l, int r) //鐢熸垚鑼冨洿鍦╨~r鐨勯殢鏈烘暟
{
    srand(time(0)); //璁剧疆鏃堕棿绉嶅�?
    for (int i = 0; i < n; i++)
    {
        a[i] = rand() % (r - l + 1) + l; //鐢熸垚鍖洪棿r~l鐨勯殢鏈烘暟
    }
}

void Print(int *a,int n)
{
	for(int i=0;i<n;i++)
		cout<<a[i]<<" ";
	cout<<endl;
}

int num[1000000];

int main()
{
    double sum = 0;
    for (int i = 0; i < 100; ++i)
    {
        Random(num, 1000000, 0, 32727);

        start = clock();
        QuickSort(num, 0, 1000000-1);
        end1 = clock();
        sum += (double)(end1 - start) / CLOCKS_PER_SEC;
    }
    cout << "QuickSort: " << sum / 100. << "ms" << endl;

    sum = 0;
    for (int i = 0; i < 100; ++i)
    {
        Random(num, 1000000, 0, 32727);

        start = clock();
        ShellSort(num, 1000000-1);
        end1 = clock();
        sum += (double)(end1 - start) / CLOCKS_PER_SEC;
    }
    cout << "ShellSort: " << sum / 100. << "ms";
    system("pause");
    return 0;
}