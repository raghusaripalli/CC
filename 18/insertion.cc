#include <iostream>
using namespace std;

template <class T>
void sort(T *arr, int size) {
    for (int j = 1; j < size; j++) {
        int key = arr[j];
        int i = j - 1;
        while (i > -1 && arr[i] > key) {
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = key;
    }
}

int main() {
    int arr[] = {10, 7, 8, 9, 1, 5};
    int n = 6;
    sort(arr, n);
    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
    cout << endl;
}