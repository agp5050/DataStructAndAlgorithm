package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RojerAlone on 2017/6/24.
 * https://leetcode.com/problems/3sum/
 * 遍历数组，每次先确定3个数字中的1个，那么剩下的两个就是TwoSum问题
 * 题目中要求返回数字而不是下标值，可以将输入数据进行排序后再用 Two Sum II 中的方法进行查找
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 输入合法性判断
        if (nums == null || nums.length < 3) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        int target = 0;
        int length = nums.length;
        // 从0开始遍历
        for (int i = 0; i < length - 2; ) {
            // 目标值，转化为TwoSum问题
            target = 0 - nums[i];
            // 从i后一个结点开始查找
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                // 找到了一对
                if (tmp == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    // 跳过重复的
                    int num = nums[left];
                    while (num == nums[left] && left < right) {
                        left++;
                    }
                } else if (tmp < target) {
                    int num = nums[left];
                    while (num == nums[left] && left < right) {
                        left++;
                    }
                } else {
                    int num = nums[right];
                    while (num == nums[right] && right > left) {
                        right--;
                    }
                }
            }
            // 跳过重复的
            int num = nums[i];
            while (i < length && nums[i] == num) {
                i++;
            }
        }
        return res;
    }

}
