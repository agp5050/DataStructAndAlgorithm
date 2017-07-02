package cn.alone.LeetCode;

import java.util.HashSet;

/**
 * Created by RojerAlone on 2017/7/2.
 * https://leetcode.com/problems/distribute-candies/
 * 给定一组长度为偶数的整数，其中每个数字代表一个糖果的种类标号。
 * 将糖果均分给哥哥和妹妹，返回妹妹可以得到的最大糖果种类数。
 * 思路：
 * 总共有偶数个糖果，所以妹妹一定能分到一半的糖果
 * 如果种类多余糖果总数的一半，那么妹妹最多能分到糖果总数一半的种类糖果
 * 否则最多能分到所有的糖果种类
 */
public class P575_DistributeCandies {

    public int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

}
