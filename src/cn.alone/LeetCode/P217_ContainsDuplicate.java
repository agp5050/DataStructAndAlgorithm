package cn.alone.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RojerAlone on 2017-08-26.
 * https://leetcode.com/problems/contains-duplicate/
 * 给定一个数组，判断是否存在重复的数字
 */
public class P217_ContainsDuplicate {

    /**
     * 可以通过 set，如果遍历过程中发现 set 中存在指定的值，则有重复值
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

}
