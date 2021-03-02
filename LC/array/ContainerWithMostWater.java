package LC.array;

import helper.Helper;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int area, maxArea = 0;
        while (left < right) {
            area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(Helper.parseStringToIntegerArray("[1,8,6,2,5,4,8,3,7]")));
        System.out.println(containerWithMostWater.maxArea(Helper.parseStringToIntegerArray("[1,1]")));
        System.out.println(containerWithMostWater.maxArea(Helper.parseStringToIntegerArray("[4,3,2,1,4]")));
        System.out.println(containerWithMostWater.maxArea(Helper.parseStringToIntegerArray("[1,2,1]")));
    }
}
