package cn.alone.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RojerAlone on 2017-08-13.
 * https://leetcode.com/problems/majority-element/
 * 数组中出现次数超过数组大小一半的数字
 */
public class P169_MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>(); // 用来记录数字以及出现的次数
        for (int num : nums) {
            int time = map.getOrDefault(num, 0) + 1;
            if (time * 2 > nums.length) {
                return num;
            }
            map.put(num, time);
        }
        return -1;
    }

}
