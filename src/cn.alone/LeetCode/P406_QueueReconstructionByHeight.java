package cn.alone.LeetCode;

import java.util.*;

/**
 * Created by RojerAlone on 2017/7/3.
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * 假定有随机数个人站在一个队中，每个人用一对数 (h, k) 来描述
 * h 表示这个人的身高，k 表示在这个人前边身高大于等于这个人的个数
 * 给定一个这种描述的数组，将数组排成正确的顺序
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class P406_QueueReconstructionByHeight {

    /**
     * 讨论区看来的
     */
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length != 2) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                // 如果身高相同，按照次序排序
                if (b[0] == a[0]) {
                    return a[1] - b[1];
                }
                // 否则按照身高排序
                return b[0] - a[0];
            }
        });
        int[][] res = new int[people.length][2];
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i][1] = k[1];
            i++;
        }
        return res;
    }

}
