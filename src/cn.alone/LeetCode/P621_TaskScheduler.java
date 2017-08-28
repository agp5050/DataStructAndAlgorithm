package cn.alone.LeetCode;

import java.util.Arrays;

/**
 * Created by RojerAlone on 2017-08-28.
 * https://leetcode.com/problems/task-scheduler/
 * 给定一个代表 CPU 执行任务的字符数组（大写的从 A 到 Z）和一个整数 n 表示每两个相同任务之间的间隔时间
 * 在每个间隔时间里，CPU 可以执行任务或者空闲，求出完成给定任务所需要的最少时间
 */
public class P621_TaskScheduler {

    /**
     * 出现次数最多的任务一定是排在两边的，在频次最多的任务中间添加任务
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        if (n == 0) {
            return tasks.length;
        }
        int[] chars = new int[26];
        for (char c : tasks) {
            chars[c - 'A']++;
        }
        Arrays.sort(chars);
        int i = 25;
        while (i >= 0 && chars[i] == chars[25]) {
            i--;
        }
        // 任务排列后的结果为 频次最多的字符后边跟着次多的字符或者同样多的字符，在给定间隔之后再排列频次最多的字符
        // 如 AAABBBCCD 间隔为 1 排列为 ABCABCABD 间隔为 3 排列为 ABCDABC_AB
        // chars[25] - 1 表示以频次最多的字符开头的部分的个数，n + 1 表示这样的组的大小，最后再加上频次最多的字符的种类数
        return Math.max(tasks.length, (chars[25] - 1) * (n + 1) + 25 - i);
    }

}
