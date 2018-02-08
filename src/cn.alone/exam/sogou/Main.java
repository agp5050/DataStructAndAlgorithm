package cn.alone.exam.sogou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by RojerAlone on 2017-09-08.
 * 圆周上两点间的距离
 * 定义圆周上两点的距离s为这两点之间的劣弧对应的圆心角度数(0<=s<=180)，现输入圆周上的n个点（n>=2），
 * 以角度a表示其位置(0<=a<360)，输入按a从小到大排序。求最远的一对点之间的距离。
 *
 * 第一行为点个数n，后跟n行，每行一个双精度浮点数，表示点的角度（小数点后保留8位），例如输入样例中为4个点的输入：
 *
 * 输出最远的一对点之间的距离（双精度浮点数，小数点后保留8位）和'\n'换行符。例如输入样例中，
 * 10.00000000与183.00000000两个点之间的距离为173.00000000，大于10.00000000与198.0000000之间的距离172.00000000，
 * 所以应输出：
 * 173.00000000
 *
 *
 4
 10.00000000
 180.00000000
 183.00000000
 198.00000000

 173.00000000
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(buffer.readLine());
        double[] points = new double[num];
        for (int i = 0; i < num; i++) {
            points[i] = Double.valueOf(buffer.readLine());
        }
        buffer.close();
        System.out.println(String.format("%.8f",getMax(points)));
    }

    /**
     * 找到当前点 + 180 的点的左右两边的数，然后计算差
     * 这个只过了 50%
     */
    private static double getMax(double[] points) {
        int size = points.length;
        double res = Double.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            double target = (points[i] + 180) % 360;
            int start = 0;
            int end = size - 1;
            int mid = 0;
            while (start <= end) {
                mid = start + (end - start) / 2;
                if (points[mid] < target) {
                    start = mid + 1;
                } else if (points[mid] > target) {
                    end = mid - 1;
                } else {
                    break;
                }
            }
            res = Math.max(res, Math.abs(points[i] - points[mid]) % 180);
            if (mid - 1 >= 0) {
                res = Math.max(res, Math.abs(points[i] - points[mid - 1]) % 180);
            }
            if (mid + 1 < size) {
                if (Math.abs(points[mid + 1] - points[i]) > 180) {
                    res = Math.max(res, (points[i] + points[mid + 1]) % 360);
                } else {
                    res = Math.max(res, Math.abs(points[i] - points[mid + 1]) % 180);
                }
            }
        }
        return res;
    }

}
