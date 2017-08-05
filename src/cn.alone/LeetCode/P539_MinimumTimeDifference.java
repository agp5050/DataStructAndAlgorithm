package cn.alone.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by RojerAlone on 2017-08-04.
 * https://leetcode.com/problems/minimum-time-difference/
 * 给一些时间，格式为 时:分 ，给出任意两个时间段之间相差的最小分钟数
 */
public class P539_MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() == 0) {
            return 0;
        }
        Collections.sort(timePoints, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.valueOf(o1.substring(0, 2)) > Integer.valueOf(o2.substring(0, 2))) {
                    return 1;
                } else if (Integer.valueOf(o1.substring(0, 2)) < Integer.valueOf(o2.substring(0, 2))) {
                    return -1;
                } else {
                    if (Integer.valueOf(o1.substring(3)) > Integer.valueOf(o2.substring(3))) {
                        return 1;
                    } else if (Integer.valueOf(o1.substring(3)) < Integer.valueOf(o2.substring(3))) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size() - 1; i++) {
            res = Math.min(res, computeDifference(timePoints.get(i), timePoints.get(i + 1)));
        }
        return Math.min(res, 60 * (Integer.valueOf(timePoints.get(0).substring(0, 2)) + 24 - Integer.valueOf(timePoints.get(timePoints.size() - 1).substring(0, 2)))
                + (Integer.valueOf(timePoints.get(0).substring(3)) - Integer.valueOf(timePoints.get(timePoints.size() - 1).substring(3))));
    }

    private int computeDifference(String str1, String str2) {
        int h1 = Integer.valueOf(str1.substring(0, 2));
        int m1 = Integer.valueOf(str1.substring(3));
        int h2 = Integer.valueOf(str2.substring(0, 2));
        int m2 = Integer.valueOf(str2.substring(3));
        return  60 *(h2 - h1) + m2 - m1;
    }

}
