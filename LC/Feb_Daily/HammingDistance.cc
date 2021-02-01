#include <stdlib.h>
#include <iostream>

using namespace std;

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count = 0;
        while (n) {
            if (n & 1) count++;
            n >>= 1;
        }
        return count;
    }
};

int main() {
    Solution s;
    cout << s.hammingWeight(00000000000000000000000000001011) << endl;
}