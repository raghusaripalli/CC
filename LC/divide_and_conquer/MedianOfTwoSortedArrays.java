package LC.divide_and_conquer;

import helper.Helper;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        int N = N1 + N2;
        double res = 0.0;
        if (N == 1) {
            if (nums1.length == 0)
                return nums2[0] * 1.0;
            return nums1[0] * 1.0;
        }
        int i = 0, j = 0, k = 0, nHalf = N / 2;
        int[] arr = new int[nHalf + 1];
        while (i + j <= nHalf && i < N1 && j < N2) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                arr[k++] = nums2[j++];
            } else {
                arr[k++] = nums1[i++];
            }
        }
        while (i + j <= nHalf && i < N1) {
            arr[k++] = nums1[i++];
        }
        while (i + j <= nHalf && j < N2) {
            arr[k++] = nums2[j++];
        }
        if (N % 2 == 0) {
            res = arr[k - 1] + arr[k - 2];
            res /= 2;

        } else {
            res = arr[k - 1];
        }
        return res;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(
                Helper.parseStringToIntegerArray("[1,3]"),
                Helper.parseStringToIntegerArray("[2]")
        ));
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(
                Helper.parseStringToIntegerArray("[1,2]"),
                Helper.parseStringToIntegerArray("[3,4]")
        ));
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(
                Helper.parseStringToIntegerArray("[0,0]"),
                Helper.parseStringToIntegerArray("[0,0]")
        ));
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(
                Helper.parseStringToIntegerArray("[2]"),
                Helper.parseStringToIntegerArray("[1]")
        ));
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(
                Helper.parseStringToIntegerArray("[]"),
                Helper.parseStringToIntegerArray("[1]")
        ));
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(
                Helper.parseStringToIntegerArray("[2]"),
                Helper.parseStringToIntegerArray("[]")
        ));
    }
}
