package cn.alone.exam.dji;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-03.
 * 满足要求的连续子序列个数
 * 给出n个数字(n <= 100000，数字范围为[0, 100000])，
 * 要求找出序列中有多少个连续子序列满足以下要求：子序列中任意一个数字出现次数小于k
 *
 * 4 1
 * 1 2 2 3
 *
 * 6
 * 对于1 2 2 3序列，满足要求的子序列为[1][2][3][4][1, 2][2, 3]
 */
public class NumOfSubMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(nums[i], 1); // 记录当前
            for (int j = i + 1; j < n; j++) {
                int tmp = map.getOrDefault(nums[j], 0) + 1; // 记录当前已经出现了多少次
                if (tmp > num) { // 如果当前出现次数大于要求的次数，结果 + 1
                    break;
                }
                count++; // 结果 + 1
                map.put(nums[j], tmp);
            }
        }
        System.out.println((count + n)); // 子数组中只有一个数的值 + 算出来的个数
    }

}
