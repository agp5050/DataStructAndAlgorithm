package cn.alone.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by RojerAlone on 2017-08-02.
 * https://leetcode.com/problems/array-nesting/
 * 输入一个从 0 到 N-1 的大小为 N 的数组 A
 * S 数组中的每一个元素是 S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }. 这样的形式
 * 如果 S[K] 遇到了之前用过的数字就结束，找出 S 数组中一个元素最多的数字有多少个
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 */
public class P565_ArrayNesting {

    /**
     * 用 set 记录访问过的数字
     * 还有一种不需要额外空间的方法是 访问过的数字置为 -1 或者 取反
     */
    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            int tmp = nums[nums[i]];
            int num = 1;
            while(!set.contains(tmp)) {
                set.add(tmp);
                tmp = nums[tmp];
                num++;
            }
            if (num > res) {
                res = num;
            }
            if (res == nums.length) { // 如果已经包含了所有的元素，那么就是最大的
                return res;
            }
        }
        return res;
    }

}
