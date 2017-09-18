package cn.alone.exam.finupgroup;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-18.
 * 统计分组的组数
 * 某学校近期要组织全校同学出去参加某项活动，由于人数众多，学校决定让同学们自行组队，以小组为单位进行活动。
 * 假设学校一共n个同学，每个同学有一个唯一的数字作为标签，标签数字范围1到n。
 * 为了统计分组情况，学校要求有分组意愿的同学提交一个数字，表示其会和以该数字为标签的同学分到一组。
 * 现在告诉你每位同学的选择，你能统计出一共有多少个小组么？
 * 注意如果1和2一组，2和3一组，那么1，2，3属于一组。默认自己一定和自己在一组。
 *
5
1 3 4 2 1

2

6
1 3 4 1 5 5

2
 */
public class CountGroup {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int res = 0;
        for (int i = 0; i < num; i++) {
            if (arr[i] != -1 && arr[arr[i] - 1] != -1) { // 如果当前人还未组队并且他想组队的人还没有组队
                res++;
                int target = arr[i]; // 当前这个人想和谁组队
                arr[i] = -1;
                while (arr[target - 1] != -1) {
                    int tmp = arr[target - 1];
                    arr[target - 1] = -1;
                    target = tmp;
                }
                if (target - 1 < i) { // 如果最后组队组到了之前已经组好的队里，那么应该减一
                    res--;
                }
            }
        }

//        for (int i = 0; i < num; i++) {
//            if (arr[i] > 0 && arr[arr[i] - 1] > 0) {
//                int target = arr[i];
//                arr[i] = ++res * -1;
//                while (arr[target - 1] > 0) {
//                    target = arr[target - 1];
//                    arr[target - 1] = res * -1;
//                }
//            }
//        }
        System.out.println(res);
    }

}
