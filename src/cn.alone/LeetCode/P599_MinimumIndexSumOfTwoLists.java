package cn.alone.LeetCode;

import java.util.*;

/**
 * Created by RojerAlone on 2017-08-11.
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 * 两个数组最小的索引的和
 * 给出两个字符串数组，表示两个人想去吃饭的地方，坐标表示距离
 * 找出两个人都想去吃饭，但是距离最近的地方
 */
public class P599_MinimumIndexSumOfTwoLists {

    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> tmp = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Integer index = 0;
        for (int i = 0; i < list2.length; i++) {
            if ((index = map.get(list2[i])) != null) {
                if (i + index > min) {
                    continue;
                }
                if (i + index < min) { // 如果有更小的数，就清除结果集
                    min = i + index;
                    tmp.clear();
                }
                tmp.add(list2[i]);
            }
        }
        return tmp.toArray(new String[tmp.size()]);
    }

}
