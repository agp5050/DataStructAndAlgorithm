package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-07.
 * 连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length <= 0) {
            return 0;
        }

        int cur = array[0];
        int max = array[0];
        for (int i = 1 ; i < array.length ; i++) {
            if (cur < 0) { // 如果当前子数组的和已经小于 0 了，直接抛弃，重新开始计算
                cur = array[i];
            } else {
                cur += array[i];
            }
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }

}
