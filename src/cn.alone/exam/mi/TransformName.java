package cn.alone.exam.mi;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-18.
 * 名称转换
 *
 转换规则：
 > 在开头和结尾都添加下划线；
 > 将“.”转化为下划线；
 > 根据下面的规则识别出组件中的单词，并使用下划线将单词进行分隔（具体参照输入输出样例）：
 > 第一个大写字母与后面连续的小写字母一起识别为一个单词，如果不以大写字母开头，则直接将连续的小写字母识别为一个单词；
 > 连续的大写字母一起识别为一个单词，但是如果最后一个大写字母后面跟着小写字母，则最后一个大写字母不包含在内；
 > 连续的数字一起识别为一个单词；

a
my.ABC
simple.HelloService
MY.ASTParser12

_A_
_MY_ABC_
_SIMPLE_HELLO_SERVICE_
_MY_AST_PARSER_12_
 */
public class TransformName {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String name = sc.nextLine();
            StringBuilder sb = new StringBuilder("_");
            int size = name.length();
            int index = 0; // 记录当前组件应该从哪个位置开始
            int tag = 0; // 记录当前的组件应该是什么格式，0 代表小写字母，1 代表大写字母， 2 代表数字
            if ('a' <= name.charAt(0) && name.charAt(0) <= 'z') {
                tag = 0;
            } else if ('A' <= name.charAt(0) && name.charAt(0) <= 'Z') {
                tag = 1;
            } else {
                tag = 2;
            }
            for (int i = 1; i < size; i++) {
                if (name.charAt(i) == '.') { // 如果是点，分割，并且计算下一个应该是什么类型的组件
                    if (tag == 2) {
                        sb.append(name.substring(index, i));
                    } else {
                        sb.append(name.substring(index, i).toUpperCase());
                    }
                    sb.append("_");
                    if (i + 1 < size) {
                        if ('a' <= name.charAt(i + 1) && name.charAt(i + 1) <= 'z') {
                            tag = 0;
                        } else if ('0' <= name.charAt(i + 1) && name.charAt(i + 1) <= '9') {
                            tag = 2;
                        } else {
                            if (i + 2 < size && 'a' <= name.charAt(i + 2) && name.charAt(i + 2) <= 'z') {
                                tag = 0;
                            } else {
                                tag = 1;
                            }
                        }
                        i++;
                        index = i;
                    } else {
                        tag = 1;
                    }
                    continue;
                }
                if ('a' <= name.charAt(i) && name.charAt(i) <= 'z' && tag != 0) { // 如果是小写字母但是不是小写字母的组件
                    if (tag == 2) {
                        sb.append(name.substring(index, i)).append("_");
                        index = i;
                    } else { // 如果碰到了 AAABc 这种情况
                        sb.append(name.substring(index, i - 1).toUpperCase()).append("_");
                        index = i - 1;
                    }
                    tag = 0;
                } else if ('0' <= name.charAt(i) && name.charAt(i) <= '9' && tag != 2) { // 如果是数字
                    sb.append(name.substring(index, i).toUpperCase()).append("_");
                    index = i;
                    tag = 2;
                } else if ('A' <= name.charAt(i) && name.charAt(i) <= 'Z' && tag != 1){ // 如果是大写字母
                    if (tag == 2) {
                        sb.append(name.substring(index, i)).append("_");
                    } else {
                        sb.append(name.substring(index, i).toUpperCase()).append("_");
                    }
                    index = i;
                    if (i + 1 < size && 'a' <= name.charAt(i + 1) && name.charAt(i + 1) <= 'z') { // 如果不是最后一位并且下一位是小写
                        tag = 0;
                    } else {
                        tag = 1;
                    }
                }
            }
            if (tag == 2) {
                sb.append(name.substring(index, size));
            } else {
                sb.append(name.substring(index, size).toUpperCase());
            }
            System.out.println(sb.append("_").toString());
        }
        sc.close();
    }

}
