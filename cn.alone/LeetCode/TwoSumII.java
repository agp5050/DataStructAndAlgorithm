package LeetCode;

/**
 * Created by RojerAlone on 2017/6/24.
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Two Sum 的变种，将输入的数据进行了排序
 * 两个指针，一个指向开头，一个指向结尾，数组是已经排序过的
 * 每次两个下标对应的数相加，如果和目标值一致，就返回
 * 否则如果大于目标值，则说明应该小一点，那么就把结尾的坐标 -1
 * 同理，如果小于目标值，那么应该将开头的坐标 +1
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        // 输入合法性判断
        if (numbers == null || numbers.length < 2) {
            return res;
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (tmp == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (tmp < target) {
                int num = numbers[left];
                // 跳过重复的数字
                while (num == numbers[left]) {
                    left++;
                }
            } else {
                int num = numbers[right];
                // 跳过重复的数字
                while (num == numbers[right]) {
                    right--;
                }
            }
        }
        return res;
    }

}
