package cn.alone.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RojerAlone on 2017-12-25
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 给定一个包含 n+1 个数字的数组，数组内的元素都是 1 到 n 之间的，找出重复的那个数字
 */
public class P287_FindTheDuplicateNumber {

    /**
     * 直接用 set 存下来出现过的数字
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /**
     * 双指针，一快一慢，慢的指针每次跳到当前元素作为下标的位置，快的指针跳两次，直到两个元素相同
     */
    public int betterFindDuplicate(int[] nums) {
        if (nums != null && nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (slow != fast) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
