package cn.alone.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by RojerAlone on 2017-08-10.
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 * 给 n 对大小为 2 的数组，在每对数中第一个数总小于第二个数
 * 如果 (a,b) 和 (c,d)，b < c，那么这两对数组可以组成一个链，求给定的数组对中链的最大长度
 * <p>
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 */
public class P646_MaximumLengthOfPairChain {

    /**
     * 先排序，然后再遍历
     */
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0 || pairs[0].length != 2) {
            return 0;
        }
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int i = -1;
        int res = 0;
        while (++i < pairs.length) {
            res++;
            int curEnd = pairs[i][1];
            while (i + 1 < pairs.length && pairs[i + 1][0] <= curEnd) {
                i++;
            }
        }
        return res;
    }

}
