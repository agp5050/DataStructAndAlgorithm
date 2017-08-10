package cn.alone.LeetCode;

import java.util.*;

/**
 * Created by RojerAlone on 2017-08-10.
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 给定一个非空数组和数字 k，找出前 k 个出现次数最多的数字
 */
public class P347_TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k < 1) {
            return res;
        }
        Map<Integer, Integer> numTimes = new HashMap<>(); // key 为数字，value 为出现的次数
        Map<Integer, Set<Integer>> timeNums = new HashMap<>(); // key 为出现的次数，value 为对应的数字
        int max = 0;
        for (int num : nums) {
            int times = numTimes.getOrDefault(num, 0);
            numTimes.put(num, times + 1); // 出现次数 +1
            if (times != 0) { // 如果是已经出现过的，移除次数对应的数字
                timeNums.get(times).remove(num);
            }
            Set<Integer> set = timeNums.get(times + 1);
            if (set == null) {
                set = new HashSet<>();
                timeNums.put(times + 1, set);
            }
            set.add(num); // 对应次数中 +1
            max = Math.max(max, times + 1); // 记录最大次数，方便最后遍历的时候从高到低获取结果
        }
        for (int i = max; i > 0; i--) {
            for (int num : timeNums.get(i)) {
                res.add(num);
                if (res.size() == k) {
                    return res;
                }
            }
        }
        return res;
    }

}
