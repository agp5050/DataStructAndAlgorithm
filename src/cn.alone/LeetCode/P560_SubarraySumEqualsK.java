package cn.alone.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RojerAlone on 2017-08-14.
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 给定一个数组 nums 和整数 k，找出和等于 k 的连续子数组的个数
 */
public class P560_SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

}
