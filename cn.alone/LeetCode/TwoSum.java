package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RojerAlone on 2017/6/24.
 * https://leetcode.com/problems/two-sum/
 * 解题思路：
 * 简单直接的方法就是直接两个 for 循环进行遍历，但是时间复杂度为 O(n!)
 * 应该这样做（时间复杂度为 O(n) ）：
 * 遍历数组，遍历到一个数的时候从字典（Map）中查找有没有和当前下标的数相加等于目标值的数，如果有的话就直接返回
 * 没有的话，当前坐标在字典中不存在就加入，存在就继续遍历（key为下标对应元素的值，value为下标值）
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // 输入数据合法性判断
        if (nums == null || nums.length < 2) {
            return res;
        }
        // map当做一个字典用来查找有没有相加等于目标值的元素
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // 在map中找有没有和当前值加起来等于target的值，有的话就返回
            if (map.get(target - nums[i]) != null) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            if (map.get(nums[i]) == null) {
                // key为下标对应元素的值，value为下标值
                map.put(nums[i], i);
            }
        }
        return res;
    }

}
