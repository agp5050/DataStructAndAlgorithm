package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RojerAlone on 2017/6/24.
 * https://leetcode.com/problems/4sum-ii/
 * 例子：
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 是 4Sum 的变种，解决方法是，参照 Two Sum 的思路，用一个 map 存储前两个数组中两两相加的和的组数，
 * 在例子中，A和B的任意数字之和有3种情况，而和为0的情况有两种，
 * 所以在map中，key为0时，value为2。通过O(n^2)的时间复杂度即可找出前两个数组的和的情况，
 * 然后再用O(n^2)的时间复杂度去匹配C和D数组的任意数字和是否在map中存在。
 */
public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        // 输入数据合法性判断
        if (A == null || B == null || C == null || D == null) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = A.length;
        // 通过 O(n^2) 的时间复杂度找出前两个数组中两两相加的和以及这样的数的组数
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = A[i] + B[j];
                // 如果包含有和为sum的数，那么更新
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        // 再从后两个数组中查找，相当于 Two Sum
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = C[i] + D[j];
                // 如果C、D某组数字之和的负数存在于map中，那么结果集中加入map集中的组数
                if (map.containsKey(-1 * sum)) {
                    res += map.get(-1 * sum);
                }
            }
        }
        return res;
    }

}
