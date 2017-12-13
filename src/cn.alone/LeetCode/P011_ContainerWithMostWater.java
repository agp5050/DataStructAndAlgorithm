package cn.alone.LeetCode;

/**
 * Created by zhangrenjie on 2017-12-13
 * https://leetcode.com/problems/container-with-most-water/
 * 给定一组非空数字，下标 i 和 对应数字 ai 组成坐标点 (i, ai)，求出哪两个坐标和 x 轴组成的容器能装下更多的水，即求组成最大的面积
 */
public class P011_ContainerWithMostWater {

    /**
     * 双指针，计算当前两个指针指向的坐标组成的面积，和当前最大的面积比较，为了让面积更大，需要高度更高（每次都会移动指针，宽一定会减小），
     * 但是高度是由两个坐标中更低的高度决定的，因此高度更高需要移动高度更低的那个坐标
     */
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }

}
