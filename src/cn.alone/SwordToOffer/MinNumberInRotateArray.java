package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-02.
 * 旋转数组的最小数字，LeetCode 153
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {

    /**
     * 如果第一个数大于最后一个数，那么不是排序过的，也就是最小值在这个区间内，然后二分查找
     * 当区间的第一个数小于最后一个数，那么第一个数就是最小值
     */
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] < array[end]) { // 如果第一个数字小于最后一个，那么第一个就是最小的
                return array[start];
            }
            int mid = (start + end) / 2;
            if (array[mid] >= array[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return array[start];
    }

}
