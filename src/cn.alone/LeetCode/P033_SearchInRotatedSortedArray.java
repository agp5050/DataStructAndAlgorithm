package cn.alone.LeetCode;

/**
 * Created by zhangrenjie on 2017-12-14
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 给定一个旋转过的有序数组（ 0 1 2 4 5 6 7 -> 4 5 6 7 0 1 2 )，找出是否存在目标值，如果找到返回下标，否则返回 -1，数组没有重复值
 */
public class P033_SearchInRotatedSortedArray {

    /**
     * 二分变种，同样可以使用二分来查找
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0 || (target < nums[0] &&  target > nums[nums.length - 1])) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) { // 如果左边区间有序
                if (nums[left] <= target && target < nums[mid]) { // 左边区间有序同时在左边区间以内
                    right = mid - 1;
                } else { // 在右边区间
                    left = mid + 1;
                }
            } else { // 如果右边区间有序
                if (nums[mid] < target && target <= nums[right]) { // 右边区间有序同时在右边区间以内
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
