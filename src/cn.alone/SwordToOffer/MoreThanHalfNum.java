package cn.alone.SwordToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RojerAlone on 2017-09-05.
 * 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum {

    /**
     * 《剑指 Offer》 中的方法是先找出出现次数最多的数字，然后再遍历找出出现次数
     * 这里我用了 map 记录出现的次数，时间复杂度都是 O(n)，虽然占用了空间，但是时间上少了一次遍历
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int length = array.length;
        for (int num : array) {
            int tmp = map.getOrDefault(num, 0) + 1;
            if (tmp * 2 > length) {
                return num;
            }
            map.put(num, tmp);
        }
        return 0;
    }

}
