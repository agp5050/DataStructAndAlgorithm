package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-01.
 * https://leetcode.com/problems/move-zeroes/
 * 给一个数组，把所有的 0 移动到数组的尾部，不能改变其他数字之间的相对位置
 */
public class P283_MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                int tmp = index; // 记录当前的坐标
                do { // 跳过所有的 0，找到不是 0 的数
                    index++;
                } while (index < nums.length && nums[index] == 0);
                if (index == nums.length) { // 到最后一个元素都是 0
                    break;
                }
                nums[tmp] = nums[index];
                nums[index] = 0;
                index = tmp + 1;
            } else {
                index++;
            }
        }
    }

    public static void main(String[] args) {
        new P283_MoveZeroes().moveZeroes(new int[]{0,1,0,3,12});
    }

}
