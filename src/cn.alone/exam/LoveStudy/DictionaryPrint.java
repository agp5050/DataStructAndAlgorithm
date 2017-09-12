package cn.alone.exam.LoveStudy;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-12.
 * 百词斩，字典序输出
 */
public class DictionaryPrint {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num  = sc.nextInt();
        sc.close();
        int index = 0;
        int begin = 0;
        while (index < num) {
            if (begin <= 0) {
                System.out.print(begin);
                index++;

                if (begin == 0) {
                    begin++;
                } else {
                    begin *= 10;
                }
            } else {
                begin = begin / 10 + 1;
                while (begin != 0 && begin % 10 != 0) {
                    begin /= 10;
                }
            }
        }
    }

}
