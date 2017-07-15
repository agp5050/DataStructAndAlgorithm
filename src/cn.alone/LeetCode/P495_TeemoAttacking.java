package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/15.
 * https://leetcode.com/problems/teemo-attacking/
 * 提莫攻击，提莫攻击其他英雄会使英雄中毒，中毒期间再次攻击英雄不会叠加中毒时间
 * 输入攻击的时间点以及每次攻击中毒时间，计算出一共的中毒时间
 */
public class P495_TeemoAttacking {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res=  0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i + 1 >= timeSeries.length) { // 如果是最后一次攻击，直接加上中毒时间
                res += duration;
            } else if (timeSeries[i + 1] - timeSeries[i] >= duration) { // 如果两次攻击时间间隔大于中毒时间
                res += duration;
            } else { // 如果中毒时间还没有结束，那么只加上两次攻击的时间差
                res += timeSeries[i + 1] - timeSeries[i];
            }
        }
        return res;
    }

}
