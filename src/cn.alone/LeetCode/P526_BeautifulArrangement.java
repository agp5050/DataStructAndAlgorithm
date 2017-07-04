package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017/7/4.
 * https://leetcode.com/problems/beautiful-arrangement/
 * 输入一个数字 N ，构建一个包含从 1到N 的所有的数字的数组，如果这个数组的所有元素都满足一下两个条件之一：
 * 1、第 i 个数能被 i 整除
 * 2、i 能够被第 i 个数整除
 * 那么这个数组就是“美丽数组”，返回这样的数组个数
 */
public class P526_BeautifulArrangement {

    private int res = 0;

    /**
     * 递归计算，结束条件是所有的数都遍历过了
     * 递归过程是 如果某个位置还没有被访问过而且这个位置满足条件，将这个位置标记为访问过，继续递归，
     * 递归完成后将这个位置重置标记，继续下一次遍历
     */
    private void count(int N, int current, int[] visited) {
        if (current > N) {
            res++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0 && (i % current == 0 || current % i == 0)) {
                visited[i] = 1;
                count(N, current + 1, visited);
                visited[i] = 0;
            }
        }
    }

    public int countArrangement(int N) {
        int[] visited = new int[N + 1];
        count(N, 1, visited);
        return res;
    }

}
