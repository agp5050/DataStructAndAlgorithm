package cn.alone.exam.SoHu;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-17.
 * 添加数字使得数组成为回文数组并且数组的值最小 30%
 *
8
51 23 52 97 97 76 23 51

598

5
1 2 3 1 2

11
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        int res = 0;
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
            res += arr[i];
        }
        sc.close();
        int left = 0;
        int right = num - 1;
        while (left <= right) {
            if (arr[left] == arr[right]) { // 相等，不用添加
                left++;
                right--;
            } else if (arr[left] < arr[right]) { // 选择较小的添加
                res += arr[left];
                left++;
            } else {
                res += arr[right];
                right--;
            }
        }
        System.out.println(res);
    }

}
