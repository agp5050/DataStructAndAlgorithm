package cn.alone.exam.mi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by RojerAlone on 2017-09-18.
 * 我们来做一个简单的密码破译游戏。破译的规则很简单，将数字转换为字母，1转化为a，2转化为b，依此类推，26转化为z。
 * 现在输入的密码是一串数字，输出的破译结果是该数字串通过转换规则所能产生的所有字符串。
 *
 1
 12
 123

 a
 ab l
 abc aw lc
 */
public class TranslatePassword {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10", "j");
        map.put("11", "k");
        map.put("12", "l");
        map.put("13", "m");
        map.put("14", "n");
        map.put("15", "o");
        map.put("16", "p");
        map.put("17", "q");
        map.put("18", "r");
        map.put("19", "s");
        map.put("20", "t");
        map.put("21", "u");
        map.put("22", "v");
        map.put("23", "w");
        map.put("24", "x");
        map.put("25", "y");
        map.put("26", "z");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder res = new StringBuilder();
            helper(str, 0, res, new StringBuilder());
            System.out.println(res.substring(0, res.length() - 1));
        }
        sc.close();
    }

    /**
     *
     * @param str
     * @param size 当前可以使用的字符的下标
     * @param res 存放结果
     */
    private static void helper(String str, int size, StringBuilder res, StringBuilder tmp) {
        if (size == str.length()) {
            res.append(tmp.toString()).append(" ");
            return;
        }
        String tmpStr = str.substring(size, size + 1);
        if (map.get(tmpStr) != null) {
            tmp.append(map.get(tmpStr));
            helper(str, size + 1, res, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
        if (size + 2 <= str.length()) {
            tmpStr = str.substring(size, size + 2);
            if (map.get(tmpStr) != null) {
                tmp.append(map.get(tmpStr));
                helper(str, size + 2, res, tmp);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }

}
