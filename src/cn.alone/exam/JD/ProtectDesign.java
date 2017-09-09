package cn.alone.exam.JD;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by RojerAlone on 2017-09-07.
 * 保卫方案
 * 战争游戏的至关重要环节就要到来了，这次的结果将决定王国的生死存亡，小B负责首都的防卫工作。首都位于一个四面环山的盆地中，
 * 周围的n个小山构成一个环，作为预警措施，小B计划在每个小山上设置一个观察哨，日夜不停的瞭望周围发生的情况。
 * 一旦发生外地入侵事件，山顶上的岗哨将点燃烽烟，若两个岗哨所在的山峰之间没有更高的山峰遮挡且两者之间有相连通路，
 * 则岗哨可以观察到另一个山峰上的烽烟是否点燃。由于小山处于环上，任意两个小山之间存在两个不同的连接通路。
 * 满足上述不遮挡的条件下，一座山峰上岗哨点燃的烽烟至少可以通过一条通路被另一端观察到。对于任意相邻的岗哨，
 * 一端的岗哨一定可以发现一端点燃的烽烟。 小B设计的这种保卫方案的一个重要特性是能够观测到对方烽烟的岗哨对的数量，
 * 她希望你能够帮她解决这个问题。
 * <p>
 * 输入
 * 输入中有多组测试数据，每一组测试数据的第一行为一个整数n(3<=n<=10^6),为首都周围的小山数量，第二行为n个整数，
 * 依次表示为小山的高度h（1<=h<=10^9）.
 * 输出
 * 对每组测试数据，在单独的一行中输出能相互观察到的岗哨的对数。
 * <p>
 * 输入
 * 5
 * 1 2 4 5 3
 * 输出
 * 7
 */
public class ProtectDesign {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(design(arr));
        }
    }

    /**
     * 单调栈
     */
    private static int design(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int length = arr.length;
        int res = 0;
        int maxIndex = 0; // 最大山峰高度的位置
        for (int i = 1; i < length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(maxIndex);
        for (int i = maxIndex + 1 == length ? 0 : maxIndex + 1; i != maxIndex; i = (i + 1) % length) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                res += 2; // 新加入的岗哨和当前栈顶岗哨，栈顶岗哨与下面的岗哨，一共两对
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            stack.pop();
            if (!stack.isEmpty()) {
                res++;
            }
        }
        return res;
    }

}
