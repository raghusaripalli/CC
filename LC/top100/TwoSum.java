package LC.top100;

import helper.Helper;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    // Time - O (N)
    // Space - O (N)
    public int[] onePassHashTable(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int N = nums.length;
        int[] res = new int[2];
        for (int i = 0; i < N; i++) {
            int remainingSum = target - nums[i];
            if (indexMap.containsKey(remainingSum)) {
                res[0] = i;
                res[1] = indexMap.get(remainingSum);
                break;
            }
            indexMap.put(nums[i], i);
        }
        return res;
    }

    /* Test Cases
[2,7,11,15]
9
[3,2,4]
6
[3,3]
6
[0,4,3,0]
0
     */
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        Helper.prettyPrint(twoSum.onePassHashTable(Helper.parseStringToIntegerArray("[2,7,11,15]"), 9));
        Helper.prettyPrint(twoSum.onePassHashTable(Helper.parseStringToIntegerArray("[3,3]"), 6));
        Helper.prettyPrint(twoSum.onePassHashTable(Helper.parseStringToIntegerArray("[0,4,3,0]"), 0));
        Helper.prettyPrint(twoSum.onePassHashTable(Helper.parseStringToIntegerArray("[3,2,4]"), 6));
    }
}