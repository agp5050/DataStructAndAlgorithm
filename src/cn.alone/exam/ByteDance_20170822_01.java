package cn.alone.exam;

import java.util.*;

/**
 * Created by RojerAlone on 2017-08-26.
 *
 * P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。
 * 求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 * 如下图：实心点为满足条件的点的集合。
 *
 * 请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
 * 输入
 * 第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
 * 输出
 * 输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。
 *
 * 样例输入
 * 5
 * 1 2
 * 5 3
 * 4 6
 * 7 5
 * 9 0
 * 样例输出
 * 输出结果按照 x 轴排序，如上例输出为：
 * 4 6
 * 7 5
 * 9 0
 */
public class ByteDance_20170822_01 {

    /**
     * 对 x 或者 y 排序，然后从大到小遍历排序过的（这里我们使用 x 坐标），
     * 如果当前坐标的 y 小于曾经出现过的最大值，那么不符合
     * 如果当前坐标的 y 大于曾经出现的最大值，符合，并且记录最大值，继续遍历
     * 如果当前坐标的 y 已经是最大的了（输入的时候记录最大值），结束
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> xmap = new HashMap<>(n); // 记录 x轴 的 值-坐标
        Map<Integer, Integer> ymap = new HashMap<>(n); // 记录 y轴 的 坐标-值
        int[] xarr = new int[n]; // x 轴的坐标集合
        int ymax = Integer.MIN_VALUE; // y轴的最大值
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (y > ymax) {
                ymax = y;
            }
            xarr[i] = x;
            xmap.put(x, i);
            ymap.put(i, y);
        }
        sc.close();
        Arrays.sort(xarr);

        List<Integer> xres = new ArrayList<>();
        List<Integer> yres = new ArrayList<>();
        xres.add(xarr[n - 1]); // x轴 最大的一定是结果之一
        int max = ymap.get(n - 1); // 记录出现过的最大 y 轴坐标，如果有遍历 x 从大到小过程中，y 轴小于曾经出现过的最大值就不符合条件
        yres.add(max);
        for (int i = n - 2; i >= 0; i--) {
            int index = xmap.get(xarr[i]); // 当前 x 轴对应的点的下标
            int y = ymap.get(index); // 获取当前点的 y 轴坐标
            if (y <= max) {
                continue;
            } else {
                xres.add(xarr[i]);
                yres.add(y);
                max = y;
            }
            if (y == ymax) { // 如果当前的坐标是 y轴的最大的，那么 x 轴上比它小的 y 轴也小，直接结束
                break;
            }
        }
        for (int i = xres.size() - 1; i >= 0; i--) {
            System.out.println(xres.get(i) + " " + yres.get(i));
        }

    }

}
