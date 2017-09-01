package cn.alone.SwordToOffer;

/**
 * Created by RojerAlone on 2017-09-01.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindNumberInTwoDimensionalArray {

    /**
     * 根据这个二维数组的特性，从第一行最后边开始，如果比目标值小，那么往下一行遍历
     * 如果比目标值大，那么从右往左遍历，遍历过程中可以使用二分法
     */
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        for (int i = 0; i < rows; i++) {
            if (array[i][cols - 1] == target) {
                return true;
            } else if (array[i][cols - 1] > target) { // 从右往左遍历
                for (int j = cols - 1; j >= 0; j--) {
                    if (array[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
