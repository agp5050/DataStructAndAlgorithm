package cn.alone.exam.hikvision;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-14.
 * 有一环形公交站，包含N(N>=3)个站点【站点序号：1…N】，每个站点停留5分钟，相邻两个站点之间行驶时间都是10分钟，
 * 循环行驶，已知第一圈第一个站点的进入时间为X，现在公交行驶时间为Y，请计算当前公交行驶的圈数，
 * 以及处在哪个站点之间M-N【如果是停在某个站点Z,则输出Z-Z】.
 *
 *
 输入
 一行字符串: 3,2017-07-25 06:00:00,2017-07-25 06:06:00
 3,2017-07-25 06:00:00,2017-07-25 06:05:00【整数、时间字符串、时间字符串，时间精确到分钟】分别表示站点数，第一圈第一个站点的进入时间，目前时间； 数据之间使用逗号分隔；
 要求至少三个站点。
 如输入条件不满足，则输出“incorrect data”
 输出
 1;1-2
 数据表示：公交正在行驶第一圈，在第一个站点和第二个站点之间；圈数与行驶站点之间使用分号分隔

 如果是1;2-2则表示公交正在行驶第一圈，目前停留在第二个站点

 3,2017-07-25 06:00:00,2017-07-25 06:40:00
 3,2017-07-25 06:00:00,2017-07-25 08:45:00
 1,2017-07-25 06:00:00,2017-07-25 06:40:00
 3,2017-07-25 06:00:66,2017-07-25 06:40:99

 1;1-1
 4;3-3
 incorrect data
 incorrect data
 */
public class BusRunTime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] strs = str.split(",");
            if (strs.length != 3) {
                System.out.println("incorrect data");
                continue;
            }
            int nums = Integer.valueOf(strs[0]);
            if (nums < 3) {
                System.out.println("incorrect data");
                continue;
            }
            if (!strs[1].matches("^\\d{4}-[0|1]\\d-[0|1|2|3]\\d [0|1|2]\\d:[0-6]\\d:00") ||
                    !strs[2].matches("^\\d{4}-[0|1]\\d-[0|1|2|3]\\d [0|1|2]\\d:[0-6]\\d:00")) {
                System.out.println("incorrect data");
                continue;
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            try {
                long start = df.parse(strs[1]).getTime();
                long end = df.parse(strs[2]).getTime();
                if (start >= end) {
                    System.out.println("incorrect data");
                    continue;
                }
                int minutes = (int) ((end - start) / 1000 / 60);
                int oneCircle = 15 * nums;
                System.out.print((minutes / oneCircle + 1) + ";");
                if (minutes % 15 == 0) {
                    int tmp = minutes % oneCircle / 15 + 1;
                    System.out.println(tmp + "-" + tmp);
                } else {
                    int tmp = minutes % oneCircle / 15;
                    System.out.println((tmp + 1) + "-" + (tmp + 2));
                }
            } catch (ParseException e) {
                System.out.println("incorrect data");
                continue;
            }
        }
        sc.close();
    }
}
