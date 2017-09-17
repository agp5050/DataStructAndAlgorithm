package cn.alone.exam.SoHu;

import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-17.
 * 化简 unix 路径到最简 40%
 * /a/./b/../../c/
 * /c
 */
public class UnixPath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine().replaceAll("//", "/");
        sc.close();
        StringBuilder sb = new StringBuilder();
        String[] strs = path.split("/");
        for (String str : strs) {
            if (str.equals("..")) {
                sb.delete(sb.length() - 2, sb.length());
            } else if (str.equals(".") || str.isEmpty()) {
                continue;
            } else {
                sb.append("/" + str);
            }
        }
//        for (int i = 0; i < path.length();) {
//            if (path.charAt(i) != '.') { // 如果不是 . 记录
//                sb.append(path.charAt(i));
//                if (path.charAt(i) == '/' && i + 1 < path.length() && path.charAt(i + 1) == '/') { // 如果是两个斜杠
//                    i += 2;
//                } else {
//                    i++;
//                }
//            } else {
//                if (path.charAt(i + 1) == '.') { // 如果和下一个可以组成 .. 那么删除当前记录的最后一层目录
//                    sb.delete(sb.length() - 2, sb.length());
//                    i += 3;
//                } else { // 如果是 ./ 那么不处理，继续遍历
//                    i += 2;
//                }
//            }
//        }
//        if (sb.charAt(sb.length() - 1) == '/' && sb.length() > 1) {
//            System.out.println(sb.substring(0, sb.length() - 1));
//        } else {
        if (sb.length() == 0) {
            System.out.println("/");
        } else {
            System.out.println(sb.toString());
        }
    }

}
