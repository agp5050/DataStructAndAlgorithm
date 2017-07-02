package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RojerAlone on 2017/6/24.
 * https://leetcode.com/problems/4sum/
 * 这个问题是 TwoSum 、3Sum 的变种，和 3Sum 一样，先确定一个值，然后从剩下的数组中找一个 3Sum 的结果，
 * 再把当前值加入，逐次遍历即可
 */
public class P018_FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        // 先排序
        Arrays.sort(nums);
        // 剔除极端情况，即不存在满足条件的值
        if (nums[0] * 4 > target || nums[nums.length - 1] * 4 < target) {
            return res;
        }
        for (int i = 0; i < nums.length; ) {
            int[] tmp = new int[nums.length - 1 - i];
            System.arraycopy(nums, i + 1, tmp, 0, tmp.length);
            List<List<Integer>> current = threeSum(tmp, target - nums[i]);
            for (List<Integer> list : current) {
                list.add(0, nums[i]);
                res.add(list);
            }

            int num = nums[i];
            while (i < nums.length && nums[i] == num) {
                i++;
            }
        }
        return res;
    }

    private List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        int tmpTarget = 0;
        for (int i = 0; i < nums.length - 2; ) {
            // 目标值，转化为TwoSum问题
            tmpTarget = target - nums[i];
            // 从i后一个结点开始查找
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[left] + nums[right];
                // 找到了一对
                if (tmp == tmpTarget) {
                    ArrayList<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    res.add(tmpList);
                    // 跳过重复的
                    int num = nums[left];
                    while (num == nums[left] && left < right) {
                        left++;
                    }
                } else if (tmp < tmpTarget) {
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
            // 注意判断顺序，如果颠倒了会抛出异常，应该先判断是否越界
            while (i < nums.length && nums[i] == num) {
                i++;
            }
        }
        return res;
    }

}
