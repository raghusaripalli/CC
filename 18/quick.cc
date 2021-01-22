#include <iostream>
using namespace std;

template <class T>
void swap(T arr[], int a, int b)
{
    T temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

template <class T>
int partition(T arr[], int low, int high)
{

    int i = low - 1;
    int pivot = arr[high];

    for (int j = low; j < high; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            swap(arr, i, j);
        }
    }

    swap(arr, i + 1, high);
    return i + 1;
}

template <class T>
void sort(T arr[], int low, int high)
{
    if (low < high)
    {
        int pivot = partition(arr, low, high);
        sort(arr, low, pivot - 1);
        sort(arr, pivot + 1, high);
    }
}

template <class T>
void printArray(T arr[], int size)
{
    for (int i = 0; i < size; i++)
        cout << arr[i] << " ";
    cout << endl;
}

int main()
{
    int arr[] = {10, 7, 8, 9, 1, 5};
    int n = 6;
    sort(arr, 0, n-1);
    printArray(arr, n);
    return 0;
}
