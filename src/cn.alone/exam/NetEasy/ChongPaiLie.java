package cn.alone.exam.NetEasy;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-09.
 * 重排列数组，使得连着的两个数的乘积能被 4 整除，如果能，输出 Yes，否则输出 No
 */
public class ChongPaiLie {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        for (int j = 0; j < time; j++) {
            int num = sc.nextInt();
            int notFour = 0; // 不能被 2 整除的数
            int numOfTwo = 0; // 能被 2 整除的数
            int numOfFour = 0; // 能被 4 整除的数
            for (int i = 0; i < num; i++) {
                int tmp = sc.nextInt();
                if (tmp % 4 == 0) {
                    numOfFour++;
                }
                if (tmp % 2 == 0) {
                    numOfTwo++;
                }
                if (tmp % 4 != 0) {
                    notFour++;
                }
            }
            if (numOfTwo == 0) {
                if (numOfFour >= notFour - 1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                if (numOfFour >= notFour) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
        sc.close();
    }

}
