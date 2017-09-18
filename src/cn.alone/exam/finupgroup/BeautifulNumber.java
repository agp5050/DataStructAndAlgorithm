package cn.alone.exam.finupgroup;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by RojerAlone on 2017-09-18.
 * 美丽数字
 * 十进制数字中没有重复数字的就是美丽数字，找出比当前输入数字大的最小的美丽数字
 */
public class BeautifulNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        num++;
        while (!isBeautiful(num)) {
            num++;
        }
        System.out.println(num);
    }

    private static boolean isBeautiful(int num) {
        Set<Integer> set = new HashSet<>();
        int index = 10;
        while (num != 0 && index > 0) {
            int tmp = num % 10;
            if (set.contains(tmp)) {
                return false;
            } else {
                set.add(tmp);
            }
            num /= 10;
            index--;
        }
        if (index < 0) {
            return false;
        }
        return true;
    }

}
