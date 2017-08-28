package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-28.
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 给定排序过的数组，但是这个数组的两部分被交换过（[0 1 2 4 5 6 7] -> [4 5 6 7 0 1 2]），找出最小值
 */
public class P153_FindMinimumInRotatedSortedArray {

    /**
     * 如果第一个数大于最后一个数，那么不是排序过的，也就是最小值在这个区间内，然后二分查找
     * 当区间的第一个数小于最后一个数，那么第一个数就是最小值
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            int mid = (start + end) / 2;
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

}
