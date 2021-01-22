#include<stdio.h>

template<class T>
int count(T *a, T value, int N) {
    int res = 0;
    for (int i = 0; i < N; i++)
    {
        if (value == a[i])
        {
            res++;
        }
        
    }
    return res;
}

int main() {
    int arr[] = {1,2,3,4,5,6,7,7,8,9,0,2,3,5,7,8};
    float arr2[] = {1.0, 3.3, 6.5, 1.0};

    printf("C1: %d, C2: %d", count(arr, 7, 16), count(arr2, 1.0f, 4));
    return 0;
}