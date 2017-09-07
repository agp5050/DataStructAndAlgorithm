package cn.alone.SwordToOffer;

import java.util.ArrayList;

/**
 * Created by RojerAlone on 2017-09-07.
 * 最小的 K 个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class MinKNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>(k); // 大小为k的容器
        int num = input.length;
        if (num < k || k <= 0) {
            return result;
        }
        int maxIndex = 0; // 记录最大树的下标
        result.add(input[0]);
        for (int i = 1; i < input.length; i++) {
            if (result.size() == k) {
                if (result.get(maxIndex) > input[i]) {
                    result.set(maxIndex, input[i]);
                    // 重新寻找最大值所在的位置
                    for (int j = 0; j < result.size(); j++) {
                        if (result.get(j) > result.get(maxIndex)) {
                            maxIndex = j;
                        }
                    }
                }
            } else {
                result.add(input[i]);
                if (input[i] > result.get(maxIndex)) {
                    maxIndex = i;
                }
            }
        }
        return result;
    }

}
