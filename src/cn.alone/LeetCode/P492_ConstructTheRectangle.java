package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-04.
 * https://leetcode.com/problems/construct-the-rectangle/
 * 给定矩形的面积area，返回矩形的长度L和宽度W，使得L和W的差值最小。
 * 长和宽都是正整数。
 */
public class P492_ConstructTheRectangle {

    public int[] constructRectangle(int area) {
        if (area <= 0) {
            return null;
        }
        int w = (int) Math.sqrt(area); // 开方后两个数相等，差最小
        while (area % w != 0) { // 每次减 1 寻找合适的数
            w--;
        }
        return new int[]{area / w, w};
    }

}
