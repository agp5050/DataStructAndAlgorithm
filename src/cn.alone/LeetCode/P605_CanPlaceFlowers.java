package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-13.
 * https://leetcode.com/problems/can-place-flowers/
 * 在地上种花，花之间要有一个间隔，1 表示已经种了花，0 表示空白
 * 给定数组表示土地，n 表示想要种花的个数，判断是否能种下
 */
public class P605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length < n * 2 - 1) {
            return false;
        }
        int res = 0;
        for (int i = 0; i < flowerbed.length;) {
            if (flowerbed[i] == 1) { // 如果当前有花，调到下一个应该种花的地方
                i += 2;
            } else {
                if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) { // 如果当前没有花但是不能种
                    i += 3;
                } else {
                    res++;
                    i += 2;
                }
            }
        }
        return res >= n;
    }

}
