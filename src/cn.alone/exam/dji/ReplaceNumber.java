package cn.alone.exam.dji;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-03.
 * 数字牌替换小游戏
 * Tom最近很闲，所以发明了一个小游戏。给出一个数字m(m < 10^521)，有三个数字牌，可以用一张牌替换随意一种数字，
 * 一张扑克牌只能用一次，现在要求求出替换后的最大值（可以选择不用数字牌）。
 *
 2
 9001
 0
 1
 2
 9301
 0
 1
 2

 9221
 9321
 */
public class ReplaceNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long num = sc.nextLong(); // 要替换的数字
            int[] nums = new int[3];
            for (int j = 0; j < 3; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(helper(num, nums));
        }
        sc.close();
    }

    /**
     * 将数字转化为字符串，然后替换字符串中的字符
     * 先将数组排序，从要替换的数字的高位开始替换，如果替换之后更大（当前可用最大扑克牌大于当前位置数字）就替换
     * 扑克牌用光或者数字从高位到地位替换完毕后结束
     */
    private static String helper(long num, int[] nums) {
        String str = String.valueOf(num);
        Arrays.sort(nums);
        char[] chars = str.toCharArray();
        int index = 2; // 记录当前可以使用的最大扑克牌
        for (int i = 0; i < chars.length; i++) {
            if (nums[index] > Integer.valueOf(String.valueOf(chars[i]))) { // 可以替换
                str = str.replaceAll(String.valueOf(chars[i]), String.valueOf(nums[index])); // 替换
                index--;
                if (index < 0) { // 如果扑克牌已经替换完毕，退出
                    break;
                }
            }
        }
        return str;
    }

}
