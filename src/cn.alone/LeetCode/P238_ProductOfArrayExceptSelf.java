package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-04.
 * https://leetcode.com/problems/product-of-array-except-self/
 * 给一个数量大于 1 的数组，返回的数组中，数组中的每个元素是其他元素的乘积
 * 输入 [1,2,3,4], 输出 [24,12,8,6].
 */
public class P238_ProductOfArrayExceptSelf {

    /**
     * 遍历所有的元素，记录乘积，记录乘积过程中如果有 0 就跳过同时记录下 0 的个数
     * 如果超过 1 个 0，那么结果集就是全为 0
     * 如果只有 1 个 0，那么结果集中除了这个元素，其余都为 0
     * 如果没有 0，那么结果集中当前元素为元素乘积除以当前元素
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int tmp = 1;
        int numOf0 = 0;
        for (int num : nums) {
            if (num == 0) {
                numOf0++;
                if (numOf0 > 1) { // 如果元素超过 1 个，结果集中全为 0
                    break;
                }
            } else {
                tmp *= num;
            }
        }
        if (numOf0 > 1) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = 0;
            }
        } else if (numOf0 == 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = tmp / nums[i];
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[i] = 0;
                } else {
                    nums[i] = tmp;
                }
            }
        }
        return nums;
    }

}
