package cn.alone.exam.xunlei;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-19.
 * 解一元一次方程组
 * 2x+5-3+x=6+x-2
 * x=1
 */
public class SolveEquation {

    static class Solution {
        public static String solveEquation(String equation) {
            String[] lr = equation.split("="); // 划分等式两边
            int index = 0;
            int leftx = 0; // 记录等式左边 x 的系数
            while (index < lr[0].length() && (index = lr[0].indexOf("x", index)) != -1) {
                if (index == 0) { // 如果是第一个字符
                    leftx += 1;
                } else {
                    int tmp = index;
                    while (--tmp >= 0 && (lr[0].charAt(tmp) != '+' && lr[0].charAt(tmp) != '-')) { // 找到符号

                    }
                    if (tmp < 0) {
                        leftx += Integer.valueOf(lr[0].substring(0, index));
                    } else if (lr[0].charAt(tmp) == '+') {
                        if (tmp + 1 == index) {
                            leftx += 1;
                        } else {
                            leftx += Integer.valueOf(lr[0].substring(tmp, index));
                        }
                    } else {
                        if (tmp + 1 == index) {
                            leftx -= 1;
                        } else {
                            leftx -= Integer.valueOf(lr[0].substring(tmp, index));
                        }
                    }
                }
                index++;
            }
            index = 0;
            int rightx = 0; // 记录等式右边 x 的系数
            while (index < lr[1].length() && (index = lr[1].indexOf("x", index)) != -1) {
                if (index == 0) { // 如果是第一个字符
                    rightx += 1;
                } else {
                    int tmp = index;
                    while (--tmp >= 0 && (lr[1].charAt(tmp) != '+' && lr[1].charAt(tmp) != '-')) { // 找到符号

                    }
                    if (tmp < 0) {
                        rightx += Integer.valueOf(lr[1].substring(0, index));
                    } else if (lr[1].charAt(tmp) == '+') {
                        if (tmp + 1 == index) {
                            rightx += 1;
                        } else {
                            rightx += Integer.valueOf(lr[1].substring(tmp, index));
                        }
                    } else {
                        if (tmp + 1 == index) {
                            rightx -= 1;
                        } else {
                            rightx -= Integer.valueOf(lr[1].substring(tmp, index));
                        }
                    }
                }
                index++;
            }
            if (leftx == 0 && rightx == 0) {
                return "No solution"; // 无解
            }
            if (leftx == rightx) {
                return "Infinite solutions"; // 无穷解
            }

            int left = 0; // 等号左边常数的和
            index = 0;
            for (int i = 0; i < lr[0].length(); i++) {
                if ('0' <= lr[0].charAt(i) && lr[0].charAt(i) <= '9') { // 如果是数字
                    continue;
                } else if (lr[0].charAt(i) == 'x') { // 如果是 x
                    index = i + 1;
                    i++; // 帮助 +1 ，跳过下一个操作符
                } else {
                    if (lr[0].charAt(index) == '+') { // 如果是 + 号
                        left += Integer.valueOf(lr[0].substring(index + 1, i));
                    } else {
                        left += Integer.valueOf(lr[0].substring(index, i));
                    }
                    index = i;
                }
            }
            if (!lr[0].endsWith("x")) { // 如果是以 +i 结尾的
                if (lr[0].charAt(index) == '+') { // 如果是 + 号
                    left += Integer.valueOf(lr[0].substring(index + 1));
                } else {
                    left += Integer.valueOf(lr[0].substring(index));
                }
            }
            int right = 0; // 等号右边常数的和
            index = 0;
            for (int i = 0; i < lr[1].length(); i++) {
                if ('0' <= lr[1].charAt(i) && lr[1].charAt(i) <= '9') { // 如果是数字
                    continue;
                } else if (lr[1].charAt(i) == 'x') { // 如果是 x
                    index = i + 1;
                    i++; // 帮助 +1 ，跳过下一个操作符
                } else {
                    if (lr[1].charAt(index) == '+') { // 如果是 + 号
                        right += Integer.valueOf(lr[1].substring(index + 1, i));
                    } else {
                        right += Integer.valueOf(lr[1].substring(index, i));
                    }
                    index = i;
                }
            }
            if (!lr[1].endsWith("x")) { // 如果是以 +i 结尾的
                if (lr[1].charAt(index) == '+') { // 如果是 + 号
                    right += Integer.valueOf(lr[1].substring(index + 1));
                } else {
                    right += Integer.valueOf(lr[1].substring(index));
                }
            }
            if (left == right) {
                return "x=0";
            } else {
                return "x=" + (right - left) / (leftx - rightx);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print(Solution.solveEquation(in.nextLine()));
    }
}
