package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/16.
 * https://leetcode.com/problems/single-number-iii/
 * http://blog.csdn.net/alone_rojer/article/details/62438479
 * 给一个数组，只有两个数字出现了一次，其余数字出现了两次，找出这两个数字
 * 结果不需要排序
 */
public class P260_SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        if (nums == null | nums.length < 2) {
            return null;
        }
        int[] res = new int[2];
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        int indexOf1 = FindFirstBitIs1(result);
        for (int i : nums) {
            if (isBit1(i, indexOf1)) { // 如果属于第一个数组
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }

    // 寻找从右往左的第一个为1的位，即特征位
    private int FindFirstBitIs1(int result) {
        int index = 0;
        while ((result & 1) == 0 && index < 8 * 4) {
            result = result >>> 1;
            index++;
        }
        return index;
    }

    // 判断一个数字的二进制从右到左数第n位是否为1，用来分两个数组
    private boolean isBit1(int num, int indexBit) {
        num = num >>> indexBit;
        return ((num & 1) == 0) ? false : true;
    }

}
